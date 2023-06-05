import './App.css';
import {Route, Routes} from "react-router-dom";
import HomeButton from "./components/HomeButton";
import Start from "./components/Start";
import Login from "./components/Login";
import Sign from "./components/Sign";
import Profile from "./components/Profile";

function App() {
    return (
        <div className="App">
            <HomeButton/>
            <Routes>
                <Route path={"/"} element={<Start/>}/>
                <Route path={"/login"} element={<Login/>}/>
                <Route path={"/sign"} element={<Sign/>}/>
                <Route path={"/user/:username"} element={<Profile/>}/>
            </Routes>
        </div>
    );
}

export default App;
