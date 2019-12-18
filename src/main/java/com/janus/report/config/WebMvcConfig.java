package com.janus.report.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
*
*SpringMvc 配置类
*@author ZWB
*@date 2019年11月15日
*@version 1.0  
*/
@EnableWebMvc
@ComponentScan(value="com.janus")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 视图解析器
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//配置JSP从/WEB-INF/view/ 路径下
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
	
	/**
	 * 静态资源访问
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//将静态资源交给Tomcat处理
		configurer.enable();
	}
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}*/
	
}
