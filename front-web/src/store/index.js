import Vue from 'vue'
import Vuex from 'vuex'
import state from './state'
import actions from './actions'
import user from './module/user'
import saveInLocal from '@/plugins/saveInLocal'

Vue.use(Vuex)

const mutations = {
  SET_USER (state, params) {
    state.userInfo = params
  }
}

export default new Vuex.Store({
  state,
  mutations,
  actions,
  modules: {
    user
  },
  plugins: [saveInLocal]
})
