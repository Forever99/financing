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
		/* $("#a_id_test").click(function(){
			alert("点击了链接");
		}); 
		测试可以的
		 */
		/* 将 container div高度设置为 屏幕的高度 自动适应 */
		$("#container").css("height", $(document).height());
		$("#before_login_search_div").click(function(){
			alert("你还没登录，请先登录后,再查询个人账簿信息");
		});
		
		/* 打开登录模态框 */
		$("#before_login_singin_modal").click(function(){
		      $("#myModal_login").modal('show');
		  });
		/* 检查 登录 输入框是否 有输入信息 */
		$("#modal_submit_btn").click(function(){
			var username = $("#modal_login_username").val();
			var pad = $("#modal_login_pad").val();
			if(username==null || username=="" || $.trim(username).length==0){
				alert("请输入用户名");
				return false;
			}
			if(pad==null || pad=="" || $.trim(pad).length==0){
				alert("请输入密码");
				return false;
			}
			return true;
		});
		/* 打开注册框 */
		$("#before_login_singout_modal").click(function(){
			$("#myModal_singup").modal('show');
		});
		/* 检查注册 输入框是否 有输入信息 */
		$("#modal_submit_btn2").click(function(){
			var username = $("#modal_singup_username").val();
			var pad1 = $("#modal_singup_pad").val();
			var pad2 = $("#modal_singup_pad2").val();
			var email = $("#modal_singup_email").val();
			if(username==null || username=="" || $.trim(username).length==0){
				alert("请输入用户名");
				return false;
			}
			if(pad1==null || pad1=="" || $.trim(pad1).length==0){
				alert("请输入密码");
				return false;
			}
			if(pad2==null || pad2=="" || $.trim(pad2).length==0){
				alert("请确认密码");
				return false;
			}
			if(email==null || email=="" || $.trim(email).length==0){
				alert("请输入邮箱");
				return false;
			}
			if(pad1!=pad2){
				alert("两次密码输入不一致");
				return false;
			}
			return true;
		});
		/* 点击 添加 消费类别 弹出 添加 消费类别的模态框  */
		$("#addSpendCateId").click(function(){
			
		});
		
		$("#submit_spend_info_btn").click(function(){
			var spendnum = $("#spend_input_div").val();
			var spendcate = $("#select_spend_cate").val(); 
			if(spendnum==null || spendnum=='' || $.trim(spendnum).length==0){
				alert("请输入消费金额");
				return false;
			}
			if(spendcate=="选择类别" || spendcate==null || spendcate=="" || $.trim(spendcate).length==0){
				alert("请选择消费类别");
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

#myModal_login{
	width:350px;
	margin:auto;
}
#myModal_singup{
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
					<p><font style="color:#009fe8;font-size:16px;">支出细节</font></p>
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
									<c:forEach items="${sessionScope.cate }" var="cate">
										<option value="${cate.id }">${cate.name}</option>
									</c:forEach> 
						 		</select>
						 		</label>
						 		<label class="radio-inline">
						 			<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span>添加类别</button>
						 		</label>
							</div>
							<div class="input-group" style="float:right;">
								<button class="btn btn-primary" type="submit" id="submit_spend_info_btn">提交消费信息</button>
							</div>
						</form>
					</div>
					<!-- <p>《风暴英雄》 是由暴雪娱乐公司开发的一款运行在Windows和Mac OS上的在线多人竞技PC游戏。</p>
					<p>
						游戏中的英雄角色主要来自于暴雪三大经典游戏系列：《魔兽世界》、《暗黑破坏神》和《星际争霸》。它是一款道具收费的游戏，与《星际争霸Ⅱ》基于同一引擎开发。
					</p> -->
				</div>
				<div class="tab-pane fade" id="income">
					<p>《300英雄》是由上海跳跃网络科技有限公司自主研发，深圳中青宝互动网络股份有限公司运营的一款类DOTA网游。游戏以7v7组队对抗玩法为主，提供永恒战场和永恒竞技场两种经典模式任由玩家选择，并创新性地加入勇者斗恶龙、克隆战争等多种休闲娱乐玩法。
					</p>
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
		
		<!-- bootstrap modal模态框  登录窗 -->
		<div class="modal fade" id="myModal_login">
		<div class="modal-dialog" id="modal_dialog_pad">
       		<div class="modal-content">
	          <div class="modal-header">
	            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	            <h4 class="modal-title" align="center">登录理财通</h4>
	          </div>
	          <div class="modal-body">
	            <!-- <p>问题描述</p>
	            <textarea class="form-control"></textarea> -->
	            <div id="modal_form_div">
		            <form action="${pageContext.request.contextPath }/user/login.action" method="post">
		            	<input type="text" name="username" class="form-control" placeholder="输入用户名" id="modal_login_username">
		            	<input type="password" name="password" class="form-control" placeholder="输入6位数密码" id="modal_login_pad">
	            </div>
	          </div>
	          <div class="modal-footer">
	            		<button class="btn btn-primary" id="modal_submit_btn" type="submit">登录理财通</button>
	            	</form>
	             <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
	          </div>
	       </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
	</div>
		
		
	<!-- bootstrap modal模态框  注册窗 -->
		<div class="modal fade" id="myModal_singup">
		<div class="modal-dialog" id="modal_dialog_pad">
       		<div class="modal-content">
	          <div class="modal-header">
	            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	            <h4 class="modal-title" align="center">加入理财通</h4>
	          </div>
	          <div class="modal-body">
	            <!-- <p>问题描述</p>
	            <textarea class="form-control"></textarea> -->
	            <div id="modal_form_div">
		            <form action="${pageContext.request.contextPath }/user/register.action" method="post">
		            	<input type="text" name="username" class="form-control" placeholder="输入用户名" id="modal_singup_username">
		            	<input type="password" name="password" class="form-control" placeholder="输入6位数密码" id="modal_singup_pad">
		            	<input type="password" name="password2" class="form-control" placeholder="确认密码" id="modal_singup_pad2">
		            	<input type="text" name="email" class="form-control" placeholder="输入邮箱" id="modal_singup_email">
	            </div>
	          </div>
	          <div class="modal-footer">
	            		<button class="btn btn-primary" id="modal_submit_btn2" type="submit">加入理财通</button>
	            	</form>
	             <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
	          </div>
	       </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
	</div>
		
		
	</div>
</body>
</html>