// 与业务无关的工具方法

// 检测商品价格
export const checkPrice = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('商品售价不能为空'))
  }
  setTimeout(() => {
    if (!Number.isInteger(value)) {
      callback(new Error('请输入数字值'))
    } else {
      if (value <= 0) {
        callback(new Error('售价必须大于0'))
      } else {
        callback()
      }
    }
  }, 1000)
}
// 检测商品名称
export const checkName = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('分类名称不能为空'))
  }
  // TODO 判断分类名称是否已存在
  callback()
}
// 检测商品分类
export const checkCategory = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('商品分类不能为空'))
  }
  callback()
}
// 检测商品描述
export const checkDescribe = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('商品描述不能为空'))
  }
  callback()
}
// 检测商品图片url
export const checkUrl = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('请上传商品图片'))
  }
  callback()
}
