import axios from '@/lib/axios'
import { Message } from 'element-ui'
import store from '@/store'

/**
 * axios响应拦截器
 */
axios.interceptors.response.use(res => {
  console.log('response', res)
  if (res.data && res.status === 200 && res.data.code !== 200) {
    Message.error({ message: res.data.message })
    sessionStorage.clear()
    return null
  }
  if (res.data && res.data.message !== '' && res.data.code === 200) {
    Message.success(res.data.message)
  }
  return res.data.data
}, error => {
  if (!error.response.status) {
    Message.error({ message: '神秘错误' })
  }
  if (error.response.status === 504 || error.response.status === 404) {
    Message.error({ message: '服务器被吃了(ง •_•)ง' })
  } else if (error.response.status === 403) {
    Message.error({ message: '权限不足，请联系管理员' })
  } else if (error.response.status === 401) {
    Message.error({ message: '尚未登录，请登录' })
  } else if (error.response.status === 500) {
    Message.error({ message: '服务器崩溃(ง •_•)ง' })
  } else {
    if (error.response.data.message) {
      Message.error({ message: error.response.data.message })
    } else {
      Message.error({ message: '未知错误' })
    }
  }
})
/**
 * axios请求拦截器
 */
axios.interceptors.request.use(req => {
  if (req.url !== '/login') {
    if (store.state.userInfo && store.state.userInfo.token) {
      req.headers.Authorization = store.state.userInfo.token
    }
  }
  console.log('request', req)
  return req
}, error => {
  console.log('interceptors-error', error)
})
export default axios
