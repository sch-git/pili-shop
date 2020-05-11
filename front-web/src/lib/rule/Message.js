export const checkTitle = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('标题不能为空'))
  }
  callback()
}
export const checkContent = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('反馈内容不能为空'))
  }
  callback()
}
