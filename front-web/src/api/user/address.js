import axios from '@/api/index'

/**
 * 获取用户地址列表
 * @returns 地址列表
 */
export const findAddressList = () => {
  return axios.get('/address/list')
}
/**
 * 获取用户默认地址
 * @returns 默认详细地址
 */
export const findDefaultAddress = () => {
  return axios.get('/address/default')
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
