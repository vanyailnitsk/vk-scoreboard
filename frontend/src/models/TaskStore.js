import { makeAutoObservable } from "mobx"

export default class TaskStore {
    constructor() {
        this._testTasks = []
        this._algorithmTasks = []
        makeAutoObservable(this)
    }
    setTestTasks(tasks) {
        this._testTasks = tasks
    }
    setAlgorithmTasks(tasks) {
        this._algorithmTasks = tasks
    }
    get testTasks() {
        return this._teskTasks
    }
    get algorithmTasks() {
        return this._algorithmtasks
    }
}