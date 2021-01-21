import React, {useState} from 'react'
import {Card, Form, Button} from 'react-bootstrap';
import { useSelector, useDispatch} from 'react-redux';
import { updateUseName, updatePassWord, updateFirstName, updateLastName, updateEmail} from '../actions/index';
import axios from 'axios';
import {Redirect, Link} from 'react-router-dom';
import {NotificationContainer, NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import UpdateUserSuccess from '../Alerts/UpdateUserSuccess'

function UserUpdate() {
  const[alert, setAlert] = useState(false)
  const currentUser = JSON.parse(localStorage.getItem('UserLocal'));

  function UpdateUser(){
    
    setAlert(false)

    console.log(Username, Paswordo, firstName, lastName, Emailo, id);
     axios.post('http://localhost:9005/Project2/socialmedia/updateUserInfo',{
        userName : Username,
        passWord : Paswordo,
        firstname : firstName,
        lastname : lastName,
        email : Emailo, 
        userId : id
      }).then(function (response) 
     {
       console.log(alert)
       setAlert(true)
       localStorage.removeItem("UserLocal")
      if(id)
        currentUser.userId = id
      if(Username)
        currentUser.userName = Username
      if(firstName)
        currentUser.firstname = firstName
      if(lastName)
        currentUser.lastname = lastName
      if(Emailo)
        currentUser.email = Emailo
       localStorage.setItem('UserLocal', JSON.stringify(currentUser))
      
     
       }
     )

  }

    const id = useSelector(state => state.LocalUser.userId);
    const Username = useSelector(state => state.Username);
    const Paswordo = useSelector(state => state.Password);
    const firstName = useSelector(state => state.FirstName);
    const lastName = useSelector(state => state.LastName);
    const Emailo = useSelector(state => state.Email);



    const dispatch = useDispatch();

    
    return (
        <div className="container fade-in">
         
        <div className="d-flex justify-content-center" id="update-user-form">
          
         
        <Form>
            <Card style={{ width: '25rem' }}>
            
<Form.Group controlId="formBasicEmail">
<Form.Label className="mt-1 ml-1"> Update Username</Form.Label>
<Form.Control type="input" placeholder={currentUser.userName} onChange={(e) => dispatch(updateUseName(e.target.value))}  />
<Form.Text className="text-muted">
</Form.Text>
</Form.Group>

{/* <Form.Group controlId="formBasicPassword">
<Form.Label> Update Password</Form.Label>
<Form.Control type="password" placeholder="Password" onChange={(e) => dispatch(updatePassWord(e.target.value))} />
</Form.Group> */}

<Form.Group controlId="formBasicEmail">
    <Form.Label className="mt-1 ml-1">Update Email address</Form.Label>
    <Form.Control type="email" placeholder={currentUser.email} onChange={(e) => dispatch(updateEmail(e.target.value))}  />
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label className="mt-1 ml-1">Update First Name</Form.Label>
    <Form.Control type="input" placeholder={currentUser.firstname} onChange={(e) => dispatch(updateFirstName(e.target.value))}/>
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label className="mt-1 ml-1">Update Last Name</Form.Label>
    <Form.Control type="input" placeholder={currentUser.lastname} onChange={(e) => dispatch(updateLastName(e.target.value))}/>
  </Form.Group>

<Button onClick={UpdateUser}> Update Profile</Button>


        </Card>
        </Form>
        </div>
        <div className="">
          {alert ? <UpdateUserSuccess></UpdateUserSuccess> : null}
        </div>  
        </div>
    )
}

export default UserUpdate;
