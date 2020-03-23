<template>
    <main class="my-address">
      <div class="crumbs">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item>
            <i class="el-icon-lx-calendar"></i> 我的设置
          </el-breadcrumb-item>
          <el-breadcrumb-item>我的地址</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="container">
        <div class="default-address">

        </div>
        <div class="address-list">

        </div>
      </div>
    </main>
</template>

<script>
export default {
  name: 'Address',
  data () {
    return {

    }
  },
  created () {
  },
  computed: {

  },
  methods: {

  }
}
</script>

<style scoped lang="scss">
  .my-address{
    background-color: #f0f0f0;
    .container{
      background-color: #f0f0f0;
      border: 0;
    }
  }
</style>
<style lang="scss">

</style>
