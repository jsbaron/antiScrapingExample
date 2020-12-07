import axios from "axios";

const BASE_URL = "http://ec2-54-237-51-236.compute-1.amazonaws.com:8080/project-server_war"


const API =  {
    getUsersByPage: async page => {
        const users = await axios.get(BASE_URL + `/users/page/${page}`);
        console.log(users)
        return users.data;
    }
}
export default API;