package tool.scaffcode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import tool.memory.MemoryUtil;
import tool.memory.PackageUtil;
import tool.scaffcode.Enum.FileType;
import tool.scaffddl.FiledDDLInfo;
import tool.utils.Constants;
import tool.utils.VelocityUtil;

/*
 * 生成Model文件实现类
 */
public class MapperGenerator extends BaseGenerator {
	
	public MapperGenerator(String vmPath, String vmName) {
		super(vmPath, vmName);
	}
	
	
	@Override
	public void Generator(String entityName) {
		// 模板上下文
		VelocityContext ctx = new VelocityContext();
		ctx.put("packageMapper", PackageUtil.instance.getPackageMapper());
		ctx.put("packageEntity", PackageUtil.instance.getPackageEntity());
		ctx.put("mapperName", entityName + this.vmName);
		ctx.put("entity", entityName);
		ctx.put("enableCache", false);
		
		Map<String, Object> entityModel = MemoryUtil.instance.entityMap.get(entityName);
		ctx.put("tableName", entityModel.get("tableName").toString());
		
		ArrayList<FiledDDLInfo> fields = (ArrayList<FiledDDLInfo>) entityModel.get("fields");
		ctx.put("fields", fields);
		
		StringBuffer sb = new StringBuffer();
		for (FiledDDLInfo filedDDLInfo : fields){
			sb.append(Constants.HALF_SIZE_SPACE).append(filedDDLInfo.getFiledName()).append(Constants.HALF_SIZE_SPACE).append("AS").append(Constants.HALF_SIZE_SPACE).append(filedDDLInfo.getEntityFiledName()).append(Constants.COMMA);
		}
		
		ctx.put("fieldsStr", sb.substring(0, sb.length() - 1).toString());
		
		GeneratorChildren(entityModel);
		try{
			// Controller
			String fileName = new StringBuilder(
					PackageUtil.instance.getPathMapper()).append(File.separator).append(entityName).append(this.vmName).append(FileType.XML.getValue()).toString();
			VelocityUtil.vmToFile(ctx, this.vmPath, fileName);
		} catch (IOException e){
			log.debug("生成" + entityName + this.vmName + "模板失败....");
		}
	}
	
	
	private void GeneratorChildren(Map<String, Object> entityModel) {
		if (entityModel.containsKey("children")){
			List<Map<String, Object>> children = (List<Map<String, Object>>) entityModel.get("children");
			for (Map<String, Object> map : children){
				String childName = map.get("entityName").toString();
				MapperGenerator childGenerator = new MapperGenerator(this.vmPath, this.vmName);
				childGenerator.Generator(childName);
			}
		}
	}
	
}
