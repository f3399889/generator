package tool.scaffddl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * *********************************
 * 
 * @ClassName: FiledDDLInfo.java
 * @Description: 生成DDL的Filed字段属性
 * @author: Thread
 * @createdAt: 2019年2月19日下午2:49:34
 **********************************
 */

public class FiledDDLInfo {
	
	private Log			DevLog		= LogFactory.getLog(getClass());
	/*
	 * 表字段名
	 */
	private String		filedName;
	/*
	 * 类字段名
	 */
	private String		EntityFiledName;
	
	/*
	 * 表字段类型
	 */
	private int			filedType;
	
	/*
	 * 注释
	 */
	private String		notes;
	
	/*
	 * 字段是否主键
	 */
	private Boolean		primaryKey	= false;
	
	/*
	 * 只针对于数字开启自增
	 */
	private Boolean		auto		= false;
	
	/*
	 * 字段校验
	 */
	private int			validType;
	
	/*
	 * 字段校验表达式
	 */
	private JSONObject	validExpress;
	
	/*
	 * 字段长度
	 */
	private Long		filedLength;
	
	
	public FiledDDLInfo() {
		super();
	}
	
	
	/*
	 * 生成一个字段DDL类
	 */
	public FiledDDLInfo(JSONObject json) {
		try{
			if (json.containsKey("primaryKey")){
				this.primaryKey = json.getBoolean("primaryKey");
			}
			if (json.containsKey("tableFiledName")){
				this.filedName = json.getString("tableFiledName");
			}
			if (json.containsKey("length")){
				this.filedLength = json.getLong("length");
			}
			if (json.containsKey("code")){
				this.EntityFiledName = json.getString("code");
			}
			if (json.containsKey("type")){
				this.filedType = json.getIntValue("type");
				// 如果是主键就判断是否自增
				if (this.primaryKey){
					if (json.containsKey("auto")){
						this.auto = json.getBoolean("auto");
					}
				}
			}
			if (json.containsKey("validType")){
				this.validType = json.getIntValue("validType");
			}
			if (json.containsKey("notes")){
				this.notes = json.getString("notes");
			}
			if (json.containsKey("validExpress")){
				this.validExpress = json.getJSONObject("validExpress");
			}
		} catch (Exception e){
			DevLog.debug(e.getMessage());
		}
	}
	
	
	public String getEntityFiledName() {
		return EntityFiledName;
	}
	
	
	public void setEntityFiledName(String entityFiledName) {
		EntityFiledName = entityFiledName;
	}
	
	
	public Boolean getPrimaryKey() {
		return primaryKey;
	}
	
	
	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	
	public JSONObject getValidExpress() {
		return validExpress;
	}
	
	
	public void setValidExpress(JSONObject validExpress) {
		this.validExpress = validExpress;
	}
	
	
	public String getFiledName() {
		return filedName;
	}
	
	
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	
	
	public int getFiledType() {
		return filedType;
	}
	
	
	public void setFiledType(int filedType) {
		this.filedType = filedType;
	}
	
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public int getValidType() {
		return validType;
	}
	
	
	public void setValidType(int validType) {
		this.validType = validType;
	}
	
	
	public Long getFiledLength() {
		return filedLength;
	}
	
	
	public void setFiledLength(Long filedLength) {
		this.filedLength = filedLength;
	}
	
	
	public Boolean getAuto() {
		return auto;
	}
	
	
	public void setAuto(Boolean auto) {
		this.auto = auto;
	}
}
