package com.janus.report.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.janus.report.util.DataSourceType;
import com.janus.report.util.DataSourceType.DataBaseType;

/**
*
* 继承AbstractRoutingDataSource 实现可动态路由的数据源
*@author ZWB
*@date 2019年11月22日
*@version 1.0  
*/
public class DynamicDataSource extends AbstractRoutingDataSource{
	

	@Override
	protected Object determineCurrentLookupKey() {
		DataBaseType dataBaseType = DataSourceType.getDataBaseType();
		return dataBaseType;
	}

}
