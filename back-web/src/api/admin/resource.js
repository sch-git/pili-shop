import axios from '@/api/index'

/**
 * 查询权限列表
 * @param params 查询条件
 * @returns 权限列表
 */
export const findResourceList = params => {
  return axios.get('/resource/list', { params })
}
