import express from 'express';
import path from 'path';
import webpack from 'webpack';
import bodyParser from 'body-parser';
import url from 'url';
import config from '../webpack.config.dev';
import apiCalls from './apiCalls';
const port = 3000;
const app = express();
const compiler = webpack(config);

app.use(bodyParser.json()); // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true })); // support encoded bodies

app.use(require('webpack-dev-middleware')(compiler, {
  publicPath  : config.output.publicPath,
  noInfo      : false,
}))

app.listen(port, function (error) {
    if(error) {
      console.log(error);
    } else {
      console.log('App connected to 3000');
    }
});

/*-----------Project track -----------*/
// Get projects
app.get('/api/getproject', async function(req, res) {
  const url_parts = url.parse(req.originalUrl, true);
  const query = url_parts.query;
  const response = await apiCalls.getSingleProject(query);
  res.send(response.data);
  res.end();
});
app.get('/api/getprojects', async function(req, res) {
  const response = await apiCalls.getAllProjects();
  res.send(response.data);
  res.end();
});
// Add or edit demand
app.post('/api/new', async function(req, res) {
  const response = await apiCalls.setProject(req.body);
  res.send(response.status);
  res.end();
});



app.get('/api/getAllsupply', async function(req, res) {
  const response = await apiCalls.getAllsupply();
  res.send(response.data);
  res.end();
});
// Add or edit Supply
app.post('/api/newSupply', async function(req, res) {
  const response = await apiCalls.setSupply(req.body);
  res.send(response.status);
  res.end();
});

//Upload file
app.post('/api/endpoint', async function(req, res) {
  const response = await apiCalls.endpoint(req.body);
  res.send(response.status);
  res.end();
});

// imt related
// app.get('/api/get_imt', async function(req, res){
//   const response = await apiCalls.getimt_project();
//   res.send(response.data);
//   res.end();
// });

// Delivery manager
app.get('/api/get_delvery_mange', async function(req, res){
  const response = await apiCalls.get_manag();
  res.send(response.data);
  res.end();
})

// Apple manager
app.get('/api/getAppleManager', async function(req, res){
  const response = await apiCalls.getAppleManager();
  res.send(response.data);
  res.end();
})
app.get('/api/getAppleL1Manager', async function(req, res){
  const response = await apiCalls.getAppleL1Manager();
  res.send(response.data);
  res.end();
})
app.get('/api/getAppleL2Manager', async function(req, res){
  const response = await apiCalls.getAppleL2Manager();
  res.send(response.data);
  res.end();
})

//Location
app.get('/api/getLocation', async function(req, res){
  const response = await apiCalls.getLocation();
  res.send(response.data);
  res.end();
})

//Demand Type
app.get('/api/getDemandType', async function(req, res){
  const response = await apiCalls.getDemandType();
  res.send(response.data);
  res.end();
})

//Lead
app.get('/api/getLead', async function(req, res){
  const response = await apiCalls.getLead();
  res.send(response.data);
  res.end();
})

//Priority
app.get('/api/getPriority', async function(req, res){
  const response = await apiCalls.getPriority();
  res.send(response.data);
  res.end();
})

//Demand Status
app.get('/api/getDemandStatus', async function(req, res){
  const response = await apiCalls.getDemandStatus();
  res.send(response.data);
  res.end();
})

//Supply Status
app.get('/api/getSupplyStatus', async function(req, res){
  const response = await apiCalls.getSupplyStatus();
  res.send(response.data);
  res.end();
})

//Year of experience
app.get('/api/getYrOfExp', async function(req, res){
  const response = await apiCalls.getYrOfExp();
  res.send(response.data);
  res.end();
})

//Submitted By in Supply
app.get('/api/getSubmittedBy', async function(req, res){
  const response = await apiCalls.getSubmittedBy();
  res.send(response.data);
  res.end();
})


//File upload
app.post('/upload', (req, res, next) => {
  let uploadFile = req.files.file
  const fileName = req.files.file.name
  uploadFile.mv(
    `${__dirname}/public/files/${fileName}`,
    function (err) {
      if (err) {
        return res.status(500).send(err)
      }

      res.json({
        file: `public/${req.files.file.name}`,
      })
    },
  )
})

/* -------- Skill ---------  */

/* get query for  skill project */
/*
app.get('/api/getskill', async function(req, res) {
  const url_parts = url.parse(req.originalUrl, true);
  const query = url_parts.query;
  const response = await apiCalls.getSkill_Project(query);
  res.send(response.data);
  res.end();
});

// get skill
app.get('/api/getskill_projects', async function(req, res) {
  const response = await apiCalls.getSkill();
  res.send(response.data);
  res.end();
});

// skill for sending db service side
app.post('/api/skill_new', async function(req, res) {
  const response = await apiCalls.skill_set(req.body);
  res.send(response.status);
  res.end();
});
*/

// Login
app.post('/api/login', async function(req, res) {
  const response = await apiCalls.setLogin(req.body);
  res.send(response.status);
  res.end();
});

app.use('/', function (req, res, next) {
if (!req.originalUrl.includes('/api')) {
  const filename = path.join(compiler.outputPath, 'index.html')
  compiler.outputFileSystem.readFile(filename, (err, result) => {
    if (err) {
      return next(err)
    }
    res.set('content-type', 'text/html')
    res.send(result)
    res.end()
  })
}
return null;
});
