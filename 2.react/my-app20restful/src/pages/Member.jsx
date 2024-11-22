import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Link, useNavigate} from 'react-router-dom';

const Member = () => {
    //페이지 이동에서 사용 함수 객체
    //Link를 써서 페이지 이동(단순이동)을 할 수 있지만, useNavigate()를 사용하면 특정 이벤트가 발생했을 때 페이지 이동을 할 수 있다. 
    const navigate = useNavigate();
    const [members, setMembers] = useState([]);

    const refresh = () => {
        axios.get('/members')
        .then(res => {
            setMembers(res.data);
        })
        .catch(err => {
            console.log(err);
        })
    }

    useEffect(()=>{
        refresh();   
    },[members]);

    //삭제 버튼 처리 이벤트 핸들러 함수
    const handleDelete = (num) => {
        axios.delete(`/members/${num}`)
        .catch(err => {
            console.log(err);
        })
    }
    return (
        <>
        <Link to="/">홈페이지</Link><br/>
        <Link to="/members/new">회원추가</Link>
        <h1>* 회원 목록 *</h1>
        
        <table border="1">
            <thead>
        <tr>
            <td>번호</td>
            <td>이름</td>
            <td>주소</td>
            <td>수정</td>
            <td>삭제</td>
        </tr>
        </thead>
        <tbody>
        {members.map(mem => (
           <tr key={mem.num}>
            <td>{mem.num}</td>
            <td>{mem.name}</td>
            <td>{mem.addr}</td>
            <td><button onClick={() => navigate(`/members/${mem.num}/edit`)}>수정</button></td>
            <td><button onClick={() => handleDelete(mem.num)}>삭제</button></td>
           </tr> 
        ))}
        </tbody>
        </table>
        </>
    )
}
export default Member;