import React, {useState, useRef, useEffect} from 'react'
import {Card, Form, Button} from 'react-bootstrap';
import { useSpring, useTransition, config, animated } from "react-spring";


import { useHeight } from "./useHeight";
import axios from 'axios';
import '../CSS/login.css'
import LoginAlert from './LoginFailedAlert';
import LoginSuccessAlert from './LoginSuccessAlert'

function Login() {
  
    const [validated, setValidated] = useState(false);
    const [showLogin, setLoginState] = useState(true);

    const [username, setUsername] = useState('');

    const [password, setPassword] = useState('');

    const [failedLogin, setFailedLogin] = useState(false);
    const[successLogin, setSuccessLogin] = useState(false);

    const [email, setEmail] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [showA, setShowA] = useState(false);
    const [showB, setShowB] = useState(false);
    const [list, setList] = useState([]);
    const[showLoginButton, setLoginButton] = useState(true);
    const[changeButtonText, setButtonText] = useState("register");
    
    const newItemRef = useRef(null);
  
    const fadeStyles = useSpring({
      config: { ...config.stiff },
      from: { opacity: 0 },
      to: {
        opacity: showA ? 1 : 0
      }
    });
  
    const [heightRef, height] = useHeight();
    const slideInStyles = useSpring({
      config: { ...config.stiff },
      from: { opacity: 0, height: 0 },
      to: {
        opacity: showB ? 1 : 0,
        height: showB ? height : 0
      }
    });

  
    const listTransitions = useTransition(list, {
      config: config.gentle,
      from: { opacity: 0, transform: "translate3d(-25%, 0px, 0px)" },
      enter: { opacity: 1, transform: "translate3d(0%, 0px, 0px)" },
      leave: { opacity: 0, height: 0, transform: "translate3d(25%, 0px, 0px)" },
      keys: list.map((item, index) => index)
    });
    

    function handleUsername(e) {
            setUsername(e.target.value);
            // console.log(username)
    }

    function handlePword(e) {
        setPassword(e.target.value);
        
        // console.log(password)
    }

    function handleSubmit(e){
        e.preventDefault() // stops default reloading behaviour
          console.log(password, username);
          console.log(validated)
          setValidated(true);
          console.log(validated)

        
          if(username && password) {
              axios.post('http://localhost:9005/Project2/socialmedia/login',{
                userName: username,
                passWord: password
              })
              /// We have it in local storage now -Andrew
              .then(function (response) {
                console.log(response.data);
                console.log("response: ",response)
                const User = response.data
                
                if(User === ""){
                    //alert("Login Failed. Check Credentials")
                    setFailedLogin(true)
                }else{
                  setFailedLogin(false)
                  setSuccessLogin(true)
                localStorage.setItem("UserLocal",JSON.stringify(User))
                console.log(localStorage.getItem("UserLocal"));
                window.location.reload();
                }
              })
            }

            

             
          //function our check users 
          //if data= null then bad bad 
          //if data = filled with stuff render the site components and route login 

      }

      function showRegister() {
        setLoginState(false) 
        setShowB(val => !val)
        

    }
    function ReturnLogin() {
      console.log(failedLogin)
        setLoginState(true) 
        console.log(failedLogin)
        
    }


    //4 Inputs Register OF DEATH
    function handleEmail(e){
        setEmail(e.target.value);
    }

    function handleFName(e){
        setFirstName(e.target.value);
    }
    
    function handleLName(e){
        setLastName(e.target.value);
    }

    function InsertNewUser(e){
        e.preventDefault()
        setFailedLogin(false)
        console.log(password, username, email, firstName, lastName);

        if(username && password && email && firstName && lastName) {
        axios.post('http://localhost:9005/Project2/socialmedia/insertNewUser',{
            "firstname": firstName,
            "passWord": password,
            "email": email,
            "lastname": lastName,
            "userName": username

              }).then(function (response) {
                console.log("response.dat: ",response.data);
               
                let User = response.data;
                console.log(User);
                console.log(response.config.data)
                localStorage.setItem("UserLocal",JSON.stringify(User))
                console.log(localStorage.getItem("UserLocal"));
                window.location.reload();
              
              })



        ReturnLogin();
            }
    }

    function failedLoginHtml() {
      return (
        <h1>Login Failed</h1>
      )
    }
     
     // if(showLogin){
    return (
        <div className='d-flex justify-content-center' id="login-form">
          <div>
          
            <Form noValidate validated={validated}>
                <Card style={{ width: '25rem' }}>
      
  <Form.Group controlId="formBasicEmail">
  {failedLogin ? <LoginAlert></LoginAlert> : null}
  {successLogin? <LoginSuccessAlert></LoginSuccessAlert> : null}
    <Form.Label>Username</Form.Label>
    <Form.Control type="input" placeholder="Enter Username" value= {username} onChange={handleUsername} required/>
    <Form.Text className="text-muted">
      We Sell your email for profit
    </Form.Text>
  </Form.Group>

  <Form.Group controlId="formBasicPassword">
    <Form.Label>Password</Form.Label>
    <Form.Control type="password" placeholder="Password" value = {password} onChange={handlePword} required/>
  </Form.Group>
  {changeButtonText == "register" ? (<Button variant="primary" type="submit" onClick={handleSubmit}>
    Submit
  </Button>) : (<div></div>) }


  

  <animated.div style={{ ...slideInStyles, overflow: "hidden" }}>
          <div ref={heightRef}>
          <Form.Group controlId="formBasicEmail">
    <Form.Label>Email address</Form.Label>
    <Form.Control type="email" placeholder="Enter email" value = {email} onChange={handleEmail} required/>
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>Enter First Name</Form.Label>
    <Form.Control type="input" placeholder="First Name here" value = {firstName} onChange={handleFName} required/>
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>Enter Last Name</Form.Label>
    <Form.Control type="input" placeholder="Password here" value = {lastName} onChange={handleLName} required/>
  </Form.Group>
  <Button className="btn-block" variant="warning" type="submit" onClick={InsertNewUser} >
    Join if you Dare!
  </Button>
   
  </div>
  </animated.div>

  <Button variant = "success" onClick={() => {setShowB(val => !val); if(changeButtonText == "register") {setButtonText("login")} else {setButtonText("register");} console.log(changeButtonText)}}>
    {changeButtonText === "register" ? (<div>New User? Register here (click me bitch) </div>) : (<div>(Already Registered? Login)</div>)}
      
  </Button>
  </Card>
</Form>


        </div>
        
        </div>
    )
}


export default Login;