import axios from '@/api/index'

/**
 * 查询权限列表
 * @param params 查询条件
 * @returns 权限列表
 */
export const findResourceList = params => {
  return axios.get('/resource/list', { params })
}
/**
 * 添加权限
 * @param params 权限数据
 */
export const addResource = params => {
  return axios.post('/resource/add', params)
}
/**
 * 删除权限
 * @param id 权限id
 */
export const deleteResource = id => {
  return axios.delete('/resource/delete', { params: { id } })
}
