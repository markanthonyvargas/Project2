import React, {useState} from 'react';
import {MDBIcon} from "mdbreact";
import axios from 'axios';

const LikeButton = (props) => {
    const [handleLikes, setLikes] = useState({
        likes: props.likes,
        isLiked: false
    });
    const {likes, isLiked} = handleLikes
    const currentUser = JSON.parse(localStorage.getItem('UserLocal'));
    const postLikes = props.postLikes;
    let likeUserNames = props.postLikes.map((a => a.userName))
   
   function likePost() {

    if(!isLiked) {
    setLikes({
        likes: likes + 1,
        isLiked: true
    })
    axios.post('http://localhost:9005/Project2/socialmedia/insertLike',{
        postId: props.postId,
        userName: currentUser.userName
      })
      /// We have it in local storage now -Andrew
      .then(function (response) {
        console.log(response.data);
        //const User = response.data
        }
      )
}
    else{
        
    }

}


    console.log(currentUser.userName);
    console.log('post likes:', props.postLikes)
    if(likeUserNames.includes(currentUser.userName) || isLiked) {
        return (
            <div>
            <MDBIcon icon="heart"/>
            {likes} likes
        </div>
        );
    }
    else {return (
        <div>
            <i className="far fa-heart" onClick={likePost}/>
            {likes} likes
        </div>
    );
    };}

export default LikeButton;
