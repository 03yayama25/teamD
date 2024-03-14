<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="bg_pattern Crown Lines_v2"></div>

<form action="register-success.jsp" method="post">
<h3>新規登録</h3>
<p>お名前</p>
<input type="text" name="name" required>
<p>パスワード</p>
<input type="password" name="pass" autocomplete="off" minlength="4" required>
<p>パスワード確認</p>
<input type="password" name="pass_confirmation" autocomplete="off" minlength="4" required>
<p>
<input type="submit" value="送信">
</p>
</form>
</body>
</html>