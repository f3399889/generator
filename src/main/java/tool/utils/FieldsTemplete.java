package tool.utils;

import com.alibaba.fastjson.JSONObject;

public class FieldsTemplete {
	private String		notes;
	private String		name;
	private String		propertyType;
	private String		tableName;
	private boolean		keyFlag;
	private boolean		hasValid	= false;
	private boolean		hasExpress	= false;
	private String		validType;
	private JSONObject	validExpress;
	
	
	public boolean isHasExpress() {
		return hasExpress;
	}
	
	
	public void setHasExpress(boolean hasExpress) {
		this.hasExpress = hasExpress;
	}
	
	
	public boolean isHasValid() {
		return hasValid;
	}
	
	
	public void setHasValid(boolean hasValid) {
		this.hasValid = hasValid;
	}
	
	
	public String getValidType() {
		return validType;
	}
	
	
	public void setValidType(String validType) {
		this.validType = validType;
	}
	
	
	public JSONObject getValidExpress() {
		return validExpress;
	}
	
	
	public void setValidExpress(JSONObject validExpress) {
		this.validExpress = validExpress;
	}
	
	
	public String getTableName() {
		return tableName;
	}
	
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPropertyType() {
		return propertyType;
	}
	
	
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	
	public boolean getKeyFlag() {
		return keyFlag;
	}
	
	
	public void setKeyFlag(boolean keyFlag) {
		this.keyFlag = keyFlag;
	}
	
}
