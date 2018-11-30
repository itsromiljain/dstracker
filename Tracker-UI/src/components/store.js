import { createStore, applyMiddleware, combineReducers } from 'redux';
import ReduxThunk from 'redux-thunk'
import thunk from 'redux-thunk';
import loginp from './Login/LoginAction';

const rootReducer = combineReducers ({
  loginp
});

const store = createStore(rootReducer, applyMiddleware(thunk));

export default store;
