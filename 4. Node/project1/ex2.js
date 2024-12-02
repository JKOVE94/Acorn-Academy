const {odd, even} = require('./ex2_1'); // require 함수를 사용하여 다른 모듈을 불러올 수 있다. => CommonJs 문법에 따른 모듈 시스템
const chkNumber = require('./ex2_2'); // require 함수를 사용하여 다른 모듈을 불러올 수 있다. => CommonJs 문법에 따른 모듈 시스템

function chkStringShow(ss){
    if(ss.length % 2){
        return odd;
    }
    return even;
}

console.log(chkNumber(3));
console.log(chkNumber(4));
console.log(chkStringShow("good"));
console.log(chkStringShow("abc"));