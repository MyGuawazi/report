package com.janus.report.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.janus.report.annotation.DataSource;
import com.janus.report.service.LeaveReportService;

/**
*
*
*@author ZWB
*@date 2019年11月19日
*@version 1.0  
*/
@Service
@DataSource("OA")
public class LeaveReportServiceImpl implements LeaveReportService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public JSONObject findLeaveUserByOneDay() {
		List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
		Map<String, Object> outValues = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				String sql = "{call Sp_LeaveReport()}";
				CallableStatement callableStatement = connection.prepareCall(sql);
				return callableStatement;
			}
		}, declaredParameters);
		Object object = outValues.get("#result-set-1");
		JSONObject result = new JSONObject();
		result.put("code","0");
		result.put("msg","");
		result.put("count",0);
		result.put("data",object);
		return result;
	}

}
