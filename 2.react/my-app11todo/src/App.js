import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState, useEffect, useCallback} from 'react';
import TodoListTemplate from './mydir/TodoListTemplate';
import Form from './mydir/Form';
import TodoItemList from './mydir/TodoItemList';

function App() {
  const [input, setInput] = useState('');
  const [todos, setTodos] = useState([
    {id:0, text:'출근(09:00)',checked:true},
    {id:1, text:'팀 회의(9:30)',checked:false},
    {id:2, text:'업무 시작',checked:false}
  ]); 
  
  const [nextId, setNextId] = useState(3); // 다음번 id 값

  //useCallback(함수, 의존성배열) => 의존성 배열값이 변경되지 않으면 동일 함수 인스턴스를 반환. 즉 불필요한 인스턴스 재생성을 방지
  //useCallback : Hook의 일종으로 Memoization을 구사 
  //메모이제이션은 함수의 결과를 캐싱하여 동일한 입력에 대해 반복적으로 계산하는 것을 방지하는 최적화 기법
  const handleChange = useCallback( e =>{
    console.log("hello");
    setInput(e.target.value);
  },[]);

  //새로운 todo 항목을 생성하고, 상태를 업데이트 하기 위한 함수. Memoization을 사용
  const handleCreate = useCallback(e => {
    if(input.trim() === '') return;
    setTodos(prevTodos => 
      //push : 기존 배열에 값을 추가하여 원본을 바꾼다.
      //concat : 기존 배열을 토대로 변경한 새로운 배열이 리턴된다. 기존의 배열은 바뀌지 않는다.
      prevTodos.concat({
        id:nextId,
        text:input,
        checked:false
      })
    )
    setInput('');
    setNextId(prevId => prevId + 1); //nextId 값에 1 더하기
  },[input, nextId]); //input과 nextId가 변경되면 handleCreate 함수가 재생성(useCallback)
  
  //엔터키를 눌렀을 때도 추가되도록 하는 함수
  const handleKeyDown = useCallback(e => {
    if(e.key === 'Enter'){
      handleCreate();
    }
  },[handleCreate]);

  //할일(todo) 목록의 특정 항목의 완료상태를 토글하는 함수
  //사용자가 할 일 목록에서 항목을 클릭하면 해당 항목의 상태를 변경 (Toggle)
  const handleToggle = useCallback(id => {
    setTodos(prevTodos => 
      prevTodos.map(todo =>
        //todo.id가 들어오는 id와 같다면 checkd 값을 반전, 그렇지 않으면 유지
        todo.id === id ? {...todo, checked : !todo.checked} : todo //checked 값을 반전
      )
    )
  },[]);

  //할일(todo)목록의 특정 항목 삭제 함수
  //삭제이기 때문에 해당 id를 제외한 나머지를 필터링 => 즉 입력한 id외 제외된 나머지만 배열안에 남게 된다.
  const handleRemove = useCallback(id => {
    setTodos(prevTodos =>
      prevTodos.filter(todo => todo.id !== id) //todo.id가 들어오는 id와 같지 않은 것만 필터링 / filter : 특정 조건에 맞는 요소만 추출하여 새로운 배열을 만든다.
    )
  },[]);

  return (
    <>
      {/* TodoListTemplate : 틀 역할 */}
      <TodoListTemplate
        form={<Form value={input} 
          onChange={handleChange}
          onCreate={handleCreate} 
          onKeyDown={handleKeyDown}
        />
      }>
        <TodoItemList 
          todos={todos}
          onToggle={handleToggle}
          onRemove={handleRemove}
        />

      </TodoListTemplate>
    </>
  );
}

export default App;
