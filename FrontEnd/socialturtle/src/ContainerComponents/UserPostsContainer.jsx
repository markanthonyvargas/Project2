import axios from "axios";
import React, { useEffect, useState } from "react";
import AllPosts from "../DisplayComponents/AllPosts";

const UserPostsContainer = (props) => {
    console.log("props username: ",props.userName)
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true)

    const currentUser = JSON.parse(localStorage.getItem('UserLocal'));
    const propUserName = props.userName;
    let username = props.userName ? propUserName : currentUser.userName;

    useEffect(()=>{
        axios
        .post("http://localhost:9005/Project2/socialmedia/getPostByUsername",{
            //user: localStorage.getItem(currentUser)
            "userName": username
          })
        .then((response)=>{
            console.log(response);
            setPosts(response.data);
            setLoading(false)
        })
        .catch((err)=>{
            console.error(err);
        })
    },[]);


    return (
        <div>
            <AllPosts posts={posts} isLoading={loading}></AllPosts>
        </div>
    );
};

export default UserPostsContainer;