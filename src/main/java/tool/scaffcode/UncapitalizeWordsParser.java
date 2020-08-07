package tool.scaffcode;

import tool.scaffcode.interfec.WordsParser;
import tool.utils.StringUtil;

public class UncapitalizeWordsParser implements WordsParser {
	
	public String parseWords(String orginalString) {
		return StringUtil.uncapitalize(orginalString.toLowerCase());
	}
	
}
