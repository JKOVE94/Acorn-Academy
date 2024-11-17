//Class 기반 컴포넌트에서 상태관리하기

import React from 'react';

class App2 extends React.Component {
constructor(props) {
    super(props);
    this.state = {
        items:[],text:""
    }
    this.handleTextChange = this.handleTextChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    }
    render(){
        return(
            <div>
            <h2>취미 목록</h2>
      <HobbyList itemsProps={this.state.items}/>
      <form onSubmit={this.handleSubmit}>
        <label htmlFor="new-hobby">취미 : </label> {/*React에서 for는 오류가 발생한다. 그렇기때문에 htmlFor를 사용해야 한다.*/}
        <input type="text" id="new-hobby" onChange={this.handleTextChange} value={this.state.text}/> &nbsp;&nbsp;<button>클릭 #{this.state.items.length}</button>
      </form>    
      <br/>
      <div>총 건수 : {this.state.items.length}</div>
            </div>
        )
    }
    handleTextChange(e){
    this.setState({text:e.target.value});
  }
  
  handleSubmit(e){
    e.preventDefault();
    if(this.state.text.length===0){
      return;
    }
    const newItem = {
      id: Date.now(),
      text:this.state.text,
    };
    this.setState((preItems) => ({
        items:this.state.items.concat(newItem),
        text:""
    }))
  }
}

export default App2; 

//다른 클래스 컴포넌트로 분리
class HobbyList extends React.Component {
    render(){
        return (
            <ul>
            {this.props.itemsProps.map(item => (
              <li key={item.id}>{item.text}</li>
            ))}
          </ul>
        )
    }
}