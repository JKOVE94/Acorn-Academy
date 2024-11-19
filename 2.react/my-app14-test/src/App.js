import './App.css';
import React from 'react';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import Gugu from './components/Gugu';
import Jikwon from './components/Jikwon';
import Main from './components/Main';


function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <div>
      <Link to="/">메인화면</Link>&nbsp;|&nbsp;
      <Link to="/gugu">구구단</Link>&nbsp;|&nbsp;
      <Link to="/jikwon">직원자료</Link>
    </div>
    <Routes>
      <Route path="/" element={<Main/>}/>
      <Route path="/gugu" element={<Gugu/>}/>
      <Route path="/jikwon" element={<Jikwon/>}/>
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
