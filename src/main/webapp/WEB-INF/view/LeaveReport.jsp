<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/baseScripts-bootstrap.jsp" %>
<%@ include file="/common/global.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>湘油泵总公司中离/请假人员看板</title>
		<link rel="icon" href="http://192.168.1.124:8602/Content/images/Log2.png" type="image/x-icon" />
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	</head>
	<style type="text/css">
		body {
			margin: 0;
			padding: 0;
			height: 100%;
   			overflow: "hidden";
   			scroll:"no";
		}
		html {
			width: 100%;
            height: 100%;
            border-width: 0px;
			font-family: "微软雅黑";
			-webkit-text-size-adjust: 100%;
			-ms-text-size-adjust: 100%;
		}
		
	</style>
	<body id="bodyW">
		<div class="container-fluid" class="fixedTop">
			<div class="row" style="background-color: #F3F3F4;">
				<div class="col-md-3">
					<img style="margin-top: 2px" src="http://192.168.1.124:8602/Content/images/Log2.png" class="img-responsive" alt="Responsive image">
				</div>
				<div class="col-md-6">
					<h2><strong>湘油泵总公司中离/请假人员看板</strong></h2>
				</div>
				<div class="col-md-3">
					<div class="form-group" style="margin-top: 17px">
						<div class="input-group date">
                             <input id="SearchDate" name="SearchDate" type="text" class="layui-input form-control" />
                             <a id="btnExport" href="#" class="input-group-addon btn btn-primary"> 导出明细 </a>
                         </div>
					</div>
				</div>
			</div>
		
		<!-- table -->
		<div class="row" >
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table table-bordered text-nowrap" id="LeaveTable">
						<thead>
							<tr>
			                    <th>姓名</th>
			                    <th>工号</th>
			                    <th>部门</th>
			                    <th>请假原因</th>
			                    <th>请假类型</th>
			                    <th>中离/请假开始日期</th>
			                    <th>中离/请假开始时间</th>
			                    <th>中离/请假结束日期</th>
			                    <th>中离/请假结束时间</th>
			                    <th>归厂日期</th>
			                    <th>归厂时间</th>
			                </tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- table -->
		</div>
	</body>
	<script>
		var path = "${path}";
		$(function(){
			$("#SearchDate").val(getTime());
		});
		var tbw = document.getElementById('bodyW').offsetWidth;
		$("#LeaveTable").bootstrapTable({
			width:tbw,
			locale: "zh-CN",
			url : path+"/findLeaveUserByOneDay",
			columns : [{
				field: 'requestid',
                title: '访问ID',
                visible:false //显示或隐藏该列， 默认显示， False为隐藏
			},{
				field: 'qjlx',
                title: '请假类型',
                visible:false //显示或隐藏该列， 默认显示， False为隐藏
			},{
                field: 'id',
                title: 'ID',
                visible:false //显示或隐藏该列， 默认显示， False为隐藏
            },{
                field: 'userdescription',
                title: '姓名',
                align : 'center',
            },{
                field: 'gh',
                title: '工号',
                align: 'center'
            },{
                field: 'departmentname',
                title: '部门',
                align: 'center'
            },{
                field: 'qjsr',
                title: '请假原因',
                align: 'center',
                formatter:function(value,row,index){
                    var tx = "";
                    if(value.length>21){
                        tx = value.substring(0,5)+'......';
                    }else{
                        tx = value;
                    }
                    return tx;
                }
            },{
                field: 'selectname',
                title: '请假类型',
                align: 'center'
            },{
                field: 'qjksrq',
                title: '中离/请假开始日期',
                align: 'center'
            }, {
                field: 'qjkssj',
                title: '中离/请假开始时间',
                align: 'center'
            }, {
                field: 'qjjsrq',
                title: '中离/请假结束日期',
                align: 'center'
            },{
                field: 'qjjssj',
                title: '中离/请假结束时间',
                align: 'center'
            },{
                field: 'gcrq',
                title: '归厂日期',
                align: 'center',
                class:"info"
            }, {
                field: 'gcsj',
                title: '归厂时间',
                align: 'center',
                class:"info"
            }],
            formatLoadingMessage: function(){
                return "请稍等，正在加载中...";
            },
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
			onDblClickRow: function (field, value, row, $element) {
				console.log(field.requestId);
				var reqid = field.requestId;
                var Uname = field.userdescription;
                var qjlx = field.qjlx;
                var gcrq = field.gcrq;
                var gcsj = row.gcsj;
                if(isNull(gcrq) || isNull(gcsj)){
                    swal({
                             title:Uname,
                             text:"归厂日期为："+getTime(),
                             type: "warning",
                             showCancelButton: true,
                             confirmButtonColor: "#DD6B55",
                             confirmButtonText: "确定",
                             cancelButtonText:"取消",
                             closeOnConfirm: false
                         });
                }else{
                    swal({title:"不能操作",type:"error"});
                }
		  	}	
		});
		//时间加载
		$("#SearchDate").datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            clearBtn: true,//清除按钮
            todayBtn: true,//今日按钮
            format: "yyyy-mm-dd"
        });
		
		/**
		 * 获取当前日期 yyyy-MM-dd
		 */
		function getTime(){
        	var date=new Date();
        	var year=date.getFullYear();
        	var month=date.getMonth()+1;
        	var day=date.getDate();
            return year+'-'+month+'-'+day;
        }
		
		/**
		* 判断是否为空
		*/
		function isNull(obj){
			if(typeof obj == "undefined" || obj == null || obj == ""){
				return true;
			}else{
				return false;
			}
		}
	</script>
</html>
