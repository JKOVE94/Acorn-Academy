import React from 'react';
import { useState } from 'react'

const Counter = () => {
    const [member, setMember] = useState(0);

    const increaseFunc = () => {
        setMember(member + 1);
    }

    const decreaseFunc = () => {
        setMember(member - 1);
    }

    return (
        <div>
            <br/><br/>
            <button onClick={increaseFunc}>친구추가</button>
            &nbsp;
            <button onClick={decreaseFunc}>친구삭제</button>
            <p>{member}</p>
        </div>
    )
}
export default Counter;