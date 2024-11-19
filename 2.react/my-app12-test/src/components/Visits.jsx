
const ShowList = ({visits, deleteVist}) => {
    
    return(
        <table className='table'>
            <tr className='border1' >
                <th>번호</th>
                <th>거래처 이름</th>
                <th>주소</th>
                <th>방문일</th>
                <th>삭제</th>
            </tr >
            {visits.map(visit =>(
                <tr key={visit.id}>
                    <td>{visit.id}</td>
                    <td>{visit.clientName}</td>
                    <td>{visit.addr}</td>
                    <td>{visit.visitDate}</td>
                    <td><div className='delete' onClick={()=> deleteVist(visit.id)}>✖️</div></td>
                </tr>
            ))}
        </table>
    );
}
export default ShowList; 