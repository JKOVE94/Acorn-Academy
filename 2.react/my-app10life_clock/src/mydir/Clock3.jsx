import React, {useState, useEffect} from 'react';

const Clock3 = () => {
    const [date, setDate] = useState(new Date());
    
    //Life Cycle관련 hook => useEffect (componentDidMount, componentDidUpdate, componentWillUnmount가 합쳐진 hook)
    //useEffect(함수, 의존성배열) => 의존성 배열에 있는 값이 변할 때마다 함수가 실행된다.
    useEffect(() => {
       const timerId = setInterval(() => showSigan(),1000);

       return () => {clearInterval(timerId);} //componentWillUnmount에 해당되는 클린업 함수 반환
    },[]);

    const showSigan = () => setDate(new Date());

    return (
        <div>
            <h1>반가워2~</h1>
                <h2>지금은 {new Date().toLocaleTimeString()}</h2> {/* 원래는 정적인 시간으로 출력되어야 하지만 componentDidMount로 렌더링되는 state로 인해 같이 렌더링 되기 떄문 (컴포넌트 자체의 리렌더링) */}
                <h2>현재 시간은 {date.toLocaleTimeString()}</h2> {/* 동적인 시간 */}
        </div>
    )
}

export default Clock3;