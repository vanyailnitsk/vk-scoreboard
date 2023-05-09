import React, { createContext } from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import User from './models/User';
import TaskStore from './models/TaskStore';


export const Context  = createContext(null)
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <Context.Provider value={{
        user: new User(),
        tasks: new TaskStore()
    }}>
        <App />
        </Context.Provider>
    </React.StrictMode>
);
