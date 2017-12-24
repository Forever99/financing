<%--
	bootstrap modal模态窗口 代码
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="${pageContext.request.contextPath }/js/jquery/2.0.0/jquery.min.js"></script>
<link href="${pageContext.request.contextPath }/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<script>
$(function(){
   $("#open").click(function(){
      $("#myModal").modal('show');
   });
   $("#submit").click(function(){
      alert("信息已经提交");
      $("#myModal").modal('hide');
   });
   /* $("#toggle").click(function(){
      $("#myModal").modal('toggle');
   }); */
});
</script>
<style>
#myModal{
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
</style>
<button  class="btn btn-default" id="open"> 打开模态窗口</button>
<button class="btn btn-default"  id="close"> 关闭模态窗口</button>
<button class="btn btn-default"  id="toggle"> 切换模态窗口</button>
 <!-- aria-labelledby="myModalLabel"  tabindex="-1"   role="dialog"-->
<div class="modal fade" id="myModal">
	<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">找回密码</h4>
          </div>
          <div class="modal-body">
            <!-- <p>问题描述</p>
            <textarea class="form-control"></textarea> -->
            <div id="modal_form_div">
	            <form action="" method="post">
	            	<input type="text"  class="form-control" placeholder="输入用户名" id="input_username">
	            	<input type="text" class="form-control" placeholder="输入邮箱">
	            	<input type="text" class="form-control" placeholder="输入新密码">
	            </form>
            </div>
          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
            <button class="btn btn-primary" id="submit" type="button">找回密码</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
</div>
 --%>

<!-- bootstrap的 可切换导航栏 代码 -->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath }/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath }/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/bootstrap/3.3.6/bootstrap.min.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){
		/* $("#a_id_test").click(function(){
			alert("点击了链接");
		}); 
		测试可以的
		*/
		/* 将 container div高度设置为 屏幕的高度 自动适应 */
		$("#container").css("height",$(document).height());
	});
</script>
<style>
#container {
	maring: auto;
	width: auto;
	background-color: #f4f4f4;
}
#nav_main_div{
	width:1000px;
	height:500px;
	margin:auto;
	margin-top:5px;
	background-color:#ffffff;
}
#headNochange_div{
	width:auto;
	height:60px;
	background: #ffffff;
}
p {
	margin-left: 10px;
	margin-top: 10px;
}
</style>
<body>
	<div id="container">
		<div id="headNochange_div"></div>
		<div id="nav_main_div">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active" id="recordBook"><a href="#dota" data-toggle="tab" id="a_id_test">个人账本</a></li>
				<li><a href="#lol" data-toggle="tab">英雄联盟</a></li>
				<li class="dropdown">
					<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown">记一笔 <b class="caret"></b></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
						<li><a href="#payout" tabindex="-1" data-toggle="tab">支出</a></li>
						<li><a href="#income" tabindex="-1" data-toggle="tab">收入</a></li>
					</ul>
				</li>
				
				<li class="dropdown">
					<a href="#" id="myTabDrop2" class="dropdown-toggle" data-toggle="dropdown">财务报表 <b class="caret"></b></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
						<li><a href="#payoutGraphs" tabindex="-1" data-toggle="tab">支出报表</a></li>
						<li><a href="#incomeGraphs" tabindex="-1" data-toggle="tab">收入报表</a></li>
					</ul>
				</li>
			</ul>
			<!-- id="myTabContent" -->
			<div class="tab-content">
				<div class="tab-pane fade in active" id="dota">
					<p>《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫，
						是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。</p>
				</div>
				<div class="tab-pane fade" id="lol">
					<p>《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。</p>
				</div>
				<div class="tab-pane fade" id="payout">
					<p>支出细节</p>
					<div style="background: green;height:300px;">dfd</div>
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
					<div style="background: yellow;height:300px;"></div>
				</div>
				<div class="tab-pane fade" id="incomeGraphs">
					<div style="background: red;height:300px;"></div>
				</div>
			</div>
		</div>
	</div>
</body>

<!-- 默认的导航栏  -->

	<div>
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					Java 
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul>
			</li>
		</ul>
	</div>