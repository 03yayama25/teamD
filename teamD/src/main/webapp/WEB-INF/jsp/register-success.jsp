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
<title>登録完了</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style>
.bg_pattern {
  position: fixed;
  
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: #b5caa0;
  opacity: 0.4;
  z-index: -1;
}
.completion {
  background-color: rgb(255, 255, 255);
  padding: 60px;
  border-radius: 8px;
  box-shadow:  0 0 10px rgba(0, 0, 0, 0.1);
  margin: 0 auto;
  max-width: 400px;
  height:400px;
  display: grid;
  place-items: center;
}

</style>
</head>
<body>
<div class="bg_pattern Crown Lines_v2"></div>
<div class='completion'>
<h3>登録完了しました</h3>
<p>お名前：<%=name %></p>
<p>パスワード：<%=pass %></p>
<a href='index.jsp'>ログイン画面へ</a>
</div>
</body>
</html>