package tool.scaffddl.Enum;

/**
 * *********************************
 * 
 * @ClassName: JavaTypeEnum.java
 * @Description: java类型与数据库类型
 * @author: Thread
 * @createdAt: 2019年2月20日上午11:12:03
 **********************************
 */
public enum DataBaseTypeEnum {
	Varchar(1, "varchar"), Char(2, "char"), Int(3, "int"), Double(4, "double"), Date(5, "date"), Time(6, "time"), Text(7, "text");
	
	private Integer	key;
	private String	value;
	
	
	private DataBaseTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	
	public static String switchJavaType(int type) {
		switch (type) {
			case 1:
				return DataBaseTypeEnum.Varchar.getValue();
			case 2:
				return DataBaseTypeEnum.Char.getValue();
			case 3:
				return DataBaseTypeEnum.Int.getValue();
			case 4:
				return DataBaseTypeEnum.Double.getValue();
			case 5:
				return DataBaseTypeEnum.Date.getValue();
			case 6:
				return DataBaseTypeEnum.Time.getValue();
			default:
				return DataBaseTypeEnum.Text.getValue();
		}
	}
	
	
	public Integer getKey() {
		return key;
	}
	
	
	public void setKey(Integer key) {
		this.key = key;
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public void setValue(String value) {
		this.value = value;
	}
}
