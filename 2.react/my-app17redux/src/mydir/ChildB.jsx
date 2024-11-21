import React from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {increment, decrement, reset} from '../redux/ResourceSlice';

const ChildB = () => {
    const storeValue = useSelector((state) => state.resource.value);
    const dispatch = useDispatch();
    return(
        <div>
            <h3>ChildB</h3>
            <p>리덕스 스토어 내의 state 값 value는 {storeValue} </p>
            <button onClick={() => dispatch(decrement())}>값(value) 감소</button>
            <button onClick={() => dispatch(reset())}>값 초기화</button>
        </div>
    )
}
export default ChildB;