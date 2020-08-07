package tool.scaffcode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tool.scaffcode.interfec.GeneratorCode;

/**
 * *********************************
 * 
 * @ClassName: BaseGenerator.java
 * @Description: 生成代码文件基类
 * @author: Thread
 * @createdAt: 2019年2月22日下午3:12:45
 **********************************
 */
public abstract class BaseGenerator implements GeneratorCode {
	public static Log	log	= LogFactory.getLog(ControllerGenerator.class);
	
	// vm
	public String		vmPath;
	public String		vmName;
	
	
	public BaseGenerator(String vmPath, String vmName) {
		super();
		this.vmPath = vmPath;
		this.vmName = vmName;
	}
	
	
	public String getVmPath() {
		return vmPath;
	}
	
	
	public void setVmPath(String vmPath) {
		this.vmPath = vmPath;
	}
	
	
	public String getVmName() {
		return vmName;
	}
	
	
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	
	
	@Override
	public void Generator(String entityName) {
	}
}
