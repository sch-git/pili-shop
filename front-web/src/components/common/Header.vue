<template>
  <main>
    <div class="header">
      <el-menu
      class="el-menu-demo my-container"
      mode="horizontal"
      @select="handleSelect"
      background-color="#242f42"
      text-color="#fff"
      router>
        <el-menu-item>pili-shop</el-menu-item>
        <el-submenu index="2">
          <template slot="title">我的工作台</template>
          <el-menu-item>选项1</el-menu-item>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item>选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item class="header-right" index="/login">登录</el-menu-item>
        <el-menu-item class="header-right">购物车<i class="el-icon-shopping-cart-1"/></el-menu-item>
      </el-menu>
    </div>
  </main>
</template>

<script>

export default {
  name: 'Header',
  data () {
    return {
      activeIndex2: '1'
    }
  },
  created () {
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped lang="scss">
  @import "../../assets/css/base";
  .header{
    height: 60px;
    .my-container{
      .header-right{
        float: right;
      }
    }
  }
  .el-menu--horizontal>.el-menu-item>.el-icon-shopping-cart-1{
    color: #f0f0f0;
  }
  .el-menu--horizontal>.el-menu-item.is-active{
    border-bottom: 2px solid #fb9f16;
    color: #fb9f16;
  }
</style>
