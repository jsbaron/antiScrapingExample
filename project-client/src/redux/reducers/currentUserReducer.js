import { CURRENT_USER } from "../stateConstants";

import { SET_CURRENT_USER } from "../actionConstants";

export const currentUserReducer = (state = CURRENT_USER, action) => {
    switch (action.type) {
        case SET_CURRENT_USER:
            return { ...state, currentUser: action.payload.currentUser };
        default:
            return state;
    }
};
