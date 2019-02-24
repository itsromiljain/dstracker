import React, { Component } from 'react';
import Table from 'csv-react-table';
import axios from 'axios';
import moment from 'moment';
import Addnew from '../Addnew/Invoice_Fix';
import Alert from '../Alert/Alert';
import Login from '../Login/Login';
import GenericHelpers from '../../../Helpers/Generic';


class Invoice_Fb extends Component {
  constructor() {
    super();
    this.state = {
      login: false,
      addnew: false,
      alertmsg: 'Edited Project Successfully',
      editedRes: false,
      InvoFb: '',
      headers: [
             {
               headerName: 'Form No',
               mapKey: 'formNo',
             },
             {
               headerName: 'AMT',
               mapKey: 'amt'
             },
             {
               headerName: ' Functional Group',
               mapKey: 'funcGrp'
             },
             {
               headerName: 'PO No',
               mapKey: 'poNo',
             },
             {
               headerName: 'PO Title',
               mapKey: 'poTitle'
             },

             {
               headerName: ' PO Value ',
               mapKey: 'poVlu'
             },
             {
               headerName: 'PO Start Date',
               mapKey: 'poStrtDt'
             },
             {
               headerName: 'PO End Date',
               mapKey: 'poEndDt'
             },
             {
               headerName: 'Business contact  Name',
               mapKey: 'buCntctNm'
             },
             {
               headerName: 'Milestone',
               mapKey: 'milestone'
             },
             {
               headerName: 'Invoice',
               mapKey: 'invoiceNo'
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
        this.getFb();
        document.body.setAttribute('class', '');
      }
      this.setState({ InvoFb: null }, () => {
        this.setState({ addnew: param });
      });
    };
    this.alertClick = (flag) => {
      this.setState({ editedRes: flag ,addnew: false});
    };
    this.editForm = (e) => {
      this.setState({ InvoFb: e.target.parentNode.getAttribute('rowno') }, () => {
        this.setState({ addnew: true });
      });
    };
    this.resetLogin = (param) => {
      this.setState({ login: param });
    };
    this.closeForm = () => {
      this.getFb();
      this.setState({ addnew: false });
    };
    // for getting all data can be use
    this.getFb = () => {
      const component = this;
      axios.get('/api/getInvoice_fb')
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
    this.getFb();
  }


  render() {
    return (
      <main className="pt">
        <h1>
        Invoice FB List
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
          uniquekey="poNo"
        />
        {
          this.state.addnew &&
          <div>
            <div className="addnew">
              <button type="button" className="addnew_close" onClick={() => this.addnew(false)}>x</button>
              <Addnew InvoFb={this.state.InvoFb} />
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

export default Invoice_Fb;
