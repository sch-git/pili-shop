import axios from '@/api/index'

/**
 * @description 查询商品列表
 * @param params 查询条件
 * @returns 商品列表
 */
export const findCommodityList = params => {
  return axios.get('/commodity/list', { params })
}
/**
 * @description 根据商品id查询详情
 * @param commodityId 商品id
 * @returns 商品详细信息
 */
export const findCommodityById = commodityId => {
  return axios.get('/commodity/item', { params: { commodityId } })
}
