import React from 'react';
import '../css/Product.css';

/**
 * 제품의 정보를 카드형으로 나타내는 컴포넌트 (재사용성을 위해 컴포넌트화)
 */
const Product = (props) => {
    return(
        <span>
            <div className="product">
                <img src={props.prod.img} className="img" />
                <div className="info">
                <div> <b>상품명 :</b> {props.prod.name}</div>
                <div> <b>가격 :</b> {props.prod.price} 원</div><br/>
                <button className="btn btn-primary" onClick={()=>props.addCart(props.prod)}>장바구니에 추가</button>
                </div>
            </div>
        </span>
    )
}
export default Product;