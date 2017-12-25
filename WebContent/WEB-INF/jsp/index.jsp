<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页-理财通</title>
<script
	src="${pageContext.request.contextPath }/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath }/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/bootstrap/3.3.6/bootstrap.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		/* 将 container div高度设置为 屏幕的高度 自动适应 */
		$("#container").css("height", $(document).height());
		$("#before_login_search_div").click(function(){
			alert("你还没登录，请先登录后,再查询个人账簿信息");
		});
		
		/* 用来 判断 是要显示 登录 还是 注册 框 以便 用jq做动态控制 */
		var singInUp = "";
		/* 打开登录/注册 模态框  共用 一个 模态框 用 jq控制  减少 代码量 */
		$("#before_login_singin_modal").click(function(){
		      $("#myModal_singInUp").modal('show');
		      singInUp = "singin";
		      $("#modal_singInUpTitle").text("登录理财通");
		      $("#modal_singInUpForm").attr("action","${pageContext.request.contextPath }/user/login.action");
		      /* 如果是登录的话 那么就 将 后面的 两个 输入框 确定密码 输入邮箱 隐藏 */
		      $("#modal_singInUp_pad2").hide();
		      $("#modal_singInUp_email").hide();
		      $("#modal_singInUpSubmit_btn").text("登录理财通");
		  });
		
		$("#before_login_singout_modal").click(function(){
		      $("#myModal_singInUp").modal('show');
		      singInUp = "singup";
		      $("#modal_singInUpTitle").text("加入理财通");
		      $("#modal_singInUpForm").attr("action","${pageContext.request.contextPath }/user/register.action");
		      /* 如果是登录的话 那么就 将 后面的 两个 输入框 确定密码 输入邮箱显示*/
		      $("#modal_singInUp_pad2").show();
		      $("#modal_singInUp_email").show();
		      $("#modal_singInUpSubmit_btn").text("加入理财通");
		  });
		     
		$("#modal_singInUpSubmit_btn").click(function(){
			var username = $("#modal_singInUp_username").val();
			var password = $("#modal_singInUp_pad").val();
			var password2 = $("#modal_singInUp_pad2").val();
			var email = $("#modal_singInUp_email").val();
			if(singInUp == "singin"){
				if(username==null || username=="" || $.trim(username).length==0){
					alert("请输入用户名");
					return false;
				}
				if(password==null || password=="" || $.trim(password).length==0){
					alert("请输入密码");
					return false;
				}
			}
			if(singInUp == "singup"){
				if(username==null || username=="" || $.trim(username).length==0){
					alert("请输入用户名");
					return false;
				}
				if(password==null || password=="" || $.trim(password).length==0){
					alert("请输入密码");
					return false;
				}
				if(password2==null || password2=="" || $.trim(password2).length==0){
					alert("请确认密码");
					return false;
				}
				if(email==null || email=="" || $.trim(email).length==0){
					alert("请输入邮箱");
					return false;
				}
				if(password!=password2){
					alert("两次密码不一致");
					return false;
				}
			}
			return true;
		});
		
		/* 由于 好多 模态框是可以 复用的 所以 用jq 来 改变 以便需要变化的值 以减少 代码量 */
		/* 添加 消费 类别 以及 收入类别 共用一个模态框 */
		var modal_spend_income = "";
		
		/* 点击 添加 消费类别 弹出 添加 消费类别的模态框  */
		$("#addSpendCateId").click(function(){
			$("#myModal_addCateModal").modal('show');
			modal_spend_income = "spendCate";
			$("#addCategoryTitle").text("添加消费类型");
		});
		
		$("#addIncomeCateId").click(function(){
			$("#myModal_addCateModal").modal('show');
			modal_spend_income = "incomeCate";
			$("#addCategoryTitle").text("添加收入类型");
		});
		
		$("#modal_addCate_submitbtn").click(function(){
			var Cateval = $("#modal_addCate_name").val();
			if(Cateval==null || Cateval=='' || $.trim(Cateval).length==0){
				alert("请输入类别名");
				return false;
			}else{
				if(modal_spend_income == "spendCate"){
					$("#addCateform").attr("action","${pageContext.request.contextPath }/spend/addSpendCate.action");
				}
				if(modal_spend_income == "incomeCate"){
					$("#addCateform").attr("action","${pageContext.request.contextPath }/income/addIncomeCate.action");
				}	
			}
		});
		
		$("#submit_spend_info_btn").click(function(){
			var spendnum = $("#spend_input_div").val();
			var spendcate = $("#select_spend_cate").val(); 
			if(spendnum==null || spendnum=='' || $.trim(spendnum).length==0){
				alert("请输入金额");
				return false;
			}
			if(spendcate=="选择类别" || spendcate==null || spendcate=="" || $.trim(spendcate).length==0){
				alert("请选择类别");
				return false;
			}
		});
		$("#submit_income_info_btn").click(function(){
			var incomenum = $("#income_input_div").val();
			var incomecate = $("#select_income_cate").val(); 
			if(incomenum==null || incomenum=='' || $.trim(incomenum).length==0){
				alert("请输入金额");
				return false;
			}
			if(incomecate=="选择类别" || incomecate==null || incomecate=="" || $.trim(incomecate).length==0){
				alert("请选择类别");
				return false;
			}
		});
		
	});
