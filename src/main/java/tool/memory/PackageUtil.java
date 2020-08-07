package tool.memory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

public enum PackageUtil {
	instance;
	private String				packageName			= "";
	private String				packageController	= packageName + ".web";
	private String				packageService		= packageName + ".service";
	private String				packageServiceImpl	= packageName + ".service.impl";
	private String				packageDao			= packageName + ".dao";
	private String				packageEntity		= packageName + ".model";
	private String				packageMapper		= packageName + ".model";
	
	private String				pathController;
	private String				pathService;
	private String				pathServiceImpl;
	private String				pathDao;
	private String				pathEntity;
	private String				pathMapper;
	private String				pathPackage;
	
	private Map<String, String>	pathInfo			= new HashMap<String, String>();
	private Map<String, String>	packageInfo			= new HashMap<String, String>();
	
	private String				controllerVm		= "/template/controller.java.vm";
	private String				serviceVm			= "/template/service.java.vm";
	private String				serviceImplVm		= "/template/serviceImpl.java.vm";
	private String				daoVm				= "/template/mapper.java.vm";
	private String				entityVm			= "/template/entity.java.vm";
	private String				MapperVm			= "/template/mapper.xml.vm";
	
	
	public void init(String parentDir, String packageName) {
		this.packageName = packageName;
		this.packageController = packageName + ".web";
		this.packageService = packageName + ".service";
		this.packageServiceImpl = packageName + ".service.impl";
		this.packageDao = packageName + ".dao";
		this.packageEntity = packageName + ".model";
		this.packageMapper = packageName + ".model";
		
		packageInfo.put("controller", packageController);
		packageInfo.put("serviceImpl", packageServiceImpl);
		packageInfo.put("service", packageService);
		packageInfo.put("dao", packageDao);
		packageInfo.put("entity", packageEntity);
		packageInfo.put("mapper", packageMapper);
		
		this.pathController = joinPath(parentDir, packageController);
		this.pathService = joinPath(parentDir, packageService);
		this.pathServiceImpl = joinPath(parentDir, packageServiceImpl);
		this.pathDao = joinPath(parentDir, packageDao);
		this.pathEntity = joinPath(parentDir, packageEntity);
		this.pathMapper = joinPath(parentDir, packageMapper);
		this.pathPackage = joinPath(parentDir, packageName);
		
		pathInfo.put("controller", pathController);
		pathInfo.put("serviceImpl", pathService);
		pathInfo.put("service", pathServiceImpl);
		pathInfo.put("dao", pathDao);
		pathInfo.put("entity", pathEntity);
		pathInfo.put("mapper", pathMapper);
		
		// 创建文件夹
		mkdirs(PackageUtil.instance.getPathInfo());
	}
	
	
	private String joinPath(String parentDir, String packageName) {
		if (StringUtils.isEmpty(parentDir)){
			parentDir = System.getProperty("java.io.tmpdir");
		}
		if (!StringUtils.endsWith(parentDir, File.separator)){
			parentDir = parentDir + File.separator;
		}
		packageName = packageName.replaceAll("\\.", "\\" + File.separator);
		return parentDir + packageName;
	}
	
	
	/**
	 * 
	 * @Title: mkdirs
	 * @Description: 创建web,dao,service,model文件夹
	 * @param pathInfo
	 * @createdBy:Thread
	 * @createaAt:2019年2月21日下午4:55:32
	 */
	private void mkdirs(Map<String, String> pathInfo) {
		for (Entry<String, String> pathEntry : pathInfo.entrySet()){
			String path = pathEntry.getValue();
			File pathFile = new File(path);
			if (!pathFile.exists()){
				pathFile.mkdirs();
			}
		}
	}
	
	
	public String getPathController() {
		return pathController;
	}
	
	
	public String getPathService() {
		return pathService;
	}
	
	
	public String getPathServiceImpl() {
		return pathServiceImpl;
	}
	
	
	public String getPathDao() {
		return pathDao;
	}
	
	
	public String getPathEntity() {
		return pathEntity;
	}
	
	
	public String getPathMapper() {
		return pathMapper;
	}
	
	
	public String getPackageName() {
		return packageName;
	}
	
	
	public String getPackageController() {
		return packageController;
	}
	
	
	public String getPackageService() {
		return packageService;
	}
	
	
	public String getPackageServiceImpl() {
		return packageServiceImpl;
	}
	
	
	public String getPackageDao() {
		return packageDao;
	}
	
	
	public String getPackageEntity() {
		return packageEntity;
	}
	
	
	public String getPackageMapper() {
		return packageMapper;
	}
	
	
	public Map<String, String> getPathInfo() {
		return pathInfo;
	}
	
	
	public Map<String, String> getPackageInfo() {
		return packageInfo;
	}
	
	
	public String getControllerVm() {
		return controllerVm;
	}
	
	
	public String getServiceVm() {
		return serviceVm;
	}
	
	
	public String getServiceImplVm() {
		return serviceImplVm;
	}
	
	
	public String getDaoVm() {
		return daoVm;
	}
	
	
	public String getEntityVm() {
		return entityVm;
	}
	
	
	public String getMapperVm() {
		return MapperVm;
	}
	
	
	public String getPathPackage() {
		return pathPackage;
	}
	
}
