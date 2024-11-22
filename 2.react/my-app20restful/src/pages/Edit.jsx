import React,{useState, useEffect} from 'react';
import {Link, useParams, useNavigate} from 'react-router-dom';
import axios from 'axios';

const Edit = () => {
    const navigate = useNavigate();
    const prams = useParams();
    const inputNum = prams.num;
    const [num, setNum] = useState('');
    const [name, setName] = useState('');
    const [addr, setAddr] = useState('');

    const handleChange = (e) => {
        switch(e.target.name){
            case 'num':
                setNum(e.target.value);
                break;
            case 'name':
                setName(e.target.value);
                break;
            case 'addr':
                setAddr(e.target.value);
                break;
        }    
    }

    const handleInsert = (e) => {
        e.preventDefault();
        axios.put(`/members/${inputNum}`, {num:num, name:name, addr:addr})
        .then(navigate('/members'))
    }

    useEffect(()=>{
        axios.get(`/members/${inputNum}`)
        .then(res => {
            setNum(res.data.num);
            setAddr(res.data.addr);
            setName(res.data.name);
        })
    },[])


    return (
        <div>
            <h1>회원 수정</h1>
           <Link to="/">메인으로</Link>
            <form onSubmit={handleInsert}>
                <label htmlFor="num">번호: </label>
                <input type="text" id="num" name="num" value={num} onChange={handleChange}/><br/>
                <label htmlFor="name">이름: </label>
                <input type="text" name="name" id="name" value={name} onChange={handleChange}/><br/>
                <label htmlFor="addr">주소: </label>
                <input type="text" name="addr" id="addr" value={addr} onChange={handleChange}/><br/><br/>
                <button>수정</button>
            </form>
        </div>
    )
}
export default Edit;