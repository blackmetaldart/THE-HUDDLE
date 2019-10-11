//CREATES VARIABLE FOR THE NEW POST BUTTON
const newPostBtn = document.querySelector('.newPostBtn');
newPostBtn.addEventListener('click', createPost);

//DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

//DISPLAYS ONLY FIRST SEVEN POSTS FROM API
listAllPosts();

//THIS FUNCTION LISTS ALL THE POSTS FROM THE API
function listAllPosts () {

 fetch('localhost:8080/posts/list')
 .then((res) => {return res.json();})
 .then((res) => {
  const randomPosts = document.querySelector('.randomPostsSection');

  //CREATES DIV TO HOLD POST TITLE AND DESCRIPTION AND HAVE THE RESPONSE IDs
  for(let i = 0; i < 5; i++) {

      const randomPost = document.createElement('div');
      const title = document.createElement('h2');
      const description = document.createElement('p');

      //CREATE COMMENT BOXES
      const commentArea = document.createElement('div');
      const commentBox = document.createElement('textarea');
      const commentSubmit = document.createElement('button');

      randomPost.setAttribute("id", res[i].id);
      title.setAttribute("class", "title");
      commentBox.setAttribute("rows", "3");
      commentBox.setAttribute("cols", "50");
      commentBox.setAttribute("placeholder", "Your response to the post?");

      //PROVIDES ID OF POST FOR COMMENT
      commentBox.setAttribute("postIdForComments", res[i].id);

      title.innerText = res[i].title;
      description.innerText = res[i].description;
      commentSubmit.innerText = "Submit Comment";

      commentArea.append(commentBox, commentSubmit);
      randomPost.append(title, description, commentArea);
      randomPosts.appendChild(randomPost);

      randomPost.classList.add('postDivStyle');
      description.classList.add('description');
      commentArea.classList.add('commentAreaDiv');
      commentSubmit.classList.add('commitSubmit');
      commentBox.classList.add('commentBox');

      viewComments(res[i].id);}})

  .catch((err) => {console.log(err);})

}

//GET POSTS FROM USER
displayUserPosts();

//THIS FUNCTION DISPLAYS ALL THE POSTS FROM THE USER
function displayUserPosts() {
  fetch("localhost:8080/user/post", {
      method: 'GET',
      headers: {
          "Authorization": "Bearer " + localStorage.getItem('user')
      }})
  .then((res) => {return res.json();})
  .then((res) => {
    //DISPLAY USER POSTS
    const userPosts = document.getElementById('prevUserPostsDiv');

    for(let i = 0; i < res.length; i++) {

        const prevPost = document.createElement('div');
        const prevTitle = document.createElement('h2');
        const prevDescription = document.createElement('p');

        //CREATES COMMENT BOXES
        const commentArea = document.createElement('div');
        const commentBox = document.createElement('textarea');
        const commentSubmit = document.createElement('button');

        prevTitle.innerText = res[i].title;
        prevDescription.innerText = res[i].description;
        commentSubmit.innerText = "Submit Comment";

        prevTitle.setAttribute("class", "title");
        prevPost.setAttribute("id", res[i].id);
        commentBox.setAttribute("rows", "3");
        commentBox.setAttribute("cols", "50");
        commentBox.setAttribute("placeholder", "Your response to the post?");

        //PROVIDES ID OF POST FOR COMMENTS
        commentBox.setAttribute("postIdForComments", res[i].id);

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

//CALLS THE FUNCTION TO VIEW THE COMMENTS
  .then((res) => {viewComments(res);})

//CONSOLE LOG ERROR RESPONSE
  .catch((err) => {console.log(err);})
}

//THIS FUNCTION ALLOWS USERS TO CREATE POSTS
function createPost(e) {
    e.preventDefault();

    //VARIABLES TO STORE ELEMENTS USED FOR CREATING A NEW POST
    const newPostsDiv = document.querySelector('.newPostsDiv');
    const title = document.querySelector('.newPostTitle');
    const des = document.querySelector('.newPostDes');

    fetch("localhost:8080/post", {
        method: 'POST',
        headers: {
          "Authorization": "Bearer " + localStorage.getItem('user'),
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title.value,
            description: des.value
        })
    })
    .then((res) => {
        //ADD A NEW POST TO THE DOM
        addPostsToDom();})
    //LOG ANY ERRORS IN THE CONSOLE WINDOW
    .catch((err) => {console.log(err);})
}

//THIS FUNCTION ATTACHES NEW POSTS TO
function addPostsToDom() {

  fetch("localhost:8080/user/post", {
      headers: {
        "Authorization": "Bearer " + localStorage.getItem('user')
      }})
  .then((res) => {return res.json();})
  .then((res) => {
    const newPosts = document.getElementById('newPostsDiv');
    const userPosts = document.getElementById('prevUserPostsDiv');

    const newPost = document.createElement('div');
    const newTitle = document.createElement('h2');
    const newDescription = document.createElement('p');

    //VARIABLES FOR ELEMENTS USED FOR "CREATE COMMENT" BOX
    const commentArea = document.createElement('div');
    const commentBox = document.createElement('textarea');
    const commentSubmit = document.createElement('button');

    newTitle.innerText = res[res.length-1].title;
    newDescription.innerText = res[res.length-1].description;
    commentSubmit.innerText = "Submit Comment";

    newPost.setAttribute("id", `newPostId ${res.length-1}`);
    commentBox.setAttribute("rows", "3");
    commentBox.setAttribute("cols", "50");
    commentBox.setAttribute("placeholder", "Your response to the post?");
    commentBox.setAttribute("postIdForComments", `newPostId ${res.length-1}`);

    commentArea.append(commentBox, commentSubmit);
    newPost.append(newTitle, newDescription, commentArea);
    newPosts.appendChild(newPost);

    newPost.classList.add('postDivStyle');
    newTitle.classList.add('title');
    newDescription.classList.add('description');
    commentArea.classList.add('commentAreaDiv');
    commentSubmit.classList.add('commentSubmit');
    commentBox.classList.add('commentBox');
})
  .catch((err) => {console.log(err);})

}

//THIS FUNCTION ALLOWS THE USER TO MAKE COMMENTS
function createComment(postId) {

  fetch(`localhost:8080/comment/${postId}` , {
    method: "POST",
    headers: {
      "Authorization": "Bearer " + localStorage.getItem("user"),
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      text: document.querySelector((`[postIdForComments="${postId}"]`)).value
    })})
  .then(res => {viewComments(postId);})
  .catch(err => {console.log(err);});
}

//THIS FUNCTION WILL DISPLAY THE COMMENTS WITH A POST ID
function viewComments(postId) {

  fetch(`localhost:8080/post/${postId}/comment/`)
  .then((res) => {return res.json();})
  .then((res) => {

    if(res !== []) {
    for(let i= 0; i < res.length; i++) {
      //CREATES THE ELEMENT TO HOLD THE COMMENT
      const commented = document.createElement('p');

      //SETS P TO HAVE THE COMMENT TEXT
      commented.innerHTML = res[i].text;

      //STYLES COMMENTS
      commented.setAttribute("class", "comment");

      //TARGETS THE POST DIV TO HOLD THE COMMENTS
      const commentsPart = document.getElementById(res[i].post.id);
      commentsPart.appendChild(commented);
    }}})
  .catch((err) => {console.log(err);})
}
