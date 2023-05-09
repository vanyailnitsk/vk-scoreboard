import NavBar from "./components/NavBar";
import AppRouter from "./components/AppRouter";
import { BrowserRouter } from "react-router-dom";
import { observer } from "mobx-react-lite";
import { useContext, useEffect } from "react";
import { Context } from ".";
import { check } from "./http/userAPI";

const App = observer(() => {
    document.body.style.backgroundColor = '#f6f6f9';
    
    return (
        <BrowserRouter>
            <NavBar />
            <AppRouter />
        </BrowserRouter>
    );
})

export default App;
