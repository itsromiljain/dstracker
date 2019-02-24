import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import moment from 'moment';
import Addnew from '../Addnew/Pos_new';
import Alert from '../Alert/Alert';
import Login from '../Login/Login';
import GenericHelpers from '../../../Helpers/Generic';


class POS_Track extends Component {
  constructor() {
    super();
    this.state = {
      login: false,
      addnew: false,
      alertmsg: 'Edited Project Successfully',
      editedRes: false,
      skillId: '',
      headers: [
        {
          headerName: 'PS No',
          mapKey: 'psno',
        },
        {
          headerName: 'Name',
          mapKey: 'name'
        },
        {
          headerName: 'SkillS',
          mapKey: 'skillsmry'
        },
    /*    {
          headerName: 'ODC',
          mapKey: 'odc'
        }, */
        {
          headerName: ' BuName',
          mapKey: 'buname'
        },
        {
          headerName: 'OFFShore / ONShore',
          mapKey: 'Off_onshore'
        },
        {
          headerName: 'Internal / Etrnal',
          mapKey: 'intext'
        },
        {
          headerName: 'Status',
          mapKey: 'primary_skill'
        },
        {
          headerName: 'Secondary Skill',
          mapKey: 'secondary_skill'
        },
        {
          headerName: 'Location',
          mapKey: 'location'
        },
        {
          headerName: 'Buname',
          mapKey: 'buname'
        },
        {
          headerName: 'Delivery Manager',
          mapKey: 'delivery_manag'
        },
        {
          headerName: 'Training Attended',
          mapKey: 'training_attended'
        }
      /*  {
          headerName: 'Demand Id',
          mapKey: 'demandId'
        },
        {
          headerName: 'CV',
          mapKey: 'cv'
        } */
      ],
      list: []
    };
    this.edited = (params) => {
      console.log(params);
    };
    this.addnew = (param) => {
      const component = this;
      if (param) {
        document.body.classList.add('no-scroll');
      } else {
        this.getSkill();
        document.body.setAttribute('class', '');
      }
      this.setState({ skillId: null }, () => {
        this.setState({ addnew: param });
      });
    };
    this.alertClick = (flag) => {
      this.setState({ editedRes: flag ,addnew: false});
    };
    this.editForm = (e) => {
      this.setState({ skillId: e.target.parentNode.getAttribute('rowno') }, () => {
        this.setState({ addnew: true });
      });
    };
    this.resetLogin = (param) => {
      this.setState({ login: param });
    };
    this.closeForm = () => {
      this.getSkill();
      this.setState({ addnew: false });
    };
    this.getSkill = () => {
      const component = this;
      axios.get('/api/getskill_projects')
        .then((response) => {
          //console.log(response);
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
    this.getSkill();
  }


  render() {
    return (
      <main className="pt">
        <h1>
        Supply Tracker List
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
          uniquekey="psno"
        />
        {
          this.state.addnew &&
          <div>
            <div className="addnew">
              <button type="button" className="addnew_close" onClick={() => this.addnew(false)}>x</button>
              <Addnew skillId={this.state.skillId} />
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

export default POS_Track;
