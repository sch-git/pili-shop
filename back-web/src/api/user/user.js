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
 * @param updateUserAO 修改条件
 * @returns
 */
export const updateUserStatus = (updateUserAO) => {
  return axios.post('/user/status', updateUserAO)
}
