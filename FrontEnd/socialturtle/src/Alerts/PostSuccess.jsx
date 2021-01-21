import React from 'react';
import { MDBContainer, MDBAlert } from 'mdbreact';
import '../CSS/alerts.css'

const PostSuccess = () => {
    return (
        <div>
             <>
            <MDBContainer id="create-post-success" className="fade-in">
      <MDBAlert color="success" >
        <strong>Post Created!</strong> Navigate to the home or profile page to view it!
      </MDBAlert>
    </MDBContainer>
        </>
        </div>
    );
};

export default PostSuccess;