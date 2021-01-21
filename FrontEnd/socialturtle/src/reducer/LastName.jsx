const LastNameReducer = (state = null , action) =>{
    switch(action.type){
        case "UpdateLastName":
            return action.payload
        default:
            return state;
    }
}

export default LastNameReducer;