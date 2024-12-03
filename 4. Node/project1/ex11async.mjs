// 노드는 비동기 기반 이벤트 처리를 지원한다. => 이벤트 루프 기반
// 파일 읽기, 웹 문서 읽기를 비동기 처리
// 이벤트 루프 기반으로 비동기 처리를 하기 때문에 이벤트 루프가 종료되면 프로그램이 종료된다.
// 이벤트 루프가 종료되지 않도록 하기 위해 setInterval() 함수를 사용한다.

import {readFile} from 'fs';
import { EventEmitter } from 'events';

const fileEvent = new EventEmitter();

//파일 읽기
fileEvent.on('readfile', (filePath) => {
    readFile(filePath, 'utf8', (err, data) => {
        if(err) return console.log("파일 읽기 오류 : "+err);
        console.log(data);
    })
})

fileEvent.emit('readfile', 'ex4read.txt');
fileEvent.emit('readfile', 'ex4write.txt');

console.log("비동기 처리로 웹문서 읽기 -----------------");
import https from 'https';
const webEvent = new EventEmitter();

webEvent.on('fetchData', () => {
    https.get('https://jsonplaceholder.typicode.com/posts/1', (resp) => {
        let data = '';
        resp.on('data', (chunk) => { //chunk 단위로 읽기
            data += chunk;
            console.log('Chunk data : ', data);
        })
        resp.on('end', () => {
            try{
                console.log('data 확인 : '+ data);
                //문자열을 JSON 객체로 변환
                const jsonData = JSON.parse(data);
                console.log('JSON화 한 data : '+ jsonData);
            }
            catch(err){
                console.log("에러 발생 : "+err);
            }
        })
    }).on('error', (err) => {
        console.log("에러 발생 : "+err.message);
    })
});
webEvent.emit('fetchData');