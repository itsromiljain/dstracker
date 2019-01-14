import React, { Component } from 'react';
import LandingPage from '../LandingPage/LandingPage';
import Login from '../Login/Login';
import { browserHistory } from 'react-router';


class LoggedUser extends Component {
  constructor() {
    super();
    this.state = {
        login: true
    };

    this.resetLogin = (param) => {
      this.setState({ login: param });
    };

  }
  componentDidMount() {
    //this.getAllProjects();
  }
  render() {
    return (
      <main className="pt">

        {this.state.login ? <h1>
        User Details
          <div>
            <Login onclick={this.resetLogin} />
            <div className="overlay" />
          </div>
      </h1> : <LandingPage />
    }
      </main>
    );
  }
}

export default LoggedUser;
