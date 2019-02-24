import axios from 'axios';

const getAllProjects = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://172.20.10.2:7020/tracker/')
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

/* skill get */
const getSkill = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://172.28.104.19:8080/api/skill')
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

/* invoice get */
const getInvoice_Project = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://172.20.10.2:7020/invoicetm/')
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

//FB
const getFb_Project = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://172.20.10.2:7020/invoicefb/')
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

const getimt_project = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://172.20.10.2:7020/imts/')
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      })
    });
  }
  catch(error) {
    console.log(error);
  }
};

const get_manag = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://172.20.10.2:7020/deliverymgr/')
      .then((response)=> {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      })
    })
  }
  catch(error) {
    console.log(error);
  }
}

const getSingleProject = (query) => {
  const id = query.id;
  try {
    return new Promise((resolve, reject) => {
      axios.get(`http://172.20.10.2:7020/tracker/${id}`)
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

/* skill single get */
const getSkill_Project = (query) => {
  const psno = query.psno;
  try {
    return new Promise((resolve, reject) => {
      axios.get(`http://172.28.104.19:8080/api/skill/${psno}`)
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};


/* invoice single get */
const getInvoice_qury = (query) => {
  const sow = query.sow;
  try {
    return new Promise((resolve, reject) => {
      axios.get(`http://172.20.10.2:7020/invoicetm/${sow}`)
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

//FB
const getFb_qury = (query) => {
  const poNo = query.poNo;
  try {
    return new Promise((resolve, reject) => {
      axios.get(`http://172.20.10.2:7020/invoicefb/${poNo}`)
      .then((response) => {
        console.log(response);
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};



const setProject = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://172.20.10.2:7020/tracker', data, {
        headers: {
          'Content-Type': 'application/json',
        }
      })
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

// skill sending db for service side
const skill_set = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://172.28.104.19:8080/api/skill', data, {
        headers: {
          'Content-Type': 'application/json',
        }
      })
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

// invoice sending db for service side
const Invoice_set = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://172.20.10.2:7020/invoicetm/', data, {
        headers: {
          'Content-Type': 'application/json',
        }
      })
      .then((response) => {
        return resolve(response)
        console.log(response);
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};


// FB db for service side
const Fb_set = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://172.20.10.2:7020/invoicefb/', data, {
        headers: {
          'Content-Type': 'application/json',
        }
      })
      .then((response) => {
        return resolve(response)
        console.log(response);
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};


// Login
const setLogin = (data) => {
  console.log(data);
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://172.20.10.2:7020/user/', data, {
        headers: {
          'Content-Type': 'application/json',
        }
      })
      .then((response) => {
        return resolve(response)
      })
      .catch((error) => {
        return reject(error);
      });
    });
  } catch(error) {
    console.log(error);
  }
};

const apiCalls = {
  getAllProjects,
  getSingleProject,
  setProject,
  setLogin ,
  getSkill ,
  getSkill_Project,
  skill_set ,
  getimt_project,
  get_manag ,
  getInvoice_qury,
  Invoice_set,
  getInvoice_Project ,
  getFb_qury ,
  getFb_Project,
  Fb_set
};

export default apiCalls;
