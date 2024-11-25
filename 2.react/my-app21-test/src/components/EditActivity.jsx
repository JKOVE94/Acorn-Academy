import React, {useState, useEffect} from 'react';
import {useParams} from 'react-router-dom';
import {useSelector, useDispatch} from 'react-redux';
import {UPDATE_EXERCISE} from '../redux/resourceSlice';

const EditActivity = () => {
    const dispatch = useDispatch();
    const {id} = useParams();
    const allExercises = useSelector(state => state.resource.dbData);
    const [data, setData] = useState({id: id, name: '', duration: 0, calorieburn: 0});
    
    const findData = (id) => {
        const result = allExercises.find(exercise => exercise.id === Number(id));
        setData(result);
        console.log(result);
    }

    useEffect(() => {
        findData(id);
    },[])

    const handleChange = (e) => {
        setData({...data, [e.target.name]: e.target.value});
    }

    const changeData = () => {
        dispatch(UPDATE_EXERCISE(data));
    }

    return(
        <>
        <h2>운동정보 수정</h2>
        <div>
            운동명 : <input type="text" name="name" value={data.name} onChange={handleChange}/><br/>
            운동시간 (분) : <input type="text" name="duration" value={data.duration} onChange={handleChange}/><br/>
            칼로리 : <input type="text" name="calorieburn" value={data.calorieburn} onChange={handleChange}/><br/>
            <button onClick={changeData}>수정</button>
        </div>
        </>
    )
}

export default EditActivity;