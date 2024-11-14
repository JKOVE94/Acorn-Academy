import { useState } from "react";
import '../App.css'
import pic1 from '../imgs/hero2.png';


//화살표 함수에서는 사용 불가능
export default function HookTest2 () {
    const [item, setItem] = useState(0);
    const incrementItem = () => setItem(item + 1);
    const decrementItem = () => setItem(item - 1);

    //Javascript의 멤버로 Style 설정, JSON 형태로 작성, 이때에 주의할것은 attribute name을 CamelCase형식으로 작성해야함
    const myStyle = {color: "blue", textAlign: "center", fontSize: "30pt", backgroundColor: "skyblue"};

    return(
        <div>
            <div>
                number : {item} &nbsp;
                <button onClick={incrementItem}>증가</button> &nbsp;
                <button onClick={decrementItem}>감소</button>
            </div>
            {/* CSS style 적용 연습 : style 속성 값은 {} 안에 작성
                작성시에는 attribute Name을 꼭 camelCase로 작성  */}
            <h2 className="black_bar">
                리액트에서 스타일 적용<br/>
                이런거지
            </h2>
            <h2 style={myStyle}>
                리액트에서 스타일 적용2<br/>
                어때?
            </h2>
            <h2 style={{color:"red", textAlign:"center", backgroundColor:"pink"}}>
                리액트에서 스타일 적용3<br/>
                좋다
            </h2>
            <div>
                <img src={pic1} alt="히어로2" /> {/* 이미지 파일을 import해서 사용 */}
            </div>
            <div className="image_bg"></div> {/* 이미지 파일을 css로 배경화면으로 사용 */}
            <div >
                {/* public 폴더에 있는 이미지 파일을 사용 - 그러나 사용을 권장하지 않는다. Webpack과 Babel의 관리대상에 해당되지 않음*/}
                <img src={`${process.env.PUBLIC_URL}/imgs/flower.jpg`} alt="public 이미지 읽기" style={{width:"150px"}}/>
            </div>
        </div>
    )
}

// export default HookTest2;