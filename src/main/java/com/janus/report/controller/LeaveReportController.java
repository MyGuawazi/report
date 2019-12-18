package com.janus.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.janus.report.base.BaseController;
import com.janus.report.service.LeaveReportService;

/**
*
*
*@author ZWB
*@date 2019年11月18日
*@version 1.0  
*/
@Controller
public class LeaveReportController extends BaseController{
	
	@Autowired
	private LeaveReportService leaveReportService;
	
	@RequestMapping("/LeaveReport")
	public String toLeaveReport() {
		return "LeaveReport";
	}
	
	@RequestMapping("/findLeaveUserByOneDay")
	@ResponseBody
	public JSONObject findLeaveUserByOneDay() {
		return leaveReportService.findLeaveUserByOneDay();
	}
	
}
