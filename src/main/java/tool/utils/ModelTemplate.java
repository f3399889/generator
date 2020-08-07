package tool.utils;

import java.util.ArrayList;
import java.util.List;

public class ModelTemplate {
	private String					entityPackage;
	private String					name;
	private String					idGenType;
	private String					addTabeName;
	private boolean					hasDate		= false;
	private boolean					hasDecimal	= false;
	private String					notes;
	private String					date;
	private String					author;
	private String					tableName;
	private boolean					hasChildren;
	private boolean					valid		= false;
	private List<Object>			children	= new ArrayList<Object>();
	private List<FieldsTemplete>	fields		= new ArrayList<FieldsTemplete>();
	
	
	public boolean isValid() {
		return valid;
	}
	
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
	public boolean isHasChildren() {
		return hasChildren;
	}
	
	
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
	
	public List<Object> getChildren() {
		return children;
	}
	
	
	public void setChildren(List<Object> children) {
		this.children = children;
	}
	
	
	public String getEntityPackage() {
		return entityPackage;
	}
	
	
	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getIdGenType() {
		return idGenType;
	}
	
	
	public void setIdGenType(String idGenType) {
		this.idGenType = idGenType;
	}
	
	
	public String getAddTabeName() {
		return addTabeName;
	}
	
	
	public void setAddTabeName(String addTabeName) {
		this.addTabeName = addTabeName;
	}
	
	
	public boolean getHasDate() {
		return hasDate;
	}
	
	
	public void setHasDate(boolean hasDate) {
		this.hasDate = hasDate;
	}
	
	
	public boolean getHasDecimal() {
		return hasDecimal;
	}
	
	
	public void setHasDecimal(boolean hasDecimal) {
		this.hasDecimal = hasDecimal;
	}
	
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public String getDate() {
		return date;
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getAuthor() {
		return author;
	}
	
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public String getTableName() {
		return tableName;
	}
	
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	public List<FieldsTemplete> getFields() {
		return fields;
	}
	
	
	public void setFields(List<FieldsTemplete> fields) {
		this.fields = fields;
	}
	
}
