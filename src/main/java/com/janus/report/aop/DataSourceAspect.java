package com.janus.report.aop;

import org.slf4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.janus.report.annotation.DataSource;
import com.janus.report.util.DataSourceType;

/**
*
*通过使用AOP拦截,获取注解的属性value值.
* 如果value的值并没有在DataSourceType.DataBaseType中,
* 则使用默认的数据源,如果有的话,则切换为相应的数据源
*@author ZWB
*@date 2019年12月18日
*@version 1.0  
*/
@Aspect
@Component
public class DataSourceAspect {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
	
	//拦截自定义注解
	@Before("@annotation(dataSource)")
	public void changeDataSource(JoinPoint joinPoint,DataSource dataSource) {
		String value = dataSource.value();
		logger.info("Before DataSourceAspect setDataSource:[{}]........",value);
		if(value.equalsIgnoreCase("OA")) {
			DataSourceType.setDataSource(DataSourceType.DataBaseType.OA);
		}else if(value.equalsIgnoreCase("Primeton")) {
			DataSourceType.setDataSource(DataSourceType.DataBaseType.Primeton);
		}else if(value.equalsIgnoreCase("ERP")) {
			DataSourceType.setDataSource(DataSourceType.DataBaseType.ERP);
		}else {
			DataSourceType.setDataSource(DataSourceType.DataBaseType.OA);
		}
	}
	
	/**
	 * 清除数据源
	 * @param joinPoint
	 * @param dataSource
	 */
	@After("@annotation(dataSource)")
	public void restoreDataSource(JoinPoint joinPoint,DataSource dataSource) {
		logger.info("After DataSourceAspect clearDataBaseType........");
		DataSourceType.clearDataBaseType();
	}

}
