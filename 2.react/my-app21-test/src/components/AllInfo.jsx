import React, {useState, useEffect} from 'react';
import axios from 'axios';

const AllInfo = () => {
    const [namechecked, setNamechecked] = useState(true);
    const [durationchecked, setDurationchecked] = useState(true);
    const [calorichecked, setCalorichecked] = useState(true);

    const handlecheck = (e) => {
        switch(e.target.name){
            case 'name':
                setNamechecked(!namechecked);
                break;
            case 'duration':
                setDurationchecked(!durationchecked);
                break;
            case 'calori':
                setCalorichecked(!calorichecked);
                break;
        }
    }

    useEffect(() => {
        
    })

    return(
        <div>
            <table border="1">
                <thead>
                <tr>
                    <td>id</td>
                    <td>name<span><input type="checkbox" name="name" checked={namechecked} onChange={handlecheck}/></span></td>
                    <td>duration<input type="checkbox" name="duration" checked={durationchecked} onChange={handlecheck}/></td>
                    <td>calori<input type="checkbox" name="calori" checked={calorichecked} onChange={handlecheck}/></td>
                    <td><button >선택결과</button></td>
                </tr>
                </thead>
            </table>
        </div>
    )
}
export default AllInfo;