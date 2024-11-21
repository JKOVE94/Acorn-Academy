import React from 'react';

const JikwonResult = ({jikwonList,avgSal}) => {

    if(jikwonList.length === 0) return <div>직원이 없습니다.</div>;
    else return(
            <table border="1">
                <thead>
                    <tr>
                        <th>사번</th>
                        <th>이름</th>
                        <th>부서명</th>
                        <th>직급</th>
                        <th>연봉</th>
                    </tr>
                </thead>
                <tbody>
                    {jikwonList.map((jikwon) => (
                        <tr key={jikwon.jikwonno}>
                            <td>{jikwon.jikwonno}</td>
                            <td>{jikwon.jikwonname}</td>
                            <td>{jikwon.busername}</td>
                            <td>{jikwon.jikwonjik}</td>
                            <td>{jikwon.jikwonpay}</td>
                        </tr>
                    ))}
                    <tr>
                        <td colSpan="2">인원수 : {jikwonList.length} 명</td>
                        <td colSpan="3">
                            평균연봉 : {avgSal}
                        </td>
                    </tr>
                </tbody>
            </table>
    )
}

export default JikwonResult;