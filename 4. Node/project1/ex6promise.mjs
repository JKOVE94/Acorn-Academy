import {promises as fs} from 'fs';

console.log('시작');

fs.readFile('./ex4read.txt')
    .then((data) => {
        console.log("1번 ", data.toString());
        return fs.readFile('./ex4read.txt');
    })
    .then((data) => {
        console.log("2번 ", data.toString());
        return fs.readFile('./ex4read.txt');
    })
    .then((data) => {
        console.log("3번 ", data.toString());
    })
    .catch((err) => {
        console.error("err : " + err);
})

console.log('끝');