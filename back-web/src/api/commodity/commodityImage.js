import axios from '@/api/index'
// import store from '@/store'

export const findImageList = commodityId => {
  return axios.get('/commodity/image', { params: { commodityId } })
}
