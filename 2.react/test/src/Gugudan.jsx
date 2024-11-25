
const Gugudan = () => {
    const gugu = [];
    const dan = 3;
    
    for(let i=1 ; i<10 ; i++){
        gugu.push(i);
    }
       
    return(
        <div>
            {gugu.map((num) => (
                <div key={num}>{dan} X {num} = {dan*num} </div> 
            ))}
        </div>
    )
}

export default Gugudan;