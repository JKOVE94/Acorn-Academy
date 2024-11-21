import {configureStore} from '@reduxjs/toolkit';
import resourceReducer from './ResourceSlice';

const Store = configureStore({
    reducer: {
        resource: resourceReducer
    }
})

export default Store;