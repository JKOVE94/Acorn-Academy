import React, {useEffect} from 'react';
import {Link, BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './components/Home';
import AllInfo from './components/AllInfo';
import AddActivity from './components/AddActivity';
import EditActivity from './components/EditActivity';
import './App.css'
import axios from 'axios';
import {useSelector, useDispatch} from 'react-redux';
import {SET_DATA} from './redux/resourceSlice';
import Login from './components/user/Login';

const App = ()  => {


  return (
    <div className="App">
    <BrowserRouter>
    <Link to="/">홈</Link>&nbsp;|&nbsp;
    <Link to="/allInfo">전체자료 출력</Link> &nbsp;|&nbsp;
    <Link to="/addActivity">운동정보 등록</Link> &nbsp;|&nbsp;
    <Link to="/editActivity/:id">칼로리소모량 수정</Link>

    <Routes>
      <Route path="/" element={<Login/>}/>
      <Route path="/allInfo" element={<AllInfo/>}/>
      <Route path="/addActivity" element={<AddActivity/>} />
      <Route path="/editActivity/:id" element={<EditActivity/>} />
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
