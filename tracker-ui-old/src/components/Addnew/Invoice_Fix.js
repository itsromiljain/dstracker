import React, { Component } from 'react';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import moment from 'moment';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';

const sowp = ['PR Created', 'PO Issued', 'Approved', 'PR not required'];
const fgroup = ['Corporate Systems', 'GNCS', 'ETS', 'SAP Global System','GBI','NON IS&T','APAC','Supply Chain'];
const pus = ['ADM','OR','DZ','IMS','BIDW','MOB','TSL','SAP'];
const egrade = ['A-1-2','B-1-1','B-1-1','PM','A-1-3','STC'];

class Invoice_Fix extends Component {
  constructor() {
    super();
    this.state = {
      Fb_Project: false,
      alertmsg: '',
      formNo:'',
      amt:'',
      funcGrp:'',
       poNo:'',
       poTitle:'',
       poVlu:'',
      poStrtDt:moment(),
      poEndDt:moment(),
       buCntctNm:'',
       milestone: '',
       invoiceNo: ''
    };

   this.alertClick = (flag) => {
      this.setState({ Fb_Project: flag }, () => {
        this.setState({
          formNo:'',
          amt:'',
          funcGrp:'',
          poNo:'',
           poTitle:'',
           poVlu:'',
           buCntctNm:'',
           milestone: '',
           invoiceNo: ''
        });
      });
    };

    this.allow = (date) => {
      this.setState({  poStrtDt: date });
    };
    this.end = (date) => {
      this.setState({  poEndDt: date });
    };
    this.setForm = (e, param) => {
      switch (param) {
        case 'formNo':
          if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ formNo: e.target.value });
        }
        break;
        case 'amt':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ amt: e.target.value });
          }
        break;
        case 'funcGrp':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ funcGrp: e.target.value });
        }
          break;
        case 'poNo':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ poNo: e.target.value });
        }
        break;
        case ' poTitle':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({  poTitle: e.target.value });
        }
        break;
        case ' poVlu':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({  poVlu: e.target.value });
        }
        break;
        case ' buCntctNm':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({  buCntctNm: e.target.value });
        }
        break;
        case ' milestone':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({  milestone: e.target.value });
        }
        break;
        case ' invoiceNo':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({  invoiceNo: e.target.value });
        }
        break;
        default:
        break;
      }
    };
    this.submit = (e) => {
      e.preventDefault();
      const data = this.state;
      delete data.editedRes;
      delete data.alertmsg;
      let error = false;
      let errors = {};
      let formIsValid = true;
      for (let i = 0;i < Object.keys(data).length;i +=1) {
        if (data.poNo.trim() === '') {
            this.setState({ validationMsg: 'PO NO is Mandatory' });
            error = true;
            break;
        }
      }
      // sending  all data to db service side
    if (!error) {
      axios.post('/api/Fb_new', data)
        .then((response) => {
          if (response.status === 201) {
            this.setState({ alertmsg: 'Invoice Added successfully', Fb_Project: true });
          }
        })
      .catch((error) => {
        this.setState({ alertmsg: `Couldnot add project due to${error}`, Fb_Project: true });
      });
    }
    };
  }
  // for editing need to be use
  componentDidMount() {
    if (this.props.InvoFb) {
      axios.get(`/api/getFb?poNo=${this.props.InvoFb}`)
      .then((response) => {
        if (response.status === 200) {
          const resData = response.data;
          if (resData.poStrtDt) {
            resData.poStrtDt = moment(GenericHelpers.formatDate(response.data.poStrtDt), 'DD/MM/YYYY');
          }
          if (resData. poEndDt) {
            resData. poEndDt = moment(GenericHelpers.formatDate(response.data.poEndDt), 'DD/MM/YYYY');
          }
          this.setState(resData);
        }
                console.log(response);
      })
      .catch((error) => {
        console.log(error);
      })
    }
  }
  render() {
    return (
      <form className="addnew_form">
        <h2>Invoice FB List</h2>


        <div className="addnew_form-field full-field">
                <label>Form No</label>
                <input type="text" value={this.state.formNo}  onChange={(e) => this.setForm(e, 'formNo')} />
              </div>
              <div className="addnew_form-field half-field">
                <label>AMT</label>
                <input type="text" value={this.state.amt}  onChange={(e) => this.setForm(e, 'amt')} />
              </div>
              <div className="addnew_form-field half-field">
                <label>Functional group</label>
                <select onChange={(e) => this.setForm(e, 'funcGrp')} value={this.state.funcGrp} >
                  {
                    fgroup.map((val, index) => (
                      <option key={index} value={val}>{val}</option>
                    ))
                  }
                </select>
              </div>
              <div className="addnew_form-field half-field">
                <label>PO</label>
                <input type="text" value={this.state.poNo}  onChange={(e) => this.setForm(e, 'poNo')} />
              </div>

              <div className="addnew_form-field half-field">
                <label>PO Title</label>
                <input type="text" value={this.state. poTitle}  onChange={(e) => this.setForm(e, ' poTitle')} />
              </div>

              <div className="addnew_form-field half-field">
                <label>PO Value </label>
                <input type="text" value={this.state. poVlu}  onChange={(e) => this.setForm(e, ' poVlu')} />
              </div>

              <div className="addnew_form-field half-field">
                <label>NAME OF EMPLOYEE</label>
                <input type="text" value={this.state.empName}  onChange={(e) => this.setForm(e, 'empName')} />
              </div>


              <div className="addnew_form-field half-field">
                <label>PO Start Date</label>
                <DatePicker dateFormat="DD/MM/YYYY" selected={this.state. poStrtDt} onChange={this.allow} />
              </div>

              <div className="addnew_form-field full-field">
                <label>PO End Date</label>
                <DatePicker dateFormat="DD/MM/YYYY" selected={this.state. poEndDt} onChange={this.end} />
              </div>

              <div className="addnew_form-field half-field">
                <label>Business contact  Name</label>
                <input type="text" value={this.state. buCntctNm}  onChange={(e) => this.setForm(e, ' buCntctNm')} />
              </div>


              <div className="addnew_form-field half-field">
                <label> Milestone </label>
                <input type="text" value={this.state. milestone}  onChange={(e) => this.setForm(e, ' milestone')} />
              </div>

              <div className="addnew_form-field half-field">
                <label> Invoice# </label>
                <input type="text" value={this.state. invoiceNo}  onChange={(e) => this.setForm(e, ' invoiceNo')} />
              </div>


        <p className="addnew_form-error">{this.state.validationMsg}</p>
        <button type="button" className="addnew_submit" onClick={this.submit}>
          Add Project
        </button>
        {
          this.state.Fb_Project &&
          <div>
            <Alert msg={this.state.alertmsg} onclick={this.alertClick} />
            <div className="overlay" />
          </div>
        }
      </form>
    );
  }
}

export default Invoice_Fix;
