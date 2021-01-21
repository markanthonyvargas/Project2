import React from 'react';
import { MDBContainer, MDBAlert } from 'mdbreact';
import '../CSS/alerts.css'

const UpdateUserSuccess = () => {
    return (
        <div >
             <>
            <MDBContainer id="update-user-success" className="fade-in">
      <MDBAlert color="success" >
        <strong>Update Successful!</strong> Your Information has been updated!
      </MDBAlert>
    </MDBContainer>
        </>
        </div>
    );
};

export default UpdateUserSuccess;