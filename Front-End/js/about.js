//DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');

let usernameDisplay = localStorage.getItem('username');

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";
