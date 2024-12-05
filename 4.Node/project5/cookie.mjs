import express from 'express';
import mariadb from 'mariadb';
import path from 'path';
import { fileURLToPath } from 'url';
import cors from 'cors';

const __dirname = path.dirname(fileURLToPath(import.meta.url)); //현재 실행 중인 파일까지의 디렉토리
const app = express();

app.set('port', process.env.PORT || 3001);

const conn = mariadb.createConnection({
    host: '127.0.0.1',
    user: 'root',
    password: 'jkove1994',
    database: 'test',
    port:3306,
    connectionLimit: 5, // 최대 5개의 커넥션
})

app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

app.get("/", (req, res) => {
    console.log(req.url, ' ', req.headers.cookie);
    res.cookie('mycookie', 'test', {httpOnly: true, secure: true, maxAge: 60 * 60 * 1000})
    res.send('Hello Cookie');
});

app.get('/login', (req, res) => {
    const {name} = req.query; //request의 query에서 name을 가져옴
    if(name){
        res.cookie('name', name, {httpOnly: true, secure: true}); //set Cookie
        res.send(`<b>${name}님 로그인 성공</b>`);
    }
    else{
        res.status(400).send('<b>이름을 입력하세요</b>');
    }
});

app.listen(app.get('port'), () => {
    console.log(app.get('port'),'번 포트에서 웹 서버 서비스 시작');
});