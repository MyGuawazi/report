package com.janus.report.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.janus.report.util.DataSourceType;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
* 
* 数据源配置类
*@author ZWB
*@date 2019年11月15日
*@version 1.0  
*/
@Configuration
@PropertySource(value= {"classpath:jdbc.properties"})
public class DataConfig {
	
	private static final String driverClass = "driverClass";
	private static final String url = "url";
	private static final String user = "user";
	private static final String password = "password";
	
	/*OA*/
	@Value("${oa.jdbc.driverClass}")
	private String driverClass_oa;
	@Value("${oa.jdbc.url}")
	private String url_oa;
	@Value("${oa.jdbc.username}")
	private String username_oa;
	@Value("${oa.jdbc.password}")
	private String password_oa;
	
	/*普元*/
	@Value("${primeton.jdbc.driverClass}")
	private String driverClass_primeton;
	@Value("${primeton.jdbc.url}")
	private String url_primeton;
	@Value("${primeton.jdbc.username}")
	private String username_primeton;
	@Value("${primeton.jdbc.password}")
	private String password_primeton;
	
	/*Erp*/
	@Value("${erp.jdbc.driverClass}")
	private String driverClass_erp;
	@Value("${erp.jdbc.url}")
	private String url_erp;
	@Value("${erp.jdbc.username}")
	private String username_erp;
	@Value("${erp.jdbc.password}")
	private String password_erp;
	
	@Primary
	@Bean(name="dataSourceOa")
	public DataSource dataSourceOa() {
		Map<String, String> args = new HashMap<String, String>();
		args.put(driverClass, driverClass_oa);
		args.put(url, url_oa);
		args.put(user, username_oa);
		args.put(password, password_oa);
		return initDataSource(args);
	}
	
	@Bean(name="dataSourcePrimeton")
	public DataSource dataSourcePrimeton() {
		Map<String, String> args = new HashMap<String, String>();
		args.put(driverClass, driverClass_primeton);
		args.put(url, url_primeton);
		args.put(user, username_primeton);
		args.put(password, password_primeton);
		return initDataSource(args);
	}
	
	@Bean(name="dataSourceErp")
	public DataSource dataSourceErp() {
		Map<String, String> args = new HashMap<String, String>();
		args.put(driverClass, driverClass_erp);
		args.put(url, url_erp);
		args.put(user, username_erp);
		args.put(password, password_erp);
		return initDataSource(args);
	}
	
	@Bean(name="DynamicDataSource")
	public DynamicDataSource dataSource(@Qualifier("dataSourceOa") DataSource dataSourceOa,
										@Qualifier("dataSourcePrimeton") DataSource dataSourcePrimeton,
										@Qualifier("dataSourceErp") DataSource dataSourceErp) {
		//用于数据库和名字之间的映射
        Map<Object,Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.OA, dataSourceOa);
        targetDataSource.put(DataSourceType.DataBaseType.Primeton, dataSourcePrimeton);
        targetDataSource.put(DataSourceType.DataBaseType.ERP, dataSourceErp);
        DynamicDataSource dataSource = new DynamicDataSource();
        
        dataSource.setTargetDataSources(targetDataSource);//设置数据源关键字与数据源的关系
        dataSource.setDefaultTargetDataSource(dataSourceOa);//设置默认的数据源
        
		return dataSource;
	}
	
	@Bean(name="jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("DynamicDataSource") DataSource dynamicDataSource) {
        return new JdbcTemplate(dynamicDataSource);
    }
	
	
	/**
	 * 创建C3P0连接池得到数据源
	 * @param args 参数
	 * @return
	 */
	public DataSource initDataSource(Map<String,String> args) {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(args.get(driverClass));
			dataSource.setJdbcUrl(args.get(url));
			dataSource.setUser(args.get(user));
			dataSource.setPassword(args.get(password));
			//请求超时时间
			dataSource.setCheckoutTimeout(30000);
			//每60秒检查所有连接池中的空闲连接。默认值: 0，不检查
			dataSource.setIdleConnectionTestPeriod(60);
			//连接数据库连接池最大空闲时间
			dataSource.setMaxIdleTime(30);
			//连接池初始化连接数
			dataSource.setInitialPoolSize(5);
			dataSource.setMinPoolSize(5);
			dataSource.setMaxPoolSize(20);
			//当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。默认值: 3
			dataSource.setAcquireIncrement(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
}
