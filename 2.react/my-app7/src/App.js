import {useState, useEffect} from 'react';
function App() {
  const [items, setItems] = useState([]); 
  const [items2, setItems2] = useState([]); 
  const [text, setText] = useState("");
  
  const handleTextChange = e => {
    setText(e.target.value);
  }
  
  const handleSubmit = e => {
    e.preventDefault();
    if(text.length===0){
      return;
    }
    const newItem = {
      id: Date.now(),
      text:text,
    };
    //리액트가 상태 업데이트를 수행할 때 현재 상태를 콜백함수에 전달해 새로운 상태를 생성
    //preItems 배열의 모든 요소를 복사한 새로운 배열에 newItem을 추가. 새로운 배열은 newItme을 지님 
    setItems((preItems) => [...preItems,newItem])
    console.log(items)
    setText("");
    
    /*
    13번 라인부터 20번라인까지의 내용과 동일 하지만 22번라인에서 코드릴 실행할때 preItems를 사용하여 상태 업데이트를 수행. 안정성이 보장됨 (react는 비동기 처리하기 때문)
    setText("");
    */
  }

  const HobbyList = ({itemsProps})=>{ //취미내용 출력용 컴포넌트
    return (
      <ul>
      {itemsProps.map(item => (
        <li key={item.id}>{item.text}</li>
      ))}
    </ul>
    )
  }

  return (
    <div>
      <h2>취미 목록</h2>
      <HobbyList itemsProps={items}/>
      <form onSubmit={handleSubmit}>
        <label htmlFor="new-hobby">취미 : </label> {/*React에서 for는 오류가 발생한다. 그렇기때문에 htmlFor를 사용해야 한다.*/}
        <input type="text" id="new-hobby" onChange={handleTextChange} value={text}/> &nbsp;&nbsp;<button>클릭 #{items.length}</button>
      </form>    
      <br/>
      <div>총 건수 : {items.length}</div>
    </div>
  );
}

export default App;
