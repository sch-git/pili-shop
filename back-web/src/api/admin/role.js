import axios from '@/api/index'

/**
 * 查询角色
 * @param params 查询条件
 * @returns 角色列表
 */
export const findRoleList = params => {
  return axios.get('/role/list', { params })
}
/**
 * 添加角色
 * @param params 角色信息
 */
export const addRole = params => {
  return axios.post('/role/add', params)
}

/**
 * 删除角色
 * @param roleId 角色id
 */
export const deleteRole = roleId => {
  return axios.get('/role/delete', { params: { roleId } })
}
