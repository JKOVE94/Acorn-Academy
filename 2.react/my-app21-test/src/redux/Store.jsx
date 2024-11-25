import React from 'react';
import {configureStore} from '@reduxjs/toolkit';
import resourceSlice from './resourceSlice';

const Store = configureStore({
    reducer:{
        resource: resourceSlice
    }
})

export default Store;