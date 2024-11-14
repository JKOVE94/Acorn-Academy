// function type component
import { useState } from "react"

const HookTest = () => {
    const [count, setCount] = useState(1); // count에 초기값을 1로 설정하고 setCount를 통해 count값을 변경할 수 있음 [state변수, state변수를 변경할 수 있는 함수]
    console.log(useState(1)); // useState는 기본적으로 1쌍이다.
    return (
        <div>
            number : {count} &nbsp;&nbsp;
            <button onClick={() => setCount(count + 1)}>증가 2</button>
        </div>
    )
}
export default HookTest;