</script>
<style>
#container {
	maring: auto;
	width: auto;
	background-color: #f4f4f4;
}

#nav_main_div {
	width: 1000px;
	height: 550px;
	margin: auto;
	margin-top: 5px;
	background-color: #ffffff;
}

#headNochange_div {
	width: auto;
	height: 60px;
	background: #ffffff;
}
#head_in{
	width:1000px;
	height:60px;
	margin:auto;
}
#head_in_left{
	width:300px;
	height:60px;
	margin:auto;
	float:left;
}
#head_in_mid{
	width:300px;
	height:60px;
	margin-left:50px;
	float:left;
}
#head_in_right{
	width:300px;
	height:60px;
	margin:auto;
	float:right;
}
#head_in_right_in{
	width:300px;
	height:35px;
	margin-top:15px;
}
#head_in_right_in_other{
	width:160px;
	height:35px;
	float:right;
}
#serach_div{
	margin-top:17px;
}

#myModal_singInUp{
	width:350px;
	margin:auto;
}
/* #myModal_singup{
	width:350px;
	margin:auto;
} */
#myModal_addCateModal{
	width:350px;
	margin:auto;
}
.modal-dialog{
	width:300px;
	margin:auto;
}
#modal_form_div{
	width:250px;
	margin:auto;
}

