import React from 'react';
import { useDispatch } from 'react-redux';
import { UPDATE_QUANTITY } from '../redux/ResourceSlice';

/**
 * Select Box를 사용하기위해 구현한 컴포넌트
 */
const Select = ({ quantity, id }) => {
    const dispatch = useDispatch();
    //Select 박스에 들어갈 옵션 태그 배열
    const options = [];
    //select 박스에 1~99까지의 숫자를 넣어줌
    for (let i = 1; i <= 99; i++) {
        options.push(<option key={i} value={i}>{i} 개</option>);
    }

    //수량 변경시 실행되는 함수
    const handleChange = (e) => {
        const newQuantity = parseInt(e.target.value);
        dispatch(UPDATE_QUANTITY({ id, quantity: newQuantity }));
    };

    return (
        <select value={quantity} onChange={handleChange}>
            {options}
        </select>
    );
}

export default Select;