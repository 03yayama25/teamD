<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script>
	function CheckPassword(pass_confirmation){
		// 入力値取得
		var input1 = pass.value;
		var input2 = pass_confirmation.value;
		// パスワード比較
		if(input1 != input2){
			pass_confirmation.setCustomValidity("入力値が一致しません。");
		}else{
			pass_confirmation.setCustomValidity('');
		}
	}
</script>
</head>
<body>
<div class="bg_pattern Crown Lines_v2"></div>

<form action="register-success.jsp" method="post">
<h1>新規登録</h1>
<p>お名前</p>
<input type="text" name="name" required>
<p>パスワード</p>
<input type="password" name="pass" id="pass"  autocomplete="off" minlength="4" required>
<p>パスワード確認</p>
<input type="password" name="pass_confirmation"  id="pass_confirmation" autocomplete="off" minlength="4" oninput="CheckPassword(this)" required>
<p>
<input type="submit" value="送信">
</p>
</form>
</body>
</html>