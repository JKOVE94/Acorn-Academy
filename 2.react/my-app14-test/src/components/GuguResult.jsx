
const GuguResult = ({gugu}) => {

    if(gugu===0) return(<div></div>)
    return(
        <div>
            <h3>{gugu} 단</h3>
            {[1,2,3,4,5,6,7,8,9].map(i => (
                <div key={i}>
                    {gugu} * {i} = {gugu * i}
                </div>
            ))}
        </div>
    )
}
export default GuguResult