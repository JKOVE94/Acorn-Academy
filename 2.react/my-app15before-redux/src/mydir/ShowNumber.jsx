import React from 'react';

const ShowNumber = (props) => {
    return(
        <div> 
            <h1>Show Number</h1>
            <input type='text' value={props.number} readOnly/>
        </div>
    );
};

export default ShowNumber;