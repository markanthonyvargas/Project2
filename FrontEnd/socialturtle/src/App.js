
import './App.css';
import './CSS/posts.css'
import './CSS/profile.css'
import { BrowserRouter, Route } from "react-router-dom";
import Login from './LoginComponents/Login';
import HomePage from './DisplayComponents/HomePage';
import HeaderUser from './DisplayComponents/HeaderUser';
import UserUpdate from './DisplayComponents/UserUpdate';
import UserProfilePic from './DisplayComponents/UserProfilePic';
import UserPosts from './DisplayComponents/UserPosts';
import UserPostsContainer from './ContainerComponents/UserPostsContainer'
import SearchPosts from './ContainerComponents/SearchPostsContainer'; 
import UserListView from './DisplayComponents/UserListView';
import ProfileSearch from './DisplayComponents/ProfileSearch';
import ChangePassword from './DisplayComponents/ChangePassword';
import UserProfile from './DisplayComponents/UserProfile';
import MakeAPostComponent from './DisplayComponents/MakeAPostComponent';
import AllUserContainers from './ContainerComponents/AllUsersContainer'


function App() {
  return (
    
    <BrowserRouter>
    <Route
        exact
        path="/"
        render={() => localStorage.getItem("UserLocal") ? (
          <>
          <HeaderUser/>
          <HomePage />         
         </>
        ) : (
         
     <Login/>
      
    
        )}


        />
      <Route exact path = "/UserUpdate"> 
      <HeaderUser/>
      <UserUpdate/>
      
      </Route>

      <Route exact path = "/ProfilePic"> 
      <HeaderUser/>
      <UserProfilePic/>
      
      </Route>

      <Route exact path = "/MyProfile"> 
      <HeaderUser/>
      <UserProfile></UserProfile>
      <UserPostsContainer></UserPostsContainer>
      
      
      </Route>

      <Route exact path = "/OtherUser">
      <HeaderUser/>
      <AllUserContainers></AllUserContainers>


      </Route>

      <Route exact path = "/UserSearchNotFound">
      <HeaderUser/>
       <UserListView/> 
      </Route>
     
      <Route exact path ="/UpdatePassword">
        <>
          <HeaderUser/>
          <ChangePassword/>
          
          </>
       </Route> 
      
       <Route exact path ="/NewPost">
         <HeaderUser/>
         <MakeAPostComponent/>
       </Route>
      
    </BrowserRouter> 
    
  );
}

export default App;
