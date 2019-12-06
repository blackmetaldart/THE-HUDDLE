// ADDS THE EVENT LISTENERS TO CREATE THE PROFILE
const createProfileBtn = document.getElementById('createProfileBtn');
createProfileBtn.addEventListener('click', createProfile);
const logoutBtn = document.querySelector('.logout');
logoutBtn.addEventListener('click', logout);
// DISPLAY PROFLIE VARIABLES
const displayUserName = document.getElementById('displayUserName');
const displayAddtEmail = document.getElementById('displayAddtEmail');
const displayMobile = document.getElementById('displayMobile');
const displayAddy = document.getElementById('displayAddy');
// CREATE PROFILE FORM VARIABLES
let addEmail = document.getElementById('addEmail');
let mobile = document.getElementById('mobile');
let addy = document.getElementById('addy');
// CREATE VARIABLES FOR DISPLAYING USERNAME
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

// DISPLAYS THE USERNAME
accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = '3px double rgb(163,13,45)';
displayUserName.innerHTML = usernameDisplay;

// THIS FUNCTION SHOWS PROFILE INFORMATION
displayProfile();

function displayProfile() {

  fetch('http://localhost:8080/profile/' + localStorage.getItem('username'), {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'}})
  .then((response) => {return response.json();})
  .then((response) => {

    // DISPLAYS THE USER'S EMAIL IF THERE IS ONE
    if(response.addtEmail) {
      displayAddtEmail.innerHTML = response.addtEmail;
      localStorage.setItem('secondaryEmail', response.addtEmail);}
    else if(response.addtEmail === undefined || !localStorage.getItem('secondaryEmail')) {
        displayAddtEmail.innerHTML = '<em>Add Secondary Email</em>';}
    else if (localStorage.getItem('secondaryEmail')) {
      displayAddtEmail.innerHTML = localStorage.getItem('secondaryEmail');
    }

    // DISPLAYS THE USER'S MOBILE IF THERE IS ONE
    if(response.mobile) {
      displayMobile.innerHTML = response.mobile;
      localStorage.setItem('mobile', response.mobile);}
    else if(response.mobile === undefined || !localStorage.getItem('mobile')) {
      displayMobile.innerHTML = '<em>Add Mobile Number</em>';}
    else if(!response.mobile) {
      displayMobile.innerHTML = localStorage.getItem('mobile');
    }

    // DISPLAYS THE USER'S ADDRESS IF THERE IS ONE
    if(response.address) {
      displayAddy.innerHTML = response.address;
      localStorage.setItem('addy', response.address);}
    else if(response.address === undefined || !localStorage.getItem('addy')) {
      displayAddy.innerHTML = '<em>Add Home Address</em>';}
    else if(!response.address) {
      displayAddy.innerHTML = localStorage.getItem('addy');
    }})
  .catch((error) => {console.log(error);})

}

// THIS FUNCTION ALLOWS THE USER TO CREATE PROFILE FUNCTION
function createProfile(e){
  e.preventDefault();

  fetch('http://localhost:8080/profile/' + `${usernameDisplay}`, {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'},
    body: JSON.stringify({
      addtEmail: addEmail.value,
      mobile: mobile.value,
      address: addy.value})})

  .then((response) => {return response.json();})
  .then((response)=> {updateProfile(response);})
  .catch((error) => {console.log(error);})
}

// THIS FUNCTION UPDATES PROFILE FUNCTION
function updateProfile(response) {

  if(addEmail.value === "" || addEmail.value === null) {
    return;
  } else {
    displayAddEmail.innerHTML = response.addtEmail;
  }

  if(mobile.value === "" || mobile.value === null) {
    return;
  } else {
    displayMobile.innerHTML = response.mobile;
  }

  if(addy.value === "" || mobile.value === null) {
    return;
  } else {
    displayAddy.innerHTML = response.address;
  }
}

// THIS FUNCTION WILL LOGOUT THE USER
function logout(){
  localStorage.setItem('user', null);
  localStorage.setItem('username', null);
  localStorage.setItem('primaryEmail', null);
}
