import React from 'react';
import Timeline from "../components/Timeline";
import 'bootstrap/dist/css/bootstrap.min.css';
import {useSelector} from "react-redux";
import {CURRENT_USER_NONE} from "../redux/stateConstants";
import UserPage from "../components/UserPage";

const App = () => {

    const currentUser = useSelector(state => state.currentUser.currentUser);
    return (
        <>
            {
                currentUser === CURRENT_USER_NONE?
                    <Timeline/>
                    : <UserPage/>
            }

        </>
    )
};

export default App;
