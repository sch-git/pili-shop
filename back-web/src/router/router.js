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
        meta: { title: '用户列表' }
      },
      {
        path: '/admin',
        component: () => import(/* webpackChunkName: "table" */ '@/views/Admin.vue'),
        meta: { title: '权限管理' }
      },
      {
        path: '/commodity',
        component: () => import(/* webpackChunkName: "table" */ '@/views/Commodity.vue'),
        meta: { title: '商品管理' }
      },
      {
        path: '/addProduct',
        component: () => import(/* webpackChunkName: "table" */ '@/views/AddProduct.vue'),
        meta: { title: '添加商品' }
      },
      {
        path: '/commodity/image/:commodityId',
        component: () => import(/* webpackChunkName: "table" */ '@/views/CommodityImage.vue'),
        props: true,
        meta: { title: '商品图片' }
      },
      {
        path: '/category',
        component: () => import(/* webpackChunkName: "table" */ '@/views/Category.vue'),
        meta: { title: '分类管理' }
      },
      {
        path: '/adminInfo',
        component: () => import(/* webpackChunkName: "table" */ '@/views/AdminInfo.vue'),
        meta: { title: '个人中心' }
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '@/views/Login.vue')
  }
]
