import {readFile} from 'fs'; //fs 모듈은 비동기 처리가 기본.

console.log('시작');

readFile('./ex4read.txt', (err, data) => {
    if(err){
        throw err;
    }
    console.log("1번 ", data.toString());
})

readFile('./ex4read.txt', (err, data) => {
    if(err){
        throw err;
    }
    console.log("2번 ", data.toString());
})

readFile('./ex4read.txt', (err, data) => {
    if(err){
        throw err;
    }
    console.log("3번 ", data.toString());
})

console.log('끝');
