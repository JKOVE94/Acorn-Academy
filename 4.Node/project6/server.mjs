import express from 'express';
import session from 'express-session';
// import bodyParser from 'body-parser';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
app.set('port', process.env.PORT || 3001);
// app.use(express.urlencoded({ extended: true }));
// app.use(express.json());
app.use(express.urlencoded({extended: true})); // JSON 파싱, 간단한 구조일 경우에는 flase, 복잡한 구조일 경우에는 true / 성능상으로는 false가 더 좋음
// app.use(bodyParser.json()) // 요청을 JSON으로 파싱 
// app.use(bodyParser.urlencoded({extended: false}))
app.use(session({
    secret: 'secret-key', // 세션 암호화 키
    resave: false, // 세션을 항상 저장할지 여부 (수정할지 안할지)
    saveUninitialized: true, // 초기화되지 않은 세션을 저장할지 여부
    cookie: {
        maxAge: 30 * 60 * 1000 // 세션 유효시간 30분
    }
}))

app.set('view engine', 'ejs'); //ejs를 템플릿 엔진으로 설정
app.set('views', path.join(__dirname, 'views')); //views 디렉토리 설정

const auth ={
    id:'kor',
    password:'111'
}

app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'login.html'));
})

app.post('/login', (req, res) => {
    const {id, password} = req.body;
    if(id === auth.id && password === auth.password){
        req.session.user = id; //Session에 id 저장
        res.redirect('/main');
    }
    else {
        res.send('로그인 실패 <a href="/">다시 로그인하기</a>');
    }
})

app.get('/main', (req, res) => {
    if(req.session.user){
        res.render('mymain', {sessionId: req.sessionID}) // mymain.ejs 렌더링 => foward 방식
    }else{
        res.send('접근 권한이 없습니다. <a href="/">로그인하기</a>');
    }
})

app.get('/logout', (req, res) => {
    req.session.destroy(err => {
        if(err) return res.redirect('/main');
        else res.clearCookie('connect.sid'); //세션 쿠키 삭제 => 쿠기에 저장된 세션아이디는 connect.sid에 저장됨
    }); //세션 삭제
    res.redirect('/');
})

app.listen(app.get('port'), () => {
    console.log(app.get('port'),'번 포트에서 웹 서버 서비스 시작');
});