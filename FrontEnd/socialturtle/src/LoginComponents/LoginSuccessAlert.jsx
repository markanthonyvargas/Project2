import React from 'react';
import { MDBContainer, MDBAlert } from 'mdbreact';

const LoginAlert = () => {
    return (
        <>
            <MDBContainer>
      <MDBAlert color="success">
        <strong>Login Succeeded</strong> Logging in...
      </MDBAlert>
    </MDBContainer>
        </>
    );
};

export default LoginAlert;