package tool.scaffddl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tool.scaffddl.Enum.DataBaseTypeEnum;
import tool.scaffddl.Enum.ValidTypeEnum;
import tool.utils.Constants;
import tool.utils.StringUtil;

public class ScaffDDLGen {
	
	private Log log = LogFactory.getLog(getClass());
	
	
	/**
	 * 
	 * @Title: generatorDDL
	 * @Description: 拼接DDL语句
	 * @createdBy:Thread
	 * @createaAt:2019年2月20日上午10:52:25
	 */
	public String generatorDDLByMap(Map<String, Object> Map) {
		StringBuffer sb = new StringBuffer();
		if (Map.get("fields") == null){
			log.debug("生成DDL语句时,未获取到数据...");
		}
		
		// 定义主键数组
		List<String> primaryKeyArray = new ArrayList<>();
		
		/*
		 * 拼接DDL语句
		 */
		String tableName = Map.get("tableName").toString();
		sb.append(Constants.CREATE_TABLE + Constants.HALF_SIZE_SPACE
				+ tableName).append(Constants.HALF_SIZE_SPACE).append(Constants.LEFT_BRACKETS).append(Constants.CR);
		
		List<FiledDDLInfo> filedInfoList = (List<FiledDDLInfo>) Map.get("fields");
		for (FiledDDLInfo n : filedInfoList){
			sb.append(Constants.Quote).append(n.getFiledName()).append(Constants.Quote).append(Constants.HALF_SIZE_SPACE).append(DataBaseTypeEnum.switchJavaType(n.getFiledType()));
			
			// char,varchar,int类型
			if (n.getFiledType() == DataBaseTypeEnum.Char.getKey()
					|| n.getFiledType() == DataBaseTypeEnum.Varchar.getKey()
					|| n.getFiledType() == DataBaseTypeEnum.Int.getKey()){
				sb.append(Constants.LEFT_BRACKETS).append(n.getFiledLength()).append(Constants.RIGHT_BRACKETS);
				// varchar类型增加默认字符
				if (n.getFiledType() == DataBaseTypeEnum.Varchar.getKey()){
					sb.append(Constants.HALF_SIZE_SPACE).append(Constants.COLLATE_UTF8);
				}
			} else if (n.getFiledType() == DataBaseTypeEnum.Double.getKey()){
				// double类型
				sb.append(Constants.LEFT_BRACKETS).append(n.getFiledLength()).append(Constants.COMMA).append(Constants.INT_TWO).append(Constants.RIGHT_BRACKETS);
			}
			
			// 判断是否非空
			sb.append(Constants.HALF_SIZE_SPACE);
			if (n.getValidType() == ValidTypeEnum.NotNull.getKey()){
				sb.append(ValidTypeEnum.DbNotNull.getValue());
			} else{
				sb.append(ValidTypeEnum.DbNULL.getValue());
			}
			
			// 判断是否自增
			if (n.getAuto()){
				sb.append(Constants.HALF_SIZE_SPACE).append(Constants.AUTO_INCREMENT);
			}
			
			// 注释
			if (StringUtil.isNotBlank(n.getNotes())){
				sb.append(Constants.HALF_SIZE_SPACE).append(Constants.COMMENT).append(Constants.HALF_SIZE_SPACE).append(Constants.SQM).append(n.getNotes()).append(Constants.SQM);
			}
			sb.append(Constants.COMMA).append(Constants.CR);
			
			// 主键增加到主键数组
			if (n.getPrimaryKey()){
				primaryKeyArray.add(n.getFiledName());
			}
		}
		
		// 没有主键
		if (primaryKeyArray.size() == 0){
			sb = new StringBuffer(
					sb.substring(0, sb.length() - 1)).append(Constants.CR).append(Constants.RIGHT_BRACKETS);
		} else{
			sb.append(Constants.PRIMARY_KEY).append(Constants.HALF_SIZE_SPACE).append(Constants.LEFT_BRACKETS);
			for (String primaryKey : primaryKeyArray){
				sb.append(Constants.SQM).append(primaryKey).append(Constants.SQM);
			}
			sb.append(Constants.RIGHT_BRACKETS).append(Constants.CR);
		}
		
		sb.append(Constants.RIGHT_BRACKETS).append("ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin");
		
		// 表注释
		if (Map.containsKey("notes")){
			sb.append(Constants.HALF_SIZE_SPACE).append("COMMENT=").append(Constants.SQM).append(Map.get("notes").toString()).append(Constants.SQM).append(Constants.SEMICOLON);
		}
		
		log.debug(tableName + "表建表语句 开始***************");
		log.debug(sb.toString());
		log.debug(tableName + "表建表语句 结束***************");
		
		return sb.toString();
	}
}
