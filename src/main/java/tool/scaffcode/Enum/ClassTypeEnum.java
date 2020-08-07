package tool.scaffcode.Enum;

public enum ClassTypeEnum {
	Controller("Controller"), Service("Service"), ServiceImpl("ServiceImpl"), Entity("Entity"), Mapper("Mapper");
	private String value;
	
	
	private ClassTypeEnum(String value) {
		this.value = value;
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public void setValue(String value) {
		this.value = value;
	}
}
