import Vue from 'vue'
import Vuex from 'vuex'
import state from './state'
import mutations from './mutations'
import actions from './actions'
import user from './module/user'
import saveInLocal from '@/plugins/saveInLocal'

Vue.use(Vuex)

export default new Vuex.Store({
  strict: true,
  state,
  mutations,
  actions,
  modules: {
    user
  },
  plugins: [saveInLocal]
})
