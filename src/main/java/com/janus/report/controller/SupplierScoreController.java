package com.janus.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.janus.report.base.BaseController;
import com.janus.report.service.SupplierScoreService;

/**
*
*@author ZWB
*@date 2019年11月15日
*@version 1.0  
*/
@Controller
public class SupplierScoreController extends BaseController{
	
	@Autowired
	private SupplierScoreService supplierScoreService;
	
	@RequestMapping("/SupplierScore")
	public String toSupplierScoreJsp() {
		return "SupplierScore";
	}
	
	@RequestMapping("/SupplierScoreWhere")
	@ResponseBody
	public JSONObject getAllK3SupplierScoreJson(@RequestParam String startDate, @RequestParam String enddate) throws Exception{
		if(StringUtils.isEmpty(startDate) || StringUtils.isEmpty(enddate)) {
			JSONObject result = new JSONObject();
			result.put("code","-1");
			result.put("msg","开始日期和结束日期不能为空");
			result.put("count",0);
			result.put("data","");
			return result;
		}
		return supplierScoreService.getAllK3SupplierScoreJson(startDate,enddate);
	}

}
