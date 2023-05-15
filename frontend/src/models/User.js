//import { makeAutoObservable } from "mobx"

import { makeAutoObservable } from "mobx"

export default class User {
    constructor() {
        this._isAuth = false
        this._user = {}
        this._testScores = []
        this._algorithmScores = []
        this._cyberSecurityScores = []
        this._testRank = -1
        this._algorithmRank = -1
        this._cyberSecurityRank = -1
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
    setCyberSecurityScores(testScores) {
        this._cyberSecurityScores= testScores
    }
    setAlgorithmRank(rank) {
        this._algorithmRank = rank
    }
    setTestRank(rank) {
        this._testRank = rank
    }
    setCyberSecurityRank(rank) {
        this._cyberSecurityRank= rank
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

    get cyberSecurityScores() {
        return this._cyberSecurityScores
    }
}