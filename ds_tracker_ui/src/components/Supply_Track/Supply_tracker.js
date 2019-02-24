import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import moment from 'moment';
import './Supply_Track.scss';
import AddnewSupply from '../Addnew/AddnewSupply';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';
import MUIDataTable from 'mui-datatables';


class Supply_tracker extends Component {
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
          name: "Supply ID",
          mapKey: 'id',
         // sort: true
        },
        {
          name: "Supply Name",
          mapKey: 'supplyname',
        },
        {
          name: "Demand Id",
          mapKey: 'demandid'
        },
        {
          name: "RR",
          mapKey: 'rrnumber'
        },

        {
          name: "Sf Id",
          mapKey: 'sfid',
        },
        {
          name: "Skill",
          mapKey: 'skill'
        }, 
        {
          name: "Year Of Experience",
          mapKey: 'yrofexp'
        },  
        {
          name: "Demand Status",
          mapKey: 'status'
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
        this.getAllsupply();
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
      this.setState({ demandId: e.target.parentNode.getAttribute('rowno') }, () => {
        this.setState({ addnew: false });
      });
    };
    this.resetLogin = (param) => {
      this.setState({ login: param });
    };
    this.closeForm = () => {
      this.getAllsupply();
      this.setState({ addnew: false });
    };
    this.getAllsupply = () => {
      const component = this;
      axios.get('/api/getAllsupply')
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
    this.getAllsupply();
  }
  render() {
    return (
      <main className="pt">
        <h1>
        {/* Recent Supplies */}
          <button
            className="pt_addnew-btn"
            type="button"
            onClick={() => this.addnew(true)}
          >
            +
          </button>
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
          title={"Supply List"}
          data={this.state.list.map(item => {
            return [
                item.id,
                item.supplyname,
                item.demandid,
                item.rrnumber,
                item.sfid,
                item.skill,
                item.yrofexp,
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
              <AddnewSupply projectId={this.state.projectId} onsuccess={this.closeForm} />
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

export default Supply_tracker;
