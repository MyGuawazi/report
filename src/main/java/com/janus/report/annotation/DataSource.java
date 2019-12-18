package com.janus.report.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*
*切换数据注解 可以用于类或者方法级别 方法级别优先级 > 类级别
*ElementType.METHOD : 用于描述方法
*ElementType.TYPE : 用于描述类、接口(包括注解类型) 或enum声明
*ElementType.PARAMETER : 用于描述参数
*@author ZWB
*@date 2019年12月18日
*@version 1.0  
*/
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
//RUNTIME:在运行时有效（即运行时保留）
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	//默认数据源是OA
	String value() default "OA";
}
