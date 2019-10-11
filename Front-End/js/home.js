//===HOME===//

//DISPLAYS USERNAME IN NAV
let accountLink = document.querySelector('#account');
let usernameDisplay = localStorage.getItem('username');

accountLink.innerText = usernameDisplay;
accountLink.style.borderBottom = "3px double rgb(163,13,45)";

///////RANDOM POSTS SECTION///////

//DISPLAYS ONLY FIRST SEVEN POSTS FROM API
listAllPosts();

function listAllPosts () {

 fetch('http://thesi.generalassemb.ly:8080/post/list')
 .then((res) => {return res.json();})
 .then((res) => {
  //console.log("list posts", res);
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

      viewComments(res[i].id);}

})

  .catch((err) => {console.log(err);})
}

///////USER POSTS SECTION///////

//GET POSTS FROM USER
displayUserPosts();

function displayUserPosts() {
  fetch("http:localhost:8080/user/post", {
      method: 'GET',
      headers: {
          "Authorization": "Bearer " + localStorage.getItem('user')
      }})

  .then((res) => {
    //console.log("res from user posts", res);
    return res.json();})

  .then((res) => {
    //DISPLAY USER POSTS
    const userPosts = document.getElementById('prevUserPostsDiv');
    console.log("res from previous posts", res);

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
      // //passes post id
      // viewComments(res[i].id);
     }
  })

//CALLS THE FUNCTION TO VIEW THE COMMENTS
  .then((res) => {viewComments(res);})

//CONSOLE LOG ERROR RESPONSE
  .catch((err) => {console.log(err);})
}

//CREATES VARIABLE FOR THE NEW POST BUTTON
const newPostBtn = document.querySelector('.newPostBtn');
newPostBtn.addEventListener('click', createPost);

//FUNCTION TO CREATE POSTS
function createPost(e) {
    e.preventDefault();

    //VARIABLES TO STORE ELEMENTS USED FOR CREATING A NEW POST
    const newPostsDiv = document.querySelector('.newPostsDiv');
    const title = document.querySelector('.newPostTitle');
    const des = document.querySelector('.newPostDes');

    fetch("http:localhost:8080/post", {
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

    //ADD A NEW POST TO THE DOM
    .then((res) => {
        console.log('res from create post', res);
        addPostsToDom();})

    //LOG ANY ERRORS IN THE CONSOLE WINDOW
    .catch((err) => {console.log(err);})
}

//ATTACHED NEW POSTS TO DOM
function addPostsToDom() {

  fetch("http://thesi.generalassemb.ly:8080/user/post", {
      headers: {
        "Authorization": "Bearer " + localStorage.getItem('user')
      }
  })

  .then((res) => {
    console.log("res from add posts", res);
    return res.json();})

  .then((res)=>{

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

  //console.log("newPost", newPost);
})

  .catch((err) => {
      console.log(err);
  })
}

///////CREATE COMMENTS///////
// function createComment(resId) {
//   console.log('resId in createComment', resId);
//
//   fetch(`http://thesi.generalassemb.ly:8080/comment/${resId}` , {
//     method: "POST",
//     headers: {
//       "Authorization": "Bearer " + localStorage.getItem("user"),
//       "Content-Type": "application/json"
//     },
//     body: JSON.stringify({
//       text: document.querySelector((`[postIdForComments="${resId}"]`)).value
//     })
//   })
//
//   .then(res => {
//     viewComments(resId);
//   })
//
//   .catch(err => {
//     console.log(err);
//   });
// }

///////DISPLAY COMMENTS///////

function viewComments(resId) {
  //console.log('res Id passed of post: ', resId)

  fetch(`http:localhost:8080/post/${resId}/comment/`)

  .then((res)=>{
    return res.json();
  })

  .then((res)=>{
    //console.log('res from viewComments', res);

    if(res !== []) {
    for(let i= 0; i < res.length; i++) {
      //creates an element to hold the comment
      const commented = document.createElement('p');

      //sets p to have the comment text
      commented.innerHTML = res[i].text;

      //styles comments
      commented.setAttribute("class", "comment");
      //console.log('res[i].text', res[i].text);
      // console.log('existing comments for post', commented);

      //targets the post div to hold the comments
      const commentsPart = document.getElementById(res[i].post.id);
      commentsPart.appendChild(commented);
    }
  }

  //console.log('res text', res.text);
  //console.log('res post id of comment', res.id);
  })

  .catch((err) => {
      console.log(err);
  })
}

///////DELETE POSTS///////
