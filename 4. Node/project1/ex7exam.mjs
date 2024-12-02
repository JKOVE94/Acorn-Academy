//키보드로 국어, 영어 점수를 입력받아 총점 계산 후 평가
import readline from 'readline'; // 키보드로 값을 받을 수 있는 모듈 => 비동기 논 블로킹 방식

//성적 평가 기준 함수
const getExamCategory = (total) => {
    switch (true){
        case total >= 90: return "우수";
        case total < 50: return "저조";
        default : return "보통";
    }
}

const rdata = readline.createInterface({
    input: process.stdin, //system input
    output: process.stdout //system output
})

console.log("비동기 입력 시작");

rdata.question("국어 점수를 입력하세요 : ", (kor) => {
    rdata.question("영어 점수를 입력하세요 : ", (eng) => {
        console.log(`국어 : ${kor}, 영어 : ${eng}`)

        const korData = parseInt(kor);
        const engData = parseInt(eng);
        const total = korData + engData;
        const category = getExamCategory(total/2);
        console.log(`총점 : ${total}, 평균 : ${total/2}, 평가 : ${category}`);
        rdata.close();
    })
});

console.log("\n비동기 입력 대기 완료"); 