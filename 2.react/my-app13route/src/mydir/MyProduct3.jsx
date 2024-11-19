import axios from "axios";
import React, { useState, useEffect } from "react";


const MyProduct3 = () => {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    //컴포넌트가 마운트된 후에 Ajax 요청 
    useEffect(() => {
        axios.get('/abcReact/product.jsp')
        .then(response => {
            setIsLoaded(true);
            setItems(response.data.items); //서버에서 받은 자료로 상태를 갱신
        })
        .catch(error => {
            setIsLoaded(true);
            setError(error);
        });
    },[]);
    
    if(!isLoaded){
        return <div>로딩중...</div>
    }
    else if(error){
        return <div>에러: {error.message}</div>
    }
    else{
        return(
            <ul>
                {items.map(item => (
                    <li key={item.id}>
                        {item.name} {item.price}
                    </li>
                ))}
            </ul>
        )
    }
}
export default MyProduct3;