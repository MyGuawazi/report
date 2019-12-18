package com.janus.report.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.janus.report.util.StringEscapeEditor;

/**
*
*
*@author ZWB
*@date 2019年11月15日
*@version 1.0  
*/
public abstract class BaseController {
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		
		/**
		 * 转换日期格式
		 */
		binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		/**
		 * 请求数据处理 防止XSS攻击
		 */
		binder.registerCustomEditor(String.class,new StringEscapeEditor(true,true,true));
	}

}
