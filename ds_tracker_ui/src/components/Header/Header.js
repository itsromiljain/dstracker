import React from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import './Header.scss';


const Header = (props) => (
  <header className="header">
    <div className="header_logo">
      <Link to="/">PROJECT TRACKER</Link>
      { console.log(props) }
    </div>
    <div className="nav"> Welcome to {props.userName}</div>
  </header>
);

const mapStateToPrpos = (state) => (
  {
    userName:state.loginp.userName ? state.loginp.userName : 'user'
  }
);

export default connect (mapStateToPrpos)(Header);
