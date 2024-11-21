import { createSlice } from '@reduxjs/toolkit';
//createSlice를 사용하면 보일러플레이트코드를 생략할 수 있다.

//reducer 파일
//createSlice : 리듀서와 액션을 생성, 초기 상태 정의, 함수 관리, 불변성 관리
const ResourceSlice = createSlice({
    name: 'resource', //Slice의 이름
    initialState: { //공유자원 정의
        value:0,
        kor: 50 
    },
    reducers: { //리듀서 정의, 각 함수는 state와 action을 인자로 받는다.
        increment: (state) => {
            state.value += 1;
        },
        decrement: (state) => {
            state.value -= 1;
        },
        reset: (state) => {
            state.value=0;
        }
    }
    //리듀서를 여러개 만들 수 있고 리듀서의 이름은 임의로 지정할 수 있다.
});

//Action, Reducer 내보내기
export const { increment, decrement, reset } = ResourceSlice.actions; //slice라는 의미처럼 Action를 각각 쪼개서 보내준다.
export default ResourceSlice.reducer; //리듀서를 내보낸다.