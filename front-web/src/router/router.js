import Login from '@/views/Login.vue'

export default [
  {
    path: '/',
    redirect: '/login'
  },

  {
    path: '/',
    component: () => import(/* webpackChunkName: "home" */ '@/views/Home'),
    meta: { title: '页面框架' },
    children: [
      {
        path: '/login',
        component: Login
      }
    ]
  }
]
