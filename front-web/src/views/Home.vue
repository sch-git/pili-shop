<template>
  <main>
    <Header></Header>
    <router-view/>
    <!-- 部分路由不应该包含这个Footer -->
    <Footer v-if="excludeRoutes.indexOf($route.name) === -1"></Footer>
  </main>
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
  created () {

  }
}
</script>
