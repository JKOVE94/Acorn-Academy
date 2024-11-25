import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import {useSelector, useDispatch} from 'react-redux';
import { SET_USER } from '../redux/resourceSlice';

const Home = () => {
    const dispatch = useDispatch();
    const name = useSelector(state => state.resource.name);
    const weight = useSelector(state => state.resource.weight);
    const [userInfo, setUserInfo] = useState({});

    const handleChange = (e) => {
        setUserInfo({...userInfo, [e.target.name]: e.target.value});
    }
    const handleInput = () => {
        dispatch(SET_USER(userInfo));
    }

    return(
        <>
            <h1>메인 (Home)</h1>
            환영합니다. 당신의 이름과 체중을 입력해주세요<br/>
            이름 : <input type="text" name="name" value={userInfo.name} onChange={handleChange}/><br/>
            체중 : <input type="number" name="weight" valeu={userInfo.weight} onChange={handleChange}/><br/>
            <button onClick={handleInput}>입력</button>
            {name} {weight}
        </>
    );
}

export default Home;