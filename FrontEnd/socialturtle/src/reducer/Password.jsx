const PasswordReducer = (state = null, action) =>{
    switch(action.type){
        case "UPDATEPWORD":
            return action.payload
        default:
            return state;
    }
}

export default PasswordReducer;