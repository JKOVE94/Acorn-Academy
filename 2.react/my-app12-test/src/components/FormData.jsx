
const Input = ({addVisit}) => {
    return (
        <form onSubmit={addVisit}>
            <label htmlFor="clientName">거래처 이름</label>
            <input className='input' type='text' id='clientName' name='clientName'></input><br/>
            <label htmlFor="address"> 주소 </label>
            <input className='input' type='text' id='address' name='address'></input><br/>
            <label htmlFor="visitDate"> 방문일 </label>
            <input className='input' type='date' id="visitDate" name='visitDate'></input>
            <button className='button right' type='submit'>등록</button>
        </form>
    )
}

export default Input;
