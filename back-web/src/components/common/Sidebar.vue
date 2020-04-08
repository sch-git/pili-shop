<template>
  <div class="sidebar">
    <el-menu
      class="sidebar-el-menu"
      :default-active="onRoutes"
      :collapse="collapse"
      background-color="#324157"
      text-color="#bfcbd9"
      active-text-color="#20a0ff"
      unique-opened
      router
    >
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template slot="title">
              <i :class="item.icon"/>
              <span slot="title">{{ item.title }}</span>
            </template>
            <template v-for="subItem in item.subs">
              <el-submenu
                v-if="subItem.subs"
                :index="subItem.index"
                :key="subItem.index"
              >
                <template slot="title">{{ subItem.title }}</template>
                <el-menu-item
                  v-for="(threeItem,i) in subItem.subs"
                  :key="i"
                  :index="threeItem.index"
                >{{ threeItem.title }}
                </el-menu-item>
              </el-submenu>
              <el-menu-item
                v-else
                :index="subItem.index"
                :key="subItem.index"
              >{{ subItem.title }}
              </el-menu-item>
            </template>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"/>
            <span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
import bus from '@/lib/bus'

export default {
  data () {
    return {
      collapse: false,
      items: [
        {
          icon: 'el-icon-s-home',
          index: '/dashboard',
          title: '系统首页'
        },
        {
          icon: 'el-icon-video-camera-solid',
          index: '1',
          title: '统计中心',
          subs: [
            {
              index: '1-1',
              title: '商品统计'
            },
            {
              index: '1-2',
              title: '订单统计'
            },
            {
              index: '1-3',
              title: '用户统计'
            }
          ]
        },
        {
          icon: 'el-icon-s-goods',
          index: '2',
          title: '商品管理',
          subs: [
            {
              icon: 'el-icon-s-goods',
              index: '/commodity',
              title: '商品列表'
            },
            {
              index: '/addProduct',
              title: '添加商品'
            },
            {
              index: '/category',
              title: '分类管理'
            }
          ]
        },
        {
          icon: 'el-icon-user',
          index: '3',
          title: '用户管理',
          subs: [
            {
              icon: 'el-icon-user',
              index: '/user',
              title: '用户列表'
            }
          ]
        },
        {
          icon: 'el-icon-lock',
          index: '4',
          title: '权限管理',
          subs: [
            {
              icon: 'el-icon-user',
              index: '/rights',
              title: '权限列表'
            }
          ]
        },
        {
          icon: 'el-icon-notebook-2',
          index: '5',
          title: '资料管理',
          subs: [
            {
              index: '/slideImage',
              title: '轮播图管理'
            },
            {
              index: 'editor',
              title: '人物管理'
            },
            {
              index: '5-2',
              title: '武器管理'
            },
            {
              index: '5-3',
              title: '其他信息'
            }
          ]
        },
        {
          icon: 'el-icon-s-order',
          index: '6',
          title: '订单管理',
          subs: [
            {
              index: '/order',
              title: '订单列表'
            }
          ]
        },
        {
          icon: 'el-icon-rank',
          index: '7',
          title: '公告'
        },
        {
          icon: 'el-icon-lx-global',
          index: '8',
          title: '用户反馈'
        }
      ]
    }
  },
  computed: {
    onRoutes () {
      return this.$route.path.replace('/', '')
    }
  },
  created () {
    // 通过 Event Bus 进行组件间通信，来折叠侧边栏
    bus.$on('collapse', msg => {
      this.collapse = msg
      bus.$emit('collapse-content', msg)
    })
  }
}
</script>

<style scoped>
  .sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
  }

  .sidebar::-webkit-scrollbar {
    width: 0;
  }

  .sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
  }

  .sidebar > ul {
    height: 100%;
  }
</style>
