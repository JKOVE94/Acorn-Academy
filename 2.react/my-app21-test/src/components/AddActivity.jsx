import React, {useState} from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {CREATE_EXERCISE} from '../redux/resourceSlice'; 
import { useEffect } from 'react';

const AddActivity = () => {
    const [exerciseTime, setExerciseTime] = useState({exStart: '', exEnd: ''});
    const [activity, setActivity] = useState({name: '', duration:0});
    const dispatch = useDispatch();

    const handleChange = (e) => {
        setActivity({...activity, name: e.target.value});
    }
    const convertToMinutes = (time) => {
        const hours = time.split(':')[0];
        const minutes = time.split(':')[1];
        return Number(hours * 60) + Number(minutes);
    }
    const handleTimeChange = (e) => {
        setExerciseTime({...exerciseTime, [e.target.name]: e.target.value});
    }
    const handleAdd = () => {
        const duration = convertToMinutes(exerciseTime.exEnd) - convertToMinutes(exerciseTime.exStart);
        setActivity({...activity, duration: duration});
        dispatch(CREATE_EXERCISE(activity));
    } 
    
    return(
        <>
        <h2>운동 등록</h2>
        운동명 : <input type="text" name="name" value={activity.name} onChange={handleChange}/><br/>
        운동 시작 시간 : <input type="time" name="exStart" value={exerciseTime.exStart} onChange={handleTimeChange}/><br/>
        운동 종료 시간 : <input type="time" name="exEnd" value={exerciseTime.exEnd} onChange={handleTimeChange}/><br/>
        <button onClick={handleAdd}>등록</button>
        </>
    )
}
export default AddActivity;