<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
export default {
  name: 'App',
  mounted () {
    this.SET_LOADING(false)
  },
  methods: {
    ...mapMutations([
      'SET_LOADING'
    ])
  }
}
</script>
<style>
  @import "./assets/css/main.css";
  @import "./assets/css/color-dark.css";

</style>
