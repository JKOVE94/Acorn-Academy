import {odd, even} from './ex3_1.mjs' // ESM문법에 따른 모듈 시스템

export const chkOddEven = (arg) => {
    if(arg % 2){
        return odd;
    }
    return even;
}
