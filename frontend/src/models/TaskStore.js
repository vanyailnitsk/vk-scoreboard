import { makeAutoObservable } from "mobx"

export default class TaskStore {
    constructor() {
        this._testTasks = []
        this._algorithmTasks = []
        this._cyberSecurityTasks = []
        makeAutoObservable(this)
    }
    setTestTasks(tasks) {
        this._testTasks = tasks
    }
    setAlgorithmTasks(tasks) {
        this._algorithmTasks = tasks
    }
    setCyberSecurityTasks(tasks) {
        this._cyberSecurityTasks = tasks
    }
    get testTasks() {
        return this._teskTasks
    }
    get algorithmTasks() {
        return this._algorithmtasks
    }

    get cyberSecurityTasks() {
        return this._cyberSecurityTasks
    }
}