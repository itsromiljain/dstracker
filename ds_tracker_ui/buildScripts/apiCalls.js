import axios from 'axios';

const getAllProjects = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://localhost:7020/tracker/')
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
const getAllsupply = () => {
  try {
    return new Promise((resolve, reject) => {
      axios.get('http://localhost:7020/supply/')
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
// const getSkill = () => {
//   try {
//     return new Promise((resolve, reject) => {
//       axios.get('http://localhost:7020/api/skill')
//       .then((response) => {
//         return resolve(response)
//       })
//       .catch((error) => {
//         return reject(error);
//       });
//     });
//   } catch(error) {
//     console.log(error);
//   }
// };

/* invoice get */
// const getInvoice_Project = () => {
//   try {
//     return new Promise((resolve, reject) => {
//       axios.get('http://172.20.10.2:7020/invoicetm/')
//       .then((response) => {
//         return resolve(response)
//       })
//       .catch((error) => {
//         return reject(error);
//       });
//     });
//   } catch(error) {
//     console.log(error);
//   }
// };

//FB
// const getFb_Project = () => {
//   try {
//     return new Promise((resolve, reject) => {
//       axios.get('http://localhost:7020/invoicefb/')
//       .then((response) => {
//         return resolve(response)
//       })
//       .catch((error) => {
//         return reject(error);
//       });
//     });
//   } catch(error) {
//     console.log(error);
//   }
// };

// const getimt_project = () => {
//   try {
//     return new Promise((resolve, reject) =>{
//       axios.get('http://localhost:7020/imts/')
//       .then((response) => {
//         return resolve(response)
//       })
//       .catch((error) => {
//         return reject(error);
//       })
//     });
//   }
//   catch(error) {
//     console.log(error);
//   }
// };
// const getAppleManager = () => {
//   try {
//     return new Promise((resolve, reject) =>{
//       axios.get('http://localhost:7020/applemgr/')
//       .then((response) => {
//         console.log(response.data)
//         return resolve(response)
//       })
//       .catch((error) => {
//         console.log(error);
//         return reject(error);
//       })
//     });
//   }
//   catch(error) {
   
//     console.log(error);
//   }
// };
// const getAppleL1Manager = () => {
//   try {
//     return new Promise((resolve, reject) =>{
//       axios.get('http://localhost:7020/getAllapplel1mgr/')
//       .then((response) => {
//         console.log(response.data)
//         return resolve(response)
//       })
//       .catch((error) => {
//         console.log(error);
//         return reject(error);
//       })
//     });
//   }
//   catch(error) {
   
//     console.log(error);
//   }
// };
const getAppleL2Manager = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/appleManager/')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getLocation = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/location')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getDemandType = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/demandType')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getLead = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/lead')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getPriority = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/priority')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getDemandStatus = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/demandStatus')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getSupplyStatus = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/supplyStatus')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getYrOfExp = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/experience')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
        return reject(error);
      })
    });
  }
  catch(error) {
   
    console.log(error);
  }
};

const getSubmittedBy = () => {
  try {
    return new Promise((resolve, reject) =>{
      axios.get('http://localhost:7020/submittedBy')
      .then((response) => {
        console.log(response.data)
        return resolve(response)
      })
      .catch((error) => {
        console.log(error);
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
      axios.get('http://localhost:7020/deliverymgr/')
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
      axios.get(`http://localhost:7020/tracker/${id}`)
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
      axios.get(`http://localhost:7020/api/skill/${psno}`)
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
      axios.get(`http://localhost:7020/invoicetm/${sow}`)
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
      axios.get(`http://localhost:7020/invoicefb/${poNo}`)
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



const setProject = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:7020/tracker', data, {
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


const setSupply = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:7020/supply', data, {
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
      axios.post('http://localhost:7020/api/skill', data, {
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
      axios.post('http://localhost:7020/invoicetm/', data, {
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


// FB db for service side
const Fb_set = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:7020/invoicefb/', data, {
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


// Login
const setLogin = (data) => {
  console.log(data);
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:7020/user/', data, {
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

//file upload
const endpoint = (data) => {
  try {
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:7020/uploadFile', data, {
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
  setSupply,
  setLogin ,
  //getimt_project,
  //get_manag ,
 // getAppleManager,
  //getAppleL1Manager,
  getAllsupply,
  getAppleL2Manager,
  getLocation,
  getDemandType,
  getLead,
  getPriority,
  getDemandStatus,
  getSupplyStatus,
  getYrOfExp,
  Fb_set,
  getSubmittedBy
};

export default apiCalls;
