const PostListReducer = (state = null, action) =>{
    switch(action.type){
        case "GetAllPosts":
            return action.payload
        default:
            return state;
    }
}

export default PostListReducer;