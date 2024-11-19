import React, {useState, useEffect, useCallback} from 'react';
import './App.css';
import FormData from './components/FormData';
import Visits from './components/Visits';
import Layor from './components/Layor'

const App = () => {
  const [id, setId] = useState(1);
  const [visits, setVisits] = useState([]);

   //아이디 자동 증가
   const increaseId = () => {
    setId(id+1);
   }

  //새로운 거래처 방문 기록 추가
  const addVist = useCallback(e => {
        e.preventDefault();
        let name = e.target.clientName.value;
        let add = e.target.address.value;
        let visit = e.target.visitDate.value;
        setVisits([...visits,{id:id,clientName:name,addr:add,visitDate:visit}])
        increaseId();
      }
  )
 
  //특정 방문 기록 삭제
  const deleteVist = (id) => {
    setVisits(visits.filter(visit => visit.id !== id));
  }

  //모든 방문 기록 초기화
  const clearVisits = () => {
    setVisits([]);
    setId(1);
  }

  return (
    <div className="App">
      <Layor formData={<FormData addVisit={addVist}/>}
      visits={<Visits visits={visits} deleteVist={deleteVist}/>}
      clearVisits={clearVisits}/>
    </div>
  );
}

export default App;
