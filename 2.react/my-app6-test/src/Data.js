import React, { useState, useEffect } from 'react';

function Data() {
  const [meter, setMeter] = useState("");
  const [cmeter, setCmeter] = useState("");

  const onChange = (e) => {
    if(e.keyCode == 13){
        setMeter(e.target.value);
    }
};

useEffect(()=>{
    setCmeter(meter * 100); // meter 값을 센티미터로 변환하여 cmeter에 저장
  },[meter])

  return (
    <div className="App">
      <h2><strong>📐길이 환산📏</strong></h2>
      <input
        type='text'
        id='meter'
        onKeyDown={onChange}
        placeholder="미터 입력"
      />
      <button>계산</button>
      {cmeter && ( // cmeter에 값이 있을 때만 보여주기
        <div id="data">
          미터 : {meter} / 센티미터 : {cmeter}
        </div>
      )}
    </div>
  );
}

export default Data;