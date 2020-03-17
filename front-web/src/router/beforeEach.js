// 全局路由前置守卫
// 全局路由前置守卫
import store from '@/store'
import { Message } from 'element-ui'
export default (to, from, next) => {
  if (to.name === 'login' || to.name === '/') {
    next()
    return
  }
  if (to.meta && to.meta.login) {
    if (store.state.user.userInfo && store.state.user.userInfo.token) {
      next()
      return
    }
    Message.error({ message: '尚未登录，请先登录' })
  } else {
    next(to.name)
  }
}
