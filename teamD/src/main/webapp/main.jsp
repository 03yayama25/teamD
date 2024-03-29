<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/randomImage.js"></script>
<script src="js/calenderImage.js"></script>
<title>服薬管理アプリ</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
</head>
<body>
<!-- 背景 -->
<div class="bg_pattern Lines_v2"></div>

<div id="contents">
	<header>
		<h1>服薬管理アプリ</h1>
		<h4>おかえり、 <%= session.getAttribute("name") %>さん。</h4>
	</header>
	
	<div id="container">
		<div id="left">
			<h2>朝</h2>
				<ul>
					<c:forEach var="medicine" items="${morningMedicines}">
						<li>${medicine.name}</li>
					</c:forEach>
					<li>ここにおくすり名がはいります</li>
					<li>ここにおくすり名がはいります</li>
				</ul>
			    <br>
				<button onclick="displayRandomImage()" id="achievedButton" class="button">服用</button>
		
		
		
			<h2>昼</h2>
				<ul>
					<c:forEach var="medicine" items="${afternoonMedicines}">
						<li>${medicine.name}</li>
					</c:forEach>
					<li>ここにおくすり名がはいります</li>
				</ul>
				<br>
			   
				<button onclick="displayRandomImage()" id="achievedButton" class="button">服用</button>
		
		
		
			<h2>晩</h2>
				<ul>
					<c:forEach var="medicine" items="${eveningMedicines}">
						<li>${medicine.name}</li>
					</c:forEach>
				</ul>
			    <br>
				<button onclick="" id="achievedButton" class="button">服用</button>
		
			
			   <h2>とん服</h2>
				<ul>
					<c:forEach var="medicine" items="${eveningMedicines}">
						<li>${medicine.name}</li>
					</c:forEach>
				</ul>
				<br> 
				<button onclick="displayRandomImage()" id="achievedButton" class="button">服用</button>
		
			<br>
			<a href="index.jsp">もどる</a>
		</div>
		
		<div id="right">
			<h2>おくすり登録はこちら</h2><br>
			<button onclick="location.href='medicine-register.jsp'" id="achievedButton" class="button">おくすり登録</button>
			
			<p><img id="randomImage" src="" alt="Random Image"></p>
			<!-- xxxx年xx月を表示 -->
			<h2 id="header"></h2>
			
			 <!-- ボタンクリックで月移動 -->
			<div id="next-prev-button">
				<button id="prev" onclick="prev()">‹</button>
				<button id="next" onclick="next()">›</button>
			</div>
			
			<!-- カレンダー -->
			<div id="calendar"></div>
		</div>
	</div>
</div>
	
</body>
</html>
