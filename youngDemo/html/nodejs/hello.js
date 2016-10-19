console.log(__dirname);//输出文件目录
console.log(__filename);

var http = require('http');
http.createServer(function(req,res){
    res.writeHead(301,{
        'Location':'Http://www.z.cn'
    });
    res.end("helloword\n");
}).listen(3000,"127.0.0.1");
console.log("Server funning at http://127.0.0.1:3000");

var EventEmitter= require('events').EventEmitter;
var test = new EventEmitter();
test.emit('msg','the message send by node');