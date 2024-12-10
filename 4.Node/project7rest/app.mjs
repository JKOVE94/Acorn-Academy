//REST API 형태의 코드 작성
import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import cors from 'cors';

const app = express();
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));
app.use(cors());

let datas = [
    {id:1, name:'오공', position:'개발자'},
    {id:2, name:'오정', position:'디자이너'},
    {id:3, name:'팔계', position:'기획자'},
]

let nextid = 4; // 아이디값을 설정하는 변수 => 자동으로 증가 설정

app.get('/', (req, res) => {
    res.send('요청을 시작합니다 abc.html, /emp, /emp/1' );
});

// 전체 자료 반환
app.get('/emp', (req, res) => {
    res.send(datas);
})

// 특정 자료 반환
app.get('/emp/:id', (req, res) => {
    const id = req.params.id;
    const employee = datas.find(data => data.id === parseInt(id, 10));
    if(!employee) return res.status(404).send('해당 자료가 없습니다.');
    res.send(employee);
})

// 자료 추가
app.post('/emp', (req, res) => {
    const newEmp = {
        id: nextid++,
        name: req.body.name,
        position: req.body.position
    }
    datas.push(newEmp);
    res.status(201).json(newEmp);
});

// 자료 수정
app.put('/emp/:id', (req, res) => {
    const id = req.params.id;
    const employee = datas.find(data => data.id === parseInt(id, 10));
    if(!employee) return res.status(404).send('해당 자료가 없습니다.');

    employee.name = req.body.name || employee.name;
    employee.position = req.body.position || employee.position;
    res.json(datas);
})

// 자료 삭제
app.delete('/emp/:id', (req, res) => {
    const id = req.params.id;
    const empIndex = datas.findIndex(data => data.id === parseInt(id, 10));
    if (empIndex === -1) return res.status(404).send('해당 자료가 없습니다.');
    const [delEmp] = datas.splice(empIndex, 1);
    res.json(datas);
    nextid-=1;
});

const startServer = () => {
    const port = app.get('port') || 80;
    app.listen(port, () => {
        console.log(`${port}번 포트에서 서버 시작`);
    }).on('error', (err) => {
        console.error(`서버 실행 오류 : ${err.message}`);
        process.exit(1); // 서버 실행 오류시 프로세스 종료 -> 코드 1번은 비정상 종료
    })
}

startServer(); // 서버 시작