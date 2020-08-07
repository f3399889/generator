package tool.scaffcode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.alibaba.fastjson.JSONObject;

import tool.memory.MemoryUtil;
import tool.memory.PackageUtil;
import tool.scaffcode.Enum.FieldTypeEnum;
import tool.scaffcode.Enum.FileType;
import tool.scaffddl.FiledDDLInfo;
import tool.scaffddl.Enum.ValidTypeEnum;
import tool.utils.DateUtil;
import tool.utils.FieldsTemplete;
import tool.utils.ModelTemplate;
import tool.utils.VelocityUtil;

/*
 * 生成Model文件实现类
 */
public class ModelGenerator extends BaseGenerator {
	
	public ModelGenerator(String vmPath, String vmName) {
		super(vmPath, vmName);
	}
	
	
	@Override
	public void Generator(String entityName) {
		// 模板上下文
		VelocityContext ctx = new VelocityContext();
		Map<String, Object> entityModel = MemoryUtil.instance.entityMap.get(entityName);
		ModelTemplate template = getTemplate(entityModel);
		// 子类处理
		if (entityModel.containsKey("children")){
			template.setHasChildren(true);
			List<Map<String, Object>> children = (List<Map<String, Object>>) entityModel.get("children");
			for (Map<String, Object> map : children){
				String childName = map.get("entityName").toString();
				ModelGenerator childGenerator = new ModelGenerator(this.vmPath, this.vmName);
				childGenerator.Generator(childName);
				template.getChildren().add(childName);
			}
		}
		ctx.put("package", template);
		try{
			// Controller
			String fileName = new StringBuilder(
					PackageUtil.instance.getPathEntity()).append(File.separator).append(entityName).append(FileType.JAVA.getValue()).toString();
			VelocityUtil.vmToFile(ctx, this.vmPath, fileName);
		} catch (IOException e){
			log.debug("生成" + entityName + this.vmName + "模板失败....");
		}
	}
	
	
	private ModelTemplate getTemplate(Map<String, Object> entityModel) {
		ModelTemplate template = new ModelTemplate();
		template.setEntityPackage(PackageUtil.instance.getPackageEntity());
		template.setName(entityModel.get("entityName").toString());
		template.setAuthor(entityModel.get("author").toString());
		template.setTableName(entityModel.get("tableName").toString());
		template.setDate(DateUtil.getYMDHMS4Date(new Date()));
		template.setNotes(entityModel.get("notes").toString());
		ArrayList<FiledDDLInfo> fields = (ArrayList<FiledDDLInfo>) entityModel.get("fields");
		for (FiledDDLInfo filedDDLInfo : fields){
			FieldsTemplete field = new FieldsTemplete();
			if (filedDDLInfo.getPrimaryKey()){
				template.setIdGenType("AUTO");
				field.setKeyFlag(true);
			}
			field.setName(filedDDLInfo.getEntityFiledName());
			field.setTableName(filedDDLInfo.getFiledName());
			field.setPropertyType(FieldTypeEnum.switchJavaType(filedDDLInfo.getFiledType()));
			if (!template.getHasDecimal()
					&& filedDDLInfo.getFiledType() == FieldTypeEnum.BigDecimal.getKey().intValue()){
				template.setHasDecimal(true);
			}
			if (!template.getHasDate() && (filedDDLInfo.getFiledType() == FieldTypeEnum.Date.getKey().intValue()
					|| filedDDLInfo.getFiledType() == FieldTypeEnum.DateTime.getKey().intValue())){
				template.setHasDate(true);
			}
			if (filedDDLInfo.getValidType() != 0){
				if (!template.isValid()){
					template.setValid(true);
				}
				field.setHasValid(true);
				field.setValidType(ValidTypeEnum.SwitchValidTypeEnum(filedDDLInfo.getValidType()));
				JSONObject validExpress = filedDDLInfo.getValidExpress();
				if (validExpress != null){
					field.setHasExpress(true);
					field.setValidExpress(validExpress);
				}
			}
			field.setNotes(filedDDLInfo.getNotes());
			template.getFields().add(field);
		}
		return template;
	}
	
}
