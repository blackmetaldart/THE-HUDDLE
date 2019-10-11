//THIS SECTION WILL HOLD ALL OF THE EVENT LISTENERS TO AFFECT THE DISPLAY OF THE APPLICATION
signUpSubmit.addEventListener("click", createUser);
signUpBtn.addEventListener("click", signUpToggle);
logInBtn.addEventListener("click", logInToggle);
logInSubmit.addEventListener('click', returningUser);

//console.log("js is linked!");
//===LANDING===//

//VARIABLE FOR THE JSON WEB TOKEN
let token;

//THESE VARIABLES STORE THE ELEMENTS FOR THE LOGIN AND SIGNUP FORM
const signUpBtn = document.querySelector('#signUpBtn');
const logInBtn = document.querySelector('#logInBtn');
const signUpForm = document.querySelector('#signUpForm');
const logInForm = document.querySelector('#logInForm');
const signUpSubmit = document.querySelector(".signUpSubmit");
const logInSubmit = document.querySelector(".logInSubmit");
//THESE VARIABLES STORE THE ELEMENTS THAT HOLD THE DATA FOR REGISTERING THE USER
const email = document.querySelector('.email');
const password = document.querySelector('.password');
const username = document.querySelector('.userName');
//THESE VARIABLES STORE THE DATA THAT THE USER LOGS IN WITH
const logInEmail = document.querySelector('.logInEmail');
const logInPassword = document.querySelector('.logInPassword');

function signUpToggle() {
  signUpForm.classList.toggle('none');
  if(signUpForm.classList.contains('none')) {
    signUpBtn.innerHTML = 'register';
  } else {
    signUpBtn.innerHTML = 'x';
  }
}

function logInToggle() {
  logInForm.classList.toggle('none');
  if(logInForm.classList.contains('none')) {
    logInBtn.innerHTML = 'log in';
  } else {
    logInBtn.innerHTML = 'x';
  }
}

//===REGISTER FUNCTION===//

//THIS FUNCTION ALLOWS THE USERS TO SIGNUP
function createUser(e) {
  e.preventDefault();

  localStorage.setItem('username', username.value);
  localStorage.setItem('primaryEmail', email.value);

  fetch('localhost:8080/signup', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              username: username.value,
              password: password.value,
              email: email.value
          })})
  .then((res) => {return res.json();})
  .then((res) => {token = res.token;//store token value to variable token
    //allows for data persistence between html pages
    localStorage.setItem('user', token); //stores token as a cookie

    //REDIRECTS USER TO HOMEPAGE
    redirectHome();})
  .catch((err) => {console.log(err);})
}

//===LOGIN FUNCTION===//

//THIS FUNCTION RETURNS A USER
function returningUser(e) {
    e.preventDefault();

    fetch('localhost:8080/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
            username: logInUsername.value,
            password: logInPassword.value
          })})

      .then(res => {return res.json();})
      .then(res => {token = res.token;
        localStorage.setItem('user', token);
        redirectHome();})

      .catch(error => {console.error(error);});
  }

//===REDIRECT FUNCTION TO HOMEPAGE===//
function redirectHome() {
    if (token != null) {
    window.location.href = "./home.html";
    }
  }
