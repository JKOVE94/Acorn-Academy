import {useSelector} from 'react-redux';
import {Link} from 'react-router-dom';

/**
 * 결제를 진행하는 컴포넌트
 */
const CartSummary = () => {
    //카트에 담긴 제품 정보가 있는 배열
    const cart = useSelector(state => state.cart.items);
    //카트에 담긴 제품의 총 가격
    const getTotalPrice = useSelector(state => state.cart.totalPrice);
    
    return (
        <div>
            <div></div>
            <br/><h2>결제진행</h2><br/>
            <table>
            <tr className="table-title">
                <th>제품명</th>
                <th>수량</th>
                <th>가격</th>
            </tr>
            {cart.map(item => (
                <tr key={item.id}>
                    <td>{item.name}</td>
                    <td>{item.quantity}</td>
                    <td>{item.price * item.quantity} 원</td>
                </tr>
            ))} 
            <tr className='space'>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td colSpan="2" className='result total-price'><b>총 액 : {getTotalPrice} 원</b></td> 
                <td className='result'><button className='btn btn-primary'>결제 진행</button> <Link to="../cart" className='btn btn-primary'>결제 취소</Link></td>
            </tr>
            </table>
        </div>
    )
}
export default CartSummary;