#modal_form_div input{
	width:250px;
	margin-top:5px;
}
#modal_dialog_pad{
	margin-top:80px;
}
#singin_head_in_right_in_other{
	width:200px;
	height:35px;
	float:right;
}
#singin_nav_head_in_right_in_other{
	float:right;
}
p {
	margin-left: 10px;
	margin-top: 8px;
}
.input-group{
	margin:10px;
}
</style>
</head>
<body>
	<div id="container">
		<div id="headNochange_div">
			<div id="head_in">
				<div id="head_in_left"><a href="${pageContext.request.contextPath }/index.action"><img alt="理财通logo" src="${pageContext.request.contextPath }/img/logo_head.jpg" width="300px" height="60px"></a></div>
				<div id="head_in_mid">
					<!-- 在 head的mid div上 放一个 搜索账簿信息框  如果用户没有登录 那么 点搜索 显示 还没登录无法搜索数据 先登录  -->
					<c:choose>
						<c:when test="${not empty sessionScope.user }">
							<form action="${pageContext.request.contextPath}/search.action" method="post"><!-- 貌似还缺少一张 账簿表 记录 支出和收入 信息 -->
								<input type="hidden" name="id" value="${sessionScope.user.id }">
								<div class="input-group" id="serach_div">
							      <input type="text" class="form-control" name="待定!!" placeholder="搜索账簿信息">
							      <span class="input-group-btn">
							        <button class="btn btn-default" type="submit">搜索</button>
							      </span>
							    </div>
							</form>
						</c:when>
						<c:otherwise>
							<!--还没登录 显示 请先登录 才会显示信息-->
								<div class="input-group" id="serach_div">
							      <input type="text" class="form-control" placeholder="搜索账簿信息">
							      <span class="input-group-btn">
							        <button class="btn btn-default" type="button" id="before_login_search_div">搜索</button>
							      </span>
							    </div>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="head_in_right">
					<div id="head_in_right_in">
						<c:choose>
							<c:when test="${not empty sessionScope.user }">
								<div id="singin_head_in_right_in_other">
									<div style="height:20px;margin-top:5px;width:110px;float:left;"><font style="color:#009fe8;font-size:18px;">欢迎 ：${user.username }</font></div>
									<div id="singin_nav_head_in_right_in_other">
										<ul class="nav navbar-nav" >
											<li class="dropdown">
												<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="height:35px;padding-top:10px;">
  													<span class="glyphicon glyphicon-user"></span>
  													<b class="caret"></b>
												</a>
												<ul class="dropdown-menu">
													<li><a href="${pageContext.request.contextPath }/user/showuserPage.action?id=${sessionScope.user.id}"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户设置</a></li>
													<li><a href="${pageContext.request.contextPath }/user/logout.action"><span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;退出系统</a></li>
													
												</ul>
											</li>
										</ul>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div id="head_in_right_in_other">
									<button type="button" class="btn btn-default" id="before_login_singin_modal">登录</button>
									<button type="button" class="btn btn-primary" id="before_login_singout_modal">加入理财通</button>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<div id="nav_main_div">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active" id="recordBook"><a  href="#personRecord"
					data-toggle="tab" id="a_id_test">个人账本</a></li>
				<li class="dropdown"><a href="#" id="myTabDrop1"
					class="dropdown-toggle" data-toggle="dropdown">记一笔 <b
						class="caret"></b></a>
					<ul class="dropdown-menu " ro le="menu" aria-labelledby="myTabDrop1">
						<li><a href="#payout" tabindex="-1" data-toggle="tab">支出</a></li>
						<li><a href="#income" tabindex="-1" data-toggle="tab">收入</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" id="myTabDrop2"
					class="dropdown-toggle" data-toggle="dropdown">财务报表 <b
						class="caret"></b></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
						<li><a href="#payoutGraphs" tabindex="-1" data-toggle="tab">支出报表</a></li>
						<li><a href="#incomeGraphs" tabindex="-1" data-toggle="tab">收入报表</a></li>
					</ul>
				</li>
				<li><a href="#wishList" data-toggle="tab">心愿单</a></li>
			</ul>
			<!-- id="myTabContent" -->
			<div class="tab-content" style="background-color:pink;height:auto;">
				<div class="tab-pane fade in active" id="personRecord" style="margin-top:5px;">
					个人账簿
				</div>
				<div class="tab-pane fade" id="payout">
					<p><font style="color:#009fe8;font-size:16px;"><b>支出</b>细节</font></p>
					<div style="height: 300px;width:600px;margin-left:50px;">
						<form action="${pageContext.request.contextPath }/spend/addSpendRecord.action" method="post">
							<!--要先 将 类别放到 request域中 -->
							<input type="hidden" name="user_id" value="${sessionScope.user.id }">
							<div class="input-group">
							  <span class="input-group-addon">￥</span>
							  <input id="spend_input_div" type="text" class="form-control" name="spendnum" placeholder="输入消费金额" aria-label="Amount (to the nearest dollar)">
							  <span class="input-group-addon">.00</span>
							</div>
							
							<div class="input-group">
							  <textarea rows="6" cols="90" class="form-control" name="comment">消费记录备注</textarea>
							</div>
							
							<div class="input-group">
								<span class="input-group-addon">选择消费类别</span>
								<label class="radio-inline" style="padding-left:0px;">
								<select class="form-control" name="s_category_id" id="select_spend_cate">
									<option>选择类别</option>
									<c:forEach items="${spendcate }" var="spendcate">
										<option value="${spendcate.id }">${spendcate.name}</option>
									</c:forEach> 
						 		</select>
						 		</label>
						 		<label class="radio-inline">
						 			<button type="button" class="btn btn-default" id="addSpendCateId"><span class="glyphicon glyphicon-plus"></span>添加类别</button>
						 		</label>
							</div>
							<div class="input-group" style="float:right;">
								<button class="btn btn-primary" type="submit" id="submit_spend_info_btn">提交消费信息</button>
							</div>
						</form>
					</div>
				</div>
				<div class="tab-pane fade" id="income">
					<p><font style="color:#009fe8;font-size:16px;"><b>收入</b>细节</font></p>
					<div style="height: 300px;width:600px;margin-left:50px;">
						<form action="${pageContext.request.contextPath }/income/addIncomeRecord.action" method="post">
							<!--要先 将 类别放到 session域中 -->
							<input type="hidden" name="user_id" value="${sessionScope.user.id }">
							<div class="input-group">
							  <span class="input-group-addon">￥</span>
							  <input id="income_input_div" type="text" class="form-control" name="incomenum" placeholder="输入金额" aria-label="Amount (to the nearest dollar)">
							  <span class="input-group-addon">.00</span>
							</div>
							
							<div class="input-group">
							  <textarea rows="6" cols="90" class="form-control" name="comment">收入备注</textarea>
							</div>
							
							<div class="input-group">
								<span class="input-group-addon">选择收入类别</span>
								<label class="radio-inline" style="padding-left:0px;">
								<select class="form-control" name="i_category_id" id="select_income_cate">
									<option>选择类别</option>
									<c:forEach items="${incomecate }" var="incomecate">
										<option value="${incomecate.id }">${incomecate.name}</option>
									</c:forEach> 
						 		</select>
						 		</label>
						 		<label class="radio-inline">
						 			<button type="button" class="btn btn-default" id="addIncomeCateId"><span class="glyphicon glyphicon-plus"></span>添加类别</button>
						 		</label>
							</div>
							<div class="input-group" style="float:right;">        
								<button class="btn btn-primary" type="submit" id="submit_income_info_btn">提交收入信息</button>
							</div>
						</form>
					</div>
					
				</div>
				<!-- 报表div -->
				<div class="tab-pane fade" id="payoutGraphs">
					<div style="background: yellow; height: 300px;"></div>
				</div>
				<div class="tab-pane fade" id="incomeGraphs">
					<div style="background: red; height: 300px;"></div>
				</div>
				<div class="tab-pane fade" id="wishList">
					<p>心愿单</p>
				</div>
			</div>
		</div>
		
		<!-- bootstrap modal模态框  登录/注册窗 -->
		<div class="modal fade" id="myModal_singInUp">
		<div class="modal-dialog" id="modal_dialog_pad">
       		<div class="modal-content">
	          <div class="modal-header">
	            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	            <h4 class="modal-title" align="center" id="modal_singInUpTitle"><!--用jq来控制  登录理财通 --></h4>
	          </div>
	          <div class="modal-body">
	            <div id="modal_form_div">    <!--  jq来控制  ${pageContext.request.contextPath }/user/login.action -->
		            <form action="" method="post" id="modal_singInUpForm"> 
		            	<input type="text" name="username" class="form-control" placeholder="输入用户名" id="modal_singInUp_username">
		            	<input type="password" name="password" class="form-control" placeholder="输入6位数密码" id="modal_singInUp_pad">
		            	
		            	<!-- 如果是  登录 那么 就用jq将 下面两个 输入框 隐藏  -->
		            	<input type="password" name="password2" class="form-control" placeholder="确认密码" id="modal_singInUp_pad2">
		            	<input type="text" name="email" class="form-control" placeholder="输入邮箱" id="modal_singInUp_email">
	            </div>
	          </div>
	          <div class="modal-footer">
	            		<button class="btn btn-primary" id="modal_singInUpSubmit_btn" type="submit"><!--jq 动态控制 登录理财通 --></button>
	            	</form>
	             <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
	          </div>
	       </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
	</div>
		
		
		<!-- bootstrap modal模态框  添加 消费/收入 类别-->
		<div class="modal fade" id="myModal_addCateModal"><!-- myModal_addSpendCateModal -->
			<div class="modal-dialog" id="modal_dialog_pad">
	       		<div class="modal-content">
		          <div class="modal-header">
		            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
		            <h4 class="modal-title" align="center" id="addCategoryTitle"><!--jq动态 控制显示  添加消费类别 --></h4>
		          </div>
		          <div class="modal-body">
		            <!-- <p>问题描述</p>
		            <div id="modal_form_div"><!--jq 动态控制  action 属性 -->
			            <form action="" method="post" id="addCateform">
			            	<input type="text" name="name" class="form-control" placeholder="输入类别名" id="modal_addCate_name">
		            </div>
		          </div>
		          <div class="modal-footer">   <!-- modal_addSpendCate_submitbtn -->
		            		<button class="btn btn-primary" id="modal_addCate_submitbtn" type="submit">添加类别</button>
		            	</form>
		             <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
		          </div>
		       </div><!-- /.modal-content -->
	      </div><!-- /.modal-dialog -->
		</div>
	
	</div>
</body>
</html>