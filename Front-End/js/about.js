// ADDS FUNCTION TO THE LOGOUT BUTTON
const logoutBtn = document.querySelector('.logout');
logoutBtn.addEventListener('click', logout);

// DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');

accountLink.innerText = localStorage.getItem('username');
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

// THIS FUNCTION WILL LOGOUT THE USER
function logout(){
  localStorage.setItem('user', null);
  localStorage.setItem('username', null);
  localStorage.setItem('primaryEmail', null);
}
