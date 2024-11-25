import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import {useSelector, useDispatch} from 'react-redux';

const Home = () => {
    const dispatch = useDispatch();

    const [userInfo, setUserInfo] = useState({});

    const handleChange = (e) => {
        setUserInfo({...userInfo, [e.target.name]: e.target.value});
    }
    
    const {name, weight} = useSelector(state => state);
    return(
        <>
            <h1>메인 (Home)</h1>
            환영합니다. 당신의 이름과 체중을 입력해주세요<br/>
            이름 : <input type="text" name="name" value={userInfo.name} onChange={handleChange}/><br/>
            체중 : <input type="number" name="weight" valeu={userInfo.weight} onChange={handleChange}/><br/>
        </>
    );
}

export default Home;