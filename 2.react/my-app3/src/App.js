import React from 'react';
import './App.css';
import {useState, useEffect} from 'react';
import HookTest from './mydir/hooktest';
import HookTest2 from './mydir/hooktest2';

/*
------------- Class Type -------------

class App extends Component {
  state = {
    count: 0, //지역 변수 : state 상태 변수 - 컴포넌트 내부에서 사용(관리)하는 동적인 데이터  값을 JSON 형태로 저장
  }

  countUpdate(n){
    this.setState({count : n});
  }

  render() {
    const {count} = this.state;
    return (
      <div>
        <h2>지역변수 State</h2>
        number : {count} &nbsp;&nbsp;
        <button onClick={() => this.countUpdate(count + 1)}>증가 1</button> 실행할때에 Virtual DOM이 업데이트 되어 Rerendering이 되어 DOM에 반영되고 화면이 다시 그려짐  
        <hr/>
        <HookTest/>
        <hr/>
        <HookTest2/>
      </div>
    );
  }
}
*/

//------------- function Type ------------- 코드의 길이가 확연히 줄어듬
const App = () => {
  const [count, setCount] = useState(0);
  const countUpdate = (n) => setCount(n);

  //컴포넌트가 렌더링될때 마다 실행
  useEffect(() => {
    let a = 1;
    console.log(a);
  },[]); //[]는 의존성 배열을 의미함. 의존성 배열이 비어있으면 최초 한번만 실행됨

    return (
      <div className="App">
        <h2>지역변수 State (함수형)</h2>
        number : {count} &nbsp;&nbsp;
        <button onClick={() => countUpdate(count + 1)}>증가 1</button> {/*실행할때에 Virtual DOM이 업데이트 되어 Rerendering이 되어 DOM에 반영되고 화면이 다시 그려짐*/}  
        <hr/>
        <HookTest/>
        <hr/>
        <HookTest2/>
      </div>
    )
}

export default App;
