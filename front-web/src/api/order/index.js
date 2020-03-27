import axios from '@/api/index'

/**
 * 提交支付订单
 * @param params 订单
 */
export const payOrder = params => {
  return axios.post('/order/pay', params)
}
