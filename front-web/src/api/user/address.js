import axios from '@/api/index'

/**
 * 获取用户地址列表
 * @returns 地址列表
 */
export const findAddressList = () => {
  return axios.post('/address/list')
}
/**
 * 获取用户默认地址
 * @returns 默认详细地址
 */
export const findDefaultAddress = () => {
  return axios.post('/address/default')
}
/**
 * 用户修改默认地址
 */
export const updateDefaultAddress = params => {
  return axios.put('/address/default', params)
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
  return axios.put('/address/update', params)
}
/**
 * 用户删除地址
 * @param id 地址id
 */
export const deleteAddress = id => {
  return axios.delete('/address/delete', { params: { id } })
}
