import React, { useEffect, useState } from 'react'
import { useSelector, useDispatch} from 'react-redux';
import { GetSpecificUserPosts} from "../actions";

import axios from 'axios';

function SearchPosts() {

    const Search = useSelector(state => state.SearchBar)
    const dispatch = useDispatch();

    //  function SearchClick() {
    //      console.log(Search);
    //      axios.post('http://localhost:9005/Project2/socialmedia/getPostByUsername',{
    //        userName: Search
    //      })
    //      .then((response)=>{
    //        dispatch(GetSpecificUserPosts(response.data))
    //      })
        
    //    }

    useEffect(()=>{
        axios
        .post("http://localhost:9005/Project2/socialmedia/getPostByUsername",{
            userName: Search
        })
        .then((response)=>{
            console.log(response);
            
            dispatch(GetSpecificUserPosts(response.data))
        })
        .catch((err)=>{
            console.error(err);
        })
    },[]);




    return (
        <div>
            
        </div>
    )
}

export default SearchPosts
