<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服薬管理アプリ</title>

</head>
<body>
	<!-- 背景 -->
	<div class="bg_pattern Lines_v2"></div>
	<div class="main"></div>
	
	             
			<!-- ランダムなオーガマンの画像 -->
			<div class="image-container">
				<img src="{animalImagePath}" alt="オーガマン" /></div>
					
				
				<!-- その日の服用を確認する -->
			<div>
				<h2>今日</h2>
			<div class="btn-container">	
					<button id="achievedButton" class="button">服用</button>
			</div>
			<p id="btntext" class="hidden">うまくやっています。最高です</p>
				</form>
			</div>
			
			
			 <script src="script.js"></script>
			
		<style>
@charset "UTF-8";


* {
	margin: 0;
	padding: 0;
	font-family: 'Zen Kaku Gothic Antique', sans-serif;
	-webkit-appearance: none
}



html, body {
	height: 100%;
	width: 100%;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	overflow: hidden; /* スクロール */
}

body {
	color: #0B1013;
	background-color: #E0E0E0;
}


h2, p {
	text-align: center;
	font-size: 20px;
	margin-top: 10px;
}
/*背景*/
.bg_pattern {
	position: fixed;
	top: 0;
	left: 0;
	width: 100vw;
	height: 100vh;
	background-color: #B5CAA0;
	opacity: 0.4;
	z-index: -1;
}


.Lines_v2 {
  background-image: linear-gradient(to right, #92a5f0, #92a5f0 10px,#ffffff 10px, #ffffff );
  background-size: 20px 100%;
}

/*２段組み*/
.main {
	display: flex;
}

.containerA {
	margin: 20px 20px 0 20px;
	width: 800px;
	float: right;
}

.containerB {
	margin: 30px 30px 0px 30px;
}



.btn-container {
  text-align: center;
}

.button {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 250px;
	margin: 0 auto;
	padding: .9em 2em;
	border: none;
	border-radius: 25px;
	background-color: #2E5C6E;
	color: #FBE251;
	font-weight: 600;
	font-size: 1em;
}

.button:hover {
	animation: anime-button .3s linear infinite;

  /* ボタンにカーソルを当てると、カーソルがポインターに変わる */
  cursor: pointer;
}

/* ボタンにカーソルを当てたとき、ボタンを半透明にする */
button:hover {
 opacity: 0.7;
}

/* ポップアップメッセージを隠す */
.hidden {
  display: none;
}

/* ポップアップメッセージを画面右下に配置 */
#btntext {
  height: 72px;
  padding: 8px 16px;
  border-radius: 8px;
  background: #ddd;
  font-weight: bold;
  text-align: center;
  line-height: 72px;
  position: fixed;
  right: 5%;
  bottom: 10%;
}

/* ポップアップアニメーションを3秒かけて実行 */
.popup-message {
  animation: popup 3s forwards;
}

@keyframes popup {
  0% {
    transform: translateY(15%);
    opacity: 0;
  }
  10%, 90% {
    transform: none;
    opacity: 1;
  }
  100% {
    transform: translateY(15%);
    opacity: 0;
    pointer-events: none;
  }
}
		
				
</body>
</html>