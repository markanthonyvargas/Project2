import React, { useEffect, useState } from "react";
import axios from "axios";
import { useSelector, useDispatch} from 'react-redux';
import { GetAllUsers } from "../actions";
import ProfileSearch from "../DisplayComponents/ProfileSearch";



function AllUsersContainer() {
    const[users, setUsers] = useState([])
    const dispatch = useDispatch();

 useEffect(()=>{
        axios
        .get("http://localhost:9005/Project2/socialmedia/getAllUsers")
        .then((response)=>{
            console.log(response);
            let jSONArray = [];
            response.data.map(dataVal => {
                jSONArray.push(dataVal.userName)
            })
            dispatch(GetAllUsers(response.data))
            setUsers(response.data)
        })
        .catch((err)=>{
            console.error(err);
        })
    },[]);
  

    return (
        <ProfileSearch users={users}></ProfileSearch>
    )
}

export default AllUsersContainer;