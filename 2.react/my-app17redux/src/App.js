import React from 'react';
import Parent from './mydir/Parent';


function App() {
  return (
    <div className="App">
      <h1>* 자식 컴포넌트 간 자원 공유 *</h1>
      <Parent />
    </div>
  );
}

export default App;
