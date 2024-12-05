import { Router } from "express";
import path from 'path';
import { fileURLToPath } from 'url';

const empoyees = [
    {id:1, name:'홍길동'},
    {id:2, name:'김철수'},
    {id:3, name:'이영희'},
]

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const router = Router(); // Router 객체 생성

router.get('/', (req, res) => {
    // res.send('안녕하세요! 직원 여러분!')
    res.sendFile(path.join(__dirname, '../public/abc.html'));
})

router.get('/nice', (req, res) => {
    res.send('반갑습니다 직원님!')
})

router.get('/employees', (req, res) => {
    res.json(empoyees);
})

router.post('/employees', (req, res) => {
    const newEmployee = req.body;
    if(!newEmployee || !newEmployee.name){
        return res.status(400).json({error: '직원자료 이름을 입력하세요'})
    }
    empoyees.push(newEmployee);
    res.status(201).json(empoyees); // 201은 Created를 의미
})

export default router;