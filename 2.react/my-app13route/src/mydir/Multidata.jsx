import React from 'react';
import { useState } from 'react';  

const MemberComp = ({memberData}) => {
    return(
        <tr>
            <td>{memberData.irum}</td>
            <td>{memberData.junhwa}</td>
        </tr>
    );
}

const Multidata = () => {
    const members = [
        {irum : "관우", junhwa : "111-1111"},
        {irum : "유비", junhwa : "222-2222"},
        {irum : "장비", junhwa : "333-3333"}
    ];

    return (
        <table>
            <thead>
                <tr>
                    <th>이름</th>
                    <th>전화번호</th>
                </tr>
            </thead>
            <tbody>
                {members.map((mem, idx) => (
                       <MemberComp key={idx} memberData={mem}/>
                ))}
            </tbody>
        </table>
    )
}


export default Multidata;