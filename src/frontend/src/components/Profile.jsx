import React, {useState, useEffect} from "react";
import {useParams} from "react-router-dom";

const Profile = () => {
    const {username} = useParams();
    const [data, setData] = useState(null);
    const [counter, setCounter] = useState(0);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:4200/user/${username}`);
                const data = await response.json();
                setData(data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, [username]);

    const onSubmit = async () => {
        try {
            await fetch(`http://localhost:4200/user/${username}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: counter
            })
        } catch (error) {
            console.log(error)
        }
    }


    const increase = () => {
        setCounter(count => count + 1);
    };

    const decrease = () => {
        setCounter(count => count - 1);
    };

    const reset = () => {
        setCounter(0)
    }

    if (data === null) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <div>UserName: {data.user}</div>
            <div>Score: {data.score}</div>
            <div>Counter: {counter}</div>
            <div>
                <button onClick={increase}>+</button>
                <button onClick={decrease}>-</button>
                <button onClick={reset}>Reset</button>
            </div>
            <button onClick={onSubmit}>Submit</button>
        </div>
    );
};

export default Profile;
