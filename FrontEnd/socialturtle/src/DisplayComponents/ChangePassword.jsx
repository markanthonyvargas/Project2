import React, {useState} from 'react'
import {Card, Form, Button} from 'react-bootstrap';
import { useSelector, useDispatch} from 'react-redux';
import { updatePassWord } from '../actions/index';
import emailjs from 'emailjs-com';
import axios from 'axios';
import UpdateUserSuccess from '../Alerts/UpdateUserSuccess'


 function ChangePassword() {

    const id = useSelector(state => state.LocalUser.userId);
    const Username = useSelector(state => state.Username);
    const Paswordo = useSelector(state => state.Password);
    const firstName = useSelector(state => state.FirstName);
    const lastName = useSelector(state => state.LastName);
    const Emailo = useSelector(state => state.Email);
    const [successAlert, setSuccessAlert] = useState(false)

    const dispatch = useDispatch();


    function sendEmail(){

        console.log("Hello")

        emailjs.send("service_gmail","template_4t31iqz",{
            subject: "Password Updated",
            name: "Social turtle network",
            email: "@SocialTurtle Media inc",
            message: "Your password Has been changed. If this was not you, please contact us",
            }, "user_UzaC7wabH7fwCnFUr4lYg")
            .then((result) => {
                console.log(result.text);
            }, (error) => {
                console.log(error.text);
            });
            console.log(id)


         axios.post('http://localhost:9005/Project2/socialmedia/updateUserInfo',{
             userName : Username,
             passWord : Paswordo,
             firstname : firstName,
             lastname : lastName,
             email : Emailo, 
             userId : id
          })
          .then( function(response) {
              console.log(response)
              setSuccessAlert(true)
          })
    }

    return (
        <div className="container fade-in">
        <div className='d-flex justify-content-center' id="password-form">
        <form>
            <Card style={{ width: '25rem' }}>
            <Form.Group controlId="formBasicPassword">
<Form.Label className="mt-1 ml-1"> Update Password</Form.Label>
<Form.Control type="password" placeholder="Password" onChange={(e) => dispatch(updatePassWord(e.target.value))} />
</Form.Group>
<Button onClick={sendEmail}> Change Password</Button>


                </Card>

                

                </form>
                </div>
                <div>
                    {successAlert ? <UpdateUserSuccess></UpdateUserSuccess> : null}
                </div>
                </div>
       
    )
}

export default ChangePassword;
