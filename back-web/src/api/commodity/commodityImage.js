import axios from '@/api/index'
// import store from '@/store'

/**
 * 根据商品id查询图片
 * @param commodityId 商品id
 * @returns 图片列表
 */
export const findImageList = commodityId => {
  return axios.get('/commodity/image', { params: { commodityId } })
}
/**
 * 添加商品图片
 * @param params 商品图片信息
 * @returns
 */
export const addCommodityImage = params => {
  return axios.post('/commodity/image', params)
}
/**
 * @description 删除商品图片
 * @param id 图片id
 * @returns
 */
export const deleteCommodityImage = id => {
  return axios.delete('/commodity/image', { params: { id } })
}
