package tool.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import tool.scaffddl.FiledDDLInfo;
import tool.utils.Constants;

public enum MemoryUtil {
	instance;
	
	private Log								DevLog		= LogFactory.getLog(getClass());
	
	public Boolean							isGenerator	= true;
	
	public String							packageName	= Constants.NULLSTRING;
	
	public List<String>						entityList	= new ArrayList<>();
	
	public Map<String, Map<String, Object>>	entityMap	= new HashMap<>();
	
	
	/**
	 * 
	 * @Title: clear
	 * @Description: 清除容器内数据
	 * @createdBy:Thread
	 * @createaAt:2019年2月19日下午2:45:13
	 */
	public void clear() {
		MemoryUtil.instance.entityList.clear();
		MemoryUtil.instance.entityMap.clear();
	}
	
	
	public void isGenerator(JSONArray jsonArray) {
		// 验证数据合法性
		if (isValidateArray(jsonArray)){
			// 数据合法性未通过,无法生成DDL语句
			MemoryUtil.instance.isGenerator = false;
		}
	}
	
	
	/**
	 * 
	 * @Title: isValidate
	 * @Description: 验证JSON
	 * @return
	 * @createdBy:Thread
	 * @createaAt:2019年2月19日下午2:13:19
	 */
	public Boolean isValidateArray(JSONArray jsonArray) {
		Boolean flag = false;
		
		for (Object object : jsonArray){
			JSONObject json = (JSONObject) object;
			if ((flag = isValidateJson(json, true, false)) == true){
				return flag;
			}
			
			// 设置主表名以及设置关联表
			Map<String, Object> filedTableMap = new HashMap<>();
			filedTableMap.put("notes", json.getString("notes"));
			filedTableMap.put("tableName", json.getString("tableName"));
			filedTableMap.put("cacheEnable", json.getString("cacheEnable"));
			filedTableMap.put("package", json.getString("package"));
			filedTableMap.put("entityName", json.getString("code"));
			filedTableMap.put("author", json.getString("author"));
			
			MemoryUtil.instance.entityList.add(json.getString("code"));
			MemoryUtil.instance.packageName = json.getString("package");
			MemoryUtil.instance.entityMap.put(json.getString("code"), filedTableMap);
			// 字段DDL数组
			List<FiledDDLInfo> filedInfoList = new ArrayList<>();
			List<FiledDDLInfo> childInfoList = new ArrayList<>();
			
			// 验证关联字段
			if (json.containsKey("children")){
				// 关联表
				JSONArray childArray = json.getJSONArray("children");
				List<Map<String, Object>> childTableList = new ArrayList<Map<String, Object>>();
				filedTableMap.put("children", childTableList);
				for (Object childObject : childArray){
					JSONObject childJson = (JSONObject) childObject;
					if ((flag = isValidateJson(childJson, true, true)) == true){
						return flag;
					}
					
					// 关联表数据
					Map<String, Object> childTableMap = new HashMap<>();
					childTableMap.put("tableName", childJson.getString("tableName"));
					childTableMap.put("relationChild", childJson.getString("relation_child"));
					childTableMap.put("relationParent", childJson.getString("relation_parent"));
					childTableMap.put("cacheEnable", childJson.getString("cacheEnable"));
					childTableMap.put("notes", childJson.getString("notes"));
					childTableMap.put("author", json.getString("author"));
					childTableMap.put("entityName", childJson.getString("code"));
					
					// 关联表字段
					JSONArray childFieldArray = childJson.getJSONArray("fields");
					for (Object childFieldObject : childFieldArray){
						JSONObject childFieldJson = (JSONObject) childFieldObject;
						if ((flag = isValidateJson(childFieldJson, false, false)) == true){
							return flag;
						}
						// 装载数据
						childInfoList.add(new FiledDDLInfo(childFieldJson));
					}
					
					// 填充
					childTableMap.put("fields", new ArrayList<FiledDDLInfo>(childInfoList));
					MemoryUtil.instance.entityMap.put(childJson.getString("code"), childTableMap);
					childTableList.add(new HashMap<>(childTableMap));
					childInfoList.clear();
				}
			}
			
			// 验证成员属性字段
			if (json.containsKey("fields")){
				JSONArray filedArray = json.getJSONArray("fields");
				for (Object filedObject : filedArray){
					JSONObject filedJson = (JSONObject) filedObject;
					if ((flag = isValidateJson(filedJson, false, false)) == true){
						return flag;
					}
					
					// 装载数据
					filedInfoList.add(new FiledDDLInfo(filedJson));
				}
			}
			
			// 填充
			filedTableMap.put("fields", new ArrayList<FiledDDLInfo>(filedInfoList));
//			MemoryUtil.instance.filedArrayTableMap.add(new HashMap<>(filedTableMap));
			filedInfoList.clear();
//			filedTableMap.clear();
		}
		
		return flag;
	}
	
	
	/*
	 * 验证一个对象是否数据安全
	 */
	private Boolean isValidateJson(JSONObject json, Boolean isPath, Boolean isChildren) {
		Boolean flag = false;
		// 验证是否没有表名字段
		if (isPath && !json.containsKey("tableName")){
			DevLog.debug(json.toString() + "没有表名");
			flag = true;
		}
		
		if (!isPath && !json.containsKey("tableFiledName")){
			DevLog.debug(json.toString() + "没有表字段名");
			flag = true;
		}
		
		// 验证是否没有类名字段
		if (!json.containsKey("code")){
			DevLog.debug(json.toString() + "没有类名");
			flag = true;
		}
		// 验证是否没有包路径字段
		if (isPath && !json.containsKey("package")){
			DevLog.debug(json.toString() + "没有包路径");
			flag = true;
		}
		// 验证是否没有成员属性字段
		if (isPath && !json.containsKey("fields")){
			DevLog.debug(json.toString() + "没有成员属性");
			flag = true;
		}
		// 验证是否没有开发者属性字段
		if (isPath && !json.containsKey("author") && !isChildren){
			DevLog.debug(json.toString() + "没有开发者属性");
			flag = true;
		}
		
		return flag;
	}
}
