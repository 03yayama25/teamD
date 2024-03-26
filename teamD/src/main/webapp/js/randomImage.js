// ランダムで画像パスを取得して表示するJavaScript
function displayRandomImage() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            if (xhr.status == 200) {
                var imagePath = xhr.responseText;
                var imageElement = document.getElementById("randomImage");
                imageElement.src = "http://localhost:8080/teamD" + imagePath; // 画像のURLを正しく構築
            } else {
                console.error('Failed to fetch random image path');
            }
        }
    };
    xhr.open("GET", "http://localhost:8080/teamD/getRandomImagePath", true);
    xhr.send();
}
