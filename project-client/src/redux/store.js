import {applyMiddleware, combineReducers, createStore} from "redux";
import thunkMiddleware from "redux-thunk";

import { usersReducer } from "./reducers/usersReducer";
import {pageReducer} from "./reducers/pageReducer";
import {currentUserReducer} from "./reducers/currentUserReducer";

const rootReducer = combineReducers({
    users: usersReducer,
    page: pageReducer,
    currentUser: currentUserReducer
})

export default createStore(rootReducer, applyMiddleware(thunkMiddleware));