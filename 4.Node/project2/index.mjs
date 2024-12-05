import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url'; //파일 url을 파일 시스템 경로로 변환해 주는 역할 
//ex) const url = 'file:///c:/path/abc.txt';
//    const filePath = fileURLToPath(url); // c:/path/abc.txt
//    console.log(filePath); c:/path/abc.txt

//CORS 문제 해결 (교차 출처 리소스 공유), SOP(Same Origin Policy) 정책
// npm install cors
import cors from 'cors';

const app = express();
app.use(cors()); //모든 도메인에 대해 허용
//미들웨어를 활성화

// const corsOption = {
//   origin: 'http://127.0.0.1:80', //허용할 도메인
//   methods: ['GET', 'POST', 'PUT'], //허용할 메소드
// };
// app.use(cors(corsOption)); //특정 도메인에 대해 허용

//환경변수 설정 env(environment) => 환경변수 포트가 존재할 시 해당 포트를 사용 아니면 3000번 포트 사용
app.set('port', process.env.PORT || 3000); 

//__dirname, __filename은 ES6에서 지원하지 않음
//__dirname을 esm환경에서 사용하는 방법

const __filename = fileURLToPath(import.meta.url); //현재 실행 중인 파일의 경로
const __dirname = path.dirname(__filename); //현재 실행 중인 파일까지의 디렉토리

app.get('/', (req, res) => {
  res.send('Hello World');
})

app.get('/java', (req, res) => {
  res.send('<h2>Hello Java</h2>'); //노드가 파싱
})

app.get('/node', (req, res) => {
  res.send('<a href="https://cafe.daum.net/flowlife">학습장</a>');
})

app.get('/json', (req, res) => {
  res.json({"겨울":'첫눈은 이미 경험'});
})

app.get('/file', (req, res) => {
  const filePath = path.join(__dirname, 'abc.html');
  res.sendFile(filePath);
})

app.get('/user/:bun/:irum', (req, res) => {
  const {bun, irum} = req.params; //파라미터를 받는 방법
  res.json({bun,irum});
})

app.get('/user/:season', (req, res) => {
  const {season} = req.params; //파라미터를 받는 방법
  if(season==='summer'){
    res.json({'season':'더워'}); }
  else if(season==='winter'){
    res.json({'season':'행복해'}); }
  else{
    res.json({'season':'만족해'});
  }
  })    

app.get('/test', (req, res) => {
  const filePath = path.join(__dirname, 'test.html');
  res.sendFile(filePath);
})

// console.log('웹 서버 서비스 시작');
// app.listen(3000)

// 위의 코드와 동일하지만 콜백함수를 사용함
app.listen(app.get('port'), () => {
    console.log(app.get('port'),'번 포트에서 웹 서버 서비스 시작');
})