import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './LandingPage.scss';


const LandingPage = () => (
  <div className="grid-container">

    <div className="grid_child"><Link to="/Project_Tracker">Project Tracker</Link></div>
    <div className="grid_child"><Link to="/assests">SOW Tracker</Link></div>
    <div className="grid_child grid_skill"><Link to="/skill">Skill Tracker</Link></div>
    <div className="grid_child"><Link to="/pos_track">Demand Tracker</Link></div>
    <div className="grid_child"><Link to="/suply_track">Supply Tracker</Link></div>
    <div className="grid_child"><Link to="/invoice_tracker">Invoice TM</Link></div>
      <div className="grid_child"><Link to="/invoice_fb">Invoice FB</Link></div>
  </div>
);

export default LandingPage;
