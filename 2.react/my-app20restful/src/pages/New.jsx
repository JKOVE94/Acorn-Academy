import React, {useState} from 'react';
import {Link, useNavigate} from 'react-router-dom';
import axios from 'axios';

const New = () => {
    const navigate = useNavigate();
    const [state, setState] = useState({})

    const handleChange = (e) => {
        setState({...state, [e.target.name]:e.target.value});
    }

    const handleInsert = () => {
        axios.post('/members', state)
        .then(res => {
            if(res.data.isSuccess) navigate('/members'); //추가 후 목록보기 (Link)
            else throw new Error();
        }) 
        .catch(err => console.log(err));
    }

    return (
        <div>
            <h1>회원 추가</h1>
            <Link to='/'>메인으로</Link><br/><br/>
            <label htmlFor='num'>번호: </label>
            <input type='text' id='num' name='num' onChange={handleChange} placeholder='번호를 입력하세요'/><br/>
            <label htmlFor='name'>이름: </label>
            <input type='text' name='name' id='name' onChange={handleChange} placeholder='이름를 입력하세요'/><br/>
            <label htmlFor='addr'>주소: </label>
            <input type='text' name='addr' id='addr' onChange={handleChange} placeholder='주소를 입력하세요'/><br/><br/>
            <button onClick={handleInsert}>추가</button>
        </div>
    )
}
export default New;