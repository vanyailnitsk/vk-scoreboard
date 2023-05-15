import NavBar from "./components/NavBar";
import AppRouter from "./components/AppRouter";
import { BrowserRouter, HashRouter } from "react-router-dom";
import { observer } from "mobx-react-lite";
import { useContext, useEffect } from "react";
import { Context } from ".";
import { check } from "./http/userAPI";
import { fetchAlgorithmTasks, fetchCyberSecurityTasks, fetchGlobalScores, fetchTestTasks } from "./http/tasksAPI";

const App = observer(() => {
    document.body.style.backgroundColor = '#f6f6f9';
    const {user} = useContext(Context)
    const {tasks} = useContext(Context)
    useEffect(() => {
        fetchTestTasks().then(data => {
            tasks.setTestTasks(data)
        })
        fetchAlgorithmTasks().then(data => {
            tasks.setAlgorithmTasks(data)
        })
        fetchCyberSecurityTasks().then(data => {
            tasks.setCyberSecurityTasks(data)
        })
        if (localStorage.getItem("token") == null) {
            return 
        }
        check().then(data => {
            user.setUser(data)
            user.setTestScores(data.testScores)
            user.setAlgorithmScores(data.algorithmScores)
            user.setCyberSecurityScores(data.cyberSecurityScores)
            user.setIsAuth(true)
        }).then(() => {
            fetchGlobalScores().then(data => {
                user.setTestRank(data.testRank)
                user.setAlgorithmRank(data.algorithmRank)
                user.setCyberSecurityRank(data.cyberSecurityRank)
                console.log(user)
            })
        })
    })
    
    return (
        <BrowserRouter>
            <NavBar />
            <AppRouter />
        </BrowserRouter>
    );
})

export default App;
