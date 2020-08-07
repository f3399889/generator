/**
 * @Title: StringUtil.java
 * @Package com.webgis.common.utils
 */
package tool.utils;

import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Clob;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

/***********************************
 * @ClassName: StringUtil.java
 * @Description: 字符相关类
 * @author: luomingguo
 * @createdAt: 2014-8-26上午10:46:25
 ***********************************/

public class StringUtil {
	// 用来将字节转换成 16 进制表示的字符
	static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	
	public static String getMD5(String data) {
		String s = "";
		byte[] source = data.getBytes();
		try{
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++){ // 从第一个字节开始，对 MD5 的每一个字节
											// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	
	private StringUtil() {
		// nothing
	}
	
	
	/**
	 * encode a password using MD5 algorithm
	 * 
	 * @param password
	 * @return
	 */
	public static String encodePassword(String password) {
		String encodedPassword = null;
		try{
			encodedPassword = encodePassword(password, "MD5");
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return encodedPassword;
	}
	
	
	public static String changeList2String(List<String> list) {
		String tmp = list.toString();
		return tmp.substring(1, tmp.length() - 1);
	}
	
	
	/**
	 * check if the string is blank "" and null return true
	 * 
	 */
	public static boolean isBlank(String str) {
		boolean flag = false;
		if (str == null || "".equals(str.trim())){
			flag = true;
		}
		return flag;
	}
	
	
	public static boolean isBlank(Object obj) {
		boolean flag = false;
		if (obj == null){
			flag = true;
		}
		return flag;
	}
	
	
	public static boolean isBlank(Integer str) {
		if (null != str){
			return isBlank(str.toString());
		}
		return true;
	}
	
	
	/**
	 * 
	 * @Title: isBlank
	 * @Description: 验证bigdecimal是否为空,如果是0.0判断不为空
	 * @param bigDecimal
	 * @return
	 * @createdBy:quansheng
	 * @createaAt:2016年5月10日上午10:38:40
	 */
	public static boolean isBlank(BigDecimal bigDecimal) {
		boolean flag = false;
		if (bigDecimal == null || "".equals(bigDecimal)){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * check if the String is not Blank "" and null return false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		boolean flag = false;
		if (str != null && !"".equals(str) && !"null".equals(str)){
			flag = true;
		}
		return flag;
	}
	
	
	public static boolean isNotBlank(Object obj) {
		boolean flag = false;
		if (obj != null){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * check if the BigDecimal is not Blank "" and null return false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(BigDecimal bigDecimal) {
		boolean flag = false;
		if (bigDecimal != null && !"".equals(bigDecimal)){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * check if the Double is not 0 and null return true
	 * 
	 */
	public static boolean isNotBlank(Double log) {
		boolean flag = false;
		if (log != null && log > 0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * check if the Integer is not 0 and null return true
	 * 
	 */
	public static boolean isNotBlank(Integer log) {
		boolean flag = false;
		if (log != null && log > 0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * check if the long is not 0 and null return true
	 * 
	 */
	public static boolean isNotBlank(Long log) {
		boolean flag = false;
		if (log != null && log > 0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * check if the long is 0 and null return true
	 * 
	 */
	public static boolean isBlank(Long log) {
		boolean flag = false;
		if (log == null || log == 0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * Encode a string using algorithm specified in web.xml and return the
	 * resulting encrypted password. If exception, the plain credentials string
	 * is returned
	 * 
	 * @param password
	 *            Password or other credentials to use in authenticating this
	 *            username
	 * @param algorithm
	 *            Algorithm used to do the digest
	 * 
	 * @return encypted password based on the algorithm.
	 * @throws NoSuchAlgorithmException
	 */
	public static String encodePassword(String password, String algorithm) throws NoSuchAlgorithmException {
		byte[] unencodedPassword = password.getBytes();
		
		MessageDigest md = null;
		
		// first create an instance, given the provider
		md = MessageDigest.getInstance(algorithm);
		
		md.reset();
		
		// call the update method one or more times
		// (useful when you don't know the size of your data, eg. stream)
		md.update(unencodedPassword);
		
		// now calculate the hash
		byte[] encodedPassword = md.digest();
		
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < encodedPassword.length; i++){
			if ((encodedPassword[i] & 0xff) < 0x10){
				buf.append("0");
			}
			
			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		
		return buf.toString();
	}
	
	
	public static boolean isEmpty(String str) {
		if (str == null)
			return true;
		return Constants.NULLSTRING.equals(str) ? true : false;
	}
	
	
	public static boolean isNotEmpty(CharSequence string) {
		return string != null && string.length() > 0;
	}
	
	
	/**
	 * 获取指定长度的随机字串
	 * 
	 * @param length
	 * @return String
	 */
	public static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int i = 0;
		int c;
		while (i < length){
			if ((c = r.nextInt(90)) > 64 || (c = r.nextInt(122)) > 97){
				sb.append((char) c);
				i++;
			}
		}
		return sb.toString();
	}
	
	
	public static boolean contains(String[] arr, String s) {
		if (arr != null){
			for (int i = 0; i < arr.length; i++){
				if (s.equals(arr[i])){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static String ljustZero(int i, int len) {
		return ljustZero(String.valueOf(i), len);
	}
	
	
	public static String ljustZero(String s, int len) {
		String id = "";
		for (int i = 0; i < len - s.length(); i++){
			id += "0";
		}
		id += s;
		return id;
	}
	
	
	public static int getWordLength(String str) {
		int len = 0;
		if (StringUtil.isBlank(str)){
			return len;
		}
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++){
			if (isChinese(ch[i])){
				len = len + 2;
			} else{
				len = len + 1;
			}
		}
		return len;
	}
	
	
	public static String getWord(String str, int max) {
		char[] ch = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int len = 0;
		for (int i = 0; i < ch.length; i++){
			if (isChinese(ch[i])){
				len = len + 2;
			} else{
				len = len + 1;
			}
			if (len > max){
				break;
			}
			sb.append(ch[i]);
		}
		return sb.toString();
	}
	
	
	public static boolean hasChinese(String s) {
		if (s == null)
			return true;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++){
			if (isChinese(chars[i])){
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS){
			return true;
		}
		return false;
	}
	
	
	public static String[] splitIntoArr(String s) {
		if (isEmpty(s))
			return new String[] {};
		return s.split(",");
	}
	
	
	public static String join(String[] arr) {
		return join(arr, ",", "'");
	}
	
	
	public static String join(String[] arr, String separtor) {
		return join(arr, ",", "");
	}
	
	
	public static String join(String[] arr, String separtor, String quota) {
		String result = "";
		for (int i = 0; i < arr.length; i++){
			result = result + quota + arr[i] + quota;
			if (i != arr.length - 1)
				result += separtor;
		}
		return result;
	}
	
	
	/**
	 * 转化字符编码，如convertCode("someStr","iso-8859-1",UTF-8")
	 * 
	 * @param inStr
	 * @param encode1
	 *            原字符串编码
	 * @param encode2
	 *            目标字串编码
	 * @return
	 */
	public static String convertCode(String inStr, String encode1, String encode2) {
		if (isBlank(inStr))
			return Constants.NULLSTRING;
		try{
			return new String(inStr.getBytes(encode1), encode2);
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return inStr;
		}
		
	}
	
	
	public static boolean isUpperCase(String s) {
		boolean result = true;
		char ch;
		for (int i = 0; i < s.length(); i++){
			ch = s.charAt(i);
			if (!(ch >= 'A' && ch <= 'Z')){
				result = false;
			}
		}
		return result;
	}
	
	
	public static boolean isLowerCase(String s) {
		boolean result = true;
		char ch;
		for (int i = 0; i < s.length(); i++){
			ch = s.charAt(i);
			if (!(ch >= 'a' && ch <= 'z')){
				result = false;
			}
		}
		return result;
	}
	
	
	public static int countBlanks(String s) {
		int count = 0;
		char[] chars = s.toCharArray();
		for (char ch : chars){
			if (ch != Constants.CHAR_BLANK){
				break;
			}
			count++;
		}
		return count;
	}
	
	
	/**
	 * oracle.sql.Clob类型转换成String类型
	 * 
	 * @param clob
	 * @return
	 */
	public static String clob2String(Clob clob) {
		if (clob == null){
			return null;
		}
		StringBuffer sb = new StringBuffer(65535);// 64K
		Reader clobStream = null;// 创建一个输入流对象
		try{
			clobStream = clob.getCharacterStream();
			char[] b = new char[60000];// 每次获取60K
			int i = 0;
			while ((i = clobStream.read(b)) != -1){
				sb.append(b, 0, i);
			}
		} catch (Exception ex){
			sb = null;
		} finally{
			try{
				if (clobStream != null)
					clobStream.close();
			} catch (Exception e){
			}
		}
		if (sb == null)
			return null;
		else return sb.toString();
	}
	
	
	/**
	 * 
	 * @Title: concat
	 * @Description: 字符数组合并
	 * @param a
	 * @param b
	 * @return
	 * @Author: bieby
	 * @Date: 2014-1-15
	 */
	public static String[] concat(String[] a, String[] b) {
		String[] c = new String[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
	
	
	/**
	 * 
	 * @Title: getStackTrace
	 * @Description: 获取堆栈日志信息
	 * @param t
	 *            异常
	 * @return 异常堆栈
	 * @Author: bieby
	 * @Date: 2014-4-3
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		t.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}
	
	
	public static void main(String[] args) {
		String uid = "abc";
		String encodeUid = StringUtil.fillString(uid, 8, "\0");
		System.out.println(encodeUid);
	}
	
	
	public static String toLowerCase(String sourceStr) {
		if (StringUtil.isNotBlank(sourceStr)){
			return sourceStr.toLowerCase();
		}
		return "";
	}
	
	
	/**
	 * 
	 * @Title: isEquals
	 * @Description: 判断字符相同
	 * @param str1
	 * @param str2
	 * @return
	 * @createdBy:Kontor
	 * @createaAt:2014年11月10日下午3:19:44
	 */
	public static boolean isEquals(Object o1, Object o2) {
		String str1 = "";
		String str2 = "";
		if (o1 != null){
			str1 = o1.toString();
		}
		if (o2 != null){
			str2 = o2.toString();
		}
		return str1.equals(str2);
	}
	
	
	/**
	 * 将字符串中的html特殊字符转成实体
	 * 
	 * @Title: ConvertHtmlTargToEntity
	 * @Description:
	 * @param value
	 * @return
	 * @createdBy:jiangzw
	 * @createaAt:2014年12月24日下午6:00:29
	 */
	/*
	 * public static String ConvertHtmlTargToEntity(String value) { return
	 * StringEscapeUtils.escapeHtml(value); }
	 */
	
	public static String fillString(String source, int maxLength, String holder) {
		if (source.length() >= maxLength){
			return source.substring(0, maxLength);
		} else{
			int dif = maxLength - source.length();
			StringBuilder temp = new StringBuilder(source);
			for (; dif > 0; dif--){
				temp.append("\0");
			}
			return temp.toString();
		}
	}
	
	
	/**
	 * @Title: returnStrOrValue
	 * @Description: 返回""或者值，用于处理PDF中的null
	 * @param value
	 * @return value
	 * @Author: lit
	 * @Date: 2014-12-31
	 */
	public static String returnStrOrValue(String value) {
		if (StringUtil.isEmpty(value) || "NULL".equals(value) || "null".equals(value)){
			return "";
		}
		return value;
	}
	
	
	/**
	 * @Title: getBigDecimalScale2
	 * @Description: BigDecimal保留两位小数
	 * @param value
	 * @return
	 * @Author: lit
	 * @Date: 2015-1-9
	 */
	public static String getBigDecimalScale2(BigDecimal value) {
		
		if (value == null){
			return "0";
		}
		return new java.text.DecimalFormat("0.##").format(value);
	}
	
	
	/**
	 * 
	 * @Title: isNumeric
	 * @Description: 数字验证
	 * @param str
	 * @return
	 * @createdBy:luomingguo
	 * @createaAt:2014年11月7日下午3:45:53
	 */
	public static boolean isNumeric(String str) {
		return isNumeric(str, false);
	}
	
	
	/**
	 * 
	 * @Title: isNumeric
	 * @Description: 数字验证
	 * @param str
	 * @param isInt
	 *            是否整数
	 * @return
	 * @createdBy:luomingguo
	 * @createaAt:2014年11月7日下午3:45:53
	 */
	public static boolean isNumeric(String str, boolean isInt) {
		if (str == null || str == ""){
			return false;
		}
		String test = "";
		if (isInt){
			test = "[0-9]*";
		} else{
			test = "[0-9]*\\.{0,1}[0-9]*";
		}
		Pattern pattern = Pattern.compile(test);
		return pattern.matcher(str).matches();
	}
	
	
	/**
	 * Capitalizes a string, changing the first letter to upper case. No other
	 * letters are changed.
	 *
	 * @param str
	 *            string to capitalize, may be null
	 * @see #uncapitalize(String)
	 */
	public static String capitalize(String str) {
		return changeFirstCharacterCase(true, str);
	}
	
	
	/**
	 * Uncapitalizes a <code>String</code>, changing the first letter to lower
	 * case. No other letters are changed.
	 *
	 * @param str
	 *            the String to uncapitalize, may be null
	 * @return the uncapitalized String, <code>null</code> if null
	 * @see #capitalize(String)
	 */
	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(false, str);
	}
	
	
	/**
	 * Internal method for changing the first character case.
	 */
	private static String changeFirstCharacterCase(boolean capitalize, String string) {
		int strLen = string.length();
		if (strLen == 0){
			return string;
		}
		
		char ch = string.charAt(0);
		char modifiedCh;
		if (capitalize){
			modifiedCh = Character.toUpperCase(ch);
		} else{
			modifiedCh = Character.toLowerCase(ch);
		}
		
		if (modifiedCh == ch){
			// no change, return unchanged string
			return string;
			
		}
		
		char chars[] = string.toCharArray();
		chars[0] = modifiedCh;
		return new String(chars);
	}
	
	
	/**
	 * Replaces all occurrences of a certain pattern in a string with a
	 * replacement string. This is the fastest replace function known to author.
	 *
	 * @param s
	 *            string to be inspected
	 * @param sub
	 *            string pattern to be replaced
	 * @param with
	 *            string that should go where the pattern was
	 */
	public static String replace(String s, String sub, String with) {
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1){
			return s;
		}
		int length = s.length();
		StringBuilder sb = new StringBuilder(length + with.length());
		do{
			sb.append(s.substring(c, i));
			sb.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < length){
			sb.append(s.substring(c, length));
		}
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @Title: str2Int
	 * @Description: 字符串转数字
	 * @param value
	 * @param defaultValue
	 * @return
	 * @createdBy:Luomingguo
	 * @createaAt:2016年2月19日上午11:18:47
	 */
	public static Integer str2Int(String value, Integer defaultValue) {
		if (isBlank(value) || !isNumeric(value)){
			return defaultValue;
		}
		return Integer.parseInt(value);
	}
	
	
	/**
	 * 
	 * @Title: algorismToHEXString
	 * @Description: 十进制转十六进制
	 * @param algorism
	 * @param maxLength
	 * @return
	 * @createdBy:Luomingguo
	 * @createaAt:2016年2月19日下午2:37:55
	 */
	public static String algorismToHEXString(int algorism, int maxLength) {
		String result = "";
		result = Integer.toHexString(algorism);
		if (result.length() % 2 == 1){
			result = "0" + result;
		}
		return patchHexString(result.toUpperCase(), maxLength);
	}
	
	
	/*
	 * 补“0”
	 */
	public static String patchHexString(String str, int maxLength) {
		String temp = "";
		for (int i = 0; i < maxLength - str.length(); i++){
			temp = "0" + temp;
		}
		str = (temp + str).substring(0, maxLength);
		return str;
	}
	
	
	/**
	 * @Title: getPageMap
	 * @Description: 通过Map获取分页参数
	 * @param queryMap
	 * @return
	 * @createdBy:Administrator
	 * @createaAt:2016年6月14日下午4:27:39
	 */
	public static Map<String, Object> getPageMap(Map<String, Object> queryMap) {
		if (!queryMap.containsKey("page") && !queryMap.containsKey("size")){
			String page = "1";
			String size = "20";
			queryMap.put("page", page);
			queryMap.put("size", size);
		}
		return queryMap;
	}
}
