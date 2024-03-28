<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
 String pass = request.getParameter("pass");
%>
=======
	pageEncoding="UTF-8"%>
>>>>>>> 92b4d9e20ed5419ecd5e266a2033718290be2ac2
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
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
	
=======
<title>ErrorPage</title>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
	<div class="bg_pattern Crown Lines_v2"></div>

	<div class="completion">
		<h1>Error！</h1>
		<p>エラーが発生しました</p>
		<a href="index.jsp">もどる</a>
	</div>

>>>>>>> 92b4d9e20ed5419ecd5e266a2033718290be2ac2
</body>
</html>