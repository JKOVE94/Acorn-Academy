import React from 'react';
import AddNumber from './AddNumber';


const AddNumberSuper = (props) => {
    return(
        <div id='super'> 
            <h1>Add Number Super</h1>
            <AddNumber onClick={(size) => props.onClick(size)} />
        </div>
    );
};

export default AddNumberSuper;
