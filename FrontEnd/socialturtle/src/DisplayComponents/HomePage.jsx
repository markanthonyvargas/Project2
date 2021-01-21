import React from 'react'
import {Card, Form, Button} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';
import AllPostsContainer from '../ContainerComponents/AllPostsContainer'
import AllUserContainers from '../ContainerComponents/AllUsersContainer'
import { useSelector, useDispatch} from 'react-redux';
import TestModal from './TestModal'


 function HomePage() {

       
    


    return (
        
            
        <>
        
        <AllPostsContainer></AllPostsContainer>
      
        </>
        
     
    )
}

export default HomePage;