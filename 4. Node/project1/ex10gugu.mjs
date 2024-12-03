//키보드로 단을 입력받아 구구단을 출력하는 프로그램
import { EventEmitter } from 'events';
import readline from 'readline';

const inout = readline.createInterface({
    input: process.stdin, //표준 입력장치
    output: process.stdout //표준 출력장치
})

const printGugudan = (dan) => {
    console.log(`\n구구단 ${dan}단 출력`);
    for(let i=1; i<=9; i++){
        console.log(`${dan} X ${i} = ${dan*i}`);
    }
}

const myEvent = new EventEmitter();

myEvent.on('gugudan', () => {
    inout.question("단을 입력하세요 : ", (danInput) => {
        const dan = parseInt(danInput, 10);
        if(!isNaN(dan)) printGugudan(dan); //10진수 정수로 반환
        else console.log("단을 정확히 입력하세요");
        inout.close(); //닫지 않으면 무한 루프에 빠짐
    })
})

myEvent.emit('gugudan');