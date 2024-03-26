<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/randomImage.js"></script>
<script src="js/resizeImages.js"></script>
<title>服薬管理アプリ</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
</head>
<body>
<!-- 背景 -->
<div class="bg_pattern Lines_v2"></div>

<div class="main"></div>
	<h1>ようこそ、 <%= session.getAttribute("name") %>！<br></h1>
	
	<a href="medicine-register.jsp">服薬登録</a>
	
	<div class="btn-container">	
	<h2>今日</h2>
	<ul>
	 <li>ロキソニン <button onclick="displayRandomImage()">済</button></li>
	</ul>
	
	
	<button id="achievedButton" class="button">服用</button>
	</div>
	<!-- ボタンテストここまで -->
	<div class="image-container">
	<img id="randomImage" src="" alt="Random Image">
	</div>
	
</div>

	
	
				<!-- その日の服用を確認する -->
			
				
			
			<p id="btntext" class="hidden">うまくやっています。最高です</p>
			 <script src="btn.js"></script>
</body>
</html>
