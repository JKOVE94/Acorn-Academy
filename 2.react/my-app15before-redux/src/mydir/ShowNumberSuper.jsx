import React from 'react';
import ShowNumber from './ShowNumber';

const ShowNumberSuper = (props) => {
    return(
        <div id='super'> 
            <h1>Show Number Super</h1>
            Show Number Super : {props.number}
            <ShowNumber number={props.number}/>
        </div>
    );
};

export default ShowNumberSuper;