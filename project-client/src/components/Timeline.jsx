import React, {useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {setCurrentUser, setUsers} from "../redux/actions";
import API from "../utils/API";
import {Button, Card, ListGroup, Alert} from "react-bootstrap";
import PageNav from "./PageNav";
import {USERS_ENFORCED} from "../redux/stateConstants";
import HoneyPotButton from "./HoneyPotButton";

const Timeline = () => {
    const dispatch = useDispatch();

    const page = useSelector(state => state.page.page);

    const users = useSelector(state => state.users.users);

    useEffect(() => {
        const fetchUsers = async () => {
            dispatch(setUsers(await API.getUsersByPage(page)));
        }
        fetchUsers();
    }, [dispatch, page]);

    return (
        <>
            {
                users === USERS_ENFORCED.users ?
                    <Alert variant={"danger"} className={"ml-auto mr-auto mt-5"}>
                        <h3>You're making too many requests!</h3>
                    </Alert>
                    :
                    <>
                        <ListGroup className={"mx-auto w-75 mt-5 mb-3"}>
                            {
                                users.map((user, i) => (
                                    <ListGroup.Item key={i}>
                                        <Card style={{border: "none"}}>
                                            <Card.Title>
                                                <Button
                                                    variant={"link"}
                                                    onClick={() => {
                                                        dispatch(setCurrentUser(user));
                                                    }}
                                                >
                                                    {user.name}
                                                </Button>
                                            </Card.Title>
                                            <Card.Body className={"mt-0 pt-0"}>{user.text}</Card.Body>
                                            <Card.Footer className="text-muted">
                                                <div className={"d-flex flex-row"}>
                                                    <div>{new Date(user.tweetCreated).toLocaleString()}</div>
                                                    <div className={"ml-auto"}>
                                                        {user.tweetLocation}
                                                    </div>
                                                </div>
                                            </Card.Footer>
                                        </Card>
                                    </ListGroup.Item>
                                ))
                            }
                        </ListGroup>
                        <HoneyPotButton/>
                        <PageNav/>
                    </>
            }

        </>
    )
};

export default Timeline;