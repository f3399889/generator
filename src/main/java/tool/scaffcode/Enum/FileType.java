package tool.scaffcode.Enum;

public enum FileType {
	JAVA(".java"), XML(".xml");
	
	private FileType(String value) {
		this.value = value;
	}
	
	private String value;
	
	
	public String getValue() {
		return value;
	}
}
