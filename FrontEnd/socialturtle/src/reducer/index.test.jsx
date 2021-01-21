import allReducers from './index';

test('reducers', () => {
  let state;
  state = allReducers(undefined, {});
  expect(state).toEqual({isLogged:false,likes:0,Username:null,Password:null,FirstName:null,LastName:null,Email:null,SearchBar:'',LocalUser:null,PostList:null,SpecificPosts:null,UserList:null,NewPost:null});
});