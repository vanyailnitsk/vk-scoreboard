import React, { useContext } from "react";
import { BASE_URL, LOGIN_ROUTE, SCOREBOARD_ROUTE, TASKS_ROUTE } from "../utils/consts";
import { Container, Nav, Navbar } from "react-bootstrap";
import { observer } from "mobx-react-lite";
import { Context } from "..";
import { useNavigate } from "react-router";


const NavBar = observer(() => {
    const {user} = useContext(Context)
    const navigate = useNavigate()
    const logOut = () => {
        user.setUser({})
        user = {}
        user.setIsAuth(false)
        localStorage.clear()
        navigate(TASKS_ROUTE)
    }
    return (
        <Navbar bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="">VK</Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link href={SCOREBOARD_ROUTE}>Рейтинг</Nav.Link>
                    <Nav.Link href={TASKS_ROUTE}>Задачи</Nav.Link>
                    <Nav.Link href={LOGIN_ROUTE}>Авторизация</Nav.Link>
                    <Nav.Link onClick={() => logOut()}>Выйти</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    );
});

export default NavBar;
