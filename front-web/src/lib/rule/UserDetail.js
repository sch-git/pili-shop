export const checkUserName = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('手机号不能为空'))
  }
  // TODO 判断分手机号是否已存在
  callback()
}
export const checkNickName = (rule, value, callback) => {
  value = value.trim()
  if (!value) {
    return callback(new Error('昵称不能为空'))
  }
  callback()
}
export const checkAvatar = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('请上传用户头像'))
  }
  callback()
}
