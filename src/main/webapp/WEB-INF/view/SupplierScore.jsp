<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/baseScripts.jsp" %>
<%@ include file="/common/global.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>供应商绩效评价统计表</title>
		<meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	    <link rel="icon" href="${staticPath}/static/img/XYBicon.jpg" />
	</head>
	<style type="text/css">
		body {
				margin: 0;
				padding: 0;
				height: 100%;
				overflow-y: scroll;
			}
		html {
			font-family: "微软雅黑";
			-webkit-text-size-adjust: 100%;
			-ms-text-size-adjust: 100%;
		}
	</style>
	<body>
		<div class="layui-fluid">
			<div class="layui-row">
				<div class="layui-col-md4">
					<img src="${staticPath }/static/img/xybicon3.jpg"/>
				</div>
				<div class="layui-col-md8 layui-col-space10">
					<h2><strong>供 应 商 绩 效 评 价 统 计 表</strong></h2>
					<h2><strong>Supplier   Score   System   Database</strong></h2>
					<small><strong>供应商评级标准：A≥80分；70≤B<80分；60≤C<70分；D<60分；总分100分</strong></small>
				</div>
			</div>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top:10px;">
					<legend>统计分析总结</legend>
			</fieldset>
			<!--内容-->
			<div class="layui-row">
				<!--日期搜索条件-->
				<div class="layui-row">
					<!-- 起始日期  5列 -->
					<div class="layui-col-md2">
						<div class="grid-demo-bg1">
							<label class="layui-form-label">起始日期:</label>
						</div>
					</div>
					<div class="layui-col-md2">
						<div class="layui-form-item">
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="startdate"
									placeholder="yyyy-MM-dd">
							</div>
						</div>
					</div>
					<!-- 起始日期  5列 -->
					<!-- 结束日期  5列 -->
					<div class="layui-col-md2">
						<div class="grid-demo grid-demo-bg1">
							<label class="layui-form-label">结束时间:</label>
						</div>
					</div>
					<div class="layui-col-md2">
						<div class="layui-form-item">
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="enddate"
									placeholder="yyyy-MM-dd">
							</div>
						</div>
					</div>
					<!-- 结束日期  5列 -->
					<!-- 查询按钮 2列-->
					<div class="layui-col-md4">
						<button class="layui-btn layui-btn-normal" id="searchBtn">查询</button>
					</div>
					<!-- 查询按钮 2列-->
				</div>
				<!--日期搜索条件-->
				
				<!-- <div class="layui-row">
					<div class="layui-col-md12">&nbsp;</div>
				</div> -->
				
				<!--table-->
				<div class="layui-row">
					<div class="layui-col-md12" id="tbDiv">
						<table class="layui-table" lay-size="lg" lay-filter="Scitem" id="supplierScoreTb">
							<thead>
								<tr>
									<th lay-data="{field:'xh',fixed:'left',align:'center'}" rowspan="3">序号</th>
									<th
										lay-data="{width:120,fixed: 'left',align:'center',sort: true,style:'background-color: #EBF1DE; color: #111;'}"
										rowspan="3">风险排名</th>
									<th
										lay-data="{width:80,fixed:'left',align:'center',sort: true, style:'background-color: #FDE9D9; color: #111;'}"
										rowspan="3">总分</th>
									<th
										lay-data="{width:80,fixed:'left',align:'center',sort: true, style:'background-color: #FDE9D9; color: #111;'}"
										rowspan="3">评级</th>
									<th
										lay-data="{field:'gysdm',width:110,fixed:'left',align:'center'}"
										rowspan="3">供应商代码</th>
									<th
										lay-data="{field:'gysmc',width:180,fixed:'left',align:'center'}"
										rowspan="3">供应商名称</th>
									<th lay-data="{width:90,fixed:'left',align:'center'}" rowspan="3">零件类别</th>
									<th lay-data="{width:80,fixed:'left',align:'center'}" rowspan="3">SQE</th>
				
									<th lay-data="{align:'center'}" colspan="17">质量情况(40分)</th>
									<th lay-data="{align:'center'}" colspan="8">交付情况(20分)</th>
									<th lay-data="{align:'center'}" colspan="3">成本(10分)</th>
									<th lay-data="{align:'center'}" colspan="4">服务与持续改进(10分)</th>
									<th lay-data="{align:'center'}" colspan="9">新品开发 (20分)</th>
								</tr>
								<tr>
									<th lay-data="{align:'center'}" colspan="5">外检批次合格率(10分)</th>
									<th lay-data="{align:'center'}" colspan="5">装配PPM（10分）</th>
									<th lay-data="{align:'center'}" colspan="2">OEM-外部客户投诉（10分）</th>
									<th lay-data="{align:'center'}" colspan="2">0KM-CMP（内部投诉）（5分）</th>
									<th lay-data="{align:'center'}" colspan="2">过程审核分值 （5分）</th>
									<th
										lay-data="{align:'center',width:90,style:'background-color: #DAEEF3; color: #111;'}"
										rowspan="2">质量得分</th>
				
									<th lay-data="{align:'center'}" colspan="4">准交率（10分）</th>
									<th lay-data="{align:'center'}" colspan="3">供货造成停线(10分)</th>
									<th
										lay-data="{align:'center',width:90,style:'background-color: #DAEEF3; color: #111;'}"
										rowspan="2">交付得分</th>
				
									<th lay-data="{align:'center'}" colspan="2">降价幅度</th>
									<th
										lay-data="{align:'center',width:90,style:'background-color: #DAEEF3; color: #111;'}"
										rowspan="2">成本得分</th>
				
									<th lay-data="{align:'center'}" colspan="3">质量问题改进情况(10分)</th>
									<th
										lay-data="{align:'center',width:90,style:'background-color: #DAEEF3; color: #111;'}"
										rowspan="2">改进得分</th>
				
									<th
										lay-data="{align:'left',width:130,align:'center', style:'background-color: #FDE9D9; color: #111;'}"
										rowspan="2">PPAP按时(5分)</th>
									<th lay-data="{align:'center'}" colspan="3">质量（5分）</th>
				
									<th lay-data="{align:'center'}" colspan="2">交付（5分）</th>
									<th
										lay-data="{align:'center',width:130,style:'background-color: #FDE9D9; color: #111;'}"
										rowspan="2">新品交付得分</th>
									<th
										lay-data="{align:'center',width:150,style:'background-color: #DAEEF3; color: #111;'}"
										rowspan="2">新品项目开发得分</th>
								</tr>
								<tr>
									<th lay-data="{field:'sjpc' ,width:90,align:'center'}" rowspan="1">送检批次</th>
									<th lay-data="{field:'hgpc',width:90,align:'center'}" rowspan="1">合格批次</th>
									<th lay-data="{field:'phgl',width:90,align:'center'}" rowspan="1">批合格率</th>
									<th lay-data="{field:'mbz',width:80,align:'center'}" rowspan="1">目标值</th>
									<th
										lay-data="{field:'phgdf',width:100,align:'center', style:'background-color: #FDE9D9; color: #111;'}"
										rowspan="1">批合格得分</th>
				
									<th lay-data="{width:90,align:'center'}" rowspan="1">总领料数</th>
									<th lay-data="{width:90,align:'center'}" rowspan="1">不合格数</th>
									<th lay-data="{width:90,align:'center'}" rowspan="1">装配PPM</th>
									<th lay-data="{width:90,align:'center'}" rowspan="1">目标PPM</th>
									<th lay-data="{width:90,align:'center', style:'background-color: #FDE9D9; color: #111;'}"
										rowspan="1">PPM得分</th>
				
									<th lay-data="{field:'wbtscs',width:130,align:'center'}">投诉次数</th>
									<th lay-data="{field:'wboemdf',width:130,align:'center', style:'background-color: #FDE9D9; color: #111;'}">OEM得分</th>
				
									<th lay-data="{field:'nbtscs',width:130,align:'center'}">投诉次数</th>
									<th lay-data="{field:'nbcmpdf',width:130,align:'center', style:'background-color: #FDE9D9; color: #111;'}">CMP得分</th>
				
									<th lay-data="{width:130,falign:'center'}">过程审核分值</th>
									<th lay-data="{width:130,align:'center', style:'background-color: #FDE9D9; color: #111;'}">过程审核得分</th>
				
									<th lay-data="{width:100,align:'center'}">总交付批数</th>
									<th lay-data="{width:100,align:'center'}">准交付批数</th>
									<th lay-data="{width:100,align:'center'}">准交付率</th>
									<th lay-data="{width:120,align:'center'}", style:'background-color: #FDE9D9; color: #111;'>准时交付得分</th>
				
									<th lay-data="{width:110,align:'center'}">停线均时(H)</th>
									<th lay-data="{width:110,align:'center'}">停线次数</th>
									<th lay-data="{width:110,align:'center'}", style:'background-color: #FDE9D9; color: #111;'>停线得分</th>
				
									<th lay-data="{width:120,align:'center'}">目标降价比例</th>
									<th lay-data="{width:120,align:'center'}">实际降价幅度</th>
				
									<th lay-data="{width:80,align:'center'}">报告数</th>
									<th lay-data="{width:90,align:'center'}">推迟完成</th>
									<th lay-data="{width:80,align:'center'}">未提交</th>
				
									<th lay-data="{width:120,align:'center'}">新品交样批数</th>
									<th lay-data="{width:120,align:'center'}">交样合格次数</th>
									<th lay-data="{width:120,align:'center'}">交样合格率</th>
				
									<th lay-data="{width:150,align:'center'}">准时交样合格次数</th>
									<th lay-data="{width:100,align:'center'}">交样准时率</th>
								</tr>
							</thead>
						</table>
			      	</div>
				</div>
				<!--table-->
			</div>
			<!--内容-->
		</div>
	</body>
	<script>
		var path = "${path}";
		layui.use('table', function() {
			//页面加载只获取当天的数据
			var date = getTime();
			var tbw = document.getElementById('tbDiv').offsetWidth;
			var table = layui.table;
			table.init('Scitem',{
				width:tbw,
				height:480,
				url: path + '/SupplierScoreWhere',
				where :{ startDate:date, enddate:date}
			});
			/**
			 * 查询按钮
			 */
			$("#searchBtn").click(function(){
				table.reload('supplierScoreTb', {
					url: path + '/SupplierScoreWhere',
					where :{ startDate:$("#startdate").val(), enddate:$("#enddate").val()}
				});
			});
		});
		//时间组件
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem : '#startdate',
				value:getTime(),
				isInitValue: true,
				type : 'date'
			});
			laydate.render({
				elem : '#enddate',
				value:getTime(),
				isInitValue: true,
				type : 'date'
			});
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
	</script>
</html>
