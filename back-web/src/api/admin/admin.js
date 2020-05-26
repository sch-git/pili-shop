import axios from '@/api/index'

/**
 * @description 登录接口
 * @param loginAO 登录信息
 * @returns 权限集合
 */
export const login = (loginAO) => {
  return axios.post('/login', loginAO)
}
/**
 * 查询管理员
 * @param params 分页信息
 * @returns 管理员列表
 */
export const findAdminList = params => {
  return axios.get('/admin/list', {params})
}
