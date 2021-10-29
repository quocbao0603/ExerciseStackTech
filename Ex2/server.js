var http = require('http');
//create a server object:
http.createServer(function (req, res) {
	res.write('Server-a receive'); //write a response to the client
	res.end(); //end the response
}).listen(8081); //the server object listens on port 8081
console.log('server a started')

//create a server object:
http.createServer(function (req, res) {
	res.write('Server-b receive'); //write a response to the client
	res.end(); //end the response
}).listen(8082); //the server object listens on port 8081
console.log('server b started')
