import React from 'react';
import ShowNumber from './ShowNumber';
import { useSelector } from 'react-redux';

const ShowNumberSuper = () => {
    //useSelector로 redux의 state를 가져옴 (immutable)
    //store의 state가 변경되면, useSelector를 사용하는 모든 컴포넌트는 리렌더링 됨
    const number = useSelector(state => state.number);
    return(
        <div id='super'> 
            <h1>Show Number Super</h1>
            Show Number Super : {number}
            <ShowNumber number={number}/>
        </div>
    );
};

export default ShowNumberSuper;