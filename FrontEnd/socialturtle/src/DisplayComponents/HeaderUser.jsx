import React from 'react'
import {Navbar, Nav, NavDropdown, Form, Button, FormControl} from 'react-bootstrap'
import {Redirect, Link} from 'react-router-dom';
import { useSelector, useDispatch} from 'react-redux';
import { SearchBar} from '../actions/index';
import axios from "axios";
import { GetSpecificUserPosts } from '../actions';
import { useHistory } from 'react-router-dom';
import MakeAPostComponent from './MakeAPostComponent';
import SelectableContext from "react-bootstrap/SelectableContext";



function HeaderUser() {

  function OurLogout(){
    localStorage.clear('UserLocal');
    if(window.location.href!=="http://localhost:3000/"){
         <Redirect  to="/" />
         console.log("hi")
    }else{
       
    window.location.reload();
    }
}

const dispatch = useDispatch();
const currentUser = JSON.parse(localStorage.getItem('UserLocal'));
const Search = useSelector(state => state.SearchBar)
const nameUsers = useSelector(state => state.UserList)
const history = useHistory()

function SearchClick() {
  console.log(Search);
  axios.post('http://localhost:9005/Project2/socialmedia/getPostByUsername',{
    userName: Search
  })
  .then((response)=>{
    dispatch(GetSpecificUserPosts(response.data))
  })
  
}

function RedirectToProfilePage(e) {
      e.preventDefault()
      console.log(e)
      console.log(e.target.form[0].value)
      dispatch(SearchBar(e.target.form[0].value))
      console.log("Hello");
      history.push("/OtherUser")
      
      
    
    // else{
    //   history.push("/UserSearchNotFound")
    // }

  


  

  

}

function handleDropdown(e) {
  e.stopPropogation();
}


    return (    
      <div className="">
        <Navbar bg="dark" expand="lg" >
  <Navbar.Brand id ="NavbarLinks">Social Turtle</Navbar.Brand>
  <Navbar.Toggle aria-controls="basic-navbar-nav" />
  <Navbar.Collapse id="basic-navbar-nav" className="">
  
    <Nav className="mr-auto">
    <Nav.Link as={Link} to="/" id ="NavbarLinks">Home </Nav.Link> 
    
      <NavDropdown title={currentUser.userName} id="basic-nav-dropdown" >
       <Nav.Link as={Link} to="/UserUpdate" id ="dropdown">Update User info </Nav.Link>
       <Nav.Link as={Link} to="/UpdatePassword" id ="dropdown"> Change Password </Nav.Link>
       <Nav.Link as={Link} to="/MyProfile" id ="dropdown">My Profile </Nav.Link>
        <NavDropdown.Divider />
        <MakeAPostComponent></MakeAPostComponent>
      </NavDropdown>
    
    </Nav>
    

 
    <Form inline className="mr-auto">
      <FormControl type="text" placeholder="Search" className="mr-sm-2" />
      <Button type="submit" variant="outline-success" className="no-button-margin" id="navbar-search-button" onClick={RedirectToProfilePage}
      >Search</Button>
      
      
        
        

    </Form>


 
    <Button variant='outline-danger' onClick={OurLogout} className="no-button-margin" id="navbar-logout">
          <a className="text-danger nounderline" href="/">
            Logout
            </a>
        </Button>

    </Navbar.Collapse>
</Navbar>
</div>
    )
}

export default HeaderUser;