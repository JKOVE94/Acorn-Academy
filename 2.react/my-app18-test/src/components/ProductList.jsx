import {useDispatch} from 'react-redux';
import { ADD_TO_CART } from '../redux/ResourceSlice';
import ToastExample from './ToastExample';
import {useState} from 'react';

/**
 * 제품 리스트 컴포넌트 (테이블형)
 */
const ProductList = () => {
    //리덕스 디스패치
    const dispatch = useDispatch();

    //부트스트랩 토스트 토글용
    const [showA, setShowA] = useState(false);
    const toggleShowA = () => {
        setShowA(true)
        setTimeout(() => {setShowA(false)}, 2000)
    }

    //제품 리스트 기본값 설정
    const products = [
    { img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOTrAn4Ej_FwZSstI9yWX5IxrLGG-NcujAUw&s", id: 1, name: "마우스", price: 5000 },
    { img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyIadjgLTd-yFKbNPQPdIB2cstkT4Or-2ByQ&s", id: 2, name: "키보드", price: 50000 },
    { img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkUl4Z25_kBjln5E4x-Pj-I6yJoVkcRRiuHA&s", id: 3, name: "모니터", price: 500000 },
    { img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYihFAfZqeYMS3tDKcjNVsTnNfCYjOT7bT-A&s", id: 4, name: "프린터", price: 150000 },
    { img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTtpYLg7DwcXD6xG4L9KjaDiXEFcLF73KaJQ&s", id: 5, name: "헤드셋", price: 30000 }
];

    //장바구니에 제품 추가
    const addCart = prod => {
        toggleShowA(); //토스트 메시지 토글
        dispatch(ADD_TO_CART({id: prod.id, name: prod.name, price: prod.price, quantity: 1}));
        
    }

    return(
        <div>
            <ToastExample toggleShowA={toggleShowA} showA={showA} type="add"/>
            <br/><h2>제품 리스트</h2><br/>

            <table>
                <tr className="table-title">
                    <th>제품 번호</th>
                    <th>제품 명</th>
                    <th>제품 가격</th>
                    <th>장바구니에 추가</th>
                </tr>
                {products.map(prod => (
                    <tr key={prod.id}>
                        <td>{prod.id}</td>
                        <td>{prod.name}</td>
                        <td>{prod.price}</td>
                        <td><button className="btn btn-primary" onClick={() => addCart(prod)}>추가</button></td>
                    </tr>
                ))}
            </table>
        </div>
    )
}
export default ProductList;