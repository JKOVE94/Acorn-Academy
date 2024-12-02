const {odd, even} = require('./ex2_1'); // require 함수를 사용하여 다른 모듈을 불러올 수 있다. => CommonJs 문법에 따른 모듈 시스템

function chkOddEven(arg){
    if(arg % 2){
        return odd;
    }
    return even;
}

module.exports = chkOddEven; // CommonJs module => CommonJs문법에 따른 모듈 / ES6 이전의 모듈 시스템