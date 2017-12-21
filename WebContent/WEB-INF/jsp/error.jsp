<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误-理财通</title>
</head>
<body>
<font style="color:red;">${msg }</font>
<br>
没跳转？<a href="${pageContext.request.contextPath }/financing/user/firstfont.action">点这里</a>
</body>
</html>