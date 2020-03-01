import axios from '@/api/index'
// import store from '@/store'

/**
 * @description 查询分类列表
 * @param params 查询条件
 * @returns 分类列表
 */
export const findCategoryList = params => {
  return axios.get('/category/list', { params })
}
