import React from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {setCustomers} from './Action'
import axios from 'axios';
import { useState, useEffect } from 'react';


const CustomerSearch = () => {
    
    const [searchTerm, setSearchTerm] = useState("");
    //리듀서의 employeeReducere에서 관리되는 state를 조회
    const customers = useSelector(state => state.customers);
    const dispatch = useDispatch();

    const handleSearch = async() => {
        const response = await axios.get('/findgogek.jsp', {
            params : {phone : searchTerm}
        });
        //웹 서버로부터 요청된 결과를 받아 Redux state에 저장 리듀서에 전달
        dispatch(setCustomers(response.data));
    }

    return (
        <div>
            <input type="text" placeholder="고객 전화번호를 입력해주세요" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} />
            <button onClick={handleSearch}>Search</button>
            <div>
                <h2>'{searchTerm}'으로 시작하는 고객 전화번호</h2>
                <ul>
                    {customers.map(costumor => (
                        <li key={costumor.gogekno}>{costumor.gogekname} {costumor.gogektel}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default CustomerSearch;