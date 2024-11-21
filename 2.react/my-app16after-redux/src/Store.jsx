import { configureStore } from '@reduxjs/toolkit';
import numberReducer from './Reducer';

const Store = configureStore({
    // 리듀서 등록
    reducer: numberReducer,
});

export default Store;