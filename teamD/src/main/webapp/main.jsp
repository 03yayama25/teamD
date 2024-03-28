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
<script src="js/btn.js"></script>
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

 	<div class="split">
    <div class="split-item left">
        <div class="left__inner">

    	<!-- <div id="btntext">うまくやっています。最高です</div> -->
    	<!-- 上記調整必要あり -->

    <h2>朝</h2>
     
<%--     <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>名前</th>
                <th>種類</th>
                <!-- 他の必要なカラムがあればここに追加 -->
            </tr>
        </thead>
        <tbody>
            <!-- 薬のリストをループして表示 -->
            <c:forEach items="${medicines}" var="medicine">
                <tr>
                    <td>${medicine.id}</td>
                    <td>${medicine.name}</td>
                    <td>${medicine.type}</td>
                    <!-- 他のカラムについても同様に表示 -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
     --%>
     
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
	    </div><!--left__inner-->
    </div><!--split-item left-->
	
	<div class="split-item right">
        <div class="right__inner">
	<div class="wrapper">
    <!-- xxxx年xx月を表示 -->
    <h1 id="header"></h1>

    <!-- ボタンクリックで月移動 -->
    <div id="next-prev-button">
        <button id="prev" onclick="prev()">‹</button>
        <button id="next" onclick="next()">›</button>
    </div>
	
	</div>

    <div id="calendar"></div>
    </div>
	</div><!--right__inner-->
    </div><!--split-item right-->
</div><!--split-->
	
</body>
</html>
