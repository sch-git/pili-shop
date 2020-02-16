import axios from '@/api/index'
// import store from '@/store'

export const findCategoryList = params => {
  return axios.get('/category/list', { params })
}
export const updateCategory = params => {
  return axios.put('/category/item', params)
}
export const addCategory = params => {
  return axios.post('/category', params)
}
