import React, { Component } from 'react';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import moment from 'moment';
import './Skillnew.scss';
import Alert from '../Alert/Alert';
import GenericHelpers from '../../../Helpers/Generic';

const statusvalues = ['Bangalore', 'Hyderabad', 'UK', 'Complete'];

class Pos_new extends Component {
  constructor() {
    super();
    this.state = {
      SkillRes: false,
      alertmsg: '',
      psno: '',
      name:'',
      grade:'',
    //  odc: 'yes',
      project_name: '',
      project_id: '',
      project_category:'',
      primary_skill:'',
      secondary_skill:'',
      location: 'Bangalore',
      buname: '',
      delivery_manag:'',
      training_attended:''
    /*  demandId: '',
      cv :'' */
    };
    this.alertClick = (flag) => {
      this.setState({ SkillRes: flag }, () => {
        this.setState({
          psno: '',
          name:'',
          grade:'',
        //  odc:'',
          project_name: '',
          project_id: '',
          project_category:'',
          primary_skill:'',
          secondary_skill:'',
          location: '',
          buname: '',
          delivery_manag:'',
          training_attended:''
        });
      });
    };
    this.setForm = (e, param) => {
      switch (param) {
        case 'psno':
          if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ psno: e.target.value });
        }
        break;
        case 'name':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ name: e.target.value });
        }
        break;
        case 'grade':
          this.setState({ grade: e.target.value });
          break;
        case 'odc':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ odc: e.target.value });
        }
          break;
        case 'project_name':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ project_name: e.target.value });
        }
        break;
        case 'project_id':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ project_id: e.target.value });
        }
        break;
        case 'project_category':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ project_category: e.target.value });
        }
        break;
        case 'primary_skill':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ primary_skill: e.target.value });
        }
        break;
        case 'secondary_skill':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ secondary_skill: e.target.value });
        }
        break;
        case 'location':
          this.setState({ location: e.target.value });
          break;
        case 'buname':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ buname: e.target.value });
        }
        break;
        case 'delivery_manag':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ delivery_manag: e.target.value });
        }
        break;
        case 'training_attended':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ training_attended: e.target.value });
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
      for (let i = 0;i < Object.keys(data).length;i +=1) {
        if (data.psno.trim() === '') {
            this.setState({ validationMsg: 'PSNO is Mandatory' });
            error = true;
            break;
        } else if (data.project_name.trim() === '') {
            this.setState({ validationMsg: 'Project name is Mandatory' });
            error = true;
            break;
        } else if (data.project_id.trim() === '') {
            this.setState({ validationMsg: 'Project Id is Mandatory' });
            error = true;
            break;
        }
      }
      // sending  all data to db service side
    if (!error) {
      axios.post('/api/skill_new', data)
        .then((response) => {
          if (response.status === 200) {
            console.log(data);
            this.setState({ alertmsg: 'Skill Added successfully', SkillRes: true });
          }
        })
      .catch((error) => {
        this.setState({ alertmsg: `Couldnot add project due to${error}`, SkillRes: true });
      });
    }
      console.log(data);
    };
  }
  componentDidMount() {
    if (this.props.skillId) {
      axios.get(`/api/getskill?psno=${this.props.skillId}`)
      .then((response) => {
        console.log(response);
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
  }
  render() {
    return (
      <form className="addnew_form">
        { console.log(this.state) }
        <h2>Skill Tracker </h2>
        <div className="addnew_form-field full-field">
          <label>PS No</label>
          <input type="text" value={this.state.psno}  onChange={(e) => this.setForm(e, 'psno')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Name</label>
          <input type="text" value={this.state.name}  onChange={(e) => this.setForm(e, 'name')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Grade</label>
          <input type="text" value={this.state.grade}  onChange={(e) => this.setForm(e, 'grade')} />
        </div>



        <div className="addnew_form-field half-field">
          <label>Project Name</label>
          <input type="text" value={this.state.project_name}  onChange={(e) => this.setForm(e, 'project_name')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Project Id</label>
          <input type="text" value={this.state.project_id}  onChange={(e) => this.setForm(e, 'project_id')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>Project Category</label>
          <input type="text" value={this.state.project_category}  onChange={(e) => this.setForm(e, 'project_category')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>Primary Skill</label>
          <input type="text" value={this.state.primary_skill}  onChange={(e) => this.setForm(e, 'primary_skill')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>Secondary skill</label>
          <input type="text" value={this.state.secondary_skill}  onChange={(e) => this.setForm(e, 'secondary_skill')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>Location</label>
          <select onChange={(e) => this.setForm(e, 'location')}>
            {
              statusvalues.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>BU Name</label>
          <input type="text" value={this.state.buname}  onChange={(e) => this.setForm(e, 'buname')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>Delivery Manager</label>
          <input type="text" value={this.state.delivery_manag}  onChange={(e) => this.setForm(e, 'delivery_manag')} />
        </div>
        <div className="addnew_form-field full-field">
          <label>Training Attended</label>
          <textarea value={this.state.training_attended}  onChange={(e) => this.setForm(e, 'training_attended')} />
        </div>
        <p className="addnew_form-error">{this.state.validationMsg}</p>
        <button type="button" className="addnew_submit" onClick={this.submit}>
          Add Project
        </button>
        {
          this.state.SkillRes &&
          <div>
            <Alert msg={this.state.alertmsg} onclick={this.alertClick} />
            <div className="overlay" />
          </div>
        }
      </form>
    );
  }
}

export default Pos_new;
