package tool.utils;

import java.io.File;

public class Constants {
	
	/****************** 业务相关常量 开始 **************************/
	/**
	 * page参数默认 1
	 */
	public static final String	PAGE_VALUE					= "1";
	/**
	 * size参数默认 20
	 */
	public static final String	PAGE_SIZE					= "20";
	/**
	 * FALSE
	 */
	public static final String	STRING_FALSE				= "FALSE";
	/**
	 * SUCCESS
	 */
	public static final String	STRING_SUCCESS				= "SUCCESS";
	
	/**
	 * 登录验证码
	 */
	public static final String	SESSION_KEY_RAND			= "rand";
	
	/**
	 * 127.0.0.1
	 */
	public static final String	LOCALHOST_V4				= "127.0.0.1";
	
	/**
	 * 0:0:0:0:0:0:0:1
	 */
	public static final String	LOCALHOST_V6				= "0:0:0:0:0:0:0:1";
	
	/****************** 业务相关常量 结束 **************************/
	
	/****************** 通用常量 开始 **************************/
	/**
	 * 参数格式错误
	 */
	public static final String	PARAMETERS_FORMATTING_ERROR	= "参数格式错误";
	/**
	 * 缺少参数
	 */
	public static final String	MISSING_PARAMETERS			= "缺少参数";
	/**
	 * 缺少参数
	 */
	public static final String	SAVE_ERROR					= "保存失败";
	
	public static final String	DELETE_ERROR				= "删除失败";
	
	public static final String	UPDATE_ERROR				= "更新失败";
	/**
	 * 登录名已存在
	 */
	public static final String	LOGINID_EXISTS				= "登录名已存在";
	/**
	 * 部门名称已存在
	 */
	public static final String	DEPT_EXISTS					= "部门名称已存在";
	/**
	 * 角色名称已存在
	 */
	public static final String	ROLE_EXISTS					= "角色名称已存在";
	/**
	 * 查询失败
	 */
	public static final String	QUERY_FAIL					= "查询失败";
	/**
	 * 无数据
	 */
	public static final String	NO_DATAS					= "数据不存在";
	/**
	 * 添加失败
	 */
	public static final String	ADD_FAIL					= "添加失败";
	/**
	 * 记录已存在
	 */
	public static final String	EXISTING_RECORD				= "记录已存在";
	/**
	 * Session失效
	 */
	public static final String	SESSION_INVALID				= "当前登录用户身份验证过期";
	/**
	 * 没有权限
	 */
	public static final String	NO_POWER					= "没有权限 ";
	/**
	 * 远程调用失败
	 */
	public static final String	RMI_FAILED					= "远程调用失败";
	/**
	 * 开
	 */
	public static final String	OPEN						= "开";
	/**
	 * 关
	 */
	public static final String	CLOSE						= "关";
	/**
	 * on
	 */
	public static final String	ON							= "on";
	/**
	 * ELSE
	 */
	public static final String	ELSE						= "ELSE ";
	/**
	 * grid传递分页页码page参数名
	 */
	public static final String	PAGE						= "page";
	/**
	 * grid传递分页页数rows参数名
	 */
	public static final String	ROW							= "rows";
	/**
	 * SQL倒序
	 */
	public static final String	SORT_DESC					= "desc";
	/**
	 * SQL正序
	 */
	public static final String	SORT_ASC					= "asc";
	
	/**
	 * 查询字段
	 */
	public static final String	SEARCH_KEY_Q				= "q";
	/**
	 * 返回页面key值：id
	 */
	public static final String	ID							= "id";
	/**
	 * 返回页面key值：success
	 */
	public static final String	SUCCESS						= "success";
	/**
	 * 返回页面key值：message
	 */
	public static final String	MESSAGE						= "message";
	
	/**
	 * 编码格式UTF-8
	 */
	public static final String	UTF8						= "UTF-8";
	
	/*
	 * 数据库DDL UTF-8
	 */
	public static final String	COLLATE_UTF8				= "COLLATE utf8_bin";
	/*
	 * 数据库DDL AUTO_INCREMENT
	 */
	public static final String	AUTO_INCREMENT				= "AUTO_INCREMENT";
	/*
	 * 数据库DDL PRIMARY KEY
	 */
	public static final String	PRIMARY_KEY					= "PRIMARY KEY";
	/*
	 * 数据库DDL CREATE TABLE
	 */
	public static final String	CREATE_TABLE				= "CREATE TABLE";
	/*
	 * 数据库DDL COMMENT
	 */
	public static final String	COMMENT						= "COMMENT";
	
