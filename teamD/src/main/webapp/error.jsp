<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
 String pass = request.getParameter("pass");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>error</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="bg_pattern Crown Lines_v2"></div>

	<div class="completion">
		<h1>error</h1>
		<p>お名前：<%=name %></p>
		<p>パスワード：<%=pass %></p>
		<a href="index.jsp">ログイン画面へ</a>
	</div>
	
</body>
</html>