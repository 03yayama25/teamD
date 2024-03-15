  <%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>服薬管理</title>
      <link rel="stylesheet" type="text/css" href="style.css">
  
  </head>
  <body>
            <!-- 背景 -->	
	  <div class="bg_pattern Lines_v2"></div>
       <!-- ログインフォーム -->
       <form action="Login" method="post">
           <h3>服薬管理アプリ</h3><br>
           <div class="span">おなまえ    <input type="text" name="name"></div><br>
           <div class="span">パスワード  <input type="password" name="pass"></span><br>
           <input type="submit" value="ログイン"><br>

           <!-- 新規登録へのリンク -->
        <a href="register.jsp"><div class="text">初めて利用する方はこちら</a></div>
       
        </form>
  </body>
  </html>