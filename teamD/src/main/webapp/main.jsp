<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/randomImage.js"></script>
<title>服薬管理アプリ</title>
</head>
<body>

	ログイン成功ページ<br>
	ようこそ、 <%= session.getAttribute("name") %>！<br>
	
	<a href="medicine-register.jsp">服薬登録</a>
</body>
</html>
