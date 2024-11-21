import React from 'react';
import ChildA from './ChildA';
import ChildB from './ChildB';

const Parent = () => {
    return(
        <div>
            <h2>부모 컴포넌트</h2>
            <ChildA />
            <ChildB />
        </div>
    )
}
export default Parent;