import Vue from 'vue'
import VueLazyLoad from 'vue-lazyload'
import { MessageBox, Message } from 'element-ui'

// 轮播图
Vue.use(VueLazyLoad, {
  loading: '../img/loading_img.svg'
})
export default VueLazyLoad

// 确认消息弹窗
export const MessageBoxConfirm = (message, title) => {
  return MessageBox.confirm(message, title, {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'error'
  }).then(() => {
    Message.success('删除成功')
    return true
  }).catch(() => {
    Message.info('已取消删除')
    return false
  })
}
