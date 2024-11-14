import React, { Component } from 'react';
import MyName from './mydir/MyName';
import MyNickName from './mydir/MyName2';


function App() {
  return (
    <div className="App">
       <h2>props 연습 - Class</h2>
       <MyName name='홍길동' type='props 입력'/>
       <MyName name='한가해' type='props 입력' addr='강남구 역삼동'/>
       <MyName />
       <br/>
       <MyNickName/><br/>
        <MyNickName name='홍길동' type='props 입력'/>
        <br/>
        <hr/>
    </div>
  );
}
  
/*
class App extends Component{
  render(){
    return(
      <div className="App">
       <h2>props 연습 - Class</h2>
       <MyName name='홍길동' type='props 입력'/>
       <MyName name='한가해' type='props 입력' addr='강남구 역삼동'/>
       <MyName />
       <br/>
       <MyNickName/><br/>
        <MyNickName name='홍길동' type='props 입력'/>
        <br/>
        <hr/>
    </div>
    )
  }
}
*/
export default App;