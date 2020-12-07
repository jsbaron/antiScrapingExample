import React from 'react';
import HomeNav from "./HomeNav";
import {Card} from "react-bootstrap";
import {useSelector} from "react-redux";

const UserPage = () => {

    const currentUser = useSelector(state => state.currentUser.currentUser);

    return (
        <>
            <HomeNav/>
            <Card className={"mx-auto w-75"}>
                <Card.Title className={"text-center mb-3"}>
                    {currentUser.name}
                </Card.Title>
                <Card.Subtitle className={"text-center mb-3"}>
                    {currentUser.description}
                </Card.Subtitle>
                <Card.Body className={"text-center mb-3"}>
                    {currentUser.text}
                </Card.Body>
                <Card.Footer className="text-muted">
                    <div className={"d-flex flex-row"}>
                        <div>{new Date(currentUser.tweetCreated).toLocaleString()}</div>
                        <div className={"ml-auto"}>
                            {currentUser.tweetLocation}
                        </div>
                    </div>
                </Card.Footer>
            </Card>
        </>
    )
};

export default UserPage;