import { USERS } from "../stateConstants";

import { SET_USERS } from "../actionConstants";

export const usersReducer = (state = USERS, action) => {
    switch (action.type) {
        case SET_USERS:
            return { ...state, users: action.payload.users };
        default:
            return state;
    }
};
