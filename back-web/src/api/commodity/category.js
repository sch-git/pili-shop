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
/**
 * @description 修改分类信息
 * @param params 分类信息
 * @returns
 */
export const updateCategory = params => {
  return axios.put('/category/item', params)
}
/**
 * @description 添加分类
 * @param params 分类对象
 * @returns
 */
export const addCategory = params => {
  return axios.post('/category', params)
}
