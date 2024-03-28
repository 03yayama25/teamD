// randomImage.js

function displayRandomImage() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            if (xhr.status == 200) {
                var imagePath = xhr.responseText;
                var imageUrl = "http://localhost:8080/teamD" + imagePath;
                var randomImage = document.getElementById("randomImage");
                randomImage.src = imageUrl; // 画像のURLを設定
                randomImage.onload = function() {
                    resizeImage(); // 画像をリサイズ
                    centerImage(); // 画像を中央寄せ
                    randomImage.style.display = 'block'; // 画像を表示
                    
                    // メッセージを表示
                    var btntext = document.getElementById('btntext');
                    btntext.classList.remove('hidden');
                    btntext.classList.add('popup-message');
                };
            } else {
                console.error('Failed to fetch random image path');
            }
        }
    };
    xhr.open("GET", "http://localhost:8080/teamD/getRandomImagePath", true);
    xhr.send();
}

function resizeImage() {
    var randomImage = document.getElementById("randomImage");
    randomImage.style.width = '300px';
}

function centerImage() {
    var randomImage = document.getElementById("randomImage");
    randomImage.style.marginLeft = "auto";
    randomImage.style.marginRight = "auto";
}
