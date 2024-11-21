import { useDispatch, useSelector } from "react-redux"
import {REMOVE_FROM_CART} from "../redux/ResourceSlice";
import {useState} from 'react';
import ToastExample from "./ToastExample";
import { useNavigate } from "react-router-dom";
import Select from "./Select";

/**
 * 장바구니에서 상품의 수량을 변경, 상품 제거, 결제 페이지로 이동하는 컴포넌트
 */
const Cart = () => {

    //토스트 타입 설정 (제품 삭제, 장바구니 비어있음)
    const [toastType, setToastType] = useState('delete');

    //리덕스 디스패치
    const dispatch = useDispatch();
    //페이지 라우팅 요청을 할 수 있는 Hook
    const navigate = useNavigate();

    //부트스트랩 토스트 토글용
    const [showA, setShowA] = useState(false);
    const toggleShowA = () => {
        setShowA(true)
        setTimeout(() => setShowA(false), 2000)
    }

    //결제 페이지로 이동
    const handleMover = () => {
        //카트가 비어있을 경우 토스트 메시지 출력
        if(cart.length===0) {
            setToastType('empty');
            toggleShowA();
        }
        //그렇지 않다면 결제 페이지로 이동
        else navigate('/payment');
    }

    //장바구니에서 상품 제거
    const removeItem = (id) => {
        setToastType('delete');
        toggleShowA();
        dispatch(REMOVE_FROM_CART({id:id}));
    }

     //카트에 담긴 제품 정보가 있는 배열
    const cart = useSelector(state => state.cart.items);
    //카트에 담긴 제품의 총 가격
    const totalPrice = useSelector(state => state.cart.totalPrice);
    
    return(
        <div>
             <ToastExample toggleShowA={toggleShowA} showA={showA} type={toastType}/>
            <br/><h2>장바구니</h2><br/>
            <table>
            <tr className="table-title">
                <th>제품명</th>
                <th>수량</th>
                <th>가격</th>
                <th>삭제</th>
            </tr>
            {/* 3항 연산자를 통해 장바구니가 비어있을경우를 지정  */}
            {cart.length===0 ? <tr className='space'><td colspan="4"><h4>장바구니가 비어있습니다</h4></td></tr> : cart.map(item => (
                <tr key={item.id}>
                    <td>{item.name}</td>
                    <td><Select quantity={item.quantity} id={item.id}/></td>
                    <td>{item.price * item.quantity} 원</td>
                    <td><span className="btn" onClick={() => removeItem(item.id)}>✖️</span></td>
                </tr>
            ))} 
            <tr className='space'>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colSpan="4" className="result total-price"><b>총 액 : {totalPrice} 원</b>&nbsp;&nbsp;&nbsp;<button className="btn btn-primary" onClick={handleMover}>결제 하기</button></td> 
            </tr>
            </table>
        </div>
    )
}

export default Cart;