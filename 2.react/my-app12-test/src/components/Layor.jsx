
const Layor = ({formData, visits, deleteVisit, clearVisits}) => {
    return(
        <div>
            <div className="left">
            <h2 className='center'>거래처 정보 입력</h2>
            {formData}
            <br/>
            {visits}
            <button className='button right' onClick={clearVisits}>전체 삭제</button>
            </div>
            <div className="right">
            </div>
        </div>
    )
}
export default Layor;