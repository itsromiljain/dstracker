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

class Invoice_new extends Component {
  constructor() {
    super();
    this.state = {
      Invoice_Proj: false,
      alertmsg: '',
      sow:'',
      po:'',
      sowStatus:'',
      sowMode:'',
      funcGrp:'',
      dsid:'',
      empLid:'',
      empName:'',
      pu:'',
      multiPurpose:'',
      projId:'',
      allocStrtDt:moment(),
      endDt:moment(),
      billAbility:'',
      location:'',
      grade:'',
      projDesc:'',
      avlbPoVlu:'',
      attn:'',
      wrkgDys:'',
      leaveDys:'',
      swipedDys:'',
      swipedHrs:'',
      diffHrs:'',
      wrkDyBilled:'',
      diffDys:'',
      billedHrs:'',
      rate:'',
      billableAmt:'',
      avlblAfterInvoice:'',
      invoiceNo:'',
      subToAppl:'',
      leavDt:'',
      compOff:'',
      ubCityOffc:'',
      wfh:'',
      tempBdgDt:'',
      redFrSwipeMismatch:'',
      remarks:''
    };

   this.alertClick = (flag) => {
      this.setState({ Invoice_Proj: flag }, () => {
        this.setState({
          sow:'',
          po:'',
          sowStatus:'',
          sowMode:'',
          funcGrp:'',
          dsid:'',
          empLid:'',
          empName:'',
          pu:'',
          multiPurpose:'',
          projId:'',
          billAbility:'',
          location:'',
          grade:'',
          projDesc:'',
          avlbPoVlu:'',
          attn:'',
          wrkgDys:'',
          leaveDys:'',
          swipedDys:'',
          swipedHrs:'',
          diffHrs:'',
          wrkDyBilled:'',
          diffDys:'',
          billedHrs:'',
          rate:'',
          billableAmt:'',
          avlblAfterInvoice:'',
          invoiceNo:'',
          subToAppl:'',
          leavDt:'',
          compOff:'',
          ubCityOffc:'',
          wfh:'',
          tempBdgDt:'',
          redFrSwipeMismatch:'',
          remarks:''
        });
      });
    };

    this.alloction = (date) => {
      this.setState({ allocStrtDt: date });
    };
    this.enddate = (date) => {
      this.setState({ endDt: date });
    };
    this.setForm = (e, param) => {
      switch (param) {
        case 'sow':
          if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ sow: e.target.value });
        }
        break;
        case 'po':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ po: e.target.value });
        }
        break;
        case 'sowStatus':
          this.setState({ sowStatus: e.target.value });
          break;
        case 'sowMode':
          if (isNaN(e.target.value) || e.target.value == '') {
            this.setState({ sowMode: e.target.value });
          }
        case 'funcGrp':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ funcGrp: e.target.value });
        }
          break;
        case 'dsid':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ dsid: e.target.value });
        }
        break;
        case 'empLid':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ empLid: e.target.value });
        }
        break;
        case 'empName':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ empName: e.target.value });
        }
        break;
        case 'billAbility':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ billAbility: e.target.value });
        }
        break;
        case 'projDesc':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ projDesc: e.target.value });
        }
        break;
        case 'avlbPoVlu':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ avlbPoVlu: e.target.value });
        }
        break;
        case 'pu':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ pu: e.target.value });
        }
        break;
        case 'multiPurpose':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ multiPurpose: e.target.value });
        }
        break;
        case 'projId':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ projId: e.target.value });
        }
        break;
        case 'attn':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ attn: e.target.value });
        }
        break;
        case 'wrkgDys':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ wrkgDys: e.target.value });
        }
        break;
        case 'leaveDys':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ leaveDys: e.target.value });
        }
        break;
        case 'swipedDys':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ swipedDys: e.target.value });
        }
        break;
        case 'swipedHrs':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ swipedHrs: e.target.value });
        }
        break;
        case 'diffHrs':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ diffHrs: e.target.value });
        }
        break;
        case 'wrkDyBilled':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ wrkDyBilled: e.target.value });
        }
        break;
        case 'diffDys':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ diffDys: e.target.value });
        }
        break;
        case 'billedHrs':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ billedHrs: e.target.value });
        }
        break;
        case 'rate':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ rate: e.target.value });
        }
        break;
        case 'billableAmt':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ billableAmt: e.target.value });
        }
        break;
        case 'invoiceNo':
        if (!isNaN(e.target.value) || e.target.value == '') {
          this.setState({ invoiceNo: e.target.value });
        }
        break;
        case 'subToAppl':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ subToAppl: e.target.value });
        }
        break;
        case 'leavDt':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ leavDt: e.target.value });
        }
        break;
        case 'avlblAfterInvoice':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ avlblAfterInvoice: e.target.value });
        }
        break;
        case 'compOff':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ compOff: e.target.value });
        }
        break;
        case 'ubCityOffc':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ ubCityOffc: e.target.value });
        }
        break;
        case 'wfh':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ wfh: e.target.value });
        }
        break;
        case 'tempBdgDt':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ tempBdgDt: e.target.value });
        }
        break;
        case 'redFrSwipeMismatch':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ redFrSwipeMismatch: e.target.value });
        }
        break;
        case 'remarks':
        if (isNaN(e.target.value) || e.target.value == '') {
          this.setState({ remarks: e.target.value });
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
      if (data.po.trim() === '') {
            this.setState({ validationMsg: 'PSNO  is Mandatory' });
            error = true;
            break;
        }
      }
      // sending  all data to db service side
    if (!error) {
      axios.post('/api/Invoice_new', data)
        .then((response) => {
          if (response.status === 201) {
            this.setState({ alertmsg: 'Invoice Added successfully', Invoice_Proj: true });
          }
        })
      .catch((error) => {
        this.setState({ alertmsg: `Couldnot add project due to${error}`, Invoice_Proj: true });
      });
    }
    };
  }
  // for editing need to be use
  componentDidMount() {
    if (this.props.InvoiceId) {
      axios.get(`/api/getInvoice?sow=${this.props.InvoiceId}`)
      .then((response) => {
        console.log(response);
        if (response.status === 200) {
          const resData = response.data;
          if (resData.allocStrtDt) {
            resData.allocStrtDt = moment(GenericHelpers.formatDate(response.data.allocStrtDt), 'DD/MM/YYYY');
          }
          if (resData.endDt) {
            resData.endDt = moment(GenericHelpers.formatDate(response.data.endDt), 'DD/MM/YYYY');
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
        <h2>Invoice TM </h2>
        <div className="addnew_form-field full-field">
          <label>SOW</label>
          <input type="text" value={this.state.sow}  onChange={(e) => this.setForm(e, 'sow')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>PO</label>
          <input type="text" value={this.state.po}  onChange={(e) => this.setForm(e, 'po')} />
        </div>
        <div className="addnew_form-field half-field">
          <label>SOW Status</label>
          <select onChange={(e) => this.setForm(e, 'sowStatus')} value={this.state.sowStatus} >
            {
              sowp.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>SOW Mode</label>
          <input type="text" value={this.state.sowMode}  onChange={(e) => this.setForm(e, 'sowMode')} />
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
          <label>DSID</label>
          <input type="text" value={this.state.dsid}  onChange={(e) => this.setForm(e, 'dsid')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>EMPLID</label>
          <input type="text" value={this.state.empLid}  onChange={(e) => this.setForm(e, 'empLid')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>NAME OF EMPLOYEE</label>
          <input type="text" value={this.state.empName}  onChange={(e) => this.setForm(e, 'empName')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>PU</label>
          <select onChange={(e) => this.setForm(e, 'pu')}>
            {
              pus.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field half-field">
          <label>MULTI PU PO</label>
          <select value={this.state.multiPurpose}  onChange={(e) => this.setForm(e, 'multiPurpose')}>
            <option value="yes">Yes</option>
            <option value="no">No</option>
          </select>
        </div>

        <div className="addnew_form-field full-field">
          <label>Project ID</label>
          <input type="text" value={this.state.projId}  onChange={(e) => this.setForm(e, 'projId')} />
        </div>


        <div className="addnew_form-field half-field">
          <label>Allocation START DATE</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.allocStrtDt} onChange={this.alloction} />
        </div>

        <div className="addnew_form-field full-field">
          <label>END DATE</label>
          <DatePicker dateFormat="DD/MM/YYYY" selected={this.state.endDt} onChange={this.enddate} />
        </div>

        <div className="addnew_form-field half-field">
          <label>Billability</label>
          <input type="text" value={this.state.billAbility}  onChange={(e) => this.setForm(e, 'billAbility')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>Location</label>
          <select value={this.state.location}  onChange={(e) => this.setForm(e, 'location')}>
            <option value="on">Onsite</option>
            <option value="off">Offshore</option>
          </select>
        </div>

        <div className="addnew_form-field half-field">
          <label>Grade</label>
          <select onChange={(e) => this.setForm(e, 'grade')}>
            {
              egrade.map((val, index) => (
                <option key={index} value={val}>{val}</option>
              ))
            }
          </select>
        </div>
        <div className="addnew_form-field full-field">
          <label>PROJECT DESCRIPTION</label>
          <textarea value={this.state.projDesc}  onChange={(e) => this.setForm(e, 'projDesc')} />
        </div>
        <div className="addnew_form-field half-field">
          <label> Available PO value </label>
          <input type="text" value={this.state.avlbPoVlu}  onChange={(e) => this.setForm(e, 'avlbPoVlu')} />
        </div>
        <div className="addnew_form-field half-field">
          <label> Attn </label>
          <input type="text" value={this.state.attn}  onChange={(e) => this.setForm(e, 'attn')} />
        </div>
        <div className="addnew_form-field half-field">
          <label> No. of Working Days</label>
          <input type="text" value={this.state.wrkgDys}  onChange={(e) => this.setForm(e, 'wrkgDys')} />
        </div>
        <div className="addnew_form-field half-field">
          <label> Leave Days </label>
          <input type="text" value={this.state.leaveDys}  onChange={(e) => this.setForm(e, 'leaveDys')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Swiped Days </label>
          <input type="text" value={this.state.swipedDys}  onChange={(e) => this.setForm(e, 'swipedDys')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>  Swipe hrs  </label>
          <input type="text" value={this.state.swipedHrs}  onChange={(e) => this.setForm(e, 'swipedHrs')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Difference in hrs  </label>
          <input type="text" value={this.state.diffHrs}  onChange={(e) => this.setForm(e, 'diffHrs')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>  WorkingDays to be billed  </label>
          <input type="text" value={this.state.wrkDyBilled}  onChange={(e) => this.setForm(e, 'wrkDyBilled')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>  Difference in days   </label>
          <input type="text" value={this.state.diffDys}  onChange={(e) => this.setForm(e, 'diffDys')} />
        </div>
        <div className="addnew_form-field half-field">
          <label> Billed Hours  </label>
          <input type="text" value={this.state.billedHrs}  onChange={(e) => this.setForm(e, 'billedHrs')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Rate  </label>
          <input type="text" value={this.state.rate}  onChange={(e) => this.setForm(e, 'rate')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>  BillableAmt </label>
          <input type="text" value={this.state.billableAmt}  onChange={(e) => this.setForm(e, 'billableAmt')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>  Available value after Invoicing  </label>
          <input type="text" value={this.state.avlblAfterInvoice}  onChange={(e) => this.setForm(e, 'avlblAfterInvoice')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Invoice# </label>
          <input type="text" value={this.state.invoiceNo}  onChange={(e) => this.setForm(e, 'invoiceNo')} />
        </div>

        <div className="addnew_form-field half-field">
          <label>MULTI PU PO</label>
          <select value={this.state.subToAppl}  onChange={(e) => this.setForm(e, 'subToAppl')}>
            <option value="true">TRUE</option>
            <option value="false">FALSE</option>
          </select>
        </div>

        <div className="addnew_form-field half-field">
          <label> Leave Dates </label>
          <input type="text" value={this.state.leavDt}  onChange={(e) => this.setForm(e, 'leavDt')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Comp-Off </label>
          <input type="text" value={this.state.compOff}  onChange={(e) => this.setForm(e, 'compOff')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> UB City Office </label>
          <input type="text" value={this.state.ubCityOffc}  onChange={(e) => this.setForm(e, 'ubCityOffc')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> WFH </label>
          <input type="text" value={this.state.wfh}  onChange={(e) => this.setForm(e, 'wfh')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Temp Badge Date</label>
          <input type="text" value={this.state.tempBdgDt}  onChange={(e) => this.setForm(e, 'tempBdgDt')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Reduced for swipe mismatch </label>
          <input type="text" value={this.state.redFrSwipeMismatch}  onChange={(e) => this.setForm(e, 'redFrSwipeMismatch')} />
        </div>

        <div className="addnew_form-field half-field">
          <label> Remarks </label>
          <input type="text" value={this.state.remarks}  onChange={(e) => this.setForm(e, 'remarks')} />
        </div>


        <p className="addnew_form-error">{this.state.validationMsg}</p>
        <button type="button" className="addnew_submit" onClick={this.submit}>
          Add Project
        </button>
        {
          this.state.Invoice_Proj &&
          <div>
            <Alert msg={this.state.alertmsg} onclick={this.alertClick} />
            <div className="overlay" />
          </div>
        }
      </form>
    );
  }
}

export default Invoice_new;
