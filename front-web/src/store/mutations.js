const mutations = {
  SET_USER (state, params) {
    state.userInfo = params
  },
  SET_PAY_FORM (state, params) {
    state.payForm = params
  },
  SET_LOADING (state, params) {
    state.loading = params
  }
}
export default mutations
