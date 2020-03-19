import axios from '@/api/index'

/**
 * @description 查询轮播图
 * @returns 图片列表
 */
export const findSlideImageList = () => {
  return axios.get('/slide/list')
}
/**
 * 删除指定轮播图片
 * @param url
 * @returns
 */
export const deleteSlideImage = url => {
  return axios.delete('/slide/delete', { params: { url } })
}
/**
 * 添加轮播图片
 * @param params
 * @returns
 */
export const addSlideImage = params => {
  return axios.post('/slide/item', params)
}
