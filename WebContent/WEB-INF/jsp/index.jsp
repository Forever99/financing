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
<link
	href="${pageContext.request.contextPath }/css/jquery.date_input.pack.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.date_input.pack.js">
	
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js.jsp">
</script>
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<div id="headNochange_div">
			<div id="head_in">
				<div id="head_in_left">
					<a href="${pageContext.request.contextPath }/index.action"><img
						alt="理财通logo"
						src="${pageContext.request.contextPath }/img/logo_head.jpg"
						width="300px" height="60px"></a>
				</div>
				<div id="head_in_mid">
					<!-- 在 head的mid div上 放一个 搜索账簿信息框  如果用户没有登录 那么 点搜索 显示 还没登录无法搜索数据 先登录  -->
					<c:choose>
						<c:when test="${not empty sessionScope.user }">
							<form action="${pageContext.request.contextPath}/search.action"
								method="post">
								<!-- 貌似还缺少一张 账簿表 记录 支出和收入 信息 -->
								<input type="hidden" name="id" value="${sessionScope.user.id }">
								<div class="input-group" id="serach_div">
									<input type="text" class="form-control" name="待定!!"
										placeholder="搜索账簿信息"> <span class="input-group-btn">
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
									<button class="btn btn-default" type="button"
										id="before_login_search_div">搜索</button>
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
									<div
										style="height: 20px; margin-top: 5px; width: 110px; float: left;">
										<font style="color: #009fe8; font-size: 18px;">欢迎
											：${user.username }</font>
									</div>
									<div id="singin_nav_head_in_right_in_other">
										<ul class="nav navbar-nav">
											<li class="dropdown"><a href="#" class="dropdown-toggle"
												data-toggle="dropdown"
												style="height: 35px; padding-top: 10px;"> <span
													class="glyphicon glyphicon-user"></span> <b class="caret"></b>
											</a>
												<ul class="dropdown-menu">
													<li><a
														href="${pageContext.request.contextPath }/user/showuserPage.action?id=${sessionScope.user.id}"><span
															class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户设置</a></li>
													<li><a
														href="${pageContext.request.contextPath }/user/logout.action"><span
															class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;退出系统</a></li>

												</ul></li>
										</ul>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div id="head_in_right_in_other">
									<button type="button" class="btn btn-default"
										id="before_login_singin_modal">登录</button>
									<button type="button" class="btn btn-primary"
										id="before_login_singout_modal">加入理财通</button>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<div id="nav_main_div">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active" id="recordBook"><a href="#personRecord"
					data-toggle="tab" id="a_id_record">个人账本</a></li>
				<li class="dropdown"><a href="#" id="a_id_takeRecord"
					class="dropdown-toggle" data-toggle="dropdown">记一笔 <b
						class="caret"></b></a>
					<ul class="dropdown-menu " role="menu" aria-labelledby="myTabDrop1">
						<li><a href="#payout" tabindex="-1" data-toggle="tab">支出</a></li>
						<li><a href="#income" tabindex="-1" data-toggle="tab">收入</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" id="a_id_graphs"
					class="dropdown-toggle" data-toggle="dropdown">财务报表 <b
						class="caret"></b></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
						<li><a href="#payoutGraphs" tabindex="-1" data-toggle="tab">支出报表</a></li>
						<li><a href="#incomeGraphs" tabindex="-1" data-toggle="tab">收入报表</a></li>
					</ul></li>
				<li><a href="#wishList" data-toggle="tab" id="a_id_wishList">心愿单</a></li>
			</ul>
			<!-- id="myTabContent" -->
			<!-- style="background-color:pink;height:auto;" -->
			<div class="tab-content" id="tab_main_content" style="height: 500px;">
				<!-- 如果没有登录的话 那么 就显示 一张美图 给用户好了  -->
				<c:choose>
					<c:when test="${empty sessionScope.user }">
						<!-- 显示 背景图 -->
					</c:when>
					<c:otherwise>
						<!-- 如果登录进来的话就显示下面的模块 -->
						<div class="tab-pane fade in active" id="personRecord"
							style="margin-top: 5px;">
							<div id="personRecord_top" style="height: 70px; width: 800px;">
								<div
									style="width: 180px; float: left; margin-left: 8px; margin-top: 8px;">
									<input placeholder="点击选择日期"
										style="width: 120px; line-height: 23px; display: inline-block"
										type="text" class="date_picker" id="datatimeo">
									<button class="btn btn-default" type="button"
										id="findDateRecordBtn">查询</button>
								</div>
								<div style="width: 100px; height: 30px; float: left;">
									<p style="float: right;">
										<font style="color: #009fe8; font-size: 16px;">
										<b id="calcuteYearId"></b><br>
										<b id="calcuteMonthId"></b>统计：</font>
									</p>
								</div>
								<div style="width: 500px; height: 60px; float: right;">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>支出(￥)</th>
												<th>收入(￥)</th>
												<th>结余(￥)</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>-<b id="table1_spendId"></b></td>
												<td>+<b id="table1_incomeId"></b></td>
												<td> <b id="table1_inOrOutId"></b></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div id="personRecord_body"
								style="height: 420px; margin-top: 5px;">
								<span style="margin-left:10px;"><button class="btn btn-default" id="showDetailRecordbtn">显示全部记录</button></span>
								<div id="personRecord_body_detail_alltable" style="height:380px;width:950px;margin:auto;">
									<p><font style="color: #009fe8; font-size: 16px;">收支明细如下:</font></p>
									<div style="width:850px;height:340px;margin:auto;">
										<div style="margin:auto;width:auto;height:260px;">
											<table class="table table-hover" id="personRecord_table">
												<thead style="background-color:#aed9fb;">
													<tr>
														<th>金额(￥)</th>
														<th>类型</th>
														<th>备注</th>
														<th>时间</th>
													</tr>
												</thead>
												<tbody> <!-- jq ajax拿到数据动态显示 --> </tbody>
											</table>
										</div>
										<div>
											<nav id="pageNavId">
											  <ul class="pager">
											    <li id="prePagebtnId_all"><a href="#">上一页</a></li>
											    <input type="hidden" value="1" id="personRecordPage"><!--默认当前是第1页  -->
											    <li id="nextPagebtnId_all"><a href="#">下一页</a></li> 
											  </ul>
											</nav>
										</div>
										
									</div>
								</div>
								
								<div id="personRecord_body_detail_datetable" style="height:380px;width:950px;margin:auto;">
									<p><font style="color: #009fe8; font-size: 16px;">查询结果: 
										<b id="person_find_result_date"></b>&nbsp;&nbsp;
										<b id="person_find_result_spend"></b>&nbsp;&nbsp;&nbsp;
										<b id="person_find_result_income"></b>
										</font>
									</p>
									<div id="personRecord_body_searchInfoId">
										<div id="personRecord_body_searchInfoId_inBody" style="width:850px;height:340px;margin:auto;">
											<div style="margin:auto;width:auto;height:260px;">
											<table class="table table-hover" id="date_table">
												<thead style="background-color:#ffecb9;">
													<tr>
														<th>金额(￥)</th>
														<th>类型</th>
														<th>备注</th>
														<th>时间</th>
													</tr>
												</thead>
												<tbody>
													<!-- jq ajax拿到数据动态显示 -->
												</tbody>
											</table>
										</div>
										<div>
											<nav>
											  <ul class="pager">
											    <li id="prePagebtnId_date"><a href="#">上一页</a></li>
											    <input type="hidden" value="1" id="recordResultPage"><!--默认当前是第1页  -->
											    <li id="nextPagebtnId_date"><a href="#">下一页 </a></li>
											  </ul>
											</nav>
										</div>
										</div>
									</div>
								</div>
							</div>  <!-- personRecord_body -->

						</div>
						<div class="tab-pane fade" id="payout">
							<p class="bg-info">
								<font style="color: #009fe8; font-size: 16px;"><b>支出</b>细节</font>
							</p>
							<div style="height: 300px; width: 600px; margin-left: 50px;">
								<form
									action="${pageContext.request.contextPath }/spend/addSpendRecord.action"
									method="post">
									<!--要先 将 类别放到 request域中 -->
									<input type="hidden" name="user_id"
										value="${sessionScope.user.id }">
									<div class="input-group">
										<span class="input-group-addon">￥</span> <input
											id="spend_input_div" type="text" class="form-control"
											name="spendnum" placeholder="输入消费金额"
											aria-label="Amount (to the nearest dollar)"> <span
											class="input-group-addon">.00</span>
									</div>

									<div class="input-group">
										<textarea rows="6" cols="90" class="form-control"
											name="comment">消费记录备注</textarea>
									</div>

									<div class="input-group">
										<span class="input-group-addon">选择消费类别</span> <label
											class="radio-inline" style="padding-left: 0px;"> <select
											class="form-control" name="s_category_id"
											id="select_spend_cate">
												<option>选择类别</option>
												<c:forEach items="${spendcate }" var="spendcate">
													<option value="${spendcate.id }">${spendcate.name}</option>
												</c:forEach>
										</select>
										</label> <label class="radio-inline">
											<button type="button" class="btn btn-default"
												id="addSpendCateId">
												<span class="glyphicon glyphicon-plus"></span>添加类别
											</button>
										</label>
									</div>
									<div class="input-group" style="float: right;">
										<button class="btn btn-primary" type="submit"
											id="submit_spend_info_btn">提交消费信息</button>
									</div>
								</form>
							</div>
						</div>
						<div class="tab-pane fade" id="income">
							<p class="bg-info">
								<font style="color: #009fe8; font-size: 16px;"><b>收入</b>细节</font>
							</p>
							<div style="height: 300px; width: 600px; margin-left: 50px;">
								<form
									action="${pageContext.request.contextPath }/income/addIncomeRecord.action"
									method="post">
									<!--要先 将 类别放到 session域中 -->
									<input type="hidden" name="user_id"
										value="${sessionScope.user.id }">
									<div class="input-group">
										<span class="input-group-addon">￥</span> <input
											id="income_input_div" type="text" class="form-control"
											name="incomenum" placeholder="输入金额"
											aria-label="Amount (to the nearest dollar)"> <span
											class="input-group-addon">.00</span>
									</div>

									<div class="input-group">
										<textarea rows="6" cols="90" class="form-control"
											name="comment">收入备注</textarea>
									</div>

									<div class="input-group">
										<span class="input-group-addon">选择收入类别</span> <label
											class="radio-inline" style="padding-left: 0px;"> <select
											class="form-control" name="i_category_id"
											id="select_income_cate">
												<option>选择类别</option>
												<c:forEach items="${incomecate }" var="incomecate">
													<option value="${incomecate.id }">${incomecate.name}</option>
												</c:forEach>
										</select>
										</label> <label class="radio-inline">
											<button type="button" class="btn btn-default"
												id="addIncomeCateId">
												<span class="glyphicon glyphicon-plus"></span>添加类别
											</button>
										</label>
									</div>
									<div class="input-group" style="float: right;">
										<button class="btn btn-primary" type="submit"
											id="submit_income_info_btn">提交收入信息</button>
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
			</c:otherwise>
			</c:choose>
		</div>

		<!-- bootstrap modal模态框  登录/注册窗 -->
		<div class="modal fade" id="myModal_singInUp">
			<div class="modal-dialog" id="modal_dialog_pad">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" align="center" id="modal_singInUpTitle">
							<!--用jq来控制  登录理财通 -->
						</h4>
					</div>
					<div class="modal-body">
						<div id="modal_form_div">
							<!--  jq来控制  ${pageContext.request.contextPath }/user/login.action -->
							<form action="" method="post" id="modal_singInUpForm">
								<input type="text" name="username" class="form-control"
									placeholder="输入用户名" id="modal_singInUp_username"> <input
									type="password" name="password" class="form-control"
									placeholder="输入6位数密码" id="modal_singInUp_pad">

								<!-- 如果是  登录 那么 就用jq将 下面两个 输入框 隐藏  -->
								<input type="password" name="password2" class="form-control"
									placeholder="确认密码" id="modal_singInUp_pad2"> <input
									type="text" name="email" class="form-control"
									placeholder="输入邮箱" id="modal_singInUp_email">
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" id="modal_singInUpSubmit_btn"
							type="submit">
							<!--jq 动态控制 登录理财通 -->
						</button>
						</form>
						<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

		<!-- bootstrap modal模态框  添加 消费/收入 类别  去掉 form 表单  用jQuery ajax form 提交后 会刷新页面-->
		<div class="modal fade" id="myModal_addCateModal">
			<!-- myModal_addSpendCateModal -->
			<div class="modal-dialog" id="modal_dialog_pad">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" align="center" id="addCategoryTitle">
							<!--jq动态 控制显示  添加消费类别 -->
						</h4>
					</div>
					<div class="modal-body">
						<!-- <p>问题描述</p>-->
						<div id="modal_form_div">
							<!--jq 动态控制  action 属性 -->
							<!--  <form action="" method="post" id="addCateform"> -->
							<input type="text" name="name" class="form-control"
								placeholder="输入类别名" id="modal_addCate_name">
						</div>
					</div>
					<div class="modal-footer">
						<!-- modal_addSpendCate_submitbtn -->
						<button class="btn btn-primary" id="modal_addCate_submitbtn"
							type="submit">添加类别</button>
						<!-- </form> -->
						<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

	</div>
</body>
</html>