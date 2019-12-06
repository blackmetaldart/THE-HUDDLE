// CREATES VARIABLE FOR THE NEW POST BUTTON
const newPostBtn = document.querySelector('.newPostBtn');
const logoutBtn = document.querySelector('.logout');
newPostBtn.addEventListener('click', createPost);
logoutBtn.addEventListener('click', logout);

// DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

// THIS FUNCTION LISTS ALL THE POSTS FROM THE API
listAllPosts();
function listAllPosts () {

 fetch('http://localhost:8080/posts/list')
 .then((response) => {return response.json();})
 .then((response) => {
  const postSection = document.querySelector('#postHistoryDiv');

  // CREATES DIV TO HOLD POST TITLE AND DESCRIPTION AND HAVE THE RESPONSE IDs
  for(let i = 0; i < response.length; i++) {

      const post = document.createElement('div');
      const title = document.createElement('h2');
      const description = document.createElement('p');

      // CREATE COMMENT BOXES
      const commentArea = document.createElement('div');
      const commentBox = document.createElement('textarea');
      const commentSubmit = document.createElement('button');

      commentSubmit.setAttribute('value', response[i].id)
      commentSubmit.addEventListener('click', createComment);

      post.setAttribute('id', response[i].id);
      title.setAttribute('class', 'title');
      commentBox.setAttribute('rows', '3');
      commentBox.setAttribute('cols', '50');
      commentBox.setAttribute('placeholder', 'Enter a comment to submit.');

      // PROVIDES ID OF POST FOR COMMENT
      commentBox.setAttribute('postIdForComments', response[i].id);

      title.innerText = response[i].title;
      description.innerText = response[i].description;
      commentSubmit.innerText = "Submit Comment";

      commentArea.append(commentBox, commentSubmit);
      post.append(title, description, commentArea);
      postSection.appendChild(post);

      post.classList.add('postDivStyle');
      description.classList.add('description');
      commentArea.classList.add('commentAreaDiv');
      commentSubmit.classList.add('commitSubmit');
      commentBox.classList.add('commentBox');

      viewComments(response[i].id);}})

  .catch((error) => {console.log(error);})

}

// THIS FUNCTION DISPLAYS ALL THE POSTS FROM THE USER
displayUserPosts();
function displayUserPosts() {
  fetch('http://localhost:8080/' + `${usernameDisplay}`+ '/posts', {
      method: 'GET',
      headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('user')
      }})
  .then((response) => {return response.json();})
  .then((response) => {
    //DISPLAY USER POSTS
    const userPosts = document.getElementById('userPostsDiv');

    for(let i = 0; i < response.length; i++) {

        const post = document.createElement('div');
        const title = document.createElement('h2');
        const description = document.createElement('p');

        //CREATES COMMENT BOXES
        const commentArea = document.createElement('div');
        const commentBox = document.createElement('textarea');
        const commentSubmit = document.createElement('button');

        commentSubmit.setAttribute('value', response[i].id)
        commentSubmit.addEventListener('click', createComment);

        title.innerText = response[i].title;
        description.innerText = response[i].description;
        commentSubmit.innerText = "Submit Comment";

        title.setAttribute('class', 'title');
        post.setAttribute('id', response[i].id);
        commentBox.setAttribute('rows', '3');
        commentBox.setAttribute('cols', '50');
        commentBox.setAttribute('placeholder', 'Enter a comment to submit.');

        //PROVIDES ID OF POST FOR COMMENTS
        commentBox.setAttribute('postIdForComments', response[i].id);

        commentArea.append(commentBox, commentSubmit);
        post.append(title, description, commentArea);
        userPosts.appendChild(post);

        post.classList.add('postDivStyle');
        description.classList.add('description');
        commentSubmit.classList.add('commentSubmit');
        commentBox.classList.add('commentBox');
        commentArea.classList.add('commentAreaDiv');
     }
  })
  .then((response) => {viewComments(response);})
  .catch((error) => {console.log(error);})
}

// THIS FUNCTION ALLOWS USERS TO CREATE POSTS
function createPost(e) {
    e.preventDefault();

    //VARIABLES TO STORE ELEMENTS USED FOR CREATING A NEW POST
    const newPostsDiv = document.querySelector('.newPostsDiv');
    const title = document.querySelector('.newPostTitle');
    const des = document.querySelector('.newPostDes');

    fetch('http://localhost:8080/' + `${usernameDisplay}` + '/makepost', {
        method: 'POST',
        headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('user'),
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: title.value,
            description: des.value
        })
    })
    .then((response) => {
        window.location.href = "./home.html";})
    .catch((error) => {console.log(error);})
}

// THIS FUNCTION ALLOWS THE USER TO MAKE COMMENTS
function createComment() {

  fetch('http://localhost:8080/' +`${this.value}` + '/comment' , {
    method: 'POST',
    headers: {
      'Authorization' : 'Bearer ' + localStorage.getItem('user'),
      'Content-Type' : 'application/json'
    },
    body: JSON.stringify({
      text: document.querySelector((`[postIdForComments="${this.value}"]`)).value
    })})
  .then((response) => {viewComments(this.value);})
  .catch((error) => {console.log(error);});
}

// THIS FUNCTION WILL DISPLAY THE COMMENTS WITH A POST ID
function viewComments(postId) {

  fetch(`http://localhost:8080/post/${postId}/comments`)
  .then((response) => {return response.json();})
  .then((response) => {

    if(response !== []) {
    for(let i = 0; i < response.length; i++) {
      const comment = document.createElement('p');
      const uName = document.createElement('p');
      const commentsPart = document.getElementById(postId);

      uName.innerHTML = response[i].username + " : "
      comment.innerHTML = uName.innerHTML + response[i].text;
      comment.setAttribute('class', 'comment');
      commentsPart.appendChild(comment);
    }}})
  .catch((error) => {console.log(error);})
}

// THIS FUNCTION WILL LOGOUT THE USER
function logout(){
  localStorage.setItem('user', null);
  localStorage.setItem('username', null);
  localStorage.setItem('primaryEmail', null);
}
