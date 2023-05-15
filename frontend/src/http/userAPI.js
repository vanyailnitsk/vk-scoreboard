import { async } from "q";
import {$authHost, $host} from "./index";

// export const registration = async (name, email, password) => {
//     const {data} = await $host.post('auth/register', {name, email, password})
//     localStorage.setItem('token', data.token)
//     return jwt_decode(data.token)
// }

export const login = async (email, password) => {
    // var credentials = btoa(email+":"+password);
    // var auth = { "Authorization" : `Basic ${credentials}` };
    const {data} = await $host.post('auth/login', {email,password})
    var credentials = btoa(email+":"+password)
    localStorage.setItem('token', credentials)
    //axios.defaults.headers.common["Authorization"] = `Bearer ${data.token}`;
    return data
}

export const check = async () => {
    if (localStorage.getItem("token") == null) {
        return 
    }
    const {data} = await $authHost.get('user')
    console.log(data)
    return data
}
