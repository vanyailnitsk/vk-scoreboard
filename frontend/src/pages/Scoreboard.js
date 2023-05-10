import React, { useContext, useEffect } from "react";
import { Context } from "..";
import { observer } from "mobx-react-lite";
import { fetchAlgorithmTasks, fetchCyberSecurityTasks, fetchGlobalScores, fetchTestScores, fetchTestTasks } from "../http/tasksAPI";
import { check } from "../http/userAPI";
import { Container } from "react-bootstrap";

const Scoreboard = observer(() => {
    const { user } = useContext(Context)
    const { tasks } = useContext(Context)
    useEffect(() => {
        check().then(data => {
            user.setUser(data)
            user.setTestScores(data.testScores)
            user.setAlgorithmScores(data.algorithmScores)
            user.setCyberSecurityScores(data.cyberSecurityScores)
            user.setIsAuth(true)
        })
        fetchTestTasks().then(data => {
            tasks.setTestTasks(data)
            console.log(data)
            console.log(tasks)
        })
        fetchAlgorithmTasks().then(data => {
            tasks.setAlgorithmTasks(data)
            console.log(data)
            console.log(tasks._algorithmTasks)
        })
        fetchCyberSecurityTasks().then(data => {
            tasks.setCyberSecurityTasks(data)
        })
        fetchGlobalScores().then(data => {
            user.setTestRank(data.testRank)
            user.setAlgorithmRank(data.algorithmRank)
            user.setCyberSecurityRank(data.cyberSecurityRank)
            console.log(user)
        })
    }, [])
    return (
        <Container>
            <h2>Глобальный рейтинг</h2>
            <div>
                <h5>{'Вы занимаете '+user._testRank +' место в категории \"Тест\"'}</h5>
                <h5>{'Вы занимаете '+user._algorithmRank +' место в категории \"Алгоритмы\"'}</h5>
                <h5>{'Вы занимаете '+user._cyberSecurityRank +' место в категории \"Кибербезопасность\"'}</h5>
            </div>
            <h2>Ваш прогресс в решении задач</h2>
            <div>
                <h4>{'Категория \"Тест\": решено ' + user.testScores.length + ' из ' + tasks._testTasks.length}</h4>
                {user.testScores.map(task =>
                    <h6>
                        {task.test.title}
                    </h6>
                )}
            </div>
            <div>
                <h4>{'Категория \"Алгоритмы\": решено ' + user.algorithmScores.length + ' из ' + tasks._algorithmTasks.length}</h4>
                {user.algorithmScores.map(task =>
                    <h6>
                        {task.algorithmTask.title}
                    </h6>
                )}
            </div>
            <div>
                <h4>{'Категория \"Кибербезопасноть\": решено ' + user._cyberSecurityScores.length + ' из ' + tasks._cyberSecurityTasks.length}</h4>
                {user._cyberSecurityScores.map(task =>
                    <h6>
                        {task.task.title}
                    </h6>
                )}
            </div>
        </Container>
    );
})

export default Scoreboard;
