const FirstNameReducer = (state = null, action) =>{
    switch(action.type){
        case "UpdateFirstName":
            return action.payload
        default:
            return state;
    }
}

export default FirstNameReducer;