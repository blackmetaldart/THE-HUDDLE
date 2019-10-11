//DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

//===ACCOUNT/PROFILE===//
//CREATE PROFILE FORM VARIABLES
let addEmail = document.getElementById('addEmail');
let mobile = document.getElementById('mobile');
let addy = document.getElementById('addy');

//DISPLAY PROFLIE VARIABLES
const displayUserName = document.getElementById('displayUserName');
const displayPrimaryEmail = document.getElementById('displayPrimaryEmail');
const displayAddEmail = document.getElementById('displayAddEmail');
const displayMobile = document.getElementById('displayMobile');
const displayAddy = document.getElementById('displayAddy');

displayProfile();

//SHOWS PROFILE INFORMATION
function displayProfile() {

  fetch('localhost:8080/profile', {
    method: 'GET',
    headers: {
      "Authorization": "Bearer " + localStorage.getItem('user'),
      "Content-Type": "application/json"}})
  .then((res) => {return res.json();})
  .then((res) => {
    displayUserName.innerHTML = localStorage.getItem('username');
    displayPrimaryEmail.innerHTML = localStorage.getItem('primaryEmail');

    //DISPLAYS THE USER'S EMAIL IF THERE IS ONE
    if(res.additionalEmail === undefined || !localStorage.getItem('secondaryEmail')) {
      displayAddEmail.innerHTML = "<em>Add Secondary Email</em>";
    } else if(res.additionalEmail) {
      displayAddEmail.innerHTML = res.additionalEmail;
      localStorage.setItem('secondaryEmail', res.additionalEmail);
    } else if (!res.additionalEmail) {
      displayAddEmail.innerHTML = localStorage.getItem('secondaryEmail');
    }

    //DISPLAYS THE USER'S MOBILE IF THERE IS ONE
    if(res.mobile === undefined || !localStorage.getItem('mobile')) {
      displayMobile.innerHTML = "<em>Add Mobile Number</em>";
    } else if(res.mobile) {
      displayMobile.innerHTML = res.mobile;
      localStorage.setItem('mobile', res.mobile);
    } else if(!res.mobile) {
      displayMobile.innerHTML = localStorage.getItem('mobile');
    }

    //DISPLAYS THE USER'S ADDRESS IF THERE IS ONE
    if(res.address === undefined || !localStorage.getItem('addy')) {
      displayAddy.innerHTML = "<em>Add Home Address</em>";
    } else if(res.address) {
      displayAddy.innerHTML = res.address;
      localStorage.setItem('addy', res.address);
    } else if(!res.address) {
      displayAddy.innerHTML = localStorage.getItem('addy');
    }})

  //LOGS ERRORS TO CONSOLE
  .catch((err) => {console.log(err);})

}

//CREATE PROFILE FUNCTION - USED ALSO AS A WORKAROUND FOR THE UPDATE PROFILE
  //CREATE PROFILE BUTTON
const createProfileBtn = document.getElementById("createProfileBtn");
createProfileBtn.addEventListener("click", createProfile);

  //CREATE PROFILE FUNCTION
function createProfile(e){
  e.preventDefault();

  fetch('localhost:8080/profile', {
    method: 'POST',
    headers: {
      "Authorization": "Bearer " + localStorage.getItem('user'),
      "Content-Type": "application/json"},
    body: JSON.stringify({
      additionalEmail: addEmail.value,
      mobile: mobile.value,
      address: addy.value})})

  .then((res) => {return res.json();})

  //CALLS UPDATEPROFILE FUNCTION TO SHOW NEW CHANGES FROM "CREATE/UPDATE" PROFILE FORM
  .then((res)=> {updateProfile(res);})

  //LOGS ERRORS TO CONSOLE
  .catch((err) => {console.log(err);})

}

  //UPDATES PROFILE FUNCTION
function updateProfile(res) {

  //IF INPUT VALUE FOR THE USER'S ADDITIONAL EMAIL IS AN EMPTY STRING OR NULL, THEN DON'T UPDATE FORM
  //OTHERWISE DISPLAY THE USER'S ADDITIONAL EMAIL
  if(addEmail.value === "" || addEmail.value === null) {
    return;
  } else {
    displayAddEmail.innerHTML = res.additionalEmail;
  }

  //IF INPUT VALUE FOR THE USER'S MOBILE IS AN EMPTY STRING OR NULL, THEN DON'T UPDATE FORM
  //OTHERWISE DISPLAY THE USER'S MOBILE
  if(mobile.value === "" || mobile.value === null) {
    return;
  } else {
    displayMobile.innerHTML = res.mobile;
  }

  //IF INPUT VALUE FOR THE USER'S ADDRESS IS AN EMPTY STRING OR NULL, THEN DON'T UPDATE FORM
  //OTHERWISE DISPLAY THE USER'S ADDRESS
  if(addy.value === "" || mobile.value === null) {
    return;
  } else {
    displayAddy.innerHTML = res.address;
  }

}
