import {useState} from 'react';
import './App.css';
import Table from './components/Table';
import 'bootstrap/dist/css/bootstrap.min.css';


const App = () => {
  const [code,setCode] = useState(1);
  const [list, setList] = useState([]);

  const getData = (e) => {
    e.preventDefault();
    
    //값이 비어있는지 체크
    if(e.target.sang.value === "" || e.target.dan.value === ""){
      document.getElementById("msg").classList = "error";
      document.getElementById("msg").innerHTML = "상품명과 가격을 입력해주세요";
      e.target.sang.focus();
    }
    
    else{
        //가격을 입력하는 곳에 음수나 문자가 있는지 체크
         document.getElementById("msg").classList = "error";
        if(e.target.dan.value < 0 || isNaN(e.target.dan.value)){
        document.getElementById("msg").innerHTML = "가격은 숫자만 입력해주세요";
      }
      
      else{
        //모든 조건이 충족할시에는 에러메세지 지우기
        document.getElementById("msg").innerHTML = "";
        let sangData = e.target.sang.value;
        let danData = e.target.dan.value;
        //코드를 따로 저장하는 이유는 코드가 증가하고 감소해야하기 때문
        setCode(parseInt(code)+1);
        setList([...list,{code:code,sang:sangData,dan:danData}]);
        e.target.sang.value = "";
        e.target.dan.value = "";
        successMsg();
      }
    }
  }

  //입력 성공시 메세지 출력
  const successMsg = () =>{
    document.getElementById("msg").classList = "success";
    document.getElementById("msg").innerHTML = "데이터가 정상적으로 추가되었습니다.";
    //메세지 1초뒤 사라지게 설정
    setTimeout(() => {
      document.getElementById("msg").classList = "transition";
    }, 1000);
    
  }

  const deleteLast = (e) => {
    //상품을 지우면서 코드도 감소
    if(code>1){
      setList(list.slice(0,list.length-1));
      setCode(code-1);
    }
    //코드가 1일때는 코드가 감소되지 않도록 설정
    else{
      setList(list.slice(0,list.length-1));
      setCode(1);
    }
}

const toggle = () => {
  //토글을 통해 테이블을 보이게 하거나 숨기게 함
  document.getElementById("table").classList.toggle("display");
}

  return (
    <div className="App">
      <h1>상품 관리</h1>
      {/* form태그를 통해 데이터를 입력받고 onSubmit으로 함수 실행 */}
      <form onSubmit={getData}>
      코드 : {code}<br/>
      품명 : <input type="text" id="sang" name="sang" /><br/>
      가격 : <input type="text" id="dan" name="dan" /><br/><br/>
      <button className="btn btn-primary">저장</button>&nbsp;&nbsp;
      <button type="button" className="btn btn-secondary" onClick={deleteLast}>삭제</button>&nbsp;&nbsp;      
      </form><br/>
      <div id="msg" className=''></div>
      <button type="button" className="btn btn-primary" onClick={toggle}>결과 보기</button>
      <hr/>
      <Table list={list}/>
    </div>
  );
}

export default App;
