import {useState, useEffect} from 'react';
import './App.css';
import Data from './Data';

  const App = () => {
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
useEffect(()=>{
    document.body.addEventListener('keydown', (e) => {
      let input = document.querySelector("#input");
      if(!input || document.activeElement !== input){
        if(e.keyCode == 65){
          document.querySelector("select[name='type']").value = "cm";
        }
        else if(e.keyCode == 83){
          document.querySelector("select[name='type']").value = "m";
        }

      }
    });
});


  return (
     <div className='App'>
        <h3>📐길이 환산📏</h3>
        <h4>&lt;키보드 단축키&gt; a : cm | s : m</h4>
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

export default App;