	/**
	 * 编码格式GBK
	 */
	public static final String	GBK							= "GBK";
	
	/**
	 * 编码格式GB2312
	 */
	public static final String	GB2312						= "GB2312";
	
	/**
	 * Space
	 */
	public static final String	HALF_SIZE_SPACE				= " ";
	
	/**
	 * 空字符串
	 */
	public static final String	NULLSTRING					= "";
	
	/**
	 * 斜杠
	 */
	public static final String	SLASH						= "/";
	
	/**
	 * 中划线
	 */
	public static final String	HALF_SIZE_HYPHEN			= "-";
	
	/**
	 * 下划线
	 */
	public static final String	UNDERLINE					= "_";
	/**
	 * 波浪号
	 */
	public static final String	TILDE						= "~";
	
	/**
	 * 引用符
	 */
	public static final String	Quote						= "`";
	
	/**
	 * 反斜杠
	 */
	public static final String	WQ							= "\"";
	
	/**
	 * 竖号
	 */
	public static final String	VC							= "\\|";
	
	/**
	 * 点
	 */
	public static final String	DOT							= ".";
	/**
	 * 空格
	 */
	public static final char	CHAR_BLANK					= ' ';
	/**
	 * 冒号
	 */
	public final static String	COLON						= ":";
	/**
	 * 分号
	 */
	public final static String	SEMICOLON					= ";";
	/**
	 * 逗号
	 */
	public final static String	COMMA						= ",";
	/**
	 * 单引号
	 */
	public final static String	SQM							= "'";
	/**
	 * 左括号
	 */
	public final static String	LEFT_BRACKETS				= "(";
	/**
	 * 右括号
	 */
	public final static String	RIGHT_BRACKETS				= ")";
	/**
	 * 文件分隔符
	 */
	public final static String	FILE_SEPARATOR				= File.separator;
	
	/**
	 * 换行（CRLF）
	 */
	public static final String	CRLF						= "\r\n";
	
	/**
	 * 换行（CR）0x0d
	 */
	public static final String	CR							= "\r";
	
	/**
	 * 换行（LF）0x0a
	 */
	public static final String	LF							= "\n";
	
	/**
	 * tab
	 */
	public static final String	TAB							= "\t";
	/**
	 * br
	 */
	public static final String	BR							= "<br>";
	
	/**
	 * HTTP
	 */
	public static final String	HTTP						= "http";
	
	/**
	 * HTTPS
	 */
	public static final String	HTTPS						= "https";
	
	/**
	 * 后缀PDF
	 */
	public static final String	EXTENSION_PDF				= ".pdf";
	
	/**
	 * 后缀HTML
	 */
	public static final String	EXTENSION_HTML				= ".html";
	
	/**
	 * 后缀PNG
	 */
	public static final String	EXTENSION_PNG				= ".png";
	
	/**
	 * 后缀TXT
	 */
	public static final String	EXTENSION_TXT				= ".txt";
	
	/**
	 * 后缀XML
	 */
	public static final String	EXTENSION_XML				= ".xml";
	
	/**
	 * 后缀XLS
	 */
	public static final String	EXTENSION_XLS				= ".xls";
	
	/**
	 * 后缀XLSX
	 */
	public static final String	EXTENSION_XLSX				= ".xlsx";
	
	/**
	 * ?
	 */
	public static final String	REQ_OPR						= "?";
	
	/**
	 * title
	 */
	public static final String	MAIL_PARA_TITLE				= "title";
	
	/**
	 * mail内容
	 */
	public static final String	MAIL_PARA_BODY				= "body";
	
	/**
	 * result
	 */
	public static final String	NODE_RESULT					= "result";
	
	/**
	 * cd
	 */
	public static final String	NODE_ATTRIBUTE_CD			= "cd";
	
	/**
	 * =
	 */
	public static final String	EQUAL_OPR					= "=";
	
	/**
	 * &
	 */
	public static final String	AND_OPR						= "&";
	
	/**
	 * CONTENT TYPE
	 */
	public static final String	CONTENT_TYPE_XML			= "text/xml;charset=UTF-8";
	
	/**
	 * CONTENT TYPE
	 */
	public static final String	CONTENT_TYPE_DOWNLOAD		= "application/x-download";
	
	/**
	 * HTTP 200
	 */
	public static final int		HTTP_STATUS_NORMAL			= 200;
	
