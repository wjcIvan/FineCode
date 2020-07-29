<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>剧院后台管理系统</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">剧院后台管理系统</div>

			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a id="name"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 管理员 </a></li>
				<li class="layui-nav-item"><a href="login.html">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">

					<li id="p1" class="layui-nav-item  layui-nav-itemed  layui-this"><a
						onclick="onc(1)" href="javascript:;">剧场管理</a></li>

					<li id="p2" class="layui-nav-item"><a
						onclick="onc(2)" href="javascript:;">剧院管理</a></li>
						
						
					<li id="p3" class="layui-nav-item"><a
						onclick="onc(3)" href="javascript:;">剧院场次管理</a></li>
						
					<li id="p4" class="layui-nav-item"><a
						onclick="onc(4)" href="javascript:;">订单管理</a></li>

					<li id="p5" class="layui-nav-item"><a
						onclick="onc(5)" href="javascript:;">用户管理</a></li>

				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">




				<div id="page1">
					<button class="layui-btn" onClick="gotoAdd()">
						<i class="layui-icon">&#xe608; </i> 添加剧场
					</button>


					<table id="demo" lay-filter="test"></table>
				</div>

				<div id="page2">
					<button class="layui-btn" onClick="gotoAdd2()">
						<i class="layui-icon">&#xe608; </i> 添加剧院
					</button>


					<table id="demo2" lay-filter="test2"></table>
				</div>
				
				<div id="page3">
					<button class="layui-btn" onClick="gotoAdd3()">
						<i class="layui-icon">&#xe608; </i> 添加剧场场次
					</button>


					<table id="demo3" lay-filter="test3"></table>
				</div>
				
				<div id="page4">
				


					<table id="demo4" lay-filter="test4"></table>
				</div>

				<div id="page5">
				


					<table id="demo5" lay-filter="test5"></table>
				</div>




			</div>
		</div>

	</div>






	<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="layui/layui.js"></script>




	<script type="text/html" id="barDemo"> 
	<a class="layui-btn layui-btn layui-btn-xs" lay-event="search">查看</a>
<a class="layui-btn layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
 </script>
 
 
 <script type="text/html" id="barDemo2"> 
<a class="layui-btn layui-btn layui-btn-xs" lay-event="search">查看</a>
<a class="layui-btn layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
 </script>
 
  <script type="text/html" id="barDemo3"> 
<a class="layui-btn layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
 </script>
 
  <script type="text/html" id="barDemo4"> 
  <a class="layui-btn layui-btn layui-btn-xs" lay-event="edit">处理</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
 </script>
 
  <script type="text/html" id="barDemo5"> 
