import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Project_Track from './components/Project_Tracker/Project_Track';
import LoggedUser from './components/LoggedUser/LoggedUser';
import Assests from './components/Assests/Assests';
import Skill from './components/Skill/Skill';
import LandingPage from './components/LandingPage/LandingPage';
import POS_Track from './components/POS_Track/POS_Track';
import Invoice_Tracker from './components/Invoice_Tracker/Invoice';
import Invoice_Fb from './components/Invoice_Fb/Invoice_Fb';

const Routes = () => (
  <Switch>
    <Route exact path='/' component={LoggedUser}/>
    <Route exact path='/landingPage' component={LandingPage}/>
    <Route exact path='/project_tracker' component={Project_Track}/>
    <Route exact path='/assests' component={Assests}/>
    <Route exact path='/skill' component={Skill}/>
    <Route exact path='/pos_track' component={POS_Track}/>
    <Route exact path='/invoice_tracker' component={Invoice_Tracker}/>
    <Route exact path='/invoice_fb' component={Invoice_Fb}/>
  </Switch>
)

export default Routes;
