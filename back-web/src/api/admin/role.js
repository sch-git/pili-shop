import axios from '@/api/index'

/**
 * 查询角色
 * @param params 查询条件
 * @returns 角色列表
 */
export const findRoleList = params => {
  return axios.get('/role/list', {params})
}
/**
 * 根据管理员id查询角色
 * @param id 管理员id
 * @returns 角色列表
 */
export const findAdminRole = id => {
  return axios.get('/role/adminId', {params: {id}})
}
/**
 * 添加角色
 * @param params 角色信息
 */
export const addRole = params => {
  return axios.get('/role/add', params)
}

/**
 * 删除角色
 * @param roleId 角色id
 */
export const deleteRole = roleId => {
  return axios.get('/role/delete', {params: {roleId}})
}
/**
 * 修改管理员角色
 * @param params
 */
export const updateAdminRole = params => {
  return axios.post('/role/change', {params})
}
