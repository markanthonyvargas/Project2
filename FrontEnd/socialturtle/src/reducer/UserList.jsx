const UserListReducer = (state = null, action) =>{
    switch(action.type){
        case "GetAllUsers":
            return action.payload
        default:
            return state;
    }
}

export default UserListReducer;