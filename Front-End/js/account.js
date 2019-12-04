//ADDS THE EVENT LISTENERS TO CREATE THE PROFILE
const createProfileBtn = document.getElementById('createProfileBtn');
createProfileBtn.addEventListener('click', createProfile);
//DISPLAY PROFLIE VARIABLES
const displayUserName = document.getElementById('displayUserName');
const displayPrimaryEmail = document.getElementById('displayPrimaryEmail');
const displayAddtEmail = document.getElementById('displayAddtEmail');
const displayMobile = document.getElementById('displayMobile');
const displayAddy = document.getElementById('displayAddy');
//CREATE PROFILE FORM VARIABLES
let addEmail = document.getElementById('addEmail');
let mobile = document.getElementById('mobile');
let addy = document.getElementById('addy');
//CREATE VARIABLES FOR DISPLAYING USERNAME
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

//DISPLAYS THE USERNAME
accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = '3px double rgb(163,13,45)';
displayUserName.innerHTML = usernameDisplay;
displayPrimaryEmail.innerHTML = localStorage.getItem('primaryEmail');

//THIS FUNCTION SHOWS PROFILE INFORMATION
displayProfile();

function displayProfile() {

  fetch('http://localhost:8080/profile/' + localStorage.getItem('username'), {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'}})
  .then((response) => {return response.json();})
  .then((response) => {
    console.log(response);

    //DISPLAYS THE USER'S EMAIL IF THERE IS ONE
    if(response.addtEmail) {
      displayAddtEmail.innerHTML = response.addtEmail;
      localStorage.setItem('secondaryEmail', response.addtEmail);}
    else if(response.addtEmail === undefined || !localStorage.getItem('secondaryEmail')) {
        displayAddtEmail.innerHTML = '<em>Add Secondary Email</em>';}
    else if (localStorage.getItem('secondaryEmail')) {
      displayAddtEmail.innerHTML = localStorage.getItem('secondaryEmail');
    }

    //DISPLAYS THE USER'S MOBILE IF THERE IS ONE
    if(response.mobile) {
      displayMobile.innerHTML = response.mobile;
      localStorage.setItem('mobile', response.mobile);}
    else if(response.mobile === undefined || !localStorage.getItem('mobile')) {
      displayMobile.innerHTML = '<em>Add Mobile Number</em>';}
    else if(!response.mobile) {
      displayMobile.innerHTML = localStorage.getItem('mobile');
    }

    //DISPLAYS THE USER'S ADDRESS IF THERE IS ONE
    if(response.address === undefined || !localStorage.getItem('addy')) {
      displayAddy.innerHTML = '<em>Add Home Address</em>';
    } else if(response.address) {
      displayAddy.innerHTML = response.address;
      localStorage.setItem('addy', response.address);
    } else if(!response.address) {
      displayAddy.innerHTML = localStorage.getItem('addy');
    }})
  .catch((error) => {console.log(error);})

}

//THIS FUNCTION ALLOWS THE USER TO CREATE PROFILE FUNCTION
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

  //CALLS UPDATEPROFILE FUNCTION TO SHOW NEW CHANGES FROM "CREATE/UPDATE" PROFILE FORM
  .then((response)=> {updateProfile(response);})

  //LOGS ERRORS TO CONSOLE
  .catch((error) => {console.log(error);})

}

//THIS FUNCTION UPDATES PROFILE FUNCTION
function updateProfile(response) {

  //IF INPUT VALUE FOR THE USER'S ADDITIONAL EMAIL IS AN EMPTY STRING OR NULL, THEN DON'T UPDATE FORM
  //OTHERWISE DISPLAY THE USER'S ADDITIONAL EMAIL
  if(addEmail.value === "" || addEmail.value === null) {
    return;
  } else {
    displayAddEmail.innerHTML = response.addtEmail;
  }

  //IF INPUT VALUE FOR THE USER'S MOBILE IS AN EMPTY STRING OR NULL, THEN DON'T UPDATE FORM
  //OTHERWISE DISPLAY THE USER'S MOBILE
  if(mobile.value === "" || mobile.value === null) {
    return;
  } else {
    displayMobile.innerHTML = response.mobile;
  }

  //IF INPUT VALUE FOR THE USER'S ADDRESS IS AN EMPTY STRING OR NULL, THEN DON'T UPDATE FORM
  //OTHERWISE DISPLAY THE USER'S ADDRESS
  if(addy.value === "" || mobile.value === null) {
    return;
  } else {
    displayAddy.innerHTML = response.address;
  }
}
