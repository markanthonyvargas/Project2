const NewPostReducer = (state = null, action) =>{
    switch(action.type){
        case "NewPostInput":
            return action.payload
        default:
            return state;
    }
}

export default NewPostReducer;