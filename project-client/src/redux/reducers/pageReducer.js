import { PAGE } from "../stateConstants";

import { SET_PAGE } from "../actionConstants";

export const pageReducer = (state = PAGE, action) => {
    switch (action.type) {
        case SET_PAGE:
            return { ...state, page: action.payload.page };
        default:
            return state;
    }
};
