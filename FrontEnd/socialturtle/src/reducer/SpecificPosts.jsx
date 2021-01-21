const SpecificPostsReducer = (state = null, action) =>{
    switch(action.type){
        case "GetSpecificPosts":
            return action.payload;
        default:
            return state;
    }
}

export default SpecificPostsReducer;