import axios from '@/api/index'

/**
 * @description 查询用户列表
 * @param searchUserAO 查询条件
 * @returns 用户列表
 */
export const findUserList = (searchUserAO) => {
  return axios.post('/user/list', searchUserAO)
}
