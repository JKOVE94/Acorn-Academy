import React from 'react';
import './App.css';
import Home from './pages/Home';
import {Routes, Route} from 'react-router-dom';
import Member from './pages/Member';
import New from './pages/New';
import Edit from './pages/Edit';

const App = () => {
  return (
    
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/members" element={<Member />} />
        <Route path="/members/new" element={<New />} />
        <Route path="/members/:num/edit" element={<Edit />} />
      </Routes>
    </div>
  );
}

export default App;