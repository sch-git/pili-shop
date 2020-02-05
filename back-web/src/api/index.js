import axios from '@/lib/axios'
import { Message } from 'element-ui'

axios.interceptors.response.use(res => {
  if (res.data && res.status === 200 && res.data.code !== 200) {
    Message.error({ message: res.data.message })
    return null
  }
  return res.data.data
}, error => {
  if (error.response.status === 504 || error.response.status === 404) {
    Message.error({ message: '服务器被吃了(ง •_•)ง' })
  } else if (error.response.status === 403) {
    Message.error({ message: '权限不足，请联系管理员' })
  } else if (error.response.status === 401) {
    Message.error({ message: '尚未登录，请登录' })
  } else {
    if (error.response.data.message) {
      Message.error({ message: error.response.data.message })
    } else {
      Message.error({ message: '未知错误' })
    }
  }
})
export default axios
