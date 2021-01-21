const EmailReducer = (state = null, action) =>{
    switch(action.type){
        case "UpdateEmail":
            return action.payload
        default:
            return state;
    }
}

export default EmailReducer;