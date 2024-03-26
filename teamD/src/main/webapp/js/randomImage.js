/* ランダムでオーガマンの画像を表示させるJavascript */

function displayRandomImage() {
    // Javaで生成されたランダムな画像パスを取得
    var imagePath = '<%= ImageUtil.getRandomImagePath() %>';
    
    // 画像要素を取得して、画像パスを設定
    var imageElement = document.getElementById("randomImage");
    imageElement.src = imagePath;
}