// 디스패치된 액션은 Reducer에서 처리되며 state를 업데이트 함
import {combineReducers} from 'redux'; // 여러개의 reducer를 하나로 합치기 위해 사용


const employeeReducer = (state = [], action) => {
    switch(action.type){
        case "SET_EMPLOYEES":
            return action.payload;
            // dispatch(setEmployees([{jikwonno:"1", jikwonname:"홍길동"},... ]))
        default: return state;
    }
}

const customerReducer = (state = [], action) => {
    switch(action.type){
        case "SET_CUSTOMERS":
            return action.payload;
        default: return state;
    }
}

//여러 리듀서를 결합하고 리덕스 스토어에서 사용할 수 있도록 함
export default combineReducers({
    employees : employeeReducer,
    customers : customerReducer
});