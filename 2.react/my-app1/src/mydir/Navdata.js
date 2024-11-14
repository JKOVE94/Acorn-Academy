import {Component} from 'react';

class Navdata extends Component{
    render(){
        return(
            <ul>
                {/* root Element가 없으면 JSX에서는 에러가 발생한다. */}
                <li><a href="https://www.naver.com" target='blank'>네이버</a></li>
                <li><a href="https://www.daum.net" target='blank'>다음</a></li>
                <li><a href="./ab.html">abc문서</a></li>
                <strong>{this.props.msg}</strong><br/>
                <i>{this.props.msg2}</i>
            </ul>
        )
    }
}
export default Navdata;