import React,{useState, useEffect} from 'react';
import {Link, useParams, useNavigate} from 'react-router-dom';
import axios from 'axios';

const Edit = () => {
    const navigate = useNavigate();
    const {num} = useParams();
    /*const prams = useParams();
    const inputNum = prams.num;*/
    const [data, setData] = useState({});
    
    const handleChange = (e) => {
        setData({...data, [e.target.name]:e.target.value});
    }

    const handleUpdate = () => {
        axios.put(`/members/${num}`, data)
        .then(res => {
            if(res.data.isSuccess) navigate('/members')
            else throw new Error();
        })
        .catch(err => console.log(err));
    }

    useEffect(() => {
        axios.get(`/members/${num}`)
        .then(res => {
            setData(res.data);
        })
    },[num])


    return (
        <div>
            <h1>회원 수정</h1>
           <Link to="/">메인으로</Link><br/><br/>
            <label htmlFor="num">번호: </label>
            <input type="text" id="num" name="num" value={data.num} onChange={handleChange} readOnly/><br/>
            <label htmlFor="name">이름: </label>
            <input type="text" name="name" id="name" value={data.name} onChange={handleChange}/><br/>
            <label htmlFor="addr">주소: </label>
            <input type="text" name="addr" id="addr" value={data.addr} onChange={handleChange}/><br/><br/>
            <button onClick={handleUpdate}>수정</button>
        </div>
    )
}
export default Edit;