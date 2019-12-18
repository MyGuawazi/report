package com.janus.report.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.janus.report.annotation.DataSource;
import com.janus.report.service.SupplierScoreService;

/**
*
*
*@author ZWB
*@date 2019年11月16日
*@version 1.0  
*/
@Service
@DataSource("OA")
public class SupplierScoreServiceImpl implements SupplierScoreService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public JSONObject getAllK3SupplierScoreJson(String startDate, String enddate)throws Exception {
		JSONObject result = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sd = sdf.parse(startDate);
		Date ed = sdf.parse(enddate);
		List<SqlParameter> declaredParameters = new ArrayList<>();
		declaredParameters.add(new SqlParameter(Types.DATE));
		declaredParameters.add(new SqlParameter(Types.DATE));
		Map<String, Object> outValues = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				String sql = "{call Sp_SupplierScoreReport (?,?)}";
				
				CallableStatement callableStatement = connection.prepareCall(sql);
				callableStatement.setDate("StartDate",new java.sql.Date(sd.getTime()));
				callableStatement.setDate("enddate",new java.sql.Date(ed.getTime()));
				return callableStatement;
			}
		}, declaredParameters);
		Object object = outValues.get("#result-set-1");//#result-set-1每个结果集的key,从1开始
		result.put("code","0");
		result.put("msg","");
		result.put("count",0);
		result.put("data",object);
		return result;
	}

}
