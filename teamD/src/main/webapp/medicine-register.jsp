<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>お薬登録</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>

<body>
<!-- 背景 -->
<div class="bg_pattern Lines_v2"></div>

<!-- 薬の登録フォーム -->
<form action="MedicineAndTimingRegister" method="post">
    <h1>おくすり登録</h1><br>
    <!-- ユーザーIDをhidden inputで送信 -->
    <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">

    <h2>お薬の名前</h2>
    <input type="text" name="name" required><br>

    <h2>頻度</h2><br>
    <input type="checkbox" id="morning" name="timing" value="朝">朝
    <input type="checkbox" id="noon" name="timing" value="昼">昼
    <input type="checkbox" id="evening" name="timing" value="夜">夜
    <input type="checkbox" id="ond" name="timing" value="とん服">とん服<br><br>

    <h2>種類</h2><br>
    <input type="radio" id="prescription" name="type" value="処方箋" required>処方箋
    <input type="radio" id="overTheCounter" name="type" value="市販薬" required>市販薬<br><br>

    <input type="submit" value="登録">
</form>

</body>
</html>
