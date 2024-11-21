import React from 'react';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Toast from 'react-bootstrap/Toast';
import { Link } from 'react-router-dom';

/**
 * 부트스트랩 토스트를 사용하기 위한 컴포넌트
 */
const ToastExample = ({ toggleShowA, showA, type}) => {
  const TypeText = () => {
    if(type==='add'){
      return(
        <>
          <Toast.Header>
            <img
              src="holder.js/20x20?text=%20"
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">제품 추가 성공</strong>
          </Toast.Header>
          <Toast.Body>
            제품이 성공적으로 추가되었습니다.<br/>
            장바구니에서 확인하시겠습니까? <Link to="../cart">확인하기</Link>
          </Toast.Body>
          </>
      )
    }
    else if(type==='delete'){
      return(
        <>
          <Toast.Header>
            <img
              src="holder.js/20x20?text=%20"
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">제품 삭제 성공</strong>
          </Toast.Header>
          <Toast.Body>제품이 성공적으로 삭제 되었습니다.</Toast.Body>
          </>
      )
    }
    else if(type==='empty'){
      return(
        <>
          <Toast.Header>
            <img
              src="holder.js/20x20?text=%20"
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">결제 실패</strong>
          </Toast.Header>
          <Toast.Body>장바구니가 비어있습니다.</Toast.Body>
          </>
      )
    }
  }

  return (
    <Row>
      <Col md={6} className="mb-2">
        <Toast 
          show={showA} 
          onClose={toggleShowA} 
          style={{
            position: 'fixed',
            bottom: '20px',
            right: '20px',
            zIndex: 1
          }}
        >
          <TypeText/>
        </Toast>
      </Col>
    </Row>
  );
}

export default ToastExample;