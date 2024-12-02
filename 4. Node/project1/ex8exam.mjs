//키보드로 국어, 영어 점수를 입력받아 총점 계산 후 평가
//동기식으로 처리

//npm install readline-sync => 동기식 처리 모듈
import { createRequire } from 'module';
const require = createRequire(import.meta.url);
const readlineSync = require('readline-sync');

//터미널 인코딩 - 한글 깨짐 방지
if(process.platform === "win32"){
    require('child_process').execSync('chcp 65001'); //UTF-8로 설정
}

//성적 평가 기준 함수
const getExamCategory = (total) => {
    switch (true){
        case total >= 90: return "우수";
        case total < 50: return "저조";
        default : return "보통";
    }
}

console.log("동기 입력 시작");

//키보드값 입력받기
const kor = readlineSync.question("국어 점수를 입력하세요 : ");
const eng = readlineSync.question("영어 점수를 입력하세요 : ");
console.log(`국어 : ${kor}, 영어 : ${eng}`)
const korData = parseInt(kor);
const engData = parseInt(eng);
const total = korData + engData;
const category = getExamCategory(total/2);
console.log(`총점 : ${total}, 평균 : ${total/2}, 평가 : ${category}`);

console.log("\n동기 입력 대기 완료"); 