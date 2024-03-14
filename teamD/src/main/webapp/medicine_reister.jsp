 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


 <!DOCTYPE html>
 <html lang=ja>
 <head>
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>お薬登録</title>
       <link rel="stylesheet" type="text/css" href="style.css">
 
 </head>
 
 <body>
	               <!-- 背景 -->
	       <div class="bg_pattern Lines_v2"></div>
	       
	               <!-- 登録画面 -->
	       <form action="register" method="post">
	       <h4>お薬の名前</h4><br>       
           <input type="text" name="name" value=""><br>
           頻度<br>
           <input type="checkbox" name="radio" value="radio1">朝
           <input type="checkbox" name="radio" value="radio1">昼
           <input type="checkbox" name="radio" value="radio1">夜
           <input type="checkbox" name="radio" value="radio1">とん服<br>
           
           種類<br>
           <input type="radio" name="radio" value="radio1">処方箋
           <input type="radio" name="radio" value="radio1">市販薬<br>
           
           <input type="submit" value="登録">
           
           
           
           
 
 
 </head>
 </html>