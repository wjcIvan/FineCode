<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>编辑酒店</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">酒店后台管理系统</div>

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
						<label class="layui-form-label">酒店名称</label>
						<div class="layui-input-block">
							<input readonly="readonly" type="text" name="name" id="name" required lay-verify="required"
								placeholder="请输入酒店名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					
					<div class="layui-form-item">
								<div class="layui-upload">
										
										<div class="layui-upload-list">
											<img style="width: 10%" class="layui-upload-img" id="imgtitle">
											<p id="imgname"></p>

										</div>
									</div>
					</div>
					
					
					

					<div class="layui-form-item">
						<label class="layui-form-label">地点</label>
						<div class="layui-input-block">
							<input readonly="readonly" type="text" name="loc" id="loc" required lay-verify="required"
								placeholder="请输入地点" autocomplete="off" class="layui-input">
						</div>
					</div>
					

					



					

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">介绍</label>
						<div class="layui-input-block">
							<textarea readonly="readonly" name="sumary" id="sumary" placeholder="请输入酒店介绍" required
								lay-verify="required" class="layui-textarea"></textarea>
						</div>
					</div>

					<div class="layui-form-item layui-form-text">


						<div class="layui-tab layui-tab-card" lay-filter="demo">
							<label class="layui-form-label">房间类型
								 </label>

							<ul id="tabTitle" class="layui-tab-title">
								<li class="layui-this" lay-id="1">房间1</li>
							</ul>
							<button style="display: none;" type="button" class="layui-btn"
								id="btn">上传图片</button>

							<div id="tabContent" class="layui-tab-content">
								<div class="layui-tab-item layui-show">

									<div class="layui-upload">
										
										<div class="layui-upload-list">
											<img style="width: 10%" class="layui-upload-img" id="img1">
											<p id="txt1"></p>

										</div>
									</div>

									<div class="layui-input-block">
										<input type="text" id="n1" name="n1" required
											lay-verify="required" placeholder="房间名称" autocomplete="off"
											class="layui-input">
										<input oninput = "value=value.replace(/[^\d]/g,'')" type="text" id="m1" name="m1" required lay-verify="required"
											placeholder="房间价格" autocomplete="off" class="layui-input">
										<input type="text" id="s1" name="s1" required lay-verify="required" placeholder="房间介绍" autocomplete="off" class="layui-input">
									</div>


								</div>
							</div>
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

		var holtel = $.parseJSON(localStorage.getItem("holtel"));
		document.getElementById('name').value = holtel.name;
		document.getElementById('sumary').value = holtel.sumary;
		document.getElementById('loc').value = holtel.loc;
		$('#imgtitle').attr('src', 'holtel_img/'+holtel.img); //图片链接（base64）
		$('#imgname').text(holtel.img);
		
		var hid = holtel.hid;
		var bz_img = [];
		var bz_txt = [];
		var bz_txt2 = [];
		var bz_txt3 = [];
		var btnIndex = 1;
		var imgname = holtel.img;
		
		var mes = holtel.content;
		var mTitle = '';
		var mContent = '';
		for ( var i = 0; i < mes.length; i++) {
			if(i == 0){
			mTitle+='<li class="layui-this" >房间'+(i+1)+'</li>';
			}else{
			mTitle+='<li >房间'+(i+1)+'</li>';
			}
			mContent+=getInitTabContent(i, mes[i].img, mes[i].name, mes[i].money, mes[i].remark);
			bz_img.push(mes[i].img);
			bz_txt.push(mes[i].name);
			bz_txt2.push(mes[i].money);
			bz_txt3.push(mes[i].remark);
		}
		document.getElementById('tabTitle').innerHTML = mTitle;
		document.getElementById('tabContent').innerHTML = mContent;
		
		
		
		
		
		function getInitTabContent(i,img,name,money,remark) {
			i += 1;
			var str = '';
			if(i == 1){
				 str = '<div class="layui-tab-item layui-show">';
			}else{
				str = '<div class="layui-tab-item">';
			}
			
			str += '<div class="layui-upload">';
			
			str += '<div class="layui-upload-list">';
			str += '<img src="holtel_img/'+img+'" style="width: 10%" class="layui-upload-img" id="img'
					+ i + '">';
			str += '<p id="txt'+i+'">'+img+'</p>';
			str += '</div></div>';
			str += '<div class="layui-input-block">';
			str += '<input readonly="readonly" value="'+name+'" type="text" id="n'+i+'" name="n'+i+'" required lay-verify="required" placeholder="房间名称" autocomplete="off" class="layui-input">';
			str += '<input readonly="readonly" value="'+money+'" oninput = "value=value.replace(/[^\d]/g,"")" type="text" id="m'+i+'" name="m'+i+'" required lay-verify="required" placeholder="房间价格" autocomplete="off" class="layui-input">';
			str += '<input readonly="readonly" value="'+remark+'" type="text" id="s'+i+'" name="s'+i+'" required lay-verify="required" placeholder="房间介绍" autocomplete="off" class="layui-input">';
			
			str += '</div></div>';
			return str;

		}

		function getTabContent(i) {
			i += 1;
			var str = '';
			str += '<div class="layui-upload">';
			
			str += '<div class="layui-upload-list">';
			str += '<img style="width: 10%" class="layui-upload-img" id="img'
					+ i + '">';
			str += '<p id="txt'+i+'"></p>';
			str += '</div></div>';
			str += '<div class="layui-input-block">';
			str += '<input type="text" id="n'+i+'" name="n'+i+'" required lay-verify="required" placeholder="房间名称" autocomplete="off" class="layui-input">';
			str += '<input oninput = "value=value.replace(/[^\d]/g,"")" type="text" id="m'+i+'" name="m'+i+'" required lay-verify="required" placeholder="房间价格" autocomplete="off" class="layui-input">';
			str += '<input type="text" id="s'+i+'" name="s'+i+'" required lay-verify="required" placeholder="房间介绍" autocomplete="off" class="layui-input">';
			str += '</div>';
			return str;

		}

		//chongzhi
		function updateTab() {
			var tabGroup = document.getElementsByClassName('layui-tab-title')[0]
					.getElementsByTagName('li');
			for ( var i = 0; i < tabGroup.length; i++) {
				tabGroup[i].innerText = '房间' + (i + 1);
				tabGroup[i].setAttribute('lay-id', i + 1);
			}
			var tabItemGroup = document
					.getElementsByClassName('layui-tab-content')[0]
					.getElementsByClassName('layui-tab-item');
			for ( var i = 0; i < tabItemGroup.length; i++) {
				tabItemGroup[i].getElementsByTagName('button')[0].setAttribute(
						'id', 'btn' + (i + 1));
				tabItemGroup[i].getElementsByTagName('img')[0].setAttribute(
						'id', 'img' + (i + 1));
						
				tabItemGroup[i].getElementsByTagName('input')[0].setAttribute(
						'id', 'n' + (i + 1));
				tabItemGroup[i].getElementsByTagName('input')[0].setAttribute(
						'name', 'n' + (i + 1));
						
				tabItemGroup[i].getElementsByTagName('input')[1].setAttribute(
						'id', 'm' + (i + 1));
				tabItemGroup[i].getElementsByTagName('input')[1].setAttribute(
						'name', 'm' + (i + 1));
						
				tabItemGroup[i].getElementsByTagName('input')[2].setAttribute(
						'id', 's' + (i + 1));
				tabItemGroup[i].getElementsByTagName('input')[2].setAttribute(
						'name', 's' + (i + 1));										

			}
			//regsterListener(tabItemGroup.length);

		}

		layui.use('upload', function() {

			var $ = layui.jquery, upload = layui.upload;
			//选完文件后不自动上传
			upload.render({
				elem : '#btn',
				url : '/TravelService/CanHoltel?action=upImg',
				accept : 'images',
				//bindAction : '#test9',
				before : function(obj) {
					//预读本地文件示例，不支持ie8
					obj.preview(function(index, file, result) {
					if(btnIndex == -1){
						$('#imgtitle').attr('src', result); //图片链接（base64）
					}else{
						$('#img' + btnIndex).attr('src', result); //图片链接（base64）
					}
						
					});
				},
				done : function(res) {
					if(btnIndex == -1){
						imgname = res.img;
						$('#imgname').text(res.img);
					}else{
						$('#txt' + btnIndex).text(res.img);
						bz_img[btnIndex - 1] = res.img;
					}
					
				}
			});

		});

		$(".layui-tab").on("click", function(e) {
			if ($(e.target).is(".layui-tab-close")) {
				var layid = $(e.target).parent().attr("lay-id");
				bz_txt.splice(layid - 1, 1);
				bz_txt2.splice(layid - 1, 1);
				bz_txt3.splice(layid - 1, 1);
				bz_img.splice(layid - 1, 1);
				updateTab();
			}
		});

		layui.use('element', function() {
			var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

			//触发事件
			var active = {
				tabAdd : function() {
					//新增一个Tab项
					element.tabAdd('demo', {
						title : '房间' + (bz_txt.length + 1) //用于演示
						,
						content : getTabContent(bz_txt.length),
						id : bz_txt.length + 1
					//实际使用一般是规定好的id，这里以时间戳模拟下
					});
					bz_img.push('');
					bz_txt.push('');
					bz_txt2.push('');
					bz_txt3.push('');
				}
			};

			$('.site-demo-active').on('click', function() {
				var othis = $(this), type = othis.data('type');
				active[type] ? active[type].call(this, othis) : '';
			});

		});

	</script>
</body>
</html>

