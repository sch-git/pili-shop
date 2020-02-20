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
