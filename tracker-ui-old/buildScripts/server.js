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

// Add or edit Projects
app.post('/api/new', async function(req, res) {
  const response = await apiCalls.setProject(req.body);
  res.send(response.status);
  res.end();
});

// imt related
app.get('/api/get_imt', async function(req, res){
  const response = await apiCalls.getimt_project();
  res.send(response.data);
  res.end();
});

// Delivery manager
app.get('/api/get_delvery_mange', async function(req, res){
  const response = await apiCalls.get_manag();
  res.send(response.data);
  res.end();
})


/* -------- Invoice ---------  */
/* get query for  Invoice project */
app.get('/api/getInvoice', async function(req, res) {
  const url_parts = url.parse(req.originalUrl, true);
  const query = url_parts.query;
  const response = await apiCalls.getInvoice_qury(query);
  res.send(response.data);
  res.end();
});

// get Invoice
app.get('/api/getInvoice_projects', async function(req, res) {
  const response = await apiCalls.getInvoice_Project();
  res.send(response.data);
  res.end();
});

// Invoice for sending db service side
app.post('/api/Invoice_new', async function(req, res) {
  const response = await apiCalls.Invoice_set(req.body);
  res.send(response.status);
  res.end();
});

/* --------Invoice FB ---------  */

//FB
app.get('/api/getFb', async function(req, res) {
  const url_parts = url.parse(req.originalUrl, true);
  const query = url_parts.query;
  const response = await apiCalls.getFb_qury(query);
  res.send(response.data);
  res.end();
});

// get FB
app.get('/api/getInvoice_fb', async function(req, res) {
  const response = await apiCalls.getFb_Project();
  res.send(response.data);
  res.end();
});

// FB for sending db service side
app.post('/api/Fb_new', async function(req, res) {
  const response = await apiCalls.Fb_set(req.body);
  res.send(response.status);
  res.end();
});

/* -------- Skill ---------  */

/* get query for  skill project */
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
