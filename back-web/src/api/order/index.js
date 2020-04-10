import axios from '@/api/index'

/**
 * @description 查询订单列表
 * @param params 查询条件
 * @returns 订单列表
 */
export const findOrderList = params => {
  return axios.get('/order/list', { params })
}
/**
 *  @description 修改订单状态
 * @param params 新状态
 */
export const updateOrderStatus = params => {
  return axios.put('/order/status', params)
}
/**
 * 根据订单id查询订单项
 * @param id 订单id
 * @returns 订单项集合
 */
export const findOrderDetail = id => {
  return axios.get('/order/detail', { params: { id } })
}
