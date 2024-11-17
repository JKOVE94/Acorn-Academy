import {useState} from 'react';
import './App.css';
import Component1 from './mydir/Component1';
import Component2 from './mydir/Component2';

const App = () =>{
  const [subject] = useState({title:"웹문서", subtitle:"오늘 금요일"});
  const [friends] = useState([
    {bun:1, irum:"상현", nai:25}, 
    {bun:2, irum:"대현", nai:27}
  ]);

  const handleChangeData = () =>{
    friends.forEach((friend => {
      console.log(`${friend.bun}번 ${friend.irum} : 나이는 ${friend.nai}살`);
    }));
  }

  return (
    <div className="App">
      <h2>이벤트 연습</h2>
       <Component1 title={subject.title} subtitle={subject.subtitle}
       changeData={handleChangeData} />
       <br/>
       <Component2 friends={friends} title={subject.title} subtitle={subject.subtitle}
       changeData={handleChangeData}/>
       <br/>
    </div>
  );
}

export default App;
