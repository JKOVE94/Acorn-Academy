import http from 'http';

http.createServer((req, res) => {
    res.writeHead(200, {'Content-Type':'text/html;charset=utf-8'});
    res.write('<h1>환영합니다. 노드 가족 여러분</h1>');
    res.write('반가워요');
    res.end('<p>안녕~</p>');
})
.listen(8080, () => {
    console.log('서버 서비스중...');
});