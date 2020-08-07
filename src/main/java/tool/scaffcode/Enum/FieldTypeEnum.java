package tool.scaffcode.Enum;

public enum FieldTypeEnum {
	String(1, "String"), Char(2, "Char"), Int(3, "Integer"), Double(4, "Double"), Date(5, "Date"), DateTime(6, "Date"), Text(7, "String"), Long(8, "Long"), BigDecimal(9, "BigDecimal"), Boolean(10, "Boolean"), Float(11, "Float");
	
	private Integer	key;
	private String	value;
	
	
	public static String switchJavaType(int type) {
		switch (type) {
			case 1:
				return FieldTypeEnum.String.getValue();
			case 2:
				return FieldTypeEnum.Char.getValue();
			case 3:
				return FieldTypeEnum.Int.getValue();
			case 4:
				return FieldTypeEnum.Double.getValue();
			case 5:
				return FieldTypeEnum.Date.getValue();
			case 6:
				return FieldTypeEnum.Date.getValue();
			case 7:
				return FieldTypeEnum.String.getValue();
			case 8:
				return FieldTypeEnum.Long.getValue();
			case 9:
				return FieldTypeEnum.BigDecimal.getValue();
			case 10:
				return FieldTypeEnum.Boolean.getValue();
			case 11:
				return FieldTypeEnum.Float.getValue();
			default:
				return FieldTypeEnum.String.getValue();
		}
	}
	
	
	private FieldTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
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
