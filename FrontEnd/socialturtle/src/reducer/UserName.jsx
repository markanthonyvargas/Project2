const UsernameReducer = (state = null, action) =>{
    switch(action.type){
        case "UPDATEUSENAME":
            return action.payload;
        default:
            return state;
    }
}

export default UsernameReducer;