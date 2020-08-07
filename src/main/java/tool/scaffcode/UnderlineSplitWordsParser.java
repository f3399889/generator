package tool.scaffcode;

import org.springframework.util.StringUtils;

import tool.scaffcode.interfec.WordsParser;

public class UnderlineSplitWordsParser implements WordsParser {
	
	public String parseWords(String orginalString) {
		String[] items = orginalString.split("_");
		String result = "";
		for (int i = 0; i < items.length; i++){
			items[i] = items[i].toLowerCase();
			if (i > 0){
				result = result + StringUtils.capitalize(items[i]);
			} else{
				result = result + items[i];
			}
		}
		return result;
	}
}
