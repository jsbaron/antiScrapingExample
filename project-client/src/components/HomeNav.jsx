import React from 'react';
import {Nav} from 'react-bootstrap';
import {useDispatch} from "react-redux";
import {setCurrentUser} from "../redux/actions";
import {CURRENT_USER_NONE} from "../redux/stateConstants";

const HomeNav = () => {
    const dispatch = useDispatch();
    return (
        <Nav>
            <Nav.Item className={"m-3"}>
                <Nav.Link
                    onClick={() => {
                        dispatch(setCurrentUser(CURRENT_USER_NONE))
                    }}
                >
                    Back to Timeline
                </Nav.Link>
            </Nav.Item>

        </Nav>
    )
};

export default HomeNav;