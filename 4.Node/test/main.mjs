import fs from 'fs';
const str = "노드여 영원하라";

fs.writeFile('./example.txt', str, (err) => {
    if (err) {
        console.log('실패');
    } else {
        console.log('성공');
    }
});