import axios from '@/api/index'

/**
 * @description 登录接口
 * @param loginAO 登录信息
 */
export const login = (loginAO) => {
  return axios.post('/login', loginAO)
}
/**
 * todo
 * @description 用户退出登录
 * @param params 用户token
 */
export const logout = (params) => {
  return axios.post('/logout')
}
export const updateUser = (params) => {
  return axios.put('/user/update', params)
}
