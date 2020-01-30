export default [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/',
    component: () => import(/* webpackChunkName: "home" */ '@/views/Home'),
    meta: { title: '自述文件' },
    children: [
      {
        path: '/dashboard',
        component: () => import(/* webpackChunkName: "dashboard" */ '@/views/Dashboard.vue'),
        meta: { title: '系统首页' }
      },
      {
        path: '/user',
        component: () => import(/* webpackChunkName: "table" */ '@/views/User.vue'),
        meta: { title: '用户管理' }
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '@/views/Login.vue')
  }
]
