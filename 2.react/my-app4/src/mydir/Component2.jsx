const Component2 = props => {
   const list =[];
   const datas = props.friends;
   let i = 0;

   while(i< datas.length){
        //React에서 반복문을 실행할 때에는 각각의 요소에 key값을 지정해주어야 한다. (unique한 값)
        //각 항목을 구분하는 식별자를 추가하여 key props 경고를 해결하자
        list.push(<h5 key={datas[i].bun}>{datas[i].bun}번 {datas[i].irum}의 나이는 {datas[i].nai}</h5>)
        i++;
   }

    return (
        <div>
            {props.title} {props.subtitle}<br/>
            {list}
            {/* a태그로 이벤트 처리 */}
            <a key="props.changeData()" href="#" onClick={e => {
                e.preventDefault();
                props.changeData();
            }}>props로 받은 함수</a>
        </div>
    )
}
export default Component2;