package tool.scaffcode;

import java.io.File;
import java.io.IOException;

import org.apache.velocity.VelocityContext;

import tool.memory.PackageUtil;
import tool.scaffcode.Enum.FileType;
import tool.utils.VelocityUtil;

/*
 * 生成Model文件实现类
 */
public class ServiceGenerator extends BaseGenerator {
	
	public ServiceGenerator(String vmPath, String vmName) {
		super(vmPath, vmName);
	}
	
	
	@Override
	public void Generator(String entityName) {
		// 模板上下文
		VelocityContext ctx = new VelocityContext();
		ctx.put("package", PackageUtil.instance.getPackageService());
		ctx.put("packageEntity", PackageUtil.instance.getPackageEntity());
		ctx.put("entity", entityName);
		ctx.put("serviceName", entityName + this.vmName);
		ctx.put("superServiceClass", "IService");
		ctx.put("superServiceClassPackage", "com.baomidou.mybatisplus.service.IService");
		try{
			// Controller
			String fileName = new StringBuilder(
					PackageUtil.instance.getPathService()).append(File.separator).append(entityName).append(this.vmName).append(FileType.JAVA.getValue()).toString();
			VelocityUtil.vmToFile(ctx, this.vmPath, fileName);
		} catch (IOException e){
			log.debug("生成" + entityName + this.vmName + "模板失败....");
		}
	}
	
}
