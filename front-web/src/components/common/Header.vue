<template>
  <main>
    <div class="header">
      <el-menu
        class="el-menu-demo my-container"
        mode="horizontal"
        @select="handleSelect"
        background-color="#242f42"
        text-color="#fff"
        active-text-color="#fb9f16"
        router>
        <el-menu-item index="/index">pili-shop</el-menu-item>
        <el-submenu index="2">
          <template slot="title">我的工作台</template>
          <el-menu-item>选项1</el-menu-item>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item>选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item v-if="!userInfo.token" class="header-right" index="/login">登录</el-menu-item>
        <el-submenu v-else class="header-right" index="3">
          <template slot="title">{{ userInfo.nickName }}</template>
          <el-menu-item class="item" :index="'/user/detail'"><i class="el-icon-setting"/>设置</el-menu-item>
          <el-menu-item class="item" @click="logout"><i class="el-icon-switch-button"/> 退出</el-menu-item>
        </el-submenu>
        <el-menu-item class="header-right" :index="'/cart/'+userInfo.nickName">购物车<i class="el-icon-shopping-cart-1"/>
        </el-menu-item>
      </el-menu>
    </div>
  </main>
</template>

<script>

import { mapState } from 'vuex'
import { logout } from '@/api/user'

export default {
  name: 'Header',
  data () {
    return {
      activeIndex2: '1'
    }
  },
  computed: {
    ...mapState(['userInfo'])
  },
  created () {
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    },
    logout () {
      logout(this.userInfo.token).then(res => {
        sessionStorage.clear()
        this.$router.push('/login')
      })
    }
  }
}
</script>

<style scoped lang="scss">
  @import "../../assets/css/base";

  .header {
    height: 60px;

    .my-container {
      .header-right {
        float: right;
      }
      .el-menu-item {
        .el-icon-shopping-cart-1 {
          color: #fff;
        }
      }
    }
  }
</style>
<style scoped lang="scss">
  .el-menu--horizontal > .el-menu-item.is-active {
    .el-icon-shopping-cart-1 {
      color: #fb9f16;
    }
  }
</style>
