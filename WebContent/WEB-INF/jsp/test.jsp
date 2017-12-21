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
