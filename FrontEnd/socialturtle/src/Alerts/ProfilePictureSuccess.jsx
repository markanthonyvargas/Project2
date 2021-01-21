import React from 'react';
import { MDBContainer, MDBAlert } from 'mdbreact';
import '../CSS/alerts.css'

const ProfilePictureSuccess = () => {
    return (
        <div >
        <>
       <MDBContainer id="update-user-success" className="fade-in">
 <MDBAlert color="success" >
   <strong>Picture Uploaded!</strong>
 </MDBAlert>
</MDBContainer>
   </>
   </div>
    );
};

export default ProfilePictureSuccess;