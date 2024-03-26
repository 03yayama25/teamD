/** 画像サイズを300pxに統一する **/
// resizeImages.js

window.onload = function() {
    var images = document.getElementsByTagName('img');
    for (var i = 0; i < images.length; i++) {
        images[i].style.width = '300px';
    }
};
