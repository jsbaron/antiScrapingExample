import axios from "axios";
import {USERS_ENFORCED} from "../redux/stateConstants";

const BASE_URL = "http://ec2-54-237-51-236.compute-1.amazonaws.com:8080/project_archive"
// const BASE_URL = "http://localhost:8080/project_archive";

const handleEnforcement = e => {
    if (e.response && e.response.status === 429) {
        return USERS_ENFORCED.users;
    } else {
        throw new Error(e);
    }
}

const API =  {
    getUsersByPage: async page => {
        try {
            const users = await axios.get(
                BASE_URL + `/users/page/${page}`);
            return users.data;
        } catch (e) {
            return handleEnforcement(e)
        }

    }
}
export default API;