import Vue from 'vue'
import VueRouter from 'vue-router'
import routes from './router'
import beforeEach from '@/router/beforeEach'

Vue.use(VueRouter)

const router = new VueRouter({
  routes
})

router.beforeEach(beforeEach)

export default router
