import axios from '@/api/index'

/**
 * @description 查询用户列表
 * @param searchUserAO 查询条件
 * @returns 用户列表
 */
export const findUserList = (searchUserAO) => {
  return axios.post('/user/list', searchUserAO)
}
/**
 * @description 修改用户状态
 * @param updateUserStatusAO 修改条件
 * @returns
 */
export const updateUserStatus = (updateUserStatusAO) => {
  return axios.put('/user/status', updateUserStatusAO)
}
