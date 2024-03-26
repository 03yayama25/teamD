/**
 * ボタン押下 js nagata
 * 
 */
const btntext = document.getElementById('btntext');
const btn = document.getElementById('btn');

btn.addEventListener('click', () => {
  btntext.classList.remove('hidden');
  btntext.classList.add('popup-message');
});

btntext.addEventListener('animationend', () => {
  btntext.classList.remove('popup-message');
  btntext.classList.add('hidden');
});