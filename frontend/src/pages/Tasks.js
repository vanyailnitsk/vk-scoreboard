import React, { useContext, useEffect } from "react";
import { Button, Card, Container } from "react-bootstrap";
import { Context } from "..";
import { fetchAlgorithmTasks, fetchTestTasks } from "../http/tasksAPI";
import { observer } from "mobx-react-lite";

const Tasks = observer(() => {
    const {tasks} = useContext(Context)
    useEffect(() => {
        fetchTestTasks().then(data => {
            tasks.setTestTasks(data)
        })
        fetchAlgorithmTasks().then(data => {
            tasks.setAlgorithmTasks(data)
        })
    }, [])
    return (
        <Container>
            <div>
                <h2>Категория "Тесты"</h2>
                {tasks._testTasks.map(task =>
                    <h5>
                        {task.title}
                    </h5>
                )}
            </div>
            <div>
                <h2>Категория "Алгоритмы"</h2>
                {tasks._algorithmTasks.map(task =>
                    <h5>
                        {task.title}
                    </h5>
                )}
            </div>
        </Container>
    )
})

export default Tasks;