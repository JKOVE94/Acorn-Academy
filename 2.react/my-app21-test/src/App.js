import React from 'react';
import {Link, BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './components/Home';
import AllInfo from './components/AllInfo';
import AddActivity from './components/AddActivity';
import EditActivity from './components/EditActivity';
import './App.css'

const App = ()  => {
  return (
    <div className="App">
    <BrowserRouter>
    <Link to="/">홈</Link>&nbsp;|&nbsp;
    <Link to="/allInfo">전체자료 출력</Link> &nbsp;|&nbsp;
    <Link to="/addActivity">운동정보 등록</Link> &nbsp;|&nbsp;
    <Link to="/editActivity">칼로리소모량 수정</Link>

    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/allInfo" element={<AllInfo/>}/>
      <Route path="/addActivity" element={<AddActivity/>} />
      <Route path="/editActivity" element={<EditActivity/>} />
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
