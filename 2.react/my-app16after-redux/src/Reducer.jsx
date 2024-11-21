//리덕스의 리듀서 함수 : Action에 따라 변경하는 순수함수로 현재 state와 action을 받아 새로운 state를 반환한다.

//리듀서의 초기 상태 설정
const initailState = { number:0 };

const numberReducer = (state=initailState, action) => {
    switch(action.type){
        case 'INCREASE_NUMBER':
            return {number: state.number + action.payload} //넘어오는 값을 payload라고 한다.;
        default:
            return state;
    }
}
export default numberReducer;