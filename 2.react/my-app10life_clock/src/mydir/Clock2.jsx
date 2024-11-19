import React, { Component } from "react";

export default class Clock2 extends Component{
    
    /*Mount : DOM이 생성되고 결과가 브라우저로 출력되는것을 의미
    ---- Mount 호출 순서 (1-3 눈에 보이지 않는 과정, 4. 브라우저 렌더링) ----
        1. constructor() : 컴포넌트가 생성될 때 가장 먼저 실행되는 함수
        2. getDerivedStateFromProps() : props로 받아온 값을 state에 동기화 시키고 싶을 때 사용
        3. render() : 컴포넌트 렌더링
        4. componentDidMount() : 컴포넌트가 생성되고 첫 렌더링을 다 마친 후 실행되는 함수
    */

    //constructor는 컴포넌트의 Life Cycle과 관련된 함수이다.
    constructor(props){ 
        super(props);
        this.state = {date: new Date()}; 
    }

    //componentDidMount는 최초의 컴포넌트가 렌더링된 직후에 호출되는 함수. callback method
    //타이머 설정하기에 매우 적합하다
    componentDidMount(){ 
        //setInterval(사용할 함수, 시간) : 일정 시간 간격으로 함수를 반복 실행
        this.timerId =  setInterval(() => this.showSigan(), 1000);
    }

    //componentWillUnmount가 화면에서 사라지기 직전에 호출되는 함수 (자바의 Distroy와 비슷). 주로 마무리 작업에서 사용
    componentWillUnmount(){
        //타이머 해제 작업
        clearInterval(this.timerId);
    }

    //시간 출력용 메소드
    showSigan = () => {
        this.setState({date: new Date()});
    }

    componentDidUpdate(){
        console.log("Clock2 컴포넌트가 갱신될때 마다 update됨");
    }
    
    render(){
        return(
            <div>
                <h1>반가워~</h1>
                <h2>지금은 {new Date().toLocaleTimeString()}</h2> {/* 원래는 정적인 시간으로 출력되어야 하지만 componentDidMount로 렌더링되는 state로 인해 같이 렌더링 되기 떄문 (컴포넌트 자체의 리렌더링) */}
                <h2>현재 시간은 {this.state.date.toLocaleTimeString()}</h2> {/* 동적인 시간 */}
            </div>
        )
    }
}