import React from 'react';
import {Routes, Route, Link, BrowserRouter} from 'react-router-dom';

import MyTest from './mydir/Test';
import HelloAbout from './mydir/About';
import CountFriend from './mydir/Count';
import Input1 from './mydir/Input1';
import Input2 from './mydir/Input2';
import Multidata from './mydir/Multidata';
import MyProduct from './mydir/MyProduct';
import MyProduct2 from './mydir/MyProduct2';
import MyProduct3 from './mydir/MyProduct3';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <h2>라우팅 연습</h2>
      <MyTest/>
      <hr/>
      <nav>
        {/* Link 컴포넌트를 사용하여 페이지 이동을 할 수 있다. Link는 HTML의 <a> 태그와 유사하며 실제 렌더링 이후에는 <a>태그로 변경된다.*/}
        <Link to="/">Test 화면</Link>&nbsp;|&nbsp; 
        <Link to="/about">About 화면</Link>&nbsp;|&nbsp; 
        <Link to="/friend">친구추가</Link>&nbsp;|&nbsp; 
        <Link to="/input1">입력화면1</Link>&nbsp;|&nbsp; 
        <Link to="/input2">입력화면2</Link>&nbsp;|&nbsp; 
        <Link to="/multi">멀티데이터</Link>&nbsp;|&nbsp;
        <Link to="/kbs/product">상품정보(fetch)</Link>&nbsp;|&nbsp;
        <Link to="/kbs/product2">상품정보(Axios)</Link>&nbsp;|&nbsp;
        <Link to="/kbs/product3">상품정보(Axios + DB)</Link>
      </nav>
      <Routes>
        {/* Link에서 to로 설정한 path를 <Routes> 컴포넌트 태그 안의 <Route>의 path에서 받아준다. 
        그리고 element로 컴포넌트를 연결해준다. */}

        <Route path="/" element={<MyTest/>}/> 
        <Route path="/about" element={<HelloAbout/>}/>
        <Route path="/friend" element={<CountFriend/>}/>
        <Route path="/input1" element={<Input1/>}/>
        <Route path="/input2" element={<Input2/>}/>
        <Route path="/multi" element={<Multidata/>}/>
        <Route path="/kbs/product" element={<MyProduct/>}/>
        <Route path="/kbs/product2" element={<MyProduct2/>}/>
        <Route path="/kbs/product3" element={<MyProduct3/>}/>
      </Routes>
    </div>
    </BrowserRouter>
  );
}

export default App;
