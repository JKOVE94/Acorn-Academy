import { Component } from "react";

export default class Component1 extends Component {
    render(){
        const clickHandler = () => {
            console.log("자체적으로 선언된 함수 실행")
        };

        const keyupHandler = event => {
            console.log("입력한 값 : " + event.target.value);
        }

        return(
            <div>
                <h3>{this.props.title}</h3>
                {this.props.subtitle}<br/>
                <hr/>
                버튼으로 이벤트 발생 <br/>
                {/* 
                처음 화살표 함수로 작업하면서 .bind()를 붙여주니 에러가 발생했다. 
                찾아보니 화살표함수는 this가 외부 스코프에서 결정되므로 bind를 사용할 필요가 없기 때문이라고 한다.
                */}
                <button onClick={function(){
                    this.props.changeData();
                }.bind(this)}>props로 받은 함수</button>
                <br/>
                <button onClick={clickHandler}> 변수로 지정된 함수 </button>
                <br/>
                데이터 입력 : <input type="text" onKeyUp={keyupHandler}/>
                <div ></div>
            </div>
        );
    }
}