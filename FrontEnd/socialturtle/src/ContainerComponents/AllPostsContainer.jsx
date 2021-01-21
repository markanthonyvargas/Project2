import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector, useDispatch} from 'react-redux';
import { GetAllPosts } from "../actions";
import AllPosts from "../DisplayComponents/AllPosts";
import PostListReducer from "../reducer/PostList";




const AllPostsContainer = () => {

    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true)

    const dispatch = useDispatch();

    const useSelector = (state => state.PostList);

    useEffect(()=>{
        axios
        .get("http://localhost:9005/Project2/socialmedia/getPosts")
        .then((response)=>{
            console.log(response);
            setPosts(response.data);
            dispatch(GetAllPosts(response.data))
            setLoading(false)
        })
        .catch((err)=>{
            console.error(err);
        })
    },[]);


    return (
        <AllPosts posts={posts} isLoading={loading}></AllPosts> 
      
    );
};

export default AllPostsContainer;