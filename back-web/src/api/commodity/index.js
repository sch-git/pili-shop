import axios from '@/api/index'
import store from '@/store'

/**
 * @description 添加商品
 * @param params 商品数据
 * @returns
 */
export const addCommodity = params => {
  params.createName = store.state.user.userInfo.username
  return axios.post('/commodity', params)
}
/**
 * @description 查询商品列表
 * @param params 查询条件
 * @returns 商品列表
 */
export const findCommodityList = params => {
  return axios.get('/commodity/list', { params })
}
/**
 * 修改商品上架状态
 * @param params 修改条件
 * @returns
 */
export const updateCommodityStatus = params => {
  params.updateName = store.state.user.userInfo.username
  return axios.put('/commodity/status', params)
}
/**
 * 修改商品信息
 * @param params 修改条件
 * @returns
 */
export const updateCommodity = params => {
  params.updateName = store.state.user.userInfo.username
  return axios.put('/commodity/item', params)
}