	/**
	 * HTTP 400
	 */
	public static final int		HTTP_STATUS_ERROR			= 400;
	
	/**
	 * String 0
	 */
	public static final String	STRING_ZERO					= "0";
	
	/**
	 * String 1
	 */
	public static final String	STRING_ONE					= "1";
	
	/**
	 * String 2
	 */
	public static final String	STRING_TWO					= "2";
	
	/**
	 * String 3
	 */
	public static final String	STRING_THREE				= "3";
	
	/**
	 * String 4
	 */
	public static final String	STRING_FOUR					= "4";
	
	/**
	 * String 5
	 */
	public static final String	STRING_FIVE					= "5";
	
	/**
	 * String 6
	 */
	public static final String	STRING_SIX					= "6";
	
	/**
	 * String 7
	 */
	public static final String	STRING_SEVEN				= "7";
	
	/**
	 * String 8
	 */
	public static final String	STRING_EIGHT				= "8";
	
	/**
	 * String 9
	 */
	public static final String	STRING_NINE					= "9";
	
	/**
	 * String 10
	 */
	public static final String	STRING_TEN					= "10";
	
	/**
	 * String -1
	 */
	public static final String	STRING_MINUS_ONE			= "-1";
	
	/**
	 * INT -1
	 */
	public static final Integer	INT_MINUS_ONE				= -1;
	
	/**
	 * INT 0
	 */
	public static final int		INT_ZERO					= 0;
	
	/**
	 * INT 1
	 */
	public static final int		INT_ONE						= 1;
	
	/**
	 * INT 2
	 */
	public static final int		INT_TWO						= 2;
	
	/**
	 * INT 3
	 */
	public static final int		INT_THREE					= 3;
	
	/**
	 * INT 4
	 */
	public static final int		INT_FOUR					= 4;
	
	/**
	 * INT 5
	 */
	public static final int		INT_FIVE					= 5;
	
	/**
	 * INT 6
	 */
	public static final int		INT_SIX						= 6;
	
	/**
	 * INT 7
	 */
	public static final int		INT_SEVEN					= 7;
	
	/**
	 * INT 8
	 */
	public static final int		INT_EIGHT					= 8;
	
	/**
	 * INT 9
	 */
	public static final int		INT_NINE					= 9;
	
	/**
	 * INT 10
	 */
	public static final int		INT_TEN						= 10;
	
	/**
	 * DOUBLE 0
	 */
	public static final Double	DOUBLE_ZERO					= 0.0;
	
	/**
	 * vehicle
	 */
	public static final String	CONTEXT_VEHICLE				= "CONTEXT_VEHICLE";
	/**
	 * company
	 */
	public static final String	CONTEXT_COMPANY				= "CONTEXT_COMPANY";
	
	public static final String	CONTEXT_DIC_TYPE			= "CONTEXT_DIC_TYPE";
	
	public static final String	CONTEXT_DIC_DATA			= "CONTEXT_DIC_DATA";
	
	public static final String	CONTEXT_GLOBAL_PARAMS		= "CONTEXT_GLOBAL_PARAMS";
	
	public static final String	CITY_FILE_PATH				= "/city.json";
	
	public static final String	CONTEXT_DIC_CITY			= "CONTEXT_DIC_CITY";
	
	public static final String	CONTEXT_VEHICLE_MENU		= "CONTEXT_VEHICLE_MENU";
	
	public static final String	SIM_IOC_10648				= "10648";
	
	public static final String	SUPER_PASSWORD				= "SUPER_PASSWORD";
	
	public static final String	USER_NOT_FOUND				= "用户不存在";
	
	public static final String	DEPT_NOT_FOUND				= "部门不存在";
	
	public static final String	ROLE_NOT_FOUND				= "角色不存在";
	
	public static final String	SESSION_MENU				= "SESSION_MENU";
	// 手机号正则
	public static final String	REGEX_MOBILE				= "^1[3|4|5|7|8][0-9]\\d{8}$";
	
	/****************** 通用常量 结束 **************************/
	/**
	 * NULL
	 */
	public static String		NORMAL_NULL					= null;
	
	/****************** 可变常量 开始 **************************/
	
	public static String		TEST_PROP					= "TEST";
	
	/****************** 可变常量 结束 **************************/
	
	/**
	 * 签名key
	 */
	public static final String	SIGNING_KEY					= "spring-security-@Jwt!&Secret^#";
	
	/**
	 * BASE64 图片 前缀
	 */
	public static final String	PIC_PREFIX					= "data:image/jpeg;base64,";
}
