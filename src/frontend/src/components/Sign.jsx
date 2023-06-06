import React from "react";
import {useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";

const Sign = () => {
    const navigate = useNavigate()
    const {register, handleSubmit} = useForm()

    const onSubmit = async (userName) => {
        try {
            const response = await fetch(`http://localhost:4200/user`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: userName.userName
            })
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
                <button type={"submit"}>Sign in</button>
            </form>
        </div>
    )
}

export default Sign
