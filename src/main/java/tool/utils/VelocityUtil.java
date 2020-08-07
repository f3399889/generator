package tool.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityUtil {
	public static VelocityEngine ve = null;
	
	/*
	 * 初始velocity引擎
	 */
	static{
		if (ve == null){
			Properties p = new Properties();
			p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			p.setProperty("file.resource.loader.path", "");
			p.setProperty("ISO-8859-1", "UTF-8");
			p.setProperty("input.encoding", "UTF-8");
			p.setProperty("output.encoding", "UTF-8");
			p.setProperty("file.resource.loader.unicode", "true");
			ve = new VelocityEngine(p);
			ve.init();
		}
	}
	
	
	/**
	 * 
	 * @Title: vmToFile
	 * @Description: 生成代码文件
	 * @param context
	 * @param templatePath
	 * @param outputFile
	 * @throws IOException
	 * @createdBy:Thread
	 * @createaAt:2019年2月22日下午1:55:58
	 */
	public static void vmToFile(VelocityContext context, String templatePath, String outputFile) throws IOException {
		Template template = ve.getTemplate(templatePath, "UTF-8");
		FileOutputStream fos = new FileOutputStream(outputFile);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
		template.merge(context, writer);
		writer.close();
	}
	
}
