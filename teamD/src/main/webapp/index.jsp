  <%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>
  <head>
      <title>服薬管理</title>
	<link rel="stylesheet" href="./css/style.css">
  </head>
  <body>
      <!-- 背景 -->	
	  <div class="bg_pattern Lines_v2"></div>
       <!-- ログインフォーム -->
       <form action="LoginServlet" method="post">
           <h1>服薬管理アプリ</h1><br>
           <div>おなまえ    <input type="text" name="name"></div><br>
           <div>パスワード  <input type="password" name="pass"></div><br>
           <input type="submit" value="ログイン"><br>
           
           <%-- エラーメッセージがある場合に表示する --%>
			<% if (request.getAttribute("errorMessage") != null) { %>
			<div class="error-message"><%= request.getAttribute("errorMessage") %></div>
			<% } %>

        	<!-- 新規登録へのリンク -->
        	<div class="text"><a href="register.jsp">初めて利用する方はこちら</a></div>
       
        </form>
  </body>
  </html>