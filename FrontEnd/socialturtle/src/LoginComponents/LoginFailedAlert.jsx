import React from 'react';
import { MDBContainer, MDBAlert } from 'mdbreact';

const LoginAlert = () => {
    return (
        <>
            <MDBContainer>
      <MDBAlert color="danger">
        <strong>Login Failed!</strong> Check your credentials.
      </MDBAlert>
    </MDBContainer>
        </>
    );
};

export default LoginAlert;