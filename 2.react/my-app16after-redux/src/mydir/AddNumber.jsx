import React, {useState} from 'react';

const AddNumber = props => {
    const [size, setSize] = useState(1);

    const handleClick = () => {
        props.onClick(size);
    }

    const handleChange = e => {
        setSize(Number(e.target.value));
    }

    return(
        <div> 
            <h1>Add Number</h1>
            <input type='button' value='+' onClick={handleClick}/>
            <input type='text' value={size} onChange={handleChange}/>
        </div>
    );
};

export default AddNumber;