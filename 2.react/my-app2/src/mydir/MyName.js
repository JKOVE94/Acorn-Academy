import React, {Component} from 'react'; 

class MyName extends Component{
    /*
    static defaultProps = {
        name : '누렁이'
    }
    */
    render(){
        return(
            <div>
                안녕하세요 제 이름은 {this.props.name} 입니다. &nbsp;&nbsp;
                 {this.props.addr}에서 살고 있습니다. <b>- {this.props.type}</b>
            </div>
        )
    }
}

MyName.defaultProps = {
    name : '누렁이',
    addr : '서울시',
    type : '기본값'
}

export default MyName;