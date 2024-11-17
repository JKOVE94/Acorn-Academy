/* eslint-disable */
import './App.css';
import {useState} from 'react';
import Test from './mydir/test';

function App() {
  let irum = "대현이의 JSX 사용법";
  let title = "이건 title"; //지역변수

  const [jemok, setJemok] = useState("자바스크립트"); //sate에는 객체, 배열, 문자열, 숫자, 불리언 등이 들어갈 수 있다.
  const [jemok2, setJemok2] = useState(["리액트", "자바"]); //sate에는 객체, 배열, 문자열, 숫자, 불리언 등이 들어갈 수 있다.

  //이벤트 처리용 함수 (내부함수)
  const dataUpdate = () => {
    setJemok("vue.js");
    //이렇게 바꿔도 화면이 바뀌지 않는다. 왜냐하면 React는 state나 props가 변경 되었을 때에만 Virtual DOM을 Re-rendering하기 때문이다.
    title = "타이틀을 바꾸자.";
  }

  const dataUpdate2 = () => {
    let newArr = [...jemok2]; //전개 연산자
    console.log(newArr)
    newArr[1] = "백엔드 프로그램의 왕";
    setJemok2(newArr); //state를 사용했기 떄문에 Re-rendering이 된다.
  }

  //이벤트 처리 계속
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <div className="redbar">
        <h2>리액트의 이해</h2>
      </div>
        <div className="list">
          <h3>이름 : {irum}</h3>
          <p>스테이트 변수 확인</p>
          
          <span>일반변수 : <b>{title}</b></span> &nbsp;&nbsp;
          <span>state : <b>{jemok}</b></span> &nbsp;&nbsp;
          <button onClick={dataUpdate}>title, jemok 변경</button>
          <hr/>
          <div>
            {jemok2[0]}<br/>
            {jemok2[1]}<br/>
            <button onClick={dataUpdate2}> 배열데이터인 jemok2 변경</button>
            <br/><br/>
            그림 클릭 : <span onClick={()=>{setCount(count+1)}}><a href="#">👍</a></span>
            <span>{count}</span>
          </div>
        </div>
            <Test/>
        
    </div>
  );
}

export default App;
