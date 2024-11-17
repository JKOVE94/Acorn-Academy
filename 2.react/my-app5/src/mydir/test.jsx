import {useState} from 'react';
//https://cafe.daum.net/flowlife/QbpR/68 문제

const Test = () => {
    const [data, setData] = useState("");
    const calc = () => {
        const mType = document.querySelector("select[name='type']").value;
        let data = document.querySelector("#input").value;
        let text;
        if (isNaN(data)) text="숫자만 입력해주세요.";
        else{

            if(data.trim()=="") text=" 값을 입력해주세요.";
            else{
                if(mType==='cm'){
                    text = `미터 : ${(data/100).toFixed(5)}m / 센티미터 : ${data}cm`;
                }
                else text = `미터 : ${data}m / 센티미터 : ${Math.round(data*100)}cm`;
            }
        }
        setData(text);
    }

const handleKey = (e) => {
    if(e.keyCode === 13) {
        calc();
    }
}

const changeMode = (e) => {
    if(e.keyCode === 49) {
        alert('a')
    }
}

    return (
        <div id="body" onKeyDown={changeMode}>
        <h3>📐길이 환산📏</h3>
        <select name="type">
            <option value="cm">cm</option>
            <option value="m" selected>m</option>
        </select>&nbsp;
        <input type="text" id="input" onKeyDown={handleKey}></input> <button type="button" onClick={e=>{
            e.preventDefault();
            calc();
        }}>계산</button><br/>
        {data}
        </div>     
    );

}
export default Test;