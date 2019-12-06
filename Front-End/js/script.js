// VARIABLE FOR THE JSON WEB TOKEN
let token;

// THESE VARIABLES STORE THE ELEMENTS FOR THE LOGIN AND SIGNUP FORM
const signUpBtn = document.querySelector('#signUpBtn');
const logInBtn = document.querySelector('#logInBtn');
const signUpForm = document.querySelector('#signUpForm');
const logInForm = document.querySelector('#logInForm');
const signUpSubmit = document.querySelector(".signUpSubmit");
const logInSubmit = document.querySelector(".logInSubmit");
// THESE VARIABLES STORE THE ELEMENTS THAT HOLD THE DATA FOR REGISTERING THE USER
const email = document.querySelector('.email');
const password = document.querySelector('.password');
const username = document.querySelector('.userName');
// THESE VARIABLES STORE THE DATA THAT THE USER LOGS IN WITH
const logInUsername = document.querySelector('.logInUsername');
const logInPassword = document.querySelector('.logInPassword');

// THIS SECTION WILL HOLD ALL OF THE EVENT LISTENERS TO AFFECT THE DISPLAY OF THE APPLICATION
signUpSubmit.addEventListener('click', signUp);
signUpBtn.addEventListener('click', signUpToggle);
logInBtn.addEventListener('click', logInToggle);
logInSubmit.addEventListener('click', logIn);


// THIS FUNCTION ALLOWS THE SIGNUP MENU TO TOGGLE
function signUpToggle() {
  signUpForm.classList.toggle('none');
  if(signUpForm.classList.contains('none')) {
    signUpBtn.innerHTML = 'register';
  } else {
    signUpBtn.innerHTML = 'x';
  }
}

// THIS FUNCTION ALLOWS THE LOGIN MENU TO TOGGLE
function logInToggle() {
  logInForm.classList.toggle('none');
  if(logInForm.classList.contains('none')) {
    logInBtn.innerHTML = 'log in';
  } else {
    logInBtn.innerHTML = 'x';
  }
}

// THIS FUNCTION ALLOWS THE USERS TO BE CREATED THROUGH SIGNUP
function signUp(e) {
  e.preventDefault();

  localStorage.setItem('username', username.value);
  localStorage.setItem('primaryEmail', email.value);

  fetch('http://localhost:8080/signup', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              username: username.value,
              password: password.value,
              email: email.value
          })})
  .then((response) => {return response.json();})
  .then((response) => {
    localStorage.setItem('user', response.token);

    // REDIRECTS USER TO HOMEPAGE
    redirectHome();})
  .catch((error) => {console.log(error);})
}

// THIS FUNCTION RETURNS A USER UPON LOGIN
function logIn(e) {
    e.preventDefault();

    fetch('http://localhost:8080/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
            username: logInUsername.value,
            password: logInPassword.value
          })})
      .then((response) => {return response.json();})
      .then((response) => {
        token = response.token;
        localStorage.setItem('username', logInUsername.value);
        localStorage.setItem('user', token);
        redirectHome();})
      .catch((error) => {console.error(error);});
  }

// THIS FUNCTION REDIRECTS A USER TO THE HOMEPAGE
function redirectHome() {
    if (token != null) {
    window.location.href = "./home.html";
    }
  }
