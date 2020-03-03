import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'

export default [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '/',
    component: () => import(/* webpackChunkName: "home" */ '@/views/Home'),
    meta: { title: '页面框架' },
    children: [
      {
        path: '/index',
        component: () => import(/* webpackChunkName: "home" */ '@/views/Index'),
        meta: { title: '主页' }
      },
      {
        path: '/goodList',
        component: () => import(/* webpackChunkName: "home" */ '~c/goods/GoodsList'),
        meta: { title: '商品列表' }
      }
    ]
  }
]
