import axios from '@/api/index'

/**
 * @description 添加商品到购物车
 * @param params 商品id，商品增量
 * @returns
 */
export const addCartItem = params => {
  return axios.post('/cart/item', params)
}

/**
 * @description 查询购物车商品
 * @returns 商品列表
 */
export const findCartList = () => {
  return axios.post('/cart/list')
}

/**
 * 从缓存中删除购物车中指定商品
 * @param params 商品id
 */
export const deleteCartItem = params => {
  return axios.delete('/cart/delete', { params })
}
