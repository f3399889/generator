package tool.scaffcode;

import java.util.ArrayList;
import java.util.List;

import tool.memory.MemoryUtil;
import tool.memory.PackageUtil;
import tool.scaffcode.Enum.ClassTypeEnum;
import tool.scaffcode.interfec.GeneratorCode;

public class ScaffoldGen {
	
	public void execute() {
		
		// 生成文件集合
		List<GeneratorCode> generatorList = new ArrayList<>();
		
		// Controller
		ControllerGenerator controllerGenerator = new ControllerGenerator(PackageUtil.instance.getControllerVm(),
				ClassTypeEnum.Controller.getValue());
		generatorList.add(controllerGenerator);
		
		// Model
		ModelGenerator modelGenerator = new ModelGenerator(PackageUtil.instance.getEntityVm(),
				ClassTypeEnum.Entity.getValue());
		generatorList.add(modelGenerator);
		
		// Mapper.xml
		MapperGenerator mapperGenerator = new MapperGenerator(PackageUtil.instance.getMapperVm(),
				ClassTypeEnum.Mapper.getValue());
		generatorList.add(mapperGenerator);
		
		// Mapper
		DaoGenerator daoGenerator = new DaoGenerator(PackageUtil.instance.getDaoVm(), ClassTypeEnum.Mapper.getValue());
		generatorList.add(daoGenerator);
		
		// Service
		ServiceGenerator serviceGenerator = new ServiceGenerator(PackageUtil.instance.getServiceVm(),
				ClassTypeEnum.Service.getValue());
		generatorList.add(serviceGenerator);
		
		// ServiceImpl
		ServiceImplGenerator serviceImplGenerator = new ServiceImplGenerator(PackageUtil.instance.getServiceImplVm(),
				ClassTypeEnum.ServiceImpl.getValue());
		generatorList.add(serviceImplGenerator);
		
		// Util
		
		// 循环主表
		for (String entityName : MemoryUtil.instance.entityList){
			// 类名
//			String entityName = filedTableMap.get("entityName").toString();
			for (GeneratorCode generatorCode : generatorList){
				generatorCode.Generator(entityName);
			}
		}
	}
}
