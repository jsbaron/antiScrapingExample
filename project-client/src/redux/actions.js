import {SET_CURRENT_USER, SET_PAGE, SET_USERS} from "./actionConstants";

export const setUsers = users => ({
    type: SET_USERS,
    payload: {
        users: users
    }
});

export const setPage = page => ({
    type: SET_PAGE,
    payload: {
        page: page
    }
});

export const setCurrentUser = user => ({
    type: SET_CURRENT_USER,
    payload: {
        currentUser: user
    }
});