import React,{useState} from 'react';

const App = () => {

  const style ={
    fontSize: '24px',
  };
  

  const [name, setName] = useState('');
  const handleEnter = (e) => {
    if(e.key ==='Enter'){
      setName(e.target.value);
    }
  }
  const handleClick = () => {
    const name = document.getElementById('name').value;
    setName(name);
  }

  return (
    <div className="App">
      <label htmlFor='name'>이름 입력 :</label>
      <input type='text' name='name' id='name' onKeyDown={handleEnter}/>
      <button onClick={handleClick}>확인</button><br/>
      <div style={fontSize:'24px'}>결과는 {name}</div>
    </div>
  );
}
export default App;