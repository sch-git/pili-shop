import Login from '@/views/Login.vue'

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
    path: '/',
    component: () => import(/* webpackChunkName: "home" */ '@/views/Home'),
    meta: { title: '页面框架' },
    children: [
      {
        path: '/index',
        component: () => import(/* webpackChunkName: "home" */ '@/views/Index'),
        meta: { title: '主页' }
      }
    ]
  }
]
