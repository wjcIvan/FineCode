<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>编辑用户</title>
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
										<button type="button" class="layui-btn" id="btn1">上传用户头像</button>
										<div class="layui-upload-list">
											<img style="width: 10%" class="layui-upload-img" id="imgtitle">

										</div>
									</div>
					</div>
				
				
				
					<div class="layui-form-item">
						<label class="layui-form-label">姓名</label>
						<div class="layui-input-block">
							<input type="text" name="name" id="name" required lay-verify="required"
								placeholder="请输入剧场名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					
					
					 <div class="layui-form-item">
					    <label class="layui-form-label">性别</label>
					    <div class="layui-input-block">
					      <input type="radio" id="sex1" name="sex" value="男" title="男" checked="">
					      <input type="radio" id="sex2" name="sex" value="女" title="女">
					    </div>
					  </div>
					
					
					
					
					
					

					<div class="layui-form-item">
						<label class="layui-form-label">登录密码</label>
						<div class="layui-input-block">
							<input type="text" name="pswd" id="pswd" required lay-verify="required"
								placeholder="请输入登录密码 autocomplete="off" class="layui-input">
						</div>
					</div>


					











					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">编辑</button>
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
		
		var user = $.parseJSON(localStorage.getItem("user"));
		document.getElementById('name').value = user.name;
		document.getElementById('pswd').value = user.pswd;
		if(user.sex == '男'){
			$('#sex1').attr('checked', '');
		}else{
			$('#sex2').attr('checked', '');
		}
		$('#imgtitle').attr('src', 'img/'+user.icon); //图片链接（base64）
		
		
		
		
		
		var imgname = user.icon;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		

		layui.use('upload', function() {

			var $ = layui.jquery, upload = layui.upload;
			//选完文件后不自动上传
			upload.render({
				elem : '#btn1',
				url : '/JuchangService/theatre/upImg',
				accept : 'images',
				//bindAction : '#test9',
				before : function(obj) {
					//预读本地文件示例，不支持ie8
					obj.preview(function(index, file, result) {
						$('#imgtitle').attr('src', result); //图片链接（base64）
					
						
					});
				},
				done : function(res) {
						imgname = res.img;
					
				}
			});

		});

		

		layui.use('form', function() {
			var form = layui.form;
			
			

			//监听提交
			form.on('submit(formDemo)', function(data) {
				if(imgname == ''){
					layer.msg('请上传用户头像');
				}else{
					data.field.icon=imgname;
					data.field.uid=user.uid;
					data.field.user = user.user;
					$.post("/JuchangService/user/webupdate",
	
					data.field, function(data, status) {
						var data_json = data;
						if (data_json.code == "success") {
							layer.msg('编辑成功！');
	
						} else {
							layer.msg(data_json.msg);
						}
					});
				}
				

				return false;
			});
		});
	</script>
</body>
</html>

