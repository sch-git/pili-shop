export const checkReceiveName = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('收货人不能为空'))
  }
  callback()
}
export const checkPhone = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('手机号不能为空'))
  }
  if (value.length !== 11) {
    return callback(new Error('请输入11位手机号'))
  }
  callback()
}
export const checkDetailedAddress = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('详细地址不能为空'))
  }
  callback()
}
