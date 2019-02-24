import React from 'react';
import PropTypes from 'prop-types';
import './Alert.scss';

const Alert = (props) => {
  const clickbtn = (params) => {
    props.onclick(params)
  };
  return (
    <div className="alertbox">
      <h3>Message</h3>
      <span>{props.msg}</span>
      <button type="button" onClick={() => clickbtn(false)}>Okay</button>
    </div>
  );
};
Alert.propTypes = {
  msg: PropTypes.string,
  onclick: PropTypes.func
};

export default Alert;
