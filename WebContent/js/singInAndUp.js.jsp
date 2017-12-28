<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
											$("#registername").val("该用户已存在");
											$("#registername").focus();
										}
									},
									error:function(data){
									}
								});
							}
						});
						$("#emailid").blur(function(){
							var inputvalue = $(this).val();
							if(inputvalue=="" || $.trim(inputvalue).length==0){
								$(this).val("请输入邮箱");
							}
						});
						$("#loginname").blur(function(){
							var inputvalue = $(this).val();
							if(inputvalue=="" || $.trim(inputvalue).length==0){
								$(this).val("请输入用户名");
								$(this).focus();
							}
						});
						$("#password0").blur(function(){
							var inputvalue = $(this).val();
							if(inputvalue=="" || $.trim(inputvalue).length==0){
								/* alert("请输入密码"); */
							}
						});
						
						/* 打开bootstrap 的 modal 窗口 */
						$("#open_findpad").click(function(){
						      $("#myModal").modal('show');
						  });
						$("#modal_find_username").blur(function(){
							var inputvalue = $(this).val();
							if(inputvalue=="" || $.trim($(this).val()).length==0){
								$(this).val("用户名不能为空");
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
										if(data.name=="0"){
											$("#modal_find_username").val("该用户不存在");
											$("#modal_find_username").focus();
										}
									},
									error:function(data){
									}
								});
							}
						});
						
						
					});
	function checkpad(){
		var value1 = $("#password1").val();
		var value2 = $("#password2").val();
		var value3 = $("#emailid").val();
		var value4 = $("#registername").val();
		if(value4==null || value4=="" || $.trim(value4).length==0){
			alert("请输入用户名");
			return false;
		}
		if(value1==null || value1=="" || $.trim(value1).length==0){
			alert("请输入密码");
			$("#password1").focus();
			return false;
		}
		if(value1!=null && value1!="" && $.trim(value1).length<6){
			alert("密码需6位数");
			$("#password1").focus();
			return false;
		}
		if(value2==null || value2=="" || $.trim(value2).length==0){
			alert("请确定密码");
			$("#password2").focus();
			return false;
		}
		if(value1!=value2){
			alert("两次密码不一致");
			return false;
		}
		if(value3==null || value3=="" || $.trim(value3).length==0){
			/* 还要进行正则表达式验证 代做 */
			alert("请输入邮箱");
			return false;
		}
		
		return true;
	}