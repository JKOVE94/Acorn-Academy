import React from 'react';
import AddNumber from './AddNumber';
import { useDispatch } from 'react-redux';


const AddNumberSuper = () => {
    const dispatch = useDispatch();
    
    // type : Reducer에서 처리할 작업의 종류를 구분하기 위한 값 (문자열)
    // payload : Reducer에 전달할 값 (state를 업데이트 할 데이터) 
    const handleClick = size => {
        dispatch({type: 'INCREASE_NUMBER', payload: size}); //Reducer의 계산 로직 호출
    }

    return(
        <div id='super'> 
            <h1>Add Number Super</h1>
            <AddNumber onClick={handleClick} />
        </div>
    );
};

export default AddNumberSuper;