<a class="layui-btn layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
 </script>
 








	<script>
		$("#page1").hide();
		$("#page2").hide();
		$("#page3").hide();
		$("#page4").hide();
		$("#page5").hide();
		function onc(index) {
		localStorage.setItem("page", index);	
		$("#p1").attr("class",'layui-nav-item');
		$("#p2").attr("class",'layui-nav-item');
		$("#p3").attr("class",'layui-nav-item');
		$("#p4").attr("class",'layui-nav-item');
		$("#p5").attr("class",'layui-nav-item');
		$("#p"+index).attr("class",'layui-nav-item  layui-nav-itemed  layui-this');
		$("#page1").hide();
		$("#page2").hide();
		$("#page3").hide();
		$("#page4").hide();
		$("#page5").hide();
		$("#page" + index).show();

			getData();
		}

		function gotoAdd() {
			window.location.href = "addTheatre.jsp";
		}
		function gotoAdd2() {
			window.location.href = "addShowplace.jsp";
		}
		function gotoAdd3() {
			window.location.href = "addCi.jsp";
		}

		function getData() {
			layui.use('table', function() {
				var table = layui.table, form = layui.form;

				table.render({
					elem : '#demo',
					height : 500,
					url : '/JuchangService/theatre/search' //数据接口
					,
					page : false //开启分页
					,
					cols : [ [ //表头
					{
						field : 'tid',
						title : 'ID',
						align : 'center',
						width : 80,
					}, {
						field : 'name',
						title : '剧场名称',
						align : 'center'
					}, {
						field : 'type',
						title : '剧场类型',
						align : 'center'
					}, {
						fixed : 'right',
						title : '操作',
						align : 'center',
						toolbar : '#barDemo'
					}
					// <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					] ]
				});

				//监听删除按钮
				table.on('tool(test)', function(obj) {
					var data = obj.data;
					if (obj.event === 'del') {
						layer.confirm('确定要删除吗？', function(index) {
							$.get("/JuchangService/theatre/delete?tid="
									+ data.tid, function(data, status) {
								var data_json = $.parseJSON(data);
								if (data_json.code == "success") {
									layer.msg('删除成功！');
									obj.del();
									layer.close(index);

								} else {
									layer.msg('删除失败');
								}
							});

						});
					} else if (obj.event === 'search') {

						localStorage.setItem("theatre", JSON.stringify(data));
						window.location.href = "/JuchangService/showTheatre.jsp";

					} else if (obj.event === 'edit') {
						localStorage.setItem("theatre", JSON.stringify(data));
						window.location.href = "/JuchangService/editTheatre.jsp";

					}
				});
				
				
				
				//分类
			table.render({
					elem : '#demo2',
					height : 500,
					url : '/JuchangService/showplace/search' //数据接口
					,
					page : false //开启分页
					,
					cols : [ [ //表头
					{
						field : 'sid',
						title : 'ID',
						align : 'center',
						width : 80,
					}, {
						field : 'name',
						title : '剧院名称',
						align : 'center'
					}, {
						fixed : 'right',
						title : '操作',
						align : 'center',
						toolbar : '#barDemo2'
					}
					// <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					] ]
				});

				//监听删除按钮
				table.on('tool(test2)', function(obj) {
					var data = obj.data;
					if (obj.event === 'del') {
						layer.confirm('确定要删除吗？', function(index) {
							$.get("/JuchangService/showplace/delete?sid="
									+ data.sid, function(data, status) {
								var data_json = $.parseJSON(data);
								if (data_json.code == "success") {
									layer.msg('删除成功！');
									obj.del();
									layer.close(index);

								} else {
									layer.msg('删除失败');
								}
							});

						});
					}  else if (obj.event === 'edit') {
						localStorage.setItem("showplace", JSON.stringify(data));
						window.location.href = "/JuchangService/editShowplace.jsp";

					} else if (obj.event === 'search') {

						localStorage.setItem("showplace", JSON.stringify(data));
						window.location.href = "/JuchangService/showShowplace.jsp";

					} 
				});
				
				
				table.render({
					elem : '#demo3',
					height : 500,
					url : '/JuchangService/ci/search' //数据接口
					,
					page : false //开启分页
					,
					cols : [ [ //表头
					{
						field : 'cid',
						title : 'ID',
						align : 'center',
						width : 80,
					}, {
						field : 'sname',
						title : '剧院名称',
						align : 'center'
					}, {
						field : 'tname',
						title : '剧场名称',
						align : 'center'
					}, {
						field : 'date',
						title : '演出日期',
						align : 'center'
					}, {
						field : 'time',
						title : '演出时间',
						align : 'center'
					}, {
						field : 'loc',
						title : '演出厅',
						align : 'center'
					}, {
						field : 'money',
						title : '门票价格',
						align : 'center'
					}, {
						fixed : 'right',
						title : '操作',
						align : 'center',
						toolbar : '#barDemo3'
					}
					// <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					] ]
				});

				//监听删除按钮
				table.on('tool(test3)', function(obj) {
					var data = obj.data;
					if (obj.event === 'del') {
						layer.confirm('确定要删除吗？', function(index) {
							$.get("/JuchangService/ci/delete?cid="
									+ data.cid, function(data, status) {
								var data_json = $.parseJSON(data);
								if (data_json.code == "success") {
									layer.msg('删除成功！');
									obj.del();
									layer.close(index);

								} else {
									layer.msg('删除失败');
								}
							});

						});
					}  else if (obj.event === 'edit') {
						localStorage.setItem("ci", JSON.stringify(data));
						window.location.href = "/JuchangService/editCi.jsp";

					}
				});
				
				
				///dingdan
				table.render({
					elem : '#demo4',
					height : 500,
					url : '/JuchangService/ticket/searchTicketAll' //数据接口
					,
					page : false //开启分页
					,
					cols : [ [ //表头
					{
						field : 'tcid',
						title : 'ID',
						align : 'center',
						width : 80,
					}, {
						field : 'sname',
						title : '剧院名称',
						align : 'center'
					}, {
						field : 'tname',
						title : '剧场名称',
						align : 'center'
					}, {
						field : 'uname',
						title : '姓名',
						align : 'center'
					}, {
						field : 'date',
						title : '演出日期',
						align : 'center'
					}, {
						field : 'time',
						title : '演出时间',
						align : 'center'
					}, {
						field : 'loc',
						title : '演出厅',
						align : 'center'
					}, {
						field : 'money',
						title : '门票价格',
						align : 'center'
					}, {
						field : 'statu',
						title : '订单状态',
						align : 'center',
						templet: function(d){
							
        					var statu = '';
							if(d.statu == 0){
								statu = '已付款';
							}else if(d.statu == 1){
								statu = '已使用';
							}else if(d.statu == 2){
								statu = '已评价';
							}else if(d.statu == 3){
								statu = '申请退款中';
							}else if(d.statu == 4){
								statu = '退款成功';
							}else if(d.statu == 5){
								statu = '退款失败';
							}
							return statu;
      					}
				

						
						
						
						
						
						
					}, {
						fixed : 'right',
						title : '操作',
						align : 'center',
						toolbar : '#barDemo4'
					}
					// <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					] ]
				});

				//监听删除按钮
				table.on('tool(test4)', function(obj) {
					var data = obj.data;
					if (obj.event === 'del') {
						layer.confirm('确定要删除吗？', function(index) {
							$.get("/JuchangService/ticket/delete?tcid="
									+ data.tcid, function(data, status) {
								var data_json = $.parseJSON(data);
								if (data_json.code == "success") {
									layer.msg('删除成功！');
									obj.del();
									layer.close(index);

								} else {
									layer.msg('删除失败');
								}
							});

						});
					}  else if (obj.event === 'edit') {
						if(data.statu == 3){
							layer.confirm('是否同意退款申请？', {
								  btn: ['同意', '不同意', '取消'] //可以无限个按钮
								  ,btn3: function(index, layero){
								  }
								}, function(index, layero){
								  //同意的回调
									layer.close(index); 
									$.get("/JuchangService/ticket/updateStatu?tcid="
											+ data.tcid+'&statu=4', function(data, status) {
										var data_json = data;
										if (data_json.code == "success") {
											layer.msg('退款成功！');
											onc(localStorage.getItem("page"));

										} else {
											layer.msg('退款失败');
										}
									});
								  
								  
								  
								}, function(index){
								  //不同意的回调
									$.get("/JuchangService/ticket/updateStatu?tcid="
											+ data.tcid+'&statu=5', function(data, status) {
										var data_json = data;
										if (data_json.code == "success") {
											layer.msg('处理成功！');
											onc(localStorage.getItem("page"));

										} else {
											layer.msg('处理失败');
										}
									});
								  
								});
							
						}else{
							layer.msg('暂无处理订单');
						}
							
					}
				});
				
				
				
				//用户管理 
				table.render({
					elem : '#demo5',
					height : 500,
					url : '/JuchangService/user/searchAll' //数据接口
					,
					page : false //开启分页
					,
					cols : [ [ //表头
					{
						field : 'uid',
						title : 'ID',
						align : 'center',
						width : 80,
					}, {
						field : 'name',
						title : '姓名',
						align : 'center'
					}, {
						field : 'sex',
						title : '性别',
						align : 'center'
					}, {
						field : 'user',
						title : '登录账号',
						align : 'center'
					}, {
						field : 'pswd',
						title : '登录密码',
						align : 'center'
					}, {
						fixed : 'right',
						title : '操作',
						align : 'center',
						toolbar : '#barDemo5'
					}
					// <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					] ]
				});

				//监听删除按钮
				table.on('tool(test5)', function(obj) {
					var data = obj.data;
					if (obj.event === 'del') {
						layer.confirm('确定要删除吗？', function(index) {
							$.get("/JuchangService/ticket/delete?tcid="
									+ data.tcid, function(data, status) {
								var data_json = $.parseJSON(data);
								if (data_json.code == "success") {
									layer.msg('删除成功！');
									obj.del();
									layer.close(index);

								} else {
									layer.msg('删除失败');
								}
							});

						});
					}  else if (obj.event === 'edit') {
						
						localStorage.setItem("user", JSON.stringify(data));
						window.location.href = "/JuchangService/editUser.jsp";
							
					}
				});
				
				
				
				
				
				
				
				
				
				
				
				
				

			});
		

		
			
			
			
			
			
			
			

			layui.use('element', function() {
				var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

			});

		}
		onc(localStorage.getItem("page"));
	</script>
</body>
</html>

