const LocalUserReducer = (state = JSON.parse(localStorage.getItem('UserLocal')), action) =>{
    switch(action.type){
        case "Trains":
            return action.payload;
        default:
            return state;
    }
}

export default LocalUserReducer;