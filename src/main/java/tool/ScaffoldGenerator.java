package tool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONArray;

import tool.memory.MemoryUtil;
import tool.memory.PackageUtil;
import tool.scaffcode.ScaffoldGen;
import tool.scaffddl.ScaffDDLoldGen;
import tool.utils.Constants;
import tool.utils.FileUtil;
import tool.utils.StringUtil;

public class ScaffoldGenerator {
	
	private static Log log = LogFactory.getLog(ScaffoldGenerator.class);
	
	
	public static void main(String[] args) {
//		GeneratorPath("C:\\Users\\myemi\\Desktop\\1.txt", "C:\\Users\\myemi\\Desktop");
		GeneratorPath("D:\\json代码示例.json", "C:\\Users\\Thread\\Desktop");
	}
	
	
	/**
	 * 
	 * @Title: GeneratorPath
	 * @Description: 生成DDL文件
	 * @param InputPath
	 *            导入JSON数据文件路径
	 * @param OutputPath
	 *            导出DDL文件路径
	 * @createdBy:Thread
	 * @createaAt:2019年2月20日下午3:06:11
	 */
	public static void GeneratorPath(String InputPath, String OutputPath) {
		// 校验,填充缓存
		memoryCache(InputPath);
		
		// 判断是否继续生成文件
		if (MemoryUtil.instance.isGenerator){
			// 初始化路径信息
			PackageUtil.instance.init(OutputPath, MemoryUtil.instance.packageName);
			// 生成Java文件
			GeneratorJAVA();
			// 生成DDL文件
			GeneratorDDL();
		}
		// 清除数据
		MemoryUtil.instance.clear();
	}
	
	
	/**
	 * 
	 * @Title: GeneratorJAVA
	 * @Description: 通过JSON生成Java文件主类入口
	 * @param txt2String
	 * @param outputPath
	 * @createdBy:Thread
	 * @createaAt:2019年2月21日上午9:57:50
	 */
	private static void GeneratorJAVA() {
		ScaffoldGen gen = new ScaffoldGen();
		gen.execute();
	}
	
	
	/**
	 * 
	 * @Title: Generator
	 * @Description: 通过JSON生成DDL语句主类入口
	 * @param txt2String
	 * @param outputPath
	 * @createdBy:Thread
	 * @createaAt:2019年2月19日下午2:46:18
	 */
	private static void GeneratorDDL() {
		// 生成代码
		ScaffDDLoldGen generator = new ScaffDDLoldGen();
		generator.executue();
	}
	
	
	/**
	 * 
	 * @Title: memoryCache
	 * @Description: 验证JSON字符串,并且填充缓存
	 * @param json
	 * @createdBy:Thread
	 * @createaAt:2019年2月21日上午10:10:13
	 */
	private static void memoryCache(String InputPath) {
		// 从文件读取JSON字符串
		String json = FileUtil.txt2String(InputPath);
		if (StringUtil.isBlank(json)){
			log.debug("JSON字符串为空!");
			MemoryUtil.instance.isGenerator = false;
			return;
		}
		
		// 验证json字符串
		JSONArray jsonArray = JSONArray.parseArray(json);
		if (jsonArray == null || jsonArray.size() <= Constants.INT_ZERO){
			log.debug("JSON字符串解析出错!");
			MemoryUtil.instance.isGenerator = false;
			return;
		}
		
		// 存入缓存
		MemoryUtil.instance.isGenerator(jsonArray);
	}
}
