import {createSlice} from '@reduxjs/toolkit';

//총 가격 계산 함수
const calcTotalPrice = (state) => {
    let total = 0;
    state.items.forEach(item => {
        total += item.price * item.quantity;
    });
    return total;
}

// 지정해야하는 값 : {id: , name: , price, quantity}
const ResourceSlice = createSlice({
    name : 'cart',
    initialState : {
        items:[],
        totalPrice :0,
        errorMsg: ''
    },
    reducers: {

        //상품 추가
        ADD_TO_CART: (state, action) => {
            //이미 items 안에 해당 id가 존재할 경우에는 수량을 추가
            if(state.items.find(item => item.id === action.payload.id)){
                ///해당 상품의 수량 변경
                state.items.find(item => item.id === action.payload.id)
                            .quantity += action.payload.quantity;
                state.totalPrice = calcTotalPrice(state); //총 가격 계산   
            }
            else{
                state.items.push(action.payload); //items에 추가
                state.totalPrice = calcTotalPrice(state); // 총 가격 계산
            }
        },

        //상품 제거   
        REMOVE_FROM_CART: (state, action) => {
            //만약 state배열에 해당 상품이 존재한다면
            if(state.items.find(item => item.id === action.payload.id)){
                //해당 상품 제거
                state.items = state.items.filter(item => item.id !== action.payload.id);
                state.totalPrice = calcTotalPrice(state); //총 가격 계산
            }
            else{
                state.errorMsg = '해당 상품은 존재하지 않습니다.';
            }
        },
        
        //수량 변경
        UPDATE_QUANTITY: (state, action) => {
            //만약 state배열에 해당 상품이 존재한다면
            if(state.items.find(item => item.id === action.payload.id)){
                //해당 상품의 수량 변경
                state.items.find(item => item.id === action.payload.id)
                            .quantity = action.payload.quantity;
                state.totalPrice = calcTotalPrice(state); //총 가격 계산
            }
            else{
                state.errorMsg = '해당 상품은 존재하지 않습니다.';
            }
        }
    }
})

export const {ADD_TO_CART, REMOVE_FROM_CART, UPDATE_QUANTITY} = ResourceSlice.actions;
export default ResourceSlice.reducer;