import React, { useState, useEffect } from 'react';
const MyProduct = () => {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    //컴포넌트가 마운트된 후에 Ajax 요청 
    useEffect(() => {
        fetch('/abcReact/', {method : 'GET'})
        .then(res => {
            if(!res.ok){
                throw new Error('서버 통신 오류');
            }
            else return res.json();
        })
        .then(data => {
            setIsLoaded(true);
            setItems(data.items);

        })
        .catch(error => {
            setError(error);
        })
    },[]);

    if(error){
        return <div>에러: {error.message}</div>
    }
    else if(!isLoaded){
        return <div>로딩중...</div>
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
export default MyProduct;