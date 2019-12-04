//CREATES VARIABLE FOR THE NEW POST BUTTON
const newPostBtn = document.querySelector('.newPostBtn');
newPostBtn.addEventListener('click', createPost);

//DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

//THIS FUNCTION LISTS ALL THE POSTS FROM THE API
listAllPosts();

function listAllPosts () {

 fetch('http://localhost:8080/posts/list')
 .then((response) => {return response.json();})
 .then((response) => {
  const randomPosts = document.querySelector('.randomPostsSection');

  //CREATES DIV TO HOLD POST TITLE AND DESCRIPTION AND HAVE THE RESPONSE IDs
  for(let i = 0; i < response.length-1; i++) {

      const randomPost = document.createElement('div');
      const title = document.createElement('h2');
      const description = document.createElement('p');

      //CREATE COMMENT BOXES
      const commentArea = document.createElement('div');
      const commentBox = document.createElement('textarea');
      const commentSubmit = document.createElement('button');

      commentSubmit.addEventListener('click', createComment);

      randomPost.setAttribute('id', response[i].id);
      title.setAttribute('class', 'title');
      commentBox.setAttribute('rows', '3');
      commentBox.setAttribute('cols', '50');
      commentBox.setAttribute('placeholder', 'Your response to the post?');

      //PROVIDES ID OF POST FOR COMMENT
      commentBox.setAttribute('postIdForComments', response[i].id);

      title.innerText = response[i].title;
      description.innerText = response[i].description;
      commentSubmit.innerText = "Submit Comment";

      commentArea.append(commentBox, commentSubmit);
      randomPost.append(title, description, commentArea);
      randomPosts.appendChild(randomPost);

      randomPost.classList.add('postDivStyle');
      description.classList.add('description');
      commentArea.classList.add('commentAreaDiv');
      commentSubmit.classList.add('commitSubmit');
      commentBox.classList.add('commentBox');

      viewComments(response[i].id);}})

  .catch((error) => {console.log(error);})

}

//THIS FUNCTION DISPLAYS ALL THE POSTS FROM THE USER
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
    const userPosts = document.getElementById('prevUserPostsDiv');

    for(let i = 0; i < response.length; i++) {

        const prevPost = document.createElement('div');
        const prevTitle = document.createElement('h2');
        const prevDescription = document.createElement('p');

        //CREATES COMMENT BOXES
        const commentArea = document.createElement('div');
        const commentBox = document.createElement('textarea');
        const commentSubmit = document.createElement('button');

        prevTitle.innerText = response[i].title;
        prevDescription.innerText = response[i].description;
        commentSubmit.innerText = "Submit Comment";

        prevTitle.setAttribute('class', 'title');
        prevPost.setAttribute('id', response[i].id);
        commentBox.setAttribute('rows', '3');
        commentBox.setAttribute('cols', '50');
        commentBox.setAttribute('placeholder', 'Your response to the post?');

        //PROVIDES ID OF POST FOR COMMENTS
        commentBox.setAttribute('postIdForComments', response[i].id);

        commentArea.append(commentBox, commentSubmit);
        prevPost.append(prevTitle, prevDescription, commentArea);
        userPosts.appendChild(prevPost);

        prevPost.classList.add('postDivStyle');
        prevDescription.classList.add('description');
        commentSubmit.classList.add('commentSubmit');
        commentBox.classList.add('commentBox');
        commentArea.classList.add('commentAreaDiv');
     }
  })
  .then((response) => {viewComments(response);})
  .catch((error) => {console.log(error);})
}

//THIS FUNCTION ALLOWS USERS TO CREATE POSTS
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

//THIS FUNCTION ALLOWS THE USER TO MAKE COMMENTS
function createComment(postId) {
  fetch('http://localhost:8080/' +`${postId}` + '/comment' , {
    method: 'POST',
    headers: {
      'Authorization' : 'Bearer ' + localStorage.getItem('user'),
      'Content-Type' : 'application/json'
    },
    body: JSON.stringify({
      text: document.querySelector((`[postIdForComments="${postId}"]`)).value
    })})
  .then((response) => {viewComments(postId);})
  .catch((error) => {console.log(error);});
}

//THIS FUNCTION WILL DISPLAY THE COMMENTS WITH A POST ID
function viewComments(postId) {
  fetch(`http://localhost:8080/post/${postId}/comments`)
  .then((response) => {return response.json();})
  .then((response) => {

    if(response !== []) {
    for(let i = 0; i < response.length; i++) {
      const commented = document.createElement('p');
      const commentsPart = document.getElementById(response[i].post.id);

      commented.innerHTML = response[i].text;
      commented.setAttribute('class', 'comment');
      commentsPart.appendChild(commented);
    }}})
  .catch((error) => {console.log(error);})
}
