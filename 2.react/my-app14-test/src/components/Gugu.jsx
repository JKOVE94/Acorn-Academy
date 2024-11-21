import React, {useState} from 'react'
import GuguResult from './GuguResult';

const Gugu = () => {
    const [gugu, setGugu] = useState(0);
    const makeGugu = (e) => {
        if(e.keyCode === 13){
             if(e.target.value <= 0 || isNaN(e.target.value)){
            alert('1 이상의 숫자를 입력해주세요');
            e.target.value = '';
            return;
        }
            setGugu(e.target.value);
            e.target.value = '';
        }
    }

    const handleClick = () => {
        let inputValue = document.getElementById("num").value;
          if(inputValue <= 0 || isNaN(inputValue)){
            alert('1 이상의 숫자를 입력해주세요');
            inputValue = '';
            return;
        }
            setGugu(inputValue);
            inputValue = '';
        
    }

    return(
        <div>
            <h2>구구단</h2>
            <label htmlFor='num'>단입력: </label>
            <input type='text' id="num" placeholder='숫자를 입력하세요' onKeyDown={makeGugu}/>&nbsp;
            <button onClick={handleClick}>확인</button>
            <GuguResult gugu={gugu}/>
        </div>
    )
}

export default Gugu;
