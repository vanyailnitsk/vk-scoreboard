import { $authHost, $host } from "."

export const fetchTestScores = async () => {
    const {data} = await $authHost.get('user/test-scores')
    return data
}

export const fetchGlobalScores = async () => {
    const {data} = await $authHost.get('user/global-rank')
    return data
}

export const fetchTestTasks = async ()  => {
    const {data} = await $host.get('tasks/test/all')
    return data
}

export const fetchAlgorithmTasks = async ()  => {
    const {data} = await $host.get('tasks/algorithm/all')
    return data
}

export const fetchCyberSecurityTasks = async ()  => {
    const {data} = await $host.get('tasks/cyberSecurity/all')
    return data
}