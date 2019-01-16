import React, { Component } from 'react';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import moment from 'moment';
import './Addnew.scss';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';

//const demandType = ['Niche', 'Regular'];
//const statusvalues = ['Open', 'Closed', 'Responded'];
// const location = ['Austin', 'Sunnyvale', 'Bangalore', 'Hyderabad'];
//const applel1manager = ['Priya', 'Teja'];
//const applel2manager = ['Shanmuga', 'Priya'];
//const recruiter = ['Shanmuga', 'Priya', 'Teja'];
//const lead = ['Vaibhav', 'Ramu', 'Ashutosh'];
//const yrOfExp = ['0-2years', '2-5 Years', '5-10 Years', '10+ Years'];
//const priority = ['0', '1', '2'];

class Addnew extends Component {
  constructor() {
    super();
    this.state = {
      projectRes: false,
      alertmsg: '',
      id: '',
      rfr: '',
      oppty: '',
      rrOnshore: '',
      //rrOffshore: '',
      demandOnsite: '',
      demandOffsite: '',
      // clientselect: '',
      location: [],
      desc: '',
      demandType: [],
      yrOfExp: [],
      priority: [],
      role: '',
      suggestedPanel: '',
      // live: moment(),
      status: [],
      // sfCreationDate: moment(),
      closureDate: moment(),
      //del_mang :[],
      //apple_mang :[],
      // apple_l1mang :[],
      apple_l2mang: [],
      // recruiter :[],


      //applemanager: '',
      // applel1manager: '',
      applel2manager: '',
      //  deliverymanager: '',
      // recruiter: '',
      suggestedPanel: '',
      sf: '',
      lead: [],
      skill: '',

    };
    this.alertClick = (flag) => {
      this.setState({ projectRes: flag }, () => {
        this.props.onsuccess();
      });
    };
    /* 
    this.changeSfCreationDate = (date) => {
      this.setState({sfCreationDate: date });
   };
   
    this.changeLive = (date) => {
      this.setState({ live: date });
    };
   */
    this.changeClosureDate = (date) => {
      this.setState({ closureDate: date });
    };

    this.setForm = (e, param) => {
      switch (param) {
        case 'id':
          this.setState({ id: e.target.value });
          break;
        case 'rfr':
          this.setState({ rfr: e.target.value });
          break;
        case 'oppty':
          this.setState({ oppty: e.target.value });
          break;
        case 'desc':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ desc: e.target.value });
          }
          break;
        case 'status':
          this.setState({ status: e.target.value });
          break;
        case 'rrOnshore':
          this.setState({ rrOnshore: e.target.value });
          break;
        case 'demandOnsite':
          this.setState({ demandOnsite: e.target.value });
          break;
        case 'demandOffsite':
          this.setState({ demandOffsite: e.target.value });
          break;
        case 'location':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ location: e.target.value });
          }
          break;
        case 'yrOfExp':
        this.setState({ yrOfExp: e.target.value });
          break;
        case 'priority':
        this.setState({ priority: e.target.value });
          break;
        case 'applel2manager':
          this.setState({ applel2manager: e.target.value });
          break;
        case 'demandType':
          this.setState({ demandType: e.target.value });
          break;
        case 'role':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ role: e.target.value });
          }
          break;
        case 'skill':
          this.setState({ skill: e.target.value });
          break;
        case 'suggestedPanel':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ suggestedPanel: e.target.value });
          }
          break;
        case 'lead':
          this.setState({ lead: e.target.value });
          break;
        case 'sf':
          this.setState({ sf: e.target.value });
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
       for (let i = 0;i < Object.keys(data).length;i +=1) {
          // if (data.applemanager.trim() === '') {
          //     this.setState({ validationMsg: 'Apple Manager is Mandatory' });
          //     error = true;
          //     break;
          // } else if (data.deliverymanager.trim() === '') {
          //     this.setState({ validationMsg: 'Delivery Manager is Mandatory' });
          //     error = true;
          //     break;
          // } else 
          if (data.desc.trim() === '') {
              this.setState({ validationMsg: 'Description is Mandatory' });
              error = true;
              break;
          }  
        }
      if (!error) {
        axios.post('/api/new', data)
          .then((response) => {
            console.log(response.data);
            if (response.status === 201) {
              this.setState({ alertmsg: 'demand Added successfully', projectRes: true });
            }
          })
          .catch((error) => {
            this.setState({ alertmsg: `Couldnot add demand due to${error}`, projectRes: true });
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
            console.log("inside edit demand");
            console.log(response.data);
            const resData = response.data;


            if (resData.closureDate) {
              resData.closureDate = moment(GenericHelpers.formatDate(response.data.closureDate), 'DD/MM/YYYY');
            }
            /*if (resData.sfCreationDate) {
              resData.sfCreationDate = moment(GenericHelpers.formatDate(response.data.sfCreationDate), 'DD/MM/YYYY');
            }
            if (resData.live) {
              resData.live = moment(GenericHelpers.formatDate(response.data.live), 'DD/MM/YYYY');
            }*/
            this.setState(resData);
          }
        })
        .catch((error) => {
          console.log(error);
        })
    }



    /* axios.get('/api/getAppleManager')
     .then((response) => {
      
       if (response.status === 200){
         this.setState({ apple_mang: response.data });
       }
     })
    axios.get('/api/getAppleL1Manager')
     .then((response) => {
       if (response.status === 200){
         this.setState({ apple_l1mang: response.data });
       }
      }) 
          axios.get('/api/get_delvery_mange')
     .then((response) =>{
       if(response.status === 200){
         this.setState({ del_mang: response.data})
       }
     })
      */


    // axios.get('/api/get_location')
    // .then((response) => {
    //   if (response.status === 200){
    //     this.setState({ location: response.data });
    //   }
    // })

