import React from 'react';
import '../mycss/Form.css';

const Form = (({value, onChange, onCreate, onKeyDown}) => {
    return (
        <div className="form">
            할 일 입력 : <input type="text" 
                value={value} 
                onChange={onChange}
                onKeyDown={onKeyDown}
            /> 
            <div className="crate-button" onClick={onCreate}>추가</div>
        </div>
    )
})

export default Form;