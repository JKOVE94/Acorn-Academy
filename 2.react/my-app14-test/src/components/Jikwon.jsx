import React, { useState, useEffect } from 'react';
import axios from 'axios';
import JikwonResult from './JikwonResult';

const Jikwon = () => {
    const [buser, setBuser] = useState('');
    const [jikwonList, setJikwonList] = useState([]);
    const [isLoaded, setIsLoaded] = useState(false);
    const [error, setError] = useState(null);
    const [avgSal, setAvgSal] = useState(0);

    const setBusername = e => {
        if (e.key === 'Enter') {
            setBuser(e.target.value);
            setJikwonList([]);
        }
    }

    const handleClick = () => {
        setBuser(document.getElementById("inputbox").value);
        setJikwonList([]);
    }   

    useEffect(()=>{
        setIsLoaded(true);
    },[])

    useEffect(() => {
        if (buser) {
            setIsLoaded(false);
            axios.get(`/api/${buser}`)
                .then(res => {
                    setJikwonList(res.data);
                    setIsLoaded(true);
                })
                .catch(err => {
                    setError(err);
                    setIsLoaded(true);
                });
        }
    }, [buser]);

    useEffect(() => {
        //accumulator는 reduce 함수의 반환값을 누적
        const totalSalary = jikwonList.reduce((accumulator, jikwon) => accumulator + parseInt(jikwon.jikwonpay), 0);
        setAvgSal(jikwonList.length > 0 ? (totalSalary / jikwonList.length).toFixed(1) : 0);
    }, [jikwonList]);

    if(!isLoaded) return <div>로딩중...</div>;  
    if(error) return <div>에러: {error.message}</div>;
    return (
        <div>
            <h2>부서명으로 직원 찾기</h2>
            <label htmlFor="inputbox">부서명: </label>
            <input type="text" id="inputbox" onKeyDown={setBusername} placeholder="부서명을 입력하세요"/>&nbsp;&nbsp;
            <button onClick={handleClick}>확인</button><br /><br />
            <JikwonResult jikwonList={jikwonList} avgSal={avgSal} />
        </div>
    );
}

export default Jikwon;