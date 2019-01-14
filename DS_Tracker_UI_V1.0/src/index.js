import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom'
import '../common/common.scss';
import Header from './components/Header/Header';
import { Provider } from 'react-redux';
import store from './components/store';
import Routes from './routes.js';
import SideDrawer from './components/dashboard/SideDrawer';

const App = () => (
  <div>
    <SideDrawer />
    <Routes />
  </div>
);

ReactDOM.render(
  <Provider store = {store}>
  <BrowserRouter>
    <App />
  </BrowserRouter>
  </Provider>,
  document.getElementById('root'));
