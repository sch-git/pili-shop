import axios from '@/api/index'

/**
 * @description 登录接口
 * @param loginAO 登录信息
 */
export const login = (loginAO) => {
  return axios.post('/login', loginAO)
}
/**
 * @description 用户退出登录
 * @param params 用户token
 */
export const logout = (params) => {
  return axios.post('/logout')
}
/**
 * 修改用户信息
 * @param params 用户信息
 */
export const updateUser = (params) => {
  return axios.put('/user/update', params)
}

/**
 * 用户发送反馈信息
 * @param params 反馈信息
 */
export const sendMessage = (params) => {
  return axios.post('/user/send', params)
}
/**
 * 查询用户反馈信息
 * @returns 反馈列表
 */
export const findMessageList = () => {
  return axios.get('/user/message')
}
