import React from 'react';
import { Switch, Route } from 'react-router-dom';
import LoggedUser from './components/LoggedUser/LoggedUser';
import LandingPage from './components/LandingPage/LandingPage';
import Supply_Track from './components/Supply_Track/Supply_tracker';
const Routes = () => (
  <Switch>
    {/* <Route exact path='/' component={LoggedUser}/> */}
    <Route exact path='/' component={LandingPage}/>
    <Route exact path='/landingPage' component={LandingPage}/>
    <Route exact path='/Supply_tracker' component={Supply_Track}/>
  </Switch>
)

export default Routes;
