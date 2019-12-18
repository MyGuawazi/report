package com.janus.report.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
* 
* 利用注解的方式配置web.xml
*@author ZWB
*@date 2019年11月15日
*@version 1.0  
*/
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 根容器,相当于Spring容器
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		//加载数据源
		return new Class<?>[] {DataConfig.class};
	}

	/**
	 * SpringMVC容器
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		//加载SpringMVC配置
		return new Class<?>[] {WebMvcConfig.class};
	}
	
	/**
	 * 映射根路径初始化
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//所有路径
		return new String[] {"/"};
	}

}
