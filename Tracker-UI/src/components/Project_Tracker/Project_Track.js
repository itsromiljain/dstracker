import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import moment from 'moment';
import './Project_Track.scss';
import Addnew from '../Addnew/Addnew';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';


class Project_Track extends Component {
  constructor() {
    super();
    this.state = {
      login: false,
      addnew: false,
      alertmsg: 'Edited Project Successfully',
      editedRes: false,
      projectId: '',
      headers: [
        {
          headerName: 'Portfolio',
          mapKey: 'portfolio',
          sort: true
        },
        {
          headerName: 'Project',
          mapKey: 'project',
        },
        {
          headerName: 'Induction Kit',
          mapKey: 'induction'
        },
        {
          headerName: 'Description',
          mapKey: 'desc'
        },
        {
          headerName: 'Project Go-Live/Final Delivery',
          mapKey: 'live'
        },
        {
          headerName: 'Project Status',
          mapKey: 'status',
          sort: true
        },
        {
          headerName: 'Next Milestone',
          mapKey: 'milestone'
        },
        {
          headerName: 'Next Milestone Due Date',
          mapKey: 'milestonedate'
        },
        {
          headerName: 'IMT',
          mapKey: 'imtName',
          sort:true
        },
        {
          headerName: 'Apple Manager',
          mapKey: 'applemanager',
          sort: true
        },
        {
          headerName: 'Delivery Manager',
          mapKey: 'dmName',
         sort: true
        },
        {
          headerName: 'LTI Managed',
          mapKey: 'ltimanaged',
          sort: true
        },
        {
          headerName: 'LTI Onsite Lead',
          mapKey: 'ltionsitelead'
        },
        {
          headerName: 'Offshore Lead',
          mapKey: 'offshorelead'
        },
        {
          headerName: 'Overall Size',
          mapKey: 'overallsize'
        },
        {
          headerName: 'LTI Onsite Team Size',
          mapKey: 'ltionsitesize'
        },
        {
          headerName: 'LTI offshore Team Size',
          mapKey: 'ltioffshoresize'
        },
        {
          headerName: 'Other Vendors Involved',
          mapKey: 'othervendors'
        },
        {
          headerName: 'Shift Time',
          mapKey: 'shifttime'
        },
        {
          headerName: 'Client Appreciation',
          mapKey: 'appreciation'
        },
        {
          headerName: 'Potential Issues / Escalations',
          mapKey: 'issues'
        },
        {
          headerName: 'Mitigation',
          mapKey: 'mitigation'
        },
        {
          headerName: 'Status of Issue Mitigation',
          mapKey: 'issuemitigation'
        },
        {
          headerName: 'Remarks',
          mapKey: 'remarks'
        },
        {
          headerName: 'Weekly Status shared with Client',
          mapKey: 'weeklystatus'
        }
      ],
      list: []
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
      this.setState({ projectId: null }, () => {
        this.setState({ addnew: param });
      });
    };
    this.alertClick = (flag) => {
      this.setState({ editedRes: flag, addnew: false });
    };
    this.editForm = (e) => {
      this.setState({ projectId: e.target.parentNode.getAttribute('rowno') }, () => {
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
        Project Tracker List
          <button
            className="pt_addnew-btn"
            type="button"
            onClick={() => this.addnew(true)}
          >
            +
          </button>
        </h1>
        <Table
          theadStyle="tablehead"
          tbodyStyle="tablebody"
          list={this.state.list}
          headers={this.state.headers}
          doubleclick={this.editForm}
          uniquekey="id"
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
