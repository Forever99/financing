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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/singInAndUp.js.jsp">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/singInAndUp.css" rel="stylesheet">

<title>登录注册-理财通</title>
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
				<form id="singinform" action="${pageContext.request.contextPath }/user/login.action" method="post" >
					<input type="text" class="form-control" name="username" placeholder="用户名" id="loginname">
					<input type="password" class="form-control" name="password" placeholder="密码" id="password0">
					<button type="submit" class="btn btn-info" id="insubmit">登录</button>
					<span id="spanpad">忘记密码？<button type="button" class="btn btn-link" id="open_findpad">点这里</button></span>
				</form>
				<form id="singupform" action="${pageContext.request.contextPath }/user/register.action" method="post" onsubmit="return checkpad();">
					<input type="text" class="form-control" name="username" placeholder="用户名" id="registername">
					<input type="password" class="form-control" name="password" placeholder="密码(字母数字等字符共6位数)" id="password1">
					<input type="password" class="form-control" name="password2" placeholder="确认密码" id="password2">
					<input type="text" class="form-control" name="email" placeholder="邮箱" id="emailid">
					<button type="submit" class="btn btn-info" id="insubmit">注册</button>
				</form>
			</div>
		</div>
		
		<div class="modal fade" id="myModal">
	<div class="modal-dialog" id="modal_dialog_pad">
        <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title" align="center">找回密码</h4>
          </div>
          <div class="modal-body">
            <!-- <p>问题描述</p>
            <textarea class="form-control"></textarea> -->
            <div id="modal_form_div">
	            <form action="${pageContext.request.contextPath }/user/updatePassword.action" method="post">
	            	<input type="text" name="username" class="form-control" placeholder="输入用户名" id="modal_find_username">
	            	<input type="text" name="email" class="form-control" placeholder="输入邮箱">
	            	<input type="password" name="password" class="form-control" placeholder="输入新密码">
            </div>
          </div>
          <div class="modal-footer">
            	<button class="btn btn-primary" id="submit" type="submit">找回密码</button>
            </form>
             <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
</div>
		
	</div>
</body>

</html>