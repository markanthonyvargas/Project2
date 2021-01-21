import React, {useState, useRef} from 'react';
import { useSelector, useDispatch} from 'react-redux';
import {  MDBRow,  MDBCard, MDBCardBody, MDBIcon, MDBCol, MDBCardTitle, MDBBtn} from "mdbreact";
import { useSpring, useTransition, config, animated } from "react-spring";
import ReactLoading from 'react-loading'


import { useHeight } from "../LoginComponents/useHeight";
import UserPostsContainer from '../ContainerComponents/UserPostsContainer';

const ProfileSearch = (props) => {
    const search = useSelector(state => state.SearchBar);
    //const props.users = props.users;
    const allPosts = useSelector(state => state.PostList);
    let specificPosts = [];
    let matchedUser = {};
    const [showA, setShowA] = useState(false);
    const [showB, setShowB] = useState(false);
    const [list, setList] = useState([]);

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

    function showPosts() {
        setShowB(val => !val)
    };


    console.log("all users: ", props.users.length)
    if(props.users && props.users.length) {
      for(let i=0; i<props.users.length; i++) {
        console.log(props.users[i].userName);
        console.log(search)
        if(props.users[i].userName === search) {
        matchedUser = props.users[i];
        // eslint-disable-next-line no-loop-func
        allPosts.forEach(element => {
            if(element.author.userName === matchedUser.userName) {
                specificPosts.push(element);
            }
        });
        return (
            <div className="fade-in">
     
               <MDBCard
          className='card-image' id='profile-background'
          style={{
            backgroundImage:
              "url('https://i.redd.it/kbhxfkobabf11.png')",
            objectFit: "cover"
          }}
        >
          <div className='text-white text-center d-flex justify-content-center rgba-black-strong py-5 px-4'>
            <div>
              <h5 id="profile-header">
              <MDBIcon icon="user" /> {props.users[i].userName}
              </h5>
              <MDBCardTitle tag='h3' className='pt-2'>
                <strong>{props.users[i].firstname} {props.users[i].lastname}</strong>
              </MDBCardTitle>
              <p>
                
              </p>
              <MDBBtn id="show-posts-btn" onClick={showPosts}>
                <MDBIcon icon='clone left'/> Show Posts
              </MDBBtn>
            </div>
          </div>
          
        </MDBCard>
        
        <div>
        <animated.div style={{ ...slideInStyles, overflow: "hidden" }}>
        <div ref={heightRef}>
          <UserPostsContainer userName={props.users[i].userName}/>
        </div>

        </animated.div>
        </div>
        
        </div>
        );
        }
        
    }
  }
  if(props.users.length == 0) { return (
      <div className="d-flex justify-content-center">
        <div className="mt-2 ml-2">
          <ReactLoading type={"bars"} color={"grey"} />
        </div>
      </div>
    );
  }
  else {
    return (
      <div className="d-flex justify-content-center">
        <h1>No Results for "{search}"</h1>
      </div>
    )
  }
};

export default ProfileSearch;