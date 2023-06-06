import React from "react";
import {Link} from "react-router-dom";

const Start = () => {
    return (
        <div>
            <Link to={"/sign"}>
                <button>
                    Sign In
                </button>
            </Link>
            <Link to={"/login"}>
                <button>
                    Login
                </button>
            </Link>
        </div>
    )
}

export default Start
