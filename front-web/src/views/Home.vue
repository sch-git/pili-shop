<template>
  <el-main
    v-loading="loading"
    element-loading-text="拼命提交订单中"
    element-loading-spinner="el-icon-loading"
    element-loading-background="rgba(0, 0, 0, 0.8)">
    <Header></Header>
    <router-view/>
    <!-- 部分路由不应该包含这个Footer -->
    <Footer v-if="excludeRoutes.indexOf($route.name) === -1"></Footer>
  </el-main>
</template>

<script>
import Header from '~c/common/Header'
import Footer from '~c/common/Footer'

export default {
  name: 'home',
  data () {
    return {
      excludeRoutes: ['HomeIndex', 'MyAddress', 'AddAddress', 'MyOrder', 'MyShoppingCart']
    }
  },
  components: {
    Header,
    Footer
  },
  computed: {
    loading () {
      return this.$store.state.loading
    }
  }
}
</script>
<style scoped lang="scss">
  .el-main{
    padding: 0;
  }
</style>
