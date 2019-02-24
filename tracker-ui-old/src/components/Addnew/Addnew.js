import React, { Component } from 'react';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import moment from 'moment';
import './Addnew.scss';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';

const statusvalues = ['White', 'Red', 'Closed', 'Complete'];

class Addnew extends Component {
  constructor() {
    super();
    this.state = {
      projectRes: false,
      alertmsg: '',
      portfolio: '',
      project: '',
      induction: 'no',
      desc: '',
      live: moment(),
      status: 'White',
      milestone: '',
      milestonedate: moment(),
      imt: '',
      imtArr: [],
      del_mang :[],
      applemanager: '',
      deliverymanager: '',
      ltimanaged: 'no',
      ltionsitelead: '',
      offshorelead: '',
      overallsize: '',
      ltionsitesize: '',
      ltioffshoresize: '',
      ltioffshoreteam: '',
      othervendors: '',
      shifttime: '',
      appreciation: '',
      issues: '',
      mitigation: '',
      issuemitigation: '',
      remarks: '',
      weeklystatus: ''
    };
    this.alertClick = (flag) => {
      this.setState({ projectRes: flag }, () => {
        this.props.onsuccess();
      });
    };
    this.changeMilestonedate = (date) => {
      this.setState({ milestonedate: date });
    };
    this.changeLive = (date) => {
      this.setState({ live: date });
    };
    this.setForm = (e, param) => {
      switch (param) {
        case 'portfolio':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ portfolio: e.target.value });
          }
          break;
        case 'project':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ project: e.target.value });
          }
          break;
        case 'induction':
          this.setState({ induction: e.target.value });
          break;
        case 'desc':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ desc: e.target.value });
          }
          break;
        case 'status':
          this.setState({ status: e.target.value });
          break;
        case 'milestone':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ milestone: e.target.value });
          }
          break;
        case 'imt':
          this.setState({ imt: e.target.value });
          break;
        case 'applemanager':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ applemanager: e.target.value });
          }
          break;
        case 'deliverymanager':
          this.setState({ deliverymanager: e.target.value });
          break;
        case 'ltimanaged':
          this.setState({ ltimanaged: e.target.value });
          break;
        case 'ltionsitelead':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ ltionsitelead: e.target.value });
          }
          break;
        case 'offshorelead':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ offshorelead: e.target.value });
          }
          break;
        case 'overallsize':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ overallsize: e.target.value });
          }
          break;
        case 'ltionsitesize':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ ltionsitesize: e.target.value });
          }
          break;
        case 'ltioffshoresize':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ ltioffshoresize: e.target.value });
          }
          break;
        case 'ltioffshoreteam':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ ltioffshoreteam: e.target.value });
          }
          break;
        case 'othervendors':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ othervendors: e.target.value });
          }
          break;
        case 'shifttime':
          this.setState({ shifttime: e.target.value });
          break;
        case 'appreciation':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ appreciation: e.target.value });
          }
          break;
        case 'issues':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ issues: e.target.value });
          }
          break;
        case 'mitigation':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ mitigation: e.target.value });
          }
          break;
        case 'issuemitigation':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ issuemitigation: e.target.value });
          }
          break;
        case 'remarks':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ remarks: e.target.value });
        }
          break;
        case 'weeklystatus':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ weeklystatus: e.target.value });
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
      for (let i = 0;i < Object.keys(data).length;i +=1) {
        if (data.portfolio.trim() === '') {
            this.setState({ validationMsg: 'Portfolio name is Mandatory' });
            error = true;
            break;
        } else if (data.project.trim() === '') {
            this.setState({ validationMsg: 'Project name is Mandatory' });
            error = true;
            break;
        } else if (data.desc.trim() === '') {
            this.setState({ validationMsg: 'Description is Mandatory' });
            error = true;
            break;
        }  else if ((data.status === 'Red') && ((data.mitigation.trim() === '') || (data.issues.trim() === '') || (data.issuemitigation.trim() === ''))) {
            this.setState({ validationMsg: 'Issue/Escalations, Mitiigation and Status of Mitigations are mandatory when project status is RED' });
            error = true;
            break;
        }
      }
      if (!error) {
        axios.post('/api/new', data)
          .then((response) => {
            if (response.status === 201) {
              this.setState({ alertmsg: 'Project Added successfully', projectRes: true });
            }
          })
        .catch((error) => {
          this.setState({ alertmsg: `Couldnot add project due to${error}`, projectRes: true });
        });
      }
      console.log(data);
    };
  }
  componentDidMount() {
    if (this.props.projectId) {
      axios.get(`/api/getproject?id=${this.props.projectId}`)
      .then((response) => {
        if (response.status === 200) {
          const resData = response.data;
          if (resData.milestonedate) {
            resData.milestonedate = moment(GenericHelpers.formatDate(response.data.milestonedate), 'DD/MM/YYYY');
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
    axios.get('/api/get_imt')
    .then((response) => {
      if (response.status === 200){
        this.setState({ imtArr: response.data });
      }
    })
    axios.get('/api/get_delvery_mange')
    .then((response) =>{
      if(response.status === 200){
        this.setState({ del_mang: response.data})
      }
    })
  }

  render() {
    return (
      <form className="addnew_form">
        <h2>Add New Project</h2>
        <div className="addnew_form-field full-field">
          <label>Portfolio Name</label>
          <input type="text" value={this.state.portfolio} required onChange={(e) => this.setForm(e, 'portfolio')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Project Name</label>
          <input type="text" value={this.state.project} required onChange={(e) => this.setForm(e, 'project')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Induction Kit</label>
          <select value={this.state.induction}  onChange={(e) => this.setForm(e, 'induction')}>
            <option value="yes">Yes</option>
            <option value="no">No</option>
          </select>
        </div>

        <div className="addnew_form-field full-field">
          <label>Description</label>
          <textarea value={this.state.desc} onChange={(e) => this.setForm(e, 'desc')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Project Go-Live/Final Delivery</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.live} onChange={this.changeLive} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Project Status</label>
          <select onChange={(e) => this.setForm(e, 'status')} value={this.state.status} >
            {
              statusvalues.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Next Milestone</label>
          <input type="text" value={this.state.milestone} required onChange={(e) => this.setForm(e, 'milestone')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Next Milestone Due Date</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.milestonedate} onChange={this.changeMilestonedate} />
        </div>
        <div className="addnew_form-field half-field">
          <label>IMT</label>
          <select onChange={(e) => this.setForm(e, 'imt')} value={this.state.imt} >
            {
              this.state.imtArr.map((val,i) => (
                <option key={i} value={val.imt_id}>{val.imt_name}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>Apple Manager</label>
          <input type="text" value={this.state.applemanager} required onChange={(e) => this.setForm(e, 'applemanager')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Delivery Manager</label>
        <select onChange={(e) => this.setForm(e,'deliverymanager')}  value={this.state.deliverymanager}>
          {
            this.state.del_mang.map((val, i) =>(
              <option key={i} value={val.dmngr_id}>{val.dmngr_name}</option>
          ))
        }
      </select>
      </div>
        <div className="addnew_form-field half-field">
          <label>LTI Managed</label>
          <select value={this.state.ltimanaged} required onChange={(e) => this.setForm(e, 'ltimanaged')}>
            <option value="yes">Yes</option>
            <option value="no">No</option>
          </select>
        </div>


        <div className="addnew_form-field half-field">
          <label>LTI Onsite Lead</label>
          <input type="text" value={this.state.ltionsitelead} required onChange={(e) => this.setForm(e, 'ltionsitelead')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Offshore Lead</label>
          <input type="text" value={this.state.offshorelead} required onChange={(e) => this.setForm(e, 'offshorelead')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Overall Size</label>
          <input type="text" min="0" value={this.state.overallsize} required onChange={(e) => this.setForm(e, 'overallsize')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>LTI Onsite Team Size</label>
          <input type="text" min="0" value={this.state.ltionsitesize} required onChange={(e) => this.setForm(e, 'ltionsitesize')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>LTI offshore Team Size</label>
          <input type="text" min="0" value={this.state.ltioffshoresize} required onChange={(e) => this.setForm(e, 'ltioffshoresize')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>LTI offshore Team Members</label>
          <input type="text" value={this.state.ltioffshoreteam} required onChange={(e) => this.setForm(e, 'ltioffshoreteam')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Other Vendors Involved</label>
          <input type="text" value={this.state.othervendors} onChange={(e) => this.setForm(e, 'othervendors')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Shift Time</label>
          <input type="text" value={this.state.shifttime} onChange={(e) => this.setForm(e, 'shifttime')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Client Appreciation</label>
          <textarea value={this.state.appreciation} onChange={(e) => this.setForm(e, 'appreciation')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Potential Issues / Escalations</label>
          <textarea value={this.state.issues} onChange={(e) => this.setForm(e, 'issues')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Mitigation</label>
          <textarea value={this.state.mitigation} onChange={(e) => this.setForm(e, 'mitigation')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Status of Issue Mitigation</label>
          <textarea value={this.state.issuemitigation} onChange={(e) => this.setForm(e, 'issuemitigation')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Remarks</label>
          <textarea value={this.state.remarks} onChange={(e) => this.setForm(e, 'remarks')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Weekly Status shared with Client</label>
          <textarea value={this.state.weeklystatus} onChange={(e) => this.setForm(e, 'weeklystatus')} />
        </div>
        <p className="addnew_form-error">{this.state.validationMsg}</p>
        <button type="button" className="addnew_submit" onClick={this.submit}>
          Add Project
        </button>
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
