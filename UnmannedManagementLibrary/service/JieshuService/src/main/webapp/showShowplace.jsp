<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>剧院</title>
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
								<div class="layui-upload">
										
										<div class="layui-upload-list">
											<img style="width: 10%" class="layui-upload-img" id="imgtitle">

										</div>
									</div>
					</div>
				
				
				
					<div class="layui-form-item">
						<label class="layui-form-label">剧院名称</label>
						<div class="layui-input-block">
							<input readonly="readonly" type="text" name="name" id="name" required lay-verify="required"
								placeholder="请输入剧院名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">剧院地点</label>
						<div class="layui-input-block">
							<input readonly="readonly" type="text" name="loc" id="loc" required lay-verify="required"
								placeholder="请输入剧院地点" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					
					
					
					
					

				



					

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">剧院介绍</label>
						<div class="layui-input-block">
							<textarea readonly="readonly" name="sumary" id="sumary" placeholder="请输入剧院介绍" required
								lay-verify="required" class="layui-textarea"></textarea>
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
		
		
		
		var cinema = $.parseJSON(localStorage.getItem("showplace"));
		document.getElementById('name').value = cinema.name;
		document.getElementById('loc').value = cinema.loc;
		document.getElementById('sumary').value = cinema.sumary;
		$('#imgtitle').attr('src', 'img/'+cinema.img); //图片链接（base64）
		
		
		
		
		
	</script>
</body>
</html>

