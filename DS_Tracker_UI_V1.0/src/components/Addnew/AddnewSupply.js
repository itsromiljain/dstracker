import React, { Component } from 'react';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import moment from 'moment';
import './Addnew.scss';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';


//const location = ['Austin', 'Sunnyvale', 'Bangalore','Hyderabad'];
const onoffshore = ['OnShore', 'OffShore'];
const intext = ['Internal', 'External'];
// const statusvalues = ['Available',
//   'Candidate Withdraw',
//   'Future Prospect',
//   'Interview in process',
//   'On Hold',
//   'Joined',
//   'Proactive Hiring',
//   'Rejected',
//   'Selected',
//   'Submitted'];
const recruitername = ['Priya', 'Teja'];
//const submittedby = ['Priya', 'Teja'];
//const yrofexp = ['0-2years', '2-5 Years', '5-10 Years', '10+ Years'];

class AddnewSupply extends Component {
  constructor() {
    super();
    this.state = {
      projectRes: false,
      alertmsg: '',
      id: '',
      supplyname: '',
      skill: '',
      demandid: '',
      premiumrate: '',
      recruitername: '',
      submittedby: [],
      yrofexp: [],
      status: [],
      location: [],
      intext: '',
      onoffshore: '',
      appleinterviewdate: moment(),
      appleselectiondate: moment(),
      onboardingdate: moment(),
      rrnumber: '',
      sfid: '',
      desc: '',
      live: moment(),
      modifieddate: moment(),
    };
    this.alertClick = (flag) => {
      this.setState({ projectRes: flag }, () => {
        this.props.onsuccess();
      });
    };
    this.changeModifiedDate = (date) => {
      this.setState({ modifieddate: date });
    };
    this.changeAppleInterviewDate = (date) => {
      this.setState({ appleinterviewdate: date });
    };
    this.changeAppleSelectionDate = (date) => {
      this.setState({ appleselectiondate: date });
    };
    this.changeOnBoardingDate = (date) => {
      this.setState({ onboardingdate: date });
    };
    this.changeLive = (date) => {
      this.setState({ live: date });
    };
    this.setForm = (e, param) => {
      switch (param) {
        case 'id':
          this.setState({ id: e.target.value });
          break;
        case 'supplyname':
          this.setState({ supplyname: e.target.value });
          break;
        case 'skill':
          this.setState({ skill: e.target.value });
          break;
        case 'demandid':
          this.setState({ demandid: e.target.value });
          break;
        case 'premiumrate':
          this.setState({ premiumrate: e.target.value });
          break;
        case 'recruitername':
          this.setState({ recruitername: e.target.value });
          break;
        case 'submittedby':
          this.setState({ submittedby: e.target.value });
          break;
        case 'yrofexp':
          this.setState({ yrofexp: e.target.value });
          break;
        case 'status':
          this.setState({ status: e.target.value });
          break;
        case 'location':
          this.setState({ location: e.target.value });
          break;
        case 'intext':
          this.setState({ intext: e.target.value });
          break;
        case 'onoffshore':
          this.setState({ onoffshore: e.target.value });
          break;
        case 'rrnumber':
          this.setState({ rrnumber: e.target.value });
          break;
        case 'sfid':
          this.setState({ sfid: e.target.value });
          break;
        case 'desc':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ desc: e.target.value });
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
      console.log(data);
      let error = false;
      /*for (let i = 0;i < Object.keys(data).length;i +=1) {
        if (data.applemanager.trim() === '') {
            this.setState({ validationMsg: 'Apple Manager is Mandatory' });
            error = true;
            break;
        } else if (data.deliverymanager.trim() === '') {
            this.setState({ validationMsg: 'Delivery Manager is Mandatory' });
            error = true;
            break;
        } else if (data.desc.trim() === '') {
            this.setState({ validationMsg: 'Description is Mandatory' });
            error = true;
            break;
        }  
      }*/
      if (!error) {
        axios.post('/api/newSupply', data)
          .then((response) => {
            console.log(response.data);
            if (response.status === 201) {
              this.setState({ alertmsg: 'Supply Added successfully', projectRes: true });
            }
          })
          .catch((error) => {
            this.setState({ alertmsg: `Couldnot add Supply due to${error}`, projectRes: true });
          });
      }
      console.log(data);
    };
  }

  // edit demand
  componentDidMount() {
    if (this.props.id) {
      axios.get(`/api/getproject?id=${this.props.id}`)
        .then((response) => {
          if (response.status === 200) {
            const resData = response.data;

            if (resData.modifieddate) {
              resData.modifieddate = moment(GenericHelpers.formatDate(response.data.modifieddate), 'DD/MM/YYYY');
            }
            if (resData.appleinterviewdate) {
              resData.appleinterviewdate = moment(GenericHelpers.formatDate(response.data.appleinterviewdate), 'DD/MM/YYYY');
            }
            if (resData.appleselectiondate) {
              resData.appleselectiondate = moment(GenericHelpers.formatDate(response.data.appleselectiondate), 'DD/MM/YYYY');
            }
            if (resData.onboardingdate) {
              resData.onboardingdate = moment(GenericHelpers.formatDate(response.data.onboardingdate), 'DD/MM/YYYY');
            }
            if (resData.live) {
              resData.live = moment(GenericHelpers.formatDate(response.data.live), 'DD/MM/YYYY');
            }
            this.setState(resData);
          }
        })
        .catch((error) => {
          console.log(error);
        })
    }

// making API calls

    axios.get('/api/getLocation')
    .then((response) => {

      if (response.status === 200) {
        this.setState({ location: response.data });
      }
    })

    axios.get('/api/getSupplyStatus')
    .then((response) => {

      if (response.status === 200) {
        this.setState({ status: response.data });
      }
    })

    axios.get('/api/getSubmittedBy')
    .then((response) => {

      if (response.status === 200) {
        this.setState({ submittedby: response.data });
      }
    })

    axios.get('/api/getYrOfExp')
    .then((response) => {

      if (response.status === 200) {
        this.setState({ yrofexp: response.data });
      }
    })

  }

  render() {
    
    return (
      <form className="addnew_form">
        <h2>Add New Supply</h2>
        <div className="addnew_form-field half-field">
          <label>Supply Id</label>
          <input type="text" value={this.state.id} required onChange={(e) => this.setForm(e, 'id')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Supply Name</label>
          <input type="text" value={this.state.supplyname} required onChange={(e) => this.setForm(e, 'supplyname')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Demand Id</label>
          <input type="text" value={this.state.demandid} required onChange={(e) => this.setForm(e, 'demandid')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Premium Rate</label>
          <select value={this.state.premiumrate} required onChange={(e) => this.setForm(e, 'premiumrate')}>
            <option value="yes">Yes</option>
            <option value="no">No</option>
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Recruiter Name</label>
          <select onChange={(e) => this.setForm(e, 'recruitername')} value={this.state.recruitername} >
            {
              recruitername.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Submitted By</label>
          <select onChange={(e) => this.setForm(e, 'submittedby')} value={this.state.submittedby} >
            {
              this.state.submittedby.map((val, index) => (
                <option key={index} value={val.submittedBy}>{val.submittedBy}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Year of Experience</label>
          <select onChange={(e) => this.setForm(e, 'yrofexp')} value={this.state.yrofexp} >
            {
              this.state.yrofexp.map((val, i) => (
                <option key={i} value={val.yrOfExp}>{val.yrOfExp}</option>
              ))
            }
          {/* <select onChange={(e) => this.setForm(e, 'yrofexp')} value={this.state.yrofexp} >
            {
              yrofexp.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            } */}
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Status</label>
          <select onChange={(e) => this.setForm(e, 'status')} value={this.state.status} >
            {
              this.state.status.map((val, i) => (
                <option key={i} value={val.supplyStatus}>{val.supplyStatus}</option>
              ))
            }
           {/* <select onChange={(e) => this.setForm(e, 'status')} value={this.state.status} >
            {
              statusvalues.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            } */}
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Location</label>
          <select onChange={(e) => this.setForm(e, 'location')} value={this.state.location} >
            {
                            this.state.location.map((val, i) => (
                              <option key={i} value={val.location}>{val.location}</option>
                             
                            ))
          // <select onChange={(e) => this.setForm(e, 'location')} value={this.state.location} >
          //   {
          //     location.map((val, index) => (
          //       <option key={index} value={val}>{val}</option>
          //     ))
            }
          </select>
        </div>
            <div className="addnew_form-field half-field">
          <label>Internal / External</label>
          <select onChange={(e) => this.setForm(e, 'intext')} value={this.state.intext} >
            {
              intext.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>On / Off Shore</label>
          <select onChange={(e) => this.setForm(e, 'onoffshore')} value={this.state.onoffshore} >
            {
              onoffshore.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>RR</label>
          <input type="text" value={this.state.rrnumber} required onChange={(e) => this.setForm(e, 'rrnumber')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>SF ID</label>
          <input type="text" value={this.state.sfid} required onChange={(e) => this.setForm(e, 'sfid')} />
        </div>
   
        <div className="addnew_form-field half-field">
          <label>Creation Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.live} onChange={this.changeLive} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Modified Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.modifieddate} onChange={this.changeModifiedDate} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Apple Interview Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.appleinterviewdate} onChange={this.changeAppleInterviewDate} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Apple Selection Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.appleselectiondate} onChange={this.changeAppleSelectionDate} />
        </div>
        <div className="addnew_form-field half-field">
          <label>On Boarding Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.onboardingdate} onChange={this.changeOnBoardingDate} />
        </div>
  
        <div className="addnew_form-field full-field">
          <label>Skill Summary</label>
          {/* <input type="text" min="0" value={this.state.skill} required onChange={(e) => this.setForm(e, 'skill')} /> */}
          <textarea value={this.state.skill} onChange={(e) => this.setForm(e, 'skill')} />
        </div>
        <div className="addnew_form-field full-field">
          <label>Comments</label>
          <textarea value={this.state.desc} onChange={(e) => this.setForm(e, 'desc')} />
        </div>
        <p className="addnew_form-error">{this.state.validationMsg}</p>
        <div className="addnew_submitdiv">
          <button type="button" className="addnew_submit" onClick={this.submit}>
            Add Supply
        </button></div>
        {
          this.state.projectRes &&
          <div>
            <Alert msg={this.state.alertmsg} onclick={this.alertClick} />
            <div className="overlay" />
          </div>
        }
      </form>
    );
  }
}



export default AddnewSupply;
