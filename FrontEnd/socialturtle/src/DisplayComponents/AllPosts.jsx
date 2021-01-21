import React, {useState} from 'react';
import {  MDBRow,  MDBCard, MDBCardBody, MDBIcon, MDBCol, MDBCardImage, MDBInput} from "mdbreact";
import LikeButton from './LikeButton'
import ReactLoading from 'react-loading'
import '../CSS/profile.css'


const AllPosts = (props) => {
    console.log(props.posts);
    if(props.posts && props.posts.length) {
        return <div className="fade-in">
        {props.posts.map((post)=>{

        return  (
          
          
        
            
            <MDBRow className="d-flex justify-content-center" key={post.postId}>
            <MDBCol md="6" lg="4">
              <MDBCard news className="my-5">
              <div class="card-body">
                  <div className="content" >
                    
                    
                    <img
                      src={post.author.profileImg}
                      alt=""
                      className="rounded-circle avatar-img z-depth-1-half"
                      id="post-prof-img"
                      
                    />
                    <span className="ml-1">{post.author.userName}</span>
                  </div>
                </div>
                
                <MDBCardImage
                  top
                  src={post.postImg}
                  alt=""
                />
                
                <MDBCardBody>
                  <div className="social-meta">
                    <div className="post-description">
                    <p >{post.description} </p>
                    </div>
                    <span>
                      <LikeButton likes={post.likes.length} postId={post.postId} postLikes={post.likes}></LikeButton>
                    </span>
                    
                    </div>
                </MDBCardBody>
              </MDBCard>
            </MDBCol>
          </MDBRow>

          
        )})}
        
        </div>
        

    }
   else if(props.isLoading){
    console.log("no data");   
    return (
     
        <div className="d-flex justify-content-center">
            
        <div className="mt-2 ml-2">
        <ReactLoading type={"bars"} color={"grey"} />
        </div>
        </div>
    );
   }
   else {
     return (
      <div className="d-flex justify-content-center">
      <h1>No Posts</h1>
    </div>

     )
   }
};

export default AllPosts;
