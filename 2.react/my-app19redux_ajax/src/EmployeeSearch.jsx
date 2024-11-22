import React from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {setEmployees} from './Action'
import axios from 'axios';
import { useState, useEffect } from 'react';


const EmployeeSearch = () => {
    
    const [searchTerm, setSearchTerm] = useState("");
    //리듀서의 employeeReducere에서 관리되는 state를 조회
    const employees = useSelector(state => state.employees);
    const dispatch = useDispatch();

    const handleSearch = async() => {
        const response = await axios.get('/findjikwon.jsp', {
            params : {name : searchTerm}
        });
        //웹 서버로부터 요청된 결과를 받아 Redux state에 저장 리듀서에 전달
        dispatch(setEmployees(response.data));
    }

    return (
        <div>
            <input type="text" placeholder="직원이름을 입력해주세요" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} />
            <button onClick={handleSearch}>Search</button>
            <div>
                <h2>'{searchTerm}'으로 시작하는 직원 목록</h2>
                <ul>
                    {employees.map(employee => (
                        <li key={employee.jikwonno}>{employee.jikwonname} {employee.jikwonjik}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default EmployeeSearch;