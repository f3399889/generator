package tool.scaffcode;

import java.io.File;
import java.io.IOException;

import org.apache.velocity.VelocityContext;

import tool.memory.PackageUtil;
import tool.scaffcode.Enum.ClassTypeEnum;
import tool.scaffcode.Enum.FileType;
import tool.utils.VelocityUtil;

/*
 * 生成Model文件实现类
 */
public class ServiceImplGenerator extends BaseGenerator {
	
	public ServiceImplGenerator(String vmPath, String vmName) {
		super(vmPath, vmName);
	}
	
	
	@Override
	public void Generator(String entityName) {
		// 模板上下文
		VelocityContext ctx = new VelocityContext();
		ctx.put("package", PackageUtil.instance.getPackageServiceImpl());
		ctx.put("packageEntity", PackageUtil.instance.getPackageEntity());
		ctx.put("entity", entityName);
		ctx.put("serviceImplName", entityName + this.vmName);
		ctx.put("superServiceClass", "IService");
		ctx.put("superServiceClassPackage", "com.baomidou.mybatisplus.service.IService");
		ctx.put("superServiceImplClassPackage", "com.baomidou.mybatisplus.service.impl.ServiceImpl");
		ctx.put("superServiceImplClass", "ServiceImpl");
		ctx.put("mapperName", entityName + ClassTypeEnum.Mapper.getValue());
		ctx.put("packageMapper", PackageUtil.instance.getPackageDao());
		ctx.put("packageService", PackageUtil.instance.getPackageService());
		ctx.put("serviceName", PackageUtil.instance.getPackageService());
		try{
			// Controller
			String fileName = new StringBuilder(
					PackageUtil.instance.getPathServiceImpl()).append(File.separator).append(entityName).append(this.vmName).append(FileType.JAVA.getValue()).toString();
			VelocityUtil.vmToFile(ctx, this.vmPath, fileName);
		} catch (IOException e){
			log.debug("生成" + entityName + this.vmName + "模板失败....");
		}
	}
	
}
