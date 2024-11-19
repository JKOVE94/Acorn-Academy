import {memo} from 'react';

const boxStyle = {
    border:"1px, dotted, blue",
    padding: "10px"
  }

const Child = ({irum,nai}) => {
    console.log("아이 나이 변경됨(re-rendering)");
    return(
        <div style={boxStyle}>
            <h3>* 자녀 1 *</h3>
            <div>👶아이 (신통한) </div>
            <div>나이 : 8</div>
            <h3>* 자녀 2 *</h3>
            <div>👶아이 ({irum}) </div>
            <div>나이 : {nai}</div>
        </div>
    )
}

export default memo(Child);