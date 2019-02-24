import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { connect } from 'react-redux';
import { LoginAction } from './LoginAction';
import './Login.scss';

class Login extends Component {
  constructor() {
    super();
    this.state = {
      psNumber: '',
      errorMsg: ''
    };
    this.enter = (e) => {
      if (e.which === 13) {
        this.login();
      }
    };
    this.login = () => {
      if (this.state.psNumber.length > 0) {
          axios.post('/api/login', {
            id: this.state.psNumber
        })
        .then((response) => {
            if (response.status === 201) {
              const log_data = response.data;
            if(typeof Storage !== 'undefined') {
              this.props.dispatch(LoginAction.username(uname));
              console.log(this.props.uname);
            }
              this.props.onclick(false);
          }
        })
        .catch((error) => {
              this.setState({ errorMsg: 'Invalid PS Number or empty field' });
        });
      } else {
              this.setState({ errorMsg: 'Invalid PS Number or empty field' });
      }
     this.props.onclick(false);
    };
    this.getpsNum = (e) => {
      if (!isNaN(e.target.value)) {
        this.setState({ psNumber: e.target.value });
      }
    };
  }
  render() {
    return (
      <div className="login">
        <input onKeyPress={(e) => this.enter(e)} placeholder="Enter your psn" value={this.state.psNumber} onChange={(e) => this.getpsNum(e)} type="text" className="login_input" name="number" placeholder="Enter PS Number" />
        <button type="button" className="login_submit" onClick={() => this.login()}>Okay</button>
        <span className="login_error">{this.state.errorMsg}</span>
      </div>
    )
  }
}

const mapStateToPrpos = (state) => (
  {
  loginp: state.loginp
  }
);
export default connect(mapStateToPrpos)(Login);
