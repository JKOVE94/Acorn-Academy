import fs from 'fs'

fs.readFile('./ex4read.txt', (err, data) => {
    if(err){
        throw err;
    }
    console.log(data.toString());
})

// promise 형식으로 읽기
//fs는 기본이 콜백이다. promise로 바꾸려면 promises를 사용한다.
import { promises as pfs } from 'fs';

pfs.readFile('./ex4read.txt')
.then((data) => {
    console.log(data.toString());
})
.catch((err) => {
    console.error(err);
});
console.log('------Write, Read------');

import { promises as wfs } from 'fs';
const str = "텍스트 문서를 저장. 작성자: 사오정";
wfs.writeFile('./ex4write.txt', str)
    .then(() => {
        wfs.readFile('./ex4write.txt')
        .then((data) => {
            console.log(data.toString());
        })
        .catch((err) => {
            console.error(err);
        });
    })