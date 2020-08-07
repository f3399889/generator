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
public class DaoGenerator extends BaseGenerator {
	
	public DaoGenerator(String vmPath, String vmName) {
		super(vmPath, vmName);
	}
	
	
	@Override
	public void Generator(String entityName) {
		// 模板上下文
		VelocityContext ctx = new VelocityContext();
		
		ctx.put("package", PackageUtil.instance.getPackageDao());
		ctx.put("packageEntity", PackageUtil.instance.getPackageEntity());
		ctx.put("entity", entityName);
		ctx.put("mapperName", entityName + this.vmName);
		ctx.put("superMapperClass", "BaseMybatisDAO");
		ctx.put("superMapperClassPackage", "cn.wine.base.dao.BaseMybatisDAO");
		
		try{
			// Controller
			String fileName = new StringBuilder(
					PackageUtil.instance.getPathDao()).append(File.separator).append(entityName).append(this.vmName).append(FileType.JAVA.getValue()).toString();
			VelocityUtil.vmToFile(ctx, this.vmPath, fileName);
		} catch (IOException e){
			log.debug("生成" + entityName + this.vmName + "模板失败....");
		}
	}
	
}
