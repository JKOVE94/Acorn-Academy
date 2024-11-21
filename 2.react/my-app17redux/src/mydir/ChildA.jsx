import React from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {increment, decrement, reset} from '../redux/ResourceSlice';

const ChildA = () => {
    const value = useSelector((state) => state.resource.value);
    const dispatch = useDispatch();
    return(
        <div>
            <h3>ChildA</h3>
            <p>공유 값 : {value} </p>
            <button onClick={() => dispatch(increment())}>값(value) 증가</button>
            <button onClick={() => dispatch(reset())}>값 초기화</button>
        </div>
    )
}
export default ChildA;