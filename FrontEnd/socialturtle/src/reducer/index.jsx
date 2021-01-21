import loggedReducer from './isLogged';
import LikesReducer from './likes';
import UsernameReducer from './UserName';
import PasswordReducer from './Password';
import FirstNameReducer from './FirstName';
import LastNameReducer from './LastName';
import EmailReducer from './Email'
import SearchBarReducer from './SearchBar';
import LocalUserReducer from './LocalUser';
import PostListReducer from './PostList';
import SpecificPostsReducer from './SpecificPosts';
import UserListReducer from './UserList';
import {combineReducers} from 'redux';
import NewPostReducer from './NewPost';

const allReducers = combineReducers({
    isLogged : loggedReducer,
    likes : LikesReducer,
    Username : UsernameReducer,
    Password : PasswordReducer,
    FirstName : FirstNameReducer,
    LastName : LastNameReducer,
    Email : EmailReducer, 
    SearchBar : SearchBarReducer,
    LocalUser : LocalUserReducer,
    PostList : PostListReducer,
    SpecificPosts : SpecificPostsReducer,
    UserList : UserListReducer,
    NewPost : NewPostReducer
})

export default allReducers;