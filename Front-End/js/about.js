//DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');

let usernameDisplay = localStorage.getItem('username');

const logoutBtn = document.querySelector('.logout');
logoutBtn.addEventListener('click', logout);

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

// THIS FUNCTION WILL LOGOUT THE USER
function logout(){
  localStorage.setItem('user', null);
  localStorage.setItem('username', null);
  localStorage.setItem('primaryEmail', null);
}
