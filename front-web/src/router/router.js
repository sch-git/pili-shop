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
        component: () => import(/* webpackChunkName: "index" */ '@/views/Index'),
        meta: { title: '主页' }
      },
      {
        path: '/goodList',
        component: () => import(/* webpackChunkName: "goodList" */ '~c/goods/GoodList'),
        meta: { title: '商品列表' }
      },
      {
        path: '/goodDetail/:commodityId',
        component: () => import(/* webpackChunkName: "goodDetail" */ '~c/goods/GoodDetail'),
        props: true,
        meta: { title: '商品详情' }
      },
      {
        path: '/cart/:username',
        component: () => import(/* webpackChunkName: "cart" */ '@/views/Cart'),
        props: true,
        meta: {
          title: '购物车',
          login: true
        }
      },
      {
        path: '/order',
        component: () => import(/* webpackChunkName: "order" */ '@/views/Order'),
        meta: {
          title: '订单',
          login: true
        },
        children: [
          {
            path: 'pay',
            component: () => import(/* webpackChunkName: "pay" */ '~c/order/Pay'),
            meta: {
              title: '支付订单',
              login: true
            }
          },
          {
            path: 'code',
            component: () => import(/* webpackChunkName: "code" */ '~c/order/Code'),
            meta: {
              title: '支付订单',
              login: true
            }
          },
          {
            path: 'success',
            component: () => import(/* webpackChunkName: "success" */ '~c/order/Success'),
            meta: {
              title: '支付成功',
              login: true
            }
          }
        ]
      },
      {
        path: '/feedBack',
        component: () => import(/* webpackChunkName: "index" */ '@/views/FeedBack'),
        meta: { title: '意见反馈' }
      },
      {
        path: '/user',
        component: () => import(/* webpackChunkName: "user" */ '@/views/User'),
        meta: {
          title: '设置',
          login: true
        },
        children: [
          {
            path: 'address',
            component: () => import(/* webpackChunkName: "address" */ '~c/user/Address'),
            meta: {
              title: '地址',
              login: true
            }
          },
          {
            path: 'message',
            component: () => import(/* webpackChunkName: "address" */ '~c/user/Message'),
            meta: {
              title: '消息',
              login: true
            }
          },
          {
            path: 'orderList',
            component: () => import(/* webpackChunkName: "address" */ '~c/user/OrderList'),
            meta: {
              title: '订单列表',
              login: true
            }
          },
          {
            path: 'detail',
            component: () => import(/* webpackChunkName: "address" */ '~c/user/UserDetail'),
            meta: {
              title: '用户信息',
              login: true
            }
          }
        ]
      }
    ]
  }
]
