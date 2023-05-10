import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Routes, Route, Navigate } from 'react-router-dom'
import { authRoutes, publicRoutes } from "../routes";
import { Context } from "..";
import Auth from "../pages/Auth";
import Tasks from "../pages/Tasks";

const AppRouter = observer(() => {
    const {user} = useContext(Context)
    return (
        //<Router>
        <Routes>
            {user.isAuth && authRoutes.map(({ path, Component }) =>
                <Route key={path} path={path} element={<Component />} />
            )}
            {publicRoutes.map(({ path, Component }) =>
                <Route key={path} path={path} element={<Component />} />
            )}
            <Route
            path="*"
                element={<Navigate to="/" replace />}
            />
        </Routes>
    )
})
export default AppRouter; 