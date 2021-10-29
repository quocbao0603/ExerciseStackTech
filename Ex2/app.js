const express = require('express')
const app = express();
// const port = 81

// app.get('/', (req, res) => {
//   res.sendFile(__dirname + "/FriendList.html");
// })

// app.listen(port, () => {
//   console.log(`Example app listening at http://localhost:${port}`)
// })

//app.use("/public", express.static("public"));
const http = require('http'),
    fs = require('fs');


fs.readFile('./indexB.html', function (err, html) {
  if (err) {
      throw err; 
  }       
  http.createServer(function(request, response) {  
    console.log("server A receive");
      response.writeHeader(200, {"Content-Type": "text/html"});  
      response.write(html);  
      response.end();  
  }).listen(8081);
});

// function onRequestServerB(request, response){
//   console.log('server b receive')
//   console.log("request URL is: " + request.url);
//   //for (var i = 0; i < 2; i++){
//     switch (request.url){
//         case "/":
//         //response.writeHead(201, {"Content-Type":"text/html"});
//         fs.createReadStream("./indexB.html").pipe(response);
//         break;
//         case "/stylesB.css":
//         //response.writeHead(201, {"Content-Type":"text/css"});
//         fs.createReadStream("./stylesB.css").pipe(response);
//         break;
//     }
// }

//http.createServer(onRequestServerB).listen(8082);
http.createServer(function (req, res) {
  console.log('server B receive');
 	res.write('server B receive'); //write a response to the client
 	res.end(); //end the response
}).listen(8082); //the server object listens on port 8082
