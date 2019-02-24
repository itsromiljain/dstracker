import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import moment from 'moment';
import Addnew from '../Addnew/Invoice_new';
import Alert from '../Alert/Alert';
import Login from '../Login/Login';
import GenericHelpers from '../../../Helpers/Generic';


class Invoice extends Component {
  constructor() {
    super();
    this.state = {
      login: false,
      addnew: false,
      alertmsg: 'Edited Project Successfully',
      editedRes: false,
      InvoiceId: '',
      headers: [
             {
               headerName: 'SOW',
               mapKey: 'sow',
             },
             {
               headerName: 'PO',
               mapKey: 'po',
             },
             {
               headerName: 'SOW Status',
               mapKey: 'sowStatus'
             },
             {
               headerName: 'SOW Mode',
               mapKey: 'sowMode'
             },
             {
               headerName: ' Functional Group',
               mapKey: 'funcGrp'
             },
             {
               headerName: 'DSID',
               mapKey: 'dsid'
             },
             {
               headerName: 'EMPLID',
               mapKey: 'empLid'
             },
             {
               headerName: 'Name Of Employee',
               mapKey: 'empName'
             },
             {
               headerName: 'PU',
               mapKey: 'pu'
             },
             {
               headerName: 'MULTI PU PO',
               mapKey: 'multiPurpose'
             },
             {
               headerName: 'Project Id',
               mapKey: 'projId'
             },
             {
               headerName: 'Allocation Start Date',
               mapKey: 'allocStrtDt'
             },
             {
               headerName: 'Allocation End Date',
               mapKey: 'endDt'
             },
             {
               headerName: 'Billability',
               mapKey: 'billAbility'
             },
             {
               headerName: 'Location',
               mapKey: 'location'
             },
             {
               headerName: 'Grade',
               mapKey: 'grade'
             },
             {
               headerName: 'Project Description',
               mapKey: 'projDesc'
             },
             {
               headerName: 'Available Po Value',
               mapKey: 'avlbPoVlu'
             },
             {
               headerName: 'Attn',
               mapKey: 'attn'
             },
             {
               headerName: 'No Of Working Days',
               mapKey: 'wrkgDys'
             },
             {
               headerName: 'Leave Days',
               mapKey: 'leaveDys'
             },
             {
               headerName: 'Swiped Days',
               mapKey: 'swipedDys'
             },
             {
               headerName: 'Swipe Hrs',
               mapKey: 'swipedhrs'
             },
             {
               headerName: 'Difference In Hrs',
               mapKey: 'diffHrs'
             },
             {
               headerName: 'Working Days to be billed',
               mapKey: 'wrkDyBilled'
             },
             {
               headerName: 'Difference in Days ',
               mapKey: 'diffDys'
             },
             {
               headerName: 'Billed Hours',
               mapKey: 'billedHrs'
             },
             {
               headerName: 'Rate',
               mapKey: 'rate'
             },
             {
               headerName: 'BillableAmt',
               mapKey: 'billableAmt'
             },
             {
               headerName: 'Available value after Invoicing',
               mapKey: 'avlblAfterInvoice'
             },
             {
               headerName: 'Invoice',
               mapKey: 'invoiceNo'
             },
            {
               headerName: 'MULTI PU PO',
               mapKey: 'subToAppl'
             },

             {
               headerName: 'Leave Dates',
               mapKey: 'leavDt'
             },
             {
               headerName: 'Comp-Off',
               mapKey: 'compOff'
             },
             {
               headerName: 'UB City Office',
               mapKey: 'ubCityOffc'
             },
             {
               headerName: 'WFH',
               mapKey: 'wfh'
             },

             {
               headerName: 'Temp Badge Date',
               mapKey: 'tempBdgDt'
             },
             {
               headerName: 'Reduced for swipe mismatch',
               mapKey: 'redFrSwipeMismatch'
             },
             {
               headerName: 'Remarks',
               mapKey: 'remarks'
             },
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
        this.getInvoice();
        document.body.setAttribute('class', '');
      }
      this.setState({ InvoiceId: null }, () => {
        this.setState({ addnew: param });
      });
    };
    this.alertClick = (flag) => {
      this.setState({ editedRes: flag ,addnew: false});
    };
    this.editForm = (e) => {
      this.setState({ InvoiceId: e.target.parentNode.getAttribute('rowno') }, () => {
        this.setState({ addnew: true });
      });
    };
    this.resetLogin = (param) => {
      this.setState({ login: param });
    };
    this.closeForm = () => {
      this.getInvoice();
      this.setState({ addnew: false });
    };
    // for getting all data can be use
    this.getInvoice = () => {
      const component = this;
      axios.get('/api/getInvoice_projects')
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
    this.getInvoice();
  }


  render() {
    return (
      <main className="pt">
        <h1>
        Invoice TM List
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
          uniquekey="sow"
        />
        {
          this.state.addnew &&
          <div>
            <div className="addnew">
              <button type="button" className="addnew_close" onClick={() => this.addnew(false)}>x</button>
              <Addnew InvoiceId={this.state.InvoiceId} />
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

export default Invoice;
