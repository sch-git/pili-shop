<template>
  <div class="sidebar">
    <el-menu
      class="sidebar-el-menu"
      :default-active="onRoutes"
      background-color="#f0f0f0"
      text-color="#444446"
      active-text-color="#444446"
      router
    >
      <template v-for="item in items">
        <template>
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
          index: '/user/detail',
          title: '基础设置'
        },
        {
          icon: 'el-icon-s-home',
          index: '/user/orderList',
          title: '我的订单'
        },
        {
          icon: 'el-icon-s-home',
          index: '/user/address',
          title: '我的地址'
        },
        {
          icon: 'el-icon-s-home',
          index: '/user/message',
          title: '我的消息'
        }
      ]
    }
  },
  computed: {
    onRoutes () {
      console.log(this.$route.path)
      return this.$route.path.replace('/', '/')
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
  .el-menu-item i {
    color: #444446;
  }
  .el-menu-item{
    width: 100%;
    text-align: center;
  }
  .sidebar {
    display: block;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
  }

  .sidebar::-webkit-scrollbar {
    width: 0;
  }
  .sidebar > ul {
    height: 100%;
  }
</style>
