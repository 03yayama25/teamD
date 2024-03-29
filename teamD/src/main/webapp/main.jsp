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
<script src="js/popupImage.js"></script>
<title>服薬管理アプリ</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
</head>
<body>
<!-- 背景 -->
<div class="bg_pattern Lines_v2"></div>

<div class="contents">
    <h1>ようこそ、 <%= session.getAttribute("name") %>さん！</h1>
    <a href="medicine-register.jsp">服薬登録</a><br>
    
    	<img id="randomImage" src="" alt="Random Image">

    
    <h2>朝</h2>
    <ul>
        <c:forEach var="medicine" items="${morningMedicines}">
            <li>${medicine.name}</li>
        </c:forEach>
    </ul>
    
	<button onclick="displayRandomImage()" id="achievedButton" class="button">服用</button>
	
	

    <h2>昼</h2>
    <ul>
        <c:forEach var="medicine" items="${afternoonMedicines}">
            <li>${medicine.name}</li>
        </c:forEach>
    </ul>
    
	<button onclick="displayRandomImage()" id="achievedButton" class="button">服用</button>
	
	

    <h2>夕</h2>
    <ul>
        <c:forEach var="medicine" items="${eveningMedicines}">
            <li>${medicine.name}</li>
        </c:forEach>
    </ul>
    
	<button onclick="" id="achievedButton" class="button">服用</button>

	
    <h2>とん服</h2>
	<ul>
        <c:forEach var="medicine" items="${eveningMedicines}">
            <li>${medicine.name}</li>
        </c:forEach>
    </ul>
    
	<button onclick="displayRandomImage()" id="achievedButton" class="button">服用</button>
	
	<br>
	<a href="index.jsp">もどる</a>
	
	</div>

	
</body>
</html>
