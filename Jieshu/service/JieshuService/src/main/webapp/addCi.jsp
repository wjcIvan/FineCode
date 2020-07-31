<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>添加剧场场次</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">剧场后台管理系统</div>

			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a > <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 管理员 </a></li>
				<li class="layui-nav-item"><a href="login.html">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">





				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">




				<!-- 你的HTML代码 -->
				<button class="layui-btn" style="margin: 10px"
					onclick="javascript :history.back(-1);">
					<i class="layui-icon">&#xe65c;</i> 返回
				</button>
				
				
				
				


				<form class="layui-form layui-form-pane">
				
					<div class="layui-form-item">
					    <label class="layui-form-label">请选择剧场</label>
					    <div class="layui-input-block">
					      <select id="tid" name="tid" lay-filter="tid" required lay-verify="required">
					        
					      </select>
					    </div>
					  </div>

					<div class="layui-form-item">
					    <label class="layui-form-label">请选择剧院</label>
					    <div class="layui-input-block">
					      <select id="sid" name="sid" lay-filter="sid" required lay-verify="required">
					        
					      </select>
					    </div>
					  </div>
				
				
					
					
					
					 <div class="layui-form-item">
					    <div class="layui-inline">
					      <label class="layui-form-label">演出日期</label>
					      <div class="layui-input-inline">
					        <input type="text" class="layui-input" id="date" name="date" placeholder="yyyy-MM-dd" required lay-verify="required">
					      </div>
					    </div>
					  </div>
					  
					  
					   <div class="layui-form-item">
					    <div class="layui-inline">
					      <label class="layui-form-label">场次时间</label>
					      <div class="layui-input-inline">
					        <input type="text" class="layui-input" id="time" name="time" placeholder="HH:mm" required lay-verify="required">
					      </div>
					    </div>
					  </div>
					
					
					
					
					
					

					<div class="layui-form-item">
						<label class="layui-form-label">演出厅</label>
						<div class="layui-input-block">
							<input type="text" name="loc" id="loc" required lay-verify="required"
								placeholder="请输入演出厅" autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">门票价格</label>
						<div class="layui-input-block">
							<input oninput = "value=value.replace(/[^\d]/g,'')" type="text" name="money" id="money" required lay-verify="required"
								placeholder="请输入价格" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					
					









					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
							<button id="rese" type="reset"
								class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>




			</div>
		</div>

	</div>









	<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="layui/layui.js"></script>








	<script>
		//a.splice(2,1); //同shift
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //常规用法
		  laydate.render({
		    elem: '#date'
		  });	
		  
		  laydate.render({
		    elem: '#time'
		    ,type: 'time'
		    ,format: 'HH:mm'
		  });
		
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		

		

		

		layui.use('form', function() {
			var form = layui.form;
			
			
			$.get("/JuchangService/theatre/search", function(data,
					status) {

				var data_json = data;
				if (data_json.code == 0) {
					var typeList = data_json.data;
					var str = '';
					for ( var i = 0; i < typeList.length; i++) {
						str += '<option value="'+typeList[i].tid+'">'
								+ typeList[i].name + '</option>';
					}
					document.getElementById('tid').innerHTML = str;
					form.render('select');
				}
			});
			
			
			
			$.get("/JuchangService/showplace/search", function(data,
					status) {

				var data_json = data;
				if (data_json.code == 0) {
					var typeList = data_json.data;
					var str = '';
					for ( var i = 0; i < typeList.length; i++) {
						str += '<option value="'+typeList[i].sid+'">'
								+ typeList[i].name + '</option>';
					}
					document.getElementById('sid').innerHTML = str;
					form.render('select');
				}
			});
			
			
			

			//监听提交
			form.on('submit(formDemo)', function(data) {
				
					$.post("/JuchangService/ci/save",
	
					data.field, function(data, status) {
						var data_json = data;
						if (data_json.code == "success") {
							layer.msg('添加成功！');
							document.getElementById("rese").click();
	
						} else {
							layer.msg(data_json.msg);
						}
					});
				
				

				return false;
			});
		});
	</script>
</body>
</html>

