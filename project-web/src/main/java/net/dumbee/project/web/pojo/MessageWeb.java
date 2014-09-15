package net.dumbee.project.web.pojo;

import net.dumbee.project.commons.pojo.Message;


public class MessageWeb extends Message{
	

	private static Integer TYPE_WARN = 50; //警告提示，一般值操作成功，但重新load或显示出错等错误
	private static Integer TYPE_ERROR = 1000;
	private static Integer TYPE_ERROR_UNDEFINED = 1001;
	
	/**
	 * 定义错误类型
	 */
	public static final MessageWeb 
			ERROR = new MessageWeb(TYPE_ERROR, "error"),
			
			ERROR_UNDEFINED = new MessageWeb(TYPE_ERROR_UNDEFINED, "未知错误");
	
	
	protected MessageWeb(Integer type, String desc) {
		super(type, desc);
	}


}
