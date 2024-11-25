import React, {useState} from 'react';

const Login = () => {
    const [logindata, setLogindata] = useState({});

    const handleChange = (e) => {
        setLogindata({
            ...logindata,
            [e.target.name]: e.target.value
        });
    }

    const login = (e) => {

    }

    return (
        <div>
            <h2> 운동 기록앱에 오신것을 환영합니다 </h2>
            <label htmlFor="userid">아이디 :</label>
            <input type="text" id="userid" name="userid" value={logindata.username} onChange={handleChange} placeholder="아이디를 입력해주세요"/><br/>
            <label htmlFor="userpass">비밀번호 :</label>
            <input type="password" id="userpass" name="userpass" value={logindata.userpass} onChange={handleChange} placeholder="비밀번호를 입력해주세요"/><br/>
            <button onClick={login}>로그인</button>
        </div>
    )
}

export default Login;