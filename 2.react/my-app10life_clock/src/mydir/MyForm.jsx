import React, {useState, useEffect} from 'react';

const MyForm = () => {
    const [formData, setFormData] = useState({
        irum : "",
        nai : "",
        menu : "아이스 아메리카노"
    });

    const dataChnage = (e) => {
        const name = e.target.name; //form tag 내의 name 속성 저장
        const value = e.target.value; //form tag 내의 value 속성 저장
        // console.log({[name]:value});
        // console.log({...formData});
        setFormData({
            ...formData, //formData 상태를 갱신, 기존 책체를 복사한 후 특정 필드만 갱신. 기존 상태를 유지하며 필요한 부분만 덮어쓰기
            [name]:value
        });
    }
    const dataSubmit = (e) => {
        e.preventDefault();

        const {nai} = formData;
        if(!Number(nai) || isNaN(Number(nai))){
            alert("나이는 숫자만 입력하세요.");
        }
    }

    //Life Cycle 관련
    useEffect(() => {
        console.log("MyForm 컴포넌트가 mount됨"); //componentDidMount
        return () => console.log("MyForm 컴포넌트가 unmount됨"); //componentWillUnmount
    }, []);

    //componentDidUpdate
    useEffect(() => console.log("MyForm 컴포넌트가 갱신될때 마다 update됨") ,[formData]);

    return(
        <>
        <h3>안녕 {formData.irum}, 넌 {formData.nai}살, 선택한 음료는 {formData.menu}</h3>
        <form onSubmit={dataSubmit}>
            이름 입력 : <input type="text" name="irum" onChange={dataChnage}/> <br/>
            나이 입력 : <input type="text" name="nai" onChange={dataChnage}/> <br/>
            음료 선택 :
            <select name="menu" onChange={dataChnage} value={formData.menu}>
                <option value="아이스 아메리카노">아이스 아메리카노</option>
                <option value="라떼">아이스 라떼</option>
                <option value="카푸치노">카푸치노</option>
            </select> <br/><br/>
            <button type="submit">전송</button>
        </form>
        </>
    )
}

export default MyForm;