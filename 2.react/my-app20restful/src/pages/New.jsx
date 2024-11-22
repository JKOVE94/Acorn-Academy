import React from 'react';
import {Link, useNavigate} from 'react-router-dom';
import axios from 'axios';

const New = () => {
    const navigate = useNavigate();

    const handleInsert = (e) => {
        e.preventDefault();
        const num = e.target.num.value;
        const name = e.target.name.value;
        const addr = e.target.addr.value;
        const request = {num:num, name:name, addr:addr};

        axios.post('/members', request)
        .then(navigate('/members'))
    }

    return (
        <div>
            <h1>회원 추가</h1>
            <Link to="/">메인으로</Link>
            <form onSubmit={handleInsert}>
                <label htmlFor="num">번호: </label>
                <input type="text" id="num" name="num"/><br/>
                <label htmlFor="name">이름: </label>
                <input type="text" name="name" id="name"/><br/>
                <label htmlFor="addr">주소: </label>
                <input type="text" name="addr" id="addr"/><br/><br/>
                <button>추가</button>
            </form>
        </div>
    )
}
export default New;