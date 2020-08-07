package tool.scaffddl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tool.memory.MemoryUtil;
import tool.memory.PackageUtil;
import tool.utils.Constants;
import tool.utils.FileUtil;

public class ScaffDDLoldGen {
	private Log DevLog = LogFactory.getLog(getClass());
	
	
	/**
	 * 
	 * @Title: executue
	 * @Description: 生成DDL语句
	 * @createdBy:Thread
	 * @createaAt:2019年2月19日下午2:44:16
	 */
	public void executue() {
		if (!MemoryUtil.instance.isGenerator){
			MemoryUtil.instance.clear();
			return;
		}
		
		// 拼接DDL语句
		StringBuffer ddlSb = new StringBuffer();
		
		ScaffDDLGen ddl = new ScaffDDLGen();
		for (String entityName : MemoryUtil.instance.entityList){
			Map<String, Object> entityMap = MemoryUtil.instance.entityMap.get(entityName);
			// 主表语句
			ddlSb.append(ddl.generatorDDLByMap(entityMap));
			
			// 关联表语句
			List<Map<String, Object>> listChildMap = (List<Map<String, Object>>) entityMap.get("children");
			if (listChildMap != null && listChildMap.size() > 0){
				for (Map<String, Object> childMap : listChildMap){
					ddlSb.append(Constants.CR);
					ddlSb.append(Constants.CR);
					ddlSb.append(ddl.generatorDDLByMap(childMap));
				}
			}
		}
		
		// 生成文件 放进文件夹内的顶层
		FileUtil.creatFile(PackageUtil.instance.getPathPackage()
				+ File.separator, "generator_create", ddlSb.toString());
	}
}
