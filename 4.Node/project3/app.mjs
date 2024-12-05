import cors from 'cors';
import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
app.use(cors());
app.use(express.json()); //json parsing middleware 추가
app.set('port', process.env.PORT || 3000); 

import gogekRouter from './routes/gogek.mjs';
import jikwonRouter from './routes/jikwon.mjs';

// 정적 파일 디렉토리 정의
// public 디렉토리 내부의 파일들은 브라우저에서 직접 접근이 가능하다.
app.use(express.static(path.join(__dirname, 'public')));

app.use('/gogek', gogekRouter);
app.use('/jikwon', jikwonRouter);


app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 웹 서버 서비스 시작');
});