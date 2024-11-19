import React from 'react';
import { useState } from 'react';

const Input2 = () => {
    const [params, setParmas] = useState({
        irum: "",
        nai: "",
        juso: ""
    });
    
    const {irum, nai, juso} = params;

    const changeFunc = data => {
        const id = data.target.id;
        const value = data.target.value;
            setParmas({
                //깊은 복사 : ...params (구조분해 할당:destructuring assignment => spread 연산자)
                //깊은 복사는 기존 객체를 변경하지 않고 새로운 객체를 생성하는 방법
                ...params,
                //동적으로 객체의 값을 변경
                [id]: value
            });
    };

    return(
        <div>
            <br/>
            <div>
                이름 : <input type='text' id='irum' name='irum' value={irum} onChange={changeFunc}/><br/>
                나이 : <input type='text' id='nai' name='nai' value={nai} onChange={changeFunc}/><br/>
                주소 : <input type='text' id='juso' name='juso' value={juso} onChange={changeFunc}/><br/>
            </div>
        <br/>
        <table border="1">
            <tr>
                <td>이름 : {irum}</td>
                <td>나이 : {nai}</td>
                <td>주소 : {juso}</td>
            </tr>
        </table>
        </div>
    );
};

export default Input2;