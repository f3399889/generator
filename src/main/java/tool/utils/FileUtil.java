package tool.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {
	
	private static Log DevLog = LogFactory.getLog(FileUtil.class);
	
	
	/**
	 * 
	 * @Title: creatFile
	 * @Description: 创建文件 写入数据
	 * @param filePath
	 *            生成文件路径
	 * @param fileName
	 *            生成文件名
	 * @param data
	 *            文件内容
	 * @createdBy:Thread
	 * @createaAt:2019年2月20日下午1:53:44
	 */
	public static void creatFile(String filePath, String fileName, String data) {
		File folder = new File(filePath);
		// 文件夹路径不存在
		if (!folder.exists() && !folder.isDirectory()){
			folder.mkdirs();
		}
		// 如果文件不存在就创建
		File file = new File(filePath + fileName + ".txt");
		if (file.exists()){
			file.delete();
		}
		try{
			file.createNewFile();
			// 遍历输出每行
			PrintWriter pfp = new PrintWriter(file, "UTF-8"); // 设置输出文件的编码为utf-8
			pfp.print(data);
			pfp.close();
		} catch (IOException e){
			DevLog.debug("创建文件失败" + e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * @Title: txt2String
	 * @Description: 读取文件
	 * @param path
	 * @return
	 * @createdBy:Thread
	 * @createaAt:2019年2月20日下午1:54:00
	 */
	public static String txt2String(String path) {
		File file = new File(path);
		
		if (!file.exists()){
			return null;
		}
		
		StringBuilder result = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null){// 使用readLine方法，一次读一行
				result.append(s);
			}
			br.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return result.toString();
	}
}
