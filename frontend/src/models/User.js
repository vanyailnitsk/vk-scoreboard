//import { makeAutoObservable } from "mobx"

import { makeAutoObservable } from "mobx"

export default class User {
    constructor() {
        this._isAuth = true
        this._user = {}
        this._testScores = []
        this._algorithmScores = []
        this._testRank = -1
        this._algorithmRank = -1
        makeAutoObservable(this)
    }
    setIsAuth(bool) {
        this._isAuth = bool
    }
    setUser(user) {
        this._user = user
    }
    setTestScores(testScores) {
        this._testScores = testScores
    }
    setAlgorithmScores(Scores) {
        this._algorithmScores = Scores
    }
    setAlgorithmRank(rank) {
        this._algorithmRank = rank
    }
    setTestRank(rank) {
        this._testRank = rank
    }
    get isAuth() {
        return this._isAuth
    }
    get User() {
        return this._user 
    }
    get testScores() {
        return this._testScores
    }
    get algorithmScores() {
        return this._algorithmScores
    }

}