import React from 'react';
import '../mycss/TodoItem.css';

const TodoItem = ({text, checked, id,  onToggle, onRemove}) => {
    return(
        <div className='todo-item' onClick={() => onToggle(id)}>
            <div className='remove' onClick={e => {
                e.stopPropagation(); //onToggle이 실행되지 않도록 함, 이벤트 전파 방지
                onRemove(id);
            }}>✖️</div> {/* X 닫기버튼 */}
        
            {/* CSS를 동적으로 처리 */}
            <div className={`todo-text ${checked && 'checked'}`}>
                <div>{text}</div>
            </div>
            
            {checked && (<div className='check-mark'>✔️</div>)}
        </div>
    )
}

export default TodoItem;