// import React, { Component } from 'react';
// import Table from 'csv-react-table';
// import axios from 'axios';
// import { Link } from 'react-router-dom';
// import './LandingPage.scss';


// const LandingPage = () => (
//   <div className="grid-container">

//     <div className="grid_child"><Link to="/Project_Tracker">Demand Tracker</Link></div>
//   <div className="grid_child"><Link to="/assests">SOW Tracker</Link></div>
//     <div className="grid_child grid_skill"><Link to="/skill">Skill Tracker</Link></div>
//     <div className="grid_child"><Link to="/pos_track">Project Tracker</Link></div>
//     <div className="grid_child"><Link to="/suply_track">Supply Tracker</Link></div>
//     <div className="grid_child"><Link to="/invoice_tracker">Invoice TM</Link></div>
//       <div className="grid_child"><Link to="/invoice_fb">Invoice FB</Link></div> 
//   </div>
// );

// export default LandingPage;
import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import moment from 'moment';
import './Project_Track.scss';
import Addnew from '../Addnew/Addnew';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';
import { Link } from 'react-router-dom';
import MUIDataTable from 'mui-datatables';


class Project_Track extends Component {
  constructor() {
    super();
    this.state = {
      login: false,
      addnew: false,
      alertmsg: 'Edited Project Successfully',
      editedRes: false,
      demandId: '',
      headers: [
        {
          name: 'Demand ID',
          mapKey: 'id',
          //sort: true
        },
        {
          name: 'RFR#',
          mapKey: 'rfr',
        },
     
        {
          name: 'Role',
          mapKey: 'role'
        },
     
        {
          name: 'Demand Onshore',
          mapKey: 'demandOnsite'
        },
        {
          name: 'Demand offshore',
          mapKey: 'demandOffsite'
        },
        {
          name: 'Project Status',
          mapKey: 'status',
         // sort: true
        },
     
      ],
      list: [],
      options: {
        selectableRows: false,
        filterType: 'dropdown',
        rowsPerPageOptions: [1,3,5],
        rowsPerPage:3,
        fixedHeader:false
      }
    };
    this.edited = (params) => {
      console.log(params);
    };
    this.addnew = (param) => {
      if (param) {
        document.body.classList.add('no-scroll');
      } else {
        this.getAllProjects();
        document.body.setAttribute('class', '');
      }
      this.setState({ demandId: null }, () => {
        this.setState({ addnew: param });
      });
    };
    this.alertClick = (flag) => {
      this.setState({ editedRes: flag, addnew: false });
    };
    this.editForm = (e) => {
      console.log(e.target.parentNode.getAttribute('rowno'));
      this.setState({ demandId: e.target.parentNode.getAttribute('rowno') }, () => {
        this.setState({ addnew: true });
      });
    };
    this.resetLogin = (param) => {
      this.setState({ login: param });
    };
    this.closeForm = () => {
      this.getAllProjects();
      this.setState({ addnew: false });
    };
    this.getAllProjects = () => {
      const component = this;
      axios.get('/api/getprojects')
        .then((response) => {
          if (response.status === 200 && response.data.length > 0) {
            const resData = response.data;
            for (let i = 0; i < response.data.length; i += 1) {
              if (response.data[i].milestonedate) {
                resData[i].milestonedate = GenericHelpers.formatDate(response.data[i].milestonedate);
              }
              if (response.data[i].live) {
                resData[i].live = GenericHelpers.formatDate(response.data[i].live);
              }
            }
            component.setState({ list: resData });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    };
  }
  componentDidMount() {
    this.getAllProjects();
  }
  render() {
    return (
      <main className="pt">
        <h1>
        {/* Recent Demands */}
          <button
            className="pt_addnew-btn"
            type="button"
            onClick={() => this.addnew(true)}
          >
            +
          </button>
          {/* <div className="grid_child"><Link to="/supply_tracker">Supply Tracker</Link></div> */}
        </h1>
   
        {/* <Table
          theadStyle="tablehead"
          tbodyStyle="tablebody"
          list={this.state.list}
          headers={this.state.headers}
          doubleclick={this.editForm}
          pageCount={5}
          uniquekey="id"
        /> */}
        <br/><br/><br/><br/>
        <MUIDataTable
          title={"Demand List"}
          data={this.state.list.map(item => {
            return [
                item.id,
                item.rfr,
                item.role,
                item.demandOnsite,
                item.demandOffsite,
                item.status
            ]
          })}
          columns={this.state.headers}
          options={this.state.options}
          
        />


        {
          this.state.addnew &&
          <div>
            <div className="addnew">
              <button type="button" className="addnew_close" onClick={() => this.addnew(false)}>x</button>
              <Addnew projectId={this.state.projectId} onsuccess={this.closeForm} />
            </div>
            <div className="overlay" />
          </div>
        }
        {
          this.state.editedRes &&
          <div>
            <Alert msg={this.state.alertmsg} onclick={this.alertClick} />
            <div className="overlay" />
          </div>
        }
      </main>
    );
  }
}

export default Project_Track;