// Making API calls for drop down fields and fetching values

    axios.get('/api/getAppleL2Manager')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ apple_l2mang: response.data });
        }
      })

      axios.get('/api/getLocation')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ location: response.data });
        }
      })

      axios.get('/api/getDemandType')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ demandType: response.data });
        }
      })

      axios.get('/api/getLead')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ lead: response.data });
        }
      })

      axios.get('/api/getPriority')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ priority: response.data });
        }
      })
      axios.get('/api/getDemandStatus')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ status: response.data });
        }
      })

      axios.get('/api/getYrOfExp')
      .then((response) => {

        if (response.status === 200) {
          this.setState({ yrOfExp: response.data });
        }
      })
  }

  render() {
    return (
      <form className="addnew_form">
        <h2>Add New Demand</h2>
        <div className="addnew_form-field half-field">
          <label>Demand Id</label>
          <input type="text" value={this.state.id} required onChange={(e) => this.setForm(e, 'id')} />
        </div>
        {/* <div className="addnew_form-field half-field">
          <label>Creation Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.live} onChange={this.changeLive} />
        </div> */}
        <div className="addnew_form-field half-field">
          <label>Demand Type</label>
          <select onChange={(e) => this.setForm(e, 'demandType')} value={this.state.demandType} >
            {
                            this.state.demandType.map((val, i) => (
                              <option key={i} value={val.demand_type_id}>{val.demandType}</option>
                              
                            ))
              // demandType.map((val, index) => (
              //   <option key={index} value={val}>{val}</option>
              // ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>RFR#</label>
          <input type="text" value={this.state.rfr} required onChange={(e) => this.setForm(e, 'rfr')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Opportunity#</label>
          <input type="text" value={this.state.oppty} required onChange={(e) => this.setForm(e, 'oppty')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>RR#</label>
          <input type="text" value={this.state.rrOnshore} required onChange={(e) => this.setForm(e, 'rrOnshore')} />
        </div>
        {/* <div className="addnew_form-field half-field">
          <label>RR# Offshore</label>
          <input type="text" value={this.state.rrOffshore} required onChange={(e) => this.setForm(e, 'rrOffshore')} />
        </div> */}
        <div className="addnew_form-field half-field">
          <label>SF# </label>
          <input type="text" value={this.state.sf} required onChange={(e) => this.setForm(e, 'sf')} />
        </div>
        {/* <div className="addnew_form-field half-field">
          <label>SF Creation Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.sfCreationDate} onChange={this.changeSfCreationDate} />
        </div> */}
        <div className="addnew_form-field half-field">
          <label>Demand Onsite</label>
          <input type="text" min="0" value={this.state.demandOnsite} required onChange={(e) => this.setForm(e, 'demandOnsite')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Demand Offshore</label>
          <input type="text" min="0" value={this.state.demandOffsite} required onChange={(e) => this.setForm(e, 'demandOffsite')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Closure Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.closureDate} onChange={this.changeClosureDate} />
        </div>
        {/* <div className="addnew_form-field half-field">
          <label>Client Select</label>
          <select value={this.state.clientselect} required onChange={(e) => this.setForm(e, 'clientselect')}>
            <option value="yes">Yes</option>
            <option value="no">No</option>
          </select>
        </div> */}
        <div className="addnew_form-field half-field">
          <label>Location</label>
          <select onChange={(e) => this.setForm(e, 'location')} value={this.state.location} >
            {
                            this.state.location.map((val, i) => (
                              <option key={i} value={val.location}>{val.location}</option>
                             
                            ))
              // location.map((val, index) => (
              //   <option key={index} value={val}>{val}</option>
              // ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Year of Experience</label>
          <select onChange={(e) => this.setForm(e, 'yrOfExp')} value={this.state.yrOfExp} >
            {
              this.state.yrOfExp.map((val, i) => (
                <option key={i} value={val.yrOfExp}>{val.yrOfExp}</option>
              ))
              // yrOfExp.map((val, index) => (
              //   <option key={index} value={val}>{val}</option>
              // ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Priority</label>
          <select onChange={(e) => this.setForm(e, 'priority')} value={this.state.priority} >
            {
              this.state.priority.map((val, i) => (
                <option key={i} value={val.priority}>{val.priority}</option>
              ))
              // priority.map((val, index) => (
              //   <option key={index} value={val}>{val}</option>
              // ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Status</label>
          <select onChange={(e) => this.setForm(e, 'status')} value={this.state.status} >
            {
              this.state.status.map((val, i) => (
                <option key={i} value={val.statusType}>{val.statusType}</option>
              ))
              // statusvalues.map((val, index) => (
              //   <option key={index} value={val}>{val}</option>
              // ))
            }
          </select>
        </div>
        {/* <div className="addnew_form-field half-field">
          <label>Apple Manager</label>
        <select onChange={(e) => this.setForm(e,'applemanager')}  value={this.state.applemanager}>
          {
            this.state.apple_mang.map((val, i) =>(
              
              <option key={i} value={val.applemngr_id}>{val.applemngr_name}</option>
          ))
        }
      </select>
      </div>
      <div className="addnew_form-field half-field">
          <label>Apple L1 Manager</label>
        <select onChange={(e) => this.setForm(e,'applel1manager')}  value={this.state.applel1manager}>
          {
             this.state.apple_l1mang.map((val, i) =>(
              
             <option key={i} value={val.applel1mngr_id}>{val.applel1mngr_name}</option>
            // <option key={i} value={val}>{val}</option>
          ))
        }
      </select>
      </div> */}
        <div className="addnew_form-field half-field">
          <label>Apple L2 Manager</label>
          <select onChange={(e) => this.setForm(e, 'applel2manager')} value={this.state.applel2manager}>
            {
              this.state.apple_l2mang.map((val, i) => (
                <option key={i} value={val.applel2mngr_name}>{val.applel2mngr_name}</option>
                //<option key={i} value={val}>{val}</option>
              ))
            }
          </select>
        </div>

        <div className="addnew_form-field half-field">
          <label>Lead</label>
          <select onChange={(e) => this.setForm(e, 'lead')} value={this.state.lead}>
            {
              this.state.lead.map((val, i) => (
              <option key={i} value={val.lead_val}>{val.lead_val}</option>
              // lead.map((val, i) => ( 
              //   <option key={i} value={val}>{val}</option>
              ))
            }
          </select>
        </div>

        <div className="addnew_form-field half-field">
          <label>Skills</label>
          <input type="text" min="0" value={this.state.skill} required onChange={(e) => this.setForm(e, 'skill')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Role</label>
          <textarea value={this.state.role} onChange={(e) => this.setForm(e, 'role')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Suggested panel List</label>
          <textarea value={this.state.suggestedPanel} onChange={(e) => this.setForm(e, 'suggestedPanel')} />
        </div>
        <div className="addnew_form-field full-field">
          <label>Description</label>
          <textarea value={this.state.desc} onChange={(e) => this.setForm(e, 'desc')} />
        </div>

        <p className="addnew_form-error">{this.state.validationMsg}</p>
        <div className="addnew_submitdiv">
          <button type="button" className="addnew_submit" onClick={this.submit}>
            Add Demand
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

export default Addnew;
