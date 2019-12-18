package com.janus.report.service;
/**
*
*
*@author ZWB
*@date 2019年11月16日
*@version 1.0  
*/

import com.alibaba.fastjson.JSONObject;

public interface SupplierScoreService {
	
	JSONObject getAllK3SupplierScoreJson(String startDate,String enddate)throws Exception;

}
