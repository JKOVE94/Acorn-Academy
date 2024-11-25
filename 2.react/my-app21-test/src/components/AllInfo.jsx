import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {useSelector, useDispatch} from 'react-redux';
import {useNavigate} from 'react-router-dom';

const AllInfo = () => {
    const navigate = useNavigate();
    const allExercises = useSelector(state => state.resource.dbData);

    const [checked, setChecked] = useState({name: true, duration: true, calori: true});

    const handlechange = (e) => {
        setChecked({...checked, [e.target.name]: !checked[e.target.name]});
    }
    const gotoEdit = (id) => {
        return () => {
            navigate(`/editActivity/${id}`);
        }
    }
    
    return(
        <div>
            <table border="1">
                <thead>
                <tr>
                    <td>id</td>
                    <td>name<span><input type="checkbox" name="name" checked={checked.name} onChange={handlechange}/></span></td>
                    <td>duration<input type="checkbox" name="duration" checked={checked.duration} onChange={handlechange}/></td>
                    <td>calori<input type="checkbox" name="calori" checked={checked.calori} onChange={handlechange}/></td>
                    <td><button >선택결과</button></td>
                </tr>
                {allExercises.map((exercise, index) => {
                    return(
                        <tr key={index}>
                            <td>{exercise.id}</td>
                            <td onClick={gotoEdit(exercise.id)}>{exercise.name}</td>
                            <td>{exercise.duration/60}시간</td>
                            <td>{exercise.calorieburn} kcal</td>
                            <td><button>삭제</button></td>
                        </tr>
                    )
                })}
                </thead>
            </table>
        </div>
    )
}
export default AllInfo;