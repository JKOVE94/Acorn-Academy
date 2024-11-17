import Table from 'react-bootstrap/Table';

const Result = (props) => {
  if(props.listSize === 0){
    return
  }
  return(
    <td colSpan="3" >
      <b>건수 :</b> {props.listSize}건 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      <b>합계 :</b> {props.sum}원 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <b>평균 :</b> {(props.sum/props.listSize).toFixed(0)}원
    </td>
  )
}

const sTable = (props) => {
let sum = 0;
if(props.list.length === 0){
return (<div id="table">데이터가 없습니다.</div>)
}
  return(
    <Table  className="display" id="table">
      <tr>
        <th>코드</th>
        <th>상품명</th>
        <th>가격</th>
      </tr>
      
        {props.list.map(i =>(
          sum += parseInt(i.dan),
          <tr key={i.code}>
            <td>{i.code}</td>
            <td>{i.sang}</td>
            <td>{i.dan} 원</td>
          </tr>
          ))}
      
        <Result sum={sum} listSize={parseInt(props.list.length)}/>
      
      </Table>
  );  
}
export default sTable;