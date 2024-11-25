import {createSlice} from '@reduxjs/toolkit';
import { useEffect } from 'react';
import axios from 'axios';

//운동마다 고유 에너지 소비량을 db로 설정하면 좋겠지만 지금 상황은 그것이 어려우니 0.05로 설정
//duration은 무조건 분단위

const calcCalories = (weight, exercise) => {
    return 0.05 * weight * exercise.duration;
}

const insertDB = async (data) => {
    try {
        await axios.post('/exercises', data);
    } catch (err) {
        console.error(err);
    }
}

const updateDB = async (id,data) => {
    try {
        await axios.post(`/exercises/${id}`, data);
    } catch (err) {
        console.error(err);
    }
}

const resourceSlice = createSlice({
    name : 'resource',
    initialState: {
        name: '',
        weight: 0,
        exercises: [{}],
        dbData: []
    },
    reducers: {
        SET_DATA : (state,action) => {
            state.dbData = action.payload;
            state.exercises = state.dbData;
        },
        SET_USER: (state, action) => {
            state.name = action.payload.name;
            state.weight = action.payload.weight;
        },
        CREATE_EXERCISE: (state, action) => {
            const data = {name: action.payload.name, duration: action.payload.duration, calorieburn: calcCalories(state.weight, action.payload)};
            state.exercises.push(data);
            insertDB(data);
        },
        UPDATE_EXERCISE: (state, action) => {
            const target = state.exercises.find(exercise => exercise.id === action.payload.id).name
            target.name = action.payload.name;
            target.duration = action.payload.duration;
            target.calorieburn = action.payload.calorieburn;
            updateDB(action.payload.id, target);
        },
    }
})

export const {SET_DATA, SET_USER, CREATE_EXERCISE,UPDATE_EXERCISE} = resourceSlice.actions;
export default resourceSlice.reducer;