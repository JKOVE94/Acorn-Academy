import {even, odd} from './ex3_1.mjs';
import {chkOddEven} from './ex3_2.mjs';


const chkStringShow = (ss) => {
    if(ss.length % 2){
        return odd;
    }
    return even;
}

console.log(chkOddEven(3));
console.log(chkOddEven(4));
console.log(chkStringShow("good"));
console.log(chkStringShow("abc"));