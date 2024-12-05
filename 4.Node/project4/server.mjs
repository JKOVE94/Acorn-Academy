import express from 'express';
import mariadb from 'mariadb';
import path from 'path';
import { fileURLToPath } from 'url';
import cors from 'cors';

const __filename = fileURLToPath(import.meta.url); //현재 실행 중인 파일의 경로
const __dirname = path.dirname(__filename); //현재 실행 중인 파일까지의 디렉토리
const app = express();

app.set('port', process.env.PORT || 3001); 

const dbpool = mariadb.createPool({
    host: '127.0.0.1',
    user: 'root',
    password: 'jkove1994',
    database: 'test',
    port:3306,
    connectionLimit: 5, // 최대 5개의 커넥션
})

app.use(express.json());
app.use(cors());
app.use(express.static(path.join(__dirname, 'public')));

// sangdata 테이블 자료 읽기
app.get('/sangdata', async (req, res) => {
    try {
         const conn = await dbpool.getConnection();
         const query = 'SELECT * FROM sangdata';
         const sangpums = await conn.query(query);
         res.json(sangpums);
       
    } catch (err) {
        res.status(500).json({err:'서버에서 에러 발생 : 요청한 서버 파일 오류'});
    }
})

app.get('/sangtable', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'select.html'));
}) 

//에러를 처리하는 미들웨어는 가장 마지막에 위치하는것이 좋다.
app.use((req,res, next) => {
    res.status(404).send('요청한 페이지를 찾을 수 없습니다.');
    // next(); 미들웨어간의 흐름을 제어하는 콜백 함수 => 다음 미들웨어로 넘어가게 함
});

app.use((err, req,res, next) => {
    console.error(err.stack);
    res.status(500).send('서버에서 에러 발생 : 요청한 서버 파일 오류');
    // next(); 미들웨어간의 흐름을 제어하는 콜백 함수 => 다음 미들웨어로 넘어가게 함
});

app.listen(app.get('port'), () => {
    console.log(app.get('port'),'번 포트에서 웹 서버 서비스 시작');
})
