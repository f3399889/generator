package tool.scaffddl.Enum;

/**
 * *********************************
 * 
 * @ClassName: ValidTypeEnum.java
 * @Description: 验证类型
 * @author: Thread
 * @createdAt: 2019年2月20日上午11:12:03
 **********************************
 */
public enum ValidTypeEnum {
	Size(1, "Size"), Pattern(2, "Pattern"), NotNull(3, "NotNull"), DbNotNull(4, "NOT NULL"), DbNULL(5, "DEFAULT NULL");
	
	private Integer	key;
	private String	value;
	
	
	private ValidTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	
	public static String SwitchValidTypeEnum(int type) {
		switch (type) {
			case 1:
				return ValidTypeEnum.Size.getValue();
			case 2:
				return ValidTypeEnum.Pattern.getValue();
			default:
				return ValidTypeEnum.NotNull.getValue();
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
