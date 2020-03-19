import axios from '@/api/index'

/**
 * @description 查询轮播图
 * @returns 图片列表
 */
export const findSlideImageList = () => {
  return axios.get('/slide/list')
}
