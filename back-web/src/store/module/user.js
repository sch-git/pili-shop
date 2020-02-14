const state = {
  userInfo: {
    id: 1,
    username: 'root',
    nickName: '超级管理员',
    phone: 'root123456',
    state: 0,
    createTime: '1579598844000',
    updateTime: '1579598844000',
    token: ''
  }
}
const mutations = {
  SET_USER (state, params) {
    state.userInfo = params
  }
}
const actions = {

}
export default {
  namespaceString: true,
  state,
  mutations,
  actions
}
