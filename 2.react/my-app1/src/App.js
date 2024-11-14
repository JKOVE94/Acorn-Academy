import { Component } from 'react';
import Navdata from './mydir/Navdata';

//클래스 컴포넌트 (유닛화) : 
class Subject extends Component {
  render() {
    return (
      <header> {/* 루트 엘리먼트는 무조건 채워져야한다. 이름은 임의로 아무렇게 넣어줘도 된다. */}
        <h1>머리글 : 웹문서</h1>
      </header>
    )
  }
}

//자식 컴포넌트 => para는 props 객체이기 때문에 (부모로부터 할당받은 것)이기 때문에 변경할 수 없다.
//props의 prameter name은 임의로 지정할 수 있으나 통상적으로는 props로 지정한다.
const Welcom = (props) => { //js
  let kbs = "공영방송"; //js
  return ( 
    <article>
      {/* Root Elemet 밑부터는 JSX */}
      {props.who} : 글 기사 내용 <br/>
      {kbs} : {props.who}의 소속 방송사  
    </article>
  )
}

//부모 컴포넌트
function App() {
  return (
    <div className="App"> {/*  JSX 주석 */}
    연습용
      <Welcom who="홍길동"/>
      <Subject/> {/* Component 호출 */}
      <hr/>
      <Subject/>
      <Welcom who="고등어"/>
      <br/>
      <Navdata msg="부모가 정보 전달" msg2="전달2"/>
    </div>
  );
}

export default App;
