//action
const username = (uname) =>(
  {
    type:'ADD_LOGIN',
    uname
  }
);

//Reducer
const loginp = (state = { }, action) => {
      switch (action.type) {
        case 'ADD_LOGIN':
          return {state, username: action.uname };
        default :
          return state;
      }
}

//Dispatch
const LoginAction = {
  username
}

export default loginp;
export { LoginAction };
