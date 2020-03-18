import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'

export default [
  {
    path: '/',
    redirect: '/index'
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
        component: () => import(/* webpackChunkName: "home" */ '~c/goods/GoodList'),
        meta: { title: '商品列表' }
      },
      {
        path: '/goodDetail/:commodityId',
        component: () => import(/* webpackChunkName: "home" */ '~c/goods/GoodDetail'),
        props: true,
        meta: { title: '商品详情' }
      },
      {
        path: '/cart/:username',
        component: () => import(/* webpackChunkName: "home" */ '~c/order/Cart'),
        props: true,
        meta: { title: '购物车', login: true }
      }
    ]
  }
]
