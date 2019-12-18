package com.janus.report.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.janus.report.entity.ProductCode;

/**
*
*
*@author ZWB
*@date 2019年12月12日
*@version 1.0  
*/
public class ProductCodeMapper implements RowMapper<ProductCode>{

	@Override
	public ProductCode mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductCode pc = new ProductCode();
		pc.setMasterProductCode(rs.getString("Master_Product_Code"));
		pc.setDerekProductCode(rs.getString("Derek_Product_Code"));
		return pc;
	}

}
