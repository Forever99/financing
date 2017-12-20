<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath }/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<script type="text/javascript">
	/*加载完页面后 设置div背景  */
	$(document).ready(
					function() {
						$("#main-body-top").css("background-image",
										"url(${pageContext.request.contextPath }/img/logo1.jpg)");
						/* 页面加载完后 将 注册form表单 隐藏 */
						$("#singupform").hide();
						/* 点击 登录 按钮 显示 登录面板 隐藏注册面板 */
						$("#loginbtn").click(function(){
							$("#singupform").hide();
							$("#singinform").show();
							$("input").val("");
						});
						/* 点击 注册 按钮 显示 登录面板 隐藏登录面板 */
						$("#registerbtn").click(function(){
							$("#singinform").hide();
							$("#singupform").show();
							$("input").val("");
						});
						
						/*  检查是否填写内容 */
						$("#registername").blur(function(){
							var inputvalue = $(this).val();
							if(inputvalue=="" || $.trim($(this).val()).length==0){
								$(this).val("请输入用户名");
							}else{
								/* 如果用户名不为空 检查是否存在 该用户 用ajax异步更新数据 */
								$.ajax({
									url:"/financing/user/findUserAjax.action",/* 发送给服务器的url */
									type:"post",
									/* data:{"username":$(this).val()}, *//* 发送给服务器的数据 json数据 */
									data:JSON.stringify({"username":$(this).val()}),
									dataType:"json", /* 预期的服务器响应的数据 */
									contentType:"application/json;charset=utf-8",/* 发送数据给服务器时所用的内容类型	*/
									success:function(data){ /* 当请求成功时运行的函数 */
										if(data.name=="1"){
											$(this).val("该用户已存在");
										}
									},
									error:function(data){
									}
								});
							}
						});
						$("#emailid").blur(function(){
							var inputvalue = $(this).val();
							if(inputvalue==""){
								$(this).val("请输入邮箱");
							}
						});
					});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#index-main {
	height: auto;
	width: auto;
}

#index-main-body {
	margin: auto;
	width: 350px;
	height: 600px;
	background-color: pink;
}

#main-body-top {
	width: 350px;
	height: 170px;
}

#changebtn {
	width: 160px;
	height: 32px;
	background-color: gray;
	margin: auto;
}

#spanl {
	float: left;
}

#spanl button font {
	color: black;
}

#spanr {
	float: right;
}

#spanr button font {
	color: black;
}

#formdiv {
	margin: auto;
	margin-top: 5px;
	width: 340px;
	height: 300px;
	background-color: green;
	width: 340px;
}

.form-control {
	height: 45px;
	width: 330px;
	margin: auto;
	margin-top: 4px;
}

#insubmit {
	margin: auto;
	margin-top: 4px;
	margin-left: 5px;
	width: 330px;
	height: 45px;
	width: 330px;
}

#spanpad {
	float: right;
	margin-right: 5px;
}
</style>

<title>首页-理财记账</title>
</head>
<body>
	<div id="index-main">
		<div id="index-main-body">
			<div id="main-body-top"></div>
			<div id="changebtn">
				<span id="spanl"><button type="button" class="btn btn-link"
						id="loginbtn">
						<font><b>登录</b></font>
					</button></span> <span id="spanr"><button type="button" class="btn btn-link"
						id="registerbtn">
						<font><b>注册</b></font>
					</button></span>
			</div>

			<div id="formdiv">
				<form id="singinform" action="" method="post">
					<input type="text" class="form-control" name="username" placeholder="用户名">
					<input type="password" class="form-control" name="password" placeholder="密码">
					<button type="submit" class="btn btn-info" id="insubmit">登录</button>
					<span id="spanpad">忘记密码？<a href="#">点这里</a></span>
				</form>
				<form id="singupform" action="${pageContext.request.contextPath }/user/register.action" method="post">
					<input type="text" class="form-control" name="username" placeholder="用户名" id="registername">
					<input type="password" class="form-control" name="password" placeholder="密码(字母数字等字符共6位数)">
					<input type="password" class="form-control" name="password2" placeholder="确认密码">
					<input type="text" class="form-control" name="email" placeholder="邮箱" id="emailid">
					<button type="submit" class="btn btn-info" id="insubmit">注册</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>