import axios from '@/api/index'

/**
 * 提交支付订单
 * @param params 订单
 */
export const createOrder = params => {
  return axios.post('/order/create', params)
}
/**
 * 用户支付订单
 * @param params 订单信息
 */
export const payOrder = params => {
  return axios.post('/order/pay', params)
}
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
