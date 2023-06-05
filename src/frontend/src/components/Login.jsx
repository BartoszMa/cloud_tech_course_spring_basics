import React from "react";
import {useForm} from 'react-hook-form';
import {Navigate, useNavigate} from "react-router-dom";

const Login = () => {
    const navigate = useNavigate()
    const {register, handleSubmit} = useForm()

    const onSubmit = async (userName) => {
        try {
            const response = await fetch(`http://localhost:4200/user/${userName.userName}`)
            if (response.status === 200) {
                navigate(`/user/${userName.userName}`)
            } else {
                console.log("wrong user name")
            }
        } catch (err) {
            console.log(err)
        }
    }

    return (
        <div>
            <form onSubmit={handleSubmit(onSubmit)}>
                <input {...register("userName", {required: "userName required"})}/>
                <button type={"submit"}>Log in</button>
            </form>
        </div>
    )
}

export default Login
