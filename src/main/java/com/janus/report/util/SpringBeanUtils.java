package com.janus.report.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
*
*
*@author ZWB
*@date 2019年11月22日
*@version 1.0  
*/
@Component
public class SpringBeanUtils implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringBeanUtils.applicationContext = applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		if(applicationContext.containsBean(beanName)) {
			return (T) applicationContext.getBean(beanName);
		}else {
			return null;
		}
	}

}
