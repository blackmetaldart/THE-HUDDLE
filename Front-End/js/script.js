//console.log("js is linked!");
//===LANDING===//

//TOKEN
let token;

//FORM VARIABLES
const signUpBtn = document.querySelector('#signUpBtn');
const logInBtn = document.querySelector('#logInBtn');

const signUpForm = document.querySelector('#signUpForm');
const logInForm = document.querySelector('#logInForm');

const signUpSubmit = document.querySelector(".signUpSubmit");
const logInSubmit = document.querySelector(".logInSubmit");

//REGISTER USER ACCT VARIABLES
const email = document.querySelector('.email');
const password = document.querySelector('.password');
const username = document.querySelector('.userName');

//LOG IN USER ACCT VARIABLES
const logInEmail = document.querySelector('.logInEmail');
const logInPassword = document.querySelector('.logInPassword');

//TOGGLES FORMS DISPLAY
signUpBtn.addEventListener("click", signUpToggle);
logInBtn.addEventListener("click", logInToggle);

function signUpToggle() {
  signUpForm.classList.toggle('none');
  if(signUpForm.classList.contains('none')) {
    signUpBtn.innerHTML = 'register';
  } else {
    signUpBtn.innerHTML = 'x';
  }
};

function logInToggle() {
  logInForm.classList.toggle('none');
  if(logInForm.classList.contains('none')) {
    logInBtn.innerHTML = 'log in';
  } else {
    logInBtn.innerHTML = 'x';
  }
};

//===REGISTER FUNCTION===//
signUpSubmit.addEventListener("click", createUser);

function createUser(e) {
  e.preventDefault();

  localStorage.setItem('username', username.value);
  localStorage.setItem('primaryEmail', email.value);

  fetch('http:localhost:8080/signup', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              username: username.value,
              password: password.value,
              email: email.value
          })
  })
  .then((res) => {
      return res.json();
  })
  .then((res) => {
    token = res.token;//store token value to variable token
    //console.log("token - create user", token);
    //console.log("res - create user", res);
    //console.log("username input value", username.value);
    //console.log("email input value", email.value);

    //allows for data persistence between html pages
    localStorage.setItem('user', token); //stores token as a cookie

    //redirects user to homepage
    redirectHome();
  })
  .catch((err) => {
      console.log(err);
  })

}

//===LOGIN FUNCTION===//
logInSubmit.addEventListener('click', returningUser);

function returningUser(e) {
    e.preventDefault();

    fetch('http:localhost:8080/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
            username: logInUsername.value,
            password: logInPassword.value
          })
      })

      .then(res => {
        return res.json();
      })

      .then(res => {
        token = res.token;

        localStorage.setItem('user', token);

        redirectHome();
      })

      .catch(error => {
        console.error(error);
      });
  }

//===REDIRECT FUNCTION TO HOMEPAGE===//
function redirectHome() {
    if (token != null) {
    window.location.href = "./home.html";
    }
  };
