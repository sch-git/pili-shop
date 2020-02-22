import axios from '@/api/index'

/**
 * @description 查询用户列表
 * @param params 查询条件
 * @returns 用户列表
 */
export const findUserList = params => {
  return axios.get('/user/list', { params })
}
/**
 * @description 修改用户状态
 * @param updateUserStatusAO 修改条件
 * @returns
 */
export const updateUserStatus = (updateUserStatusAO) => {
  return axios.put('/user/status', updateUserStatusAO)
}