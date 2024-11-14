/*
const MyName2 = props => {
    console.log(props, ' ', props.name, ' ', props.addr);
    return(
        <>
            안녕하세요 제 이름은 {props.name} 입니다. &nbsp;&nbsp;
            {props.addr}에서 살고 있습니다. <b>- {props.type}</b>
        </>
    );
}
*/

const MyName2 = ({name, addr, type}) => {
    // let aa = name + "님";
    // console.log(aa);
    return(
        <>
            반갑습니다 제 이름은 {name} 입니다. &nbsp;&nbsp;
            {addr}에서 살고 있습니다. <b>- {type}</b>
        </>
    );
};

MyName2.defaultProps = {
    name : '누렁이',
    addr : '서울시',
    type : '기본값'
};

export default MyName2;