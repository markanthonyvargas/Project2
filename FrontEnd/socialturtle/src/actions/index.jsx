export const updateUseName = (val) =>{
    return {
        type: 'UPDATEUSENAME', 
        payload : val
    }
} 

export const updatePassWord = (val) =>{
    return{
        type: 'UPDATEPWORD',
        payload : val
    }
}

export const updateFirstName = (val) =>{
    return{
        type : 'UpdateFirstName',
        payload : val
    }
}

export const updateLastName = (val) =>{
    return{
        type : "UpdateLastName",
        payload : val
    }
}

export const updateEmail = (val) =>{
    return{
        type : "UpdateEmail",
        payload : val
    }
}

export const SearchBar = (val) =>{
    return{
        type : "SEARCH",
        payload : val
    }
}

export const GetAllPosts = (val) =>{
    return{
        type : "GetAllPosts",
        payload : val
    }
}

/// Finding a specific user based on their posts
export const GetSpecificUserPosts = (val) =>{
    return{
        type : "GetSpecificPosts",
        payload : val
    }
}

export const GetAllUsers = (val) =>{
    return{
        type : "GetAllUsers",
        payload : val
    }
   
    
}

export const NewPostInputs = (val) =>{
    return{
        type : "NewPostInput",
        payload : val
    }
}