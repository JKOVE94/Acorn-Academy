import {configureStore} from '@reduxjs/toolkit';
import ResourceSlice from './ResourceSlice';

const Store = configureStore({
    reducer: {
        cart : ResourceSlice
    }
})

export default Store;