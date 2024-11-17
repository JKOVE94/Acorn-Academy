//https://cafe.daum.net/flowlife/QbpR/68 문제
const Test = () => {
    const calc = () => {
        let data = document.querySelector("#input").value;
        let text = `미터 : ${data}m / 센티미터 : ${data * 100}cm`;
        document.querySelector("#result").innerText = text;
    }
    return (
        <>
        <h3>📐길이 환산📏</h3>
        <input type="text" id="input"></input> <button type="button" onClick={e=>{
            e.preventDefault();
            calc();
        }}>계산</button>
        <div id="result"></div>
        </>     
    );

}
export default Test;