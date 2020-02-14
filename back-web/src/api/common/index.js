// 通用api
import { Message } from 'element-ui'

/**
 * 上传图片成功的调用
 * @param res 返回的响应
 * @returns 图片地址
 */
export const uploadSuccess = res => {
  Message.success(res.message)
  return res.data
}
/**
 * @description 上传前的处理
 * @param params 上传的文件数据
 * @returns {boolean}是否满足上传规则
 */
export const beforeUpload = params => {
  const isLt2M = params.size / 1024 / 1024 < 2
  if (!isLt2M) {
    Message.error({ message: '上传头像图片大小不能超过 2MB!' })
  }
  return isLt2M
}
