import Admin from "./pages/Admin"
import Auth from "./pages/Auth"
import { ADMIN_ROUTE, LOGIN_ROUTE, REGISTRATION_ROUTE, SCOREBOARD_ROUTE, TASKS_ROUTE, } from "./utils/consts"
import Scoreboard from "./pages/Scoreboard"
import Tasks from "./pages/Tasks"

 export const authRoutes =[
    {
        path: ADMIN_ROUTE,
        Component: Admin
    },
    {
        path: SCOREBOARD_ROUTE,
        Component : Scoreboard
    },
    

 ]
 export const publicRoutes = [
    {
        path: LOGIN_ROUTE,
        Component: Auth
    },
    {
        path: REGISTRATION_ROUTE,
        Component: Auth
    },
    {
        path : TASKS_ROUTE,
        Component : Tasks
    }
 ]