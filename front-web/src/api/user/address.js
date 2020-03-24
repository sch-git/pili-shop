import axios from '@/api/index'

/**
 * 获取用户地址列表
 * @returns 地址列表
 */
export const findAddressList = () => {
  return axios.post('/address/list')
}
/**
 * 添加用户新地址
 * @param params 新的地址
 */
export const addAddress = params => {
  return axios.post('/address/insert', params)
}
/**
 * 用户修改地址
 * @param params 新的地址
 */
export const updateAddress = params => {
  return axios.post('/address/update', params)
}
