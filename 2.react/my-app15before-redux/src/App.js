import './App.css';
import ShowNumberSuper from "./mydir/ShowNumberSuper";
import AddNumberSuper from "./mydir/AddNumberSuper";
import { useState } from 'react';

const App = () => {
  const [number, setNumber] = useState(0);
  
  const handleAddNumber = size => {
    setNumber(number + size);
  }

  return (
    <div>
      <h1>메인</h1>
        <AddNumberSuper onClick={handleAddNumber} />
        AddNumber : {number}
        <br/>
        <ShowNumberSuper number={number} />
    </div>
  );
}

export default App;
