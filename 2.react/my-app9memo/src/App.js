import React, {useState} from 'react';
import Child from './Child';

function App() {
  const [fatherAge, setFatherAge] = useState(34);
  const [childAge, setChildAge] = useState(3);

  const changeFatherAge = () => {
    setFatherAge(fatherAge + 1);
  }

  const chnageChildAge = () => {
    setChildAge(childAge + 1);
  }

  console.log("아빠 나이가 변경됨(re-rendering)");

  const boxStyle = {
    border:"1px, solid",
    padding: "10px"
  }

  return (
    <div className="App" style={boxStyle}>
      <h2>🧔‍♂️ 아빠 (신기해님) </h2>
      <div>나이 : {fatherAge}</div>
      <button onClick={changeFatherAge}>아빠 나이 +1</button>
      <hr/>
      <Child irum="신통해" nai={childAge}/> {/* 부모의 함수를 자식의 props로 전달하게 된다면 자식 컴포넌트에서 memo 함수는 작동하지 않는다. */}
      <button onClick={chnageChildAge}>아이 나이 +1</button>
    </div>
  );
}

export default App;
