<template>
  <main>
    <div class="pay-container">
      <el-alert
        class="alert-box"
        title="扫码支付"
        description="请扫描右边二维码进行支付"
        type="info" :closable="false" show-icon>
      </el-alert>
      <div class="pay-box">
        <div class="pay-demo">
          <img src="../../assets/img/pay-demo.png" alt="">
        </div>
        <div class="pay-qr-scan">
          <iframe id="iframe" :src="formData" class="qr-iframe" allowtransparency="true"></iframe>
          <div class="pay-tips">
            <p>扫码完成支付</p>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'Pay',
  data () {
    return {
      url: ''
    }
  },
  created () {
  },
  mounted () {
  },
  methods: {

  },
  computed: {
    formData () {
      return this.$store.state.payForm
    }
  }
}
</script>

<style scoped lang="scss">
  .pay-container{
    margin: 15px auto;
    width: 80%;
    min-width: 1000px;
    .alert-box {
      line-height: 25px;
      background-color: #d5e8fc;
      color: #6b6d6f;
      margin-bottom: 30px;
    }
    .pay-box {
      height: 500px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      .pay-demo {
        width: 50%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        img{
          height: 80%;
        }
      }
      .pay-qr-scan {
        width: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        .qr-iframe{
          min-width: 301px;
          min-height: 301px;
          background: #cccccc;
        }
        .pay-tips {
          width: 50%;
          text-align: center;
          font-size: 14px;
          line-height: 30px;
        }
      }
    }
  }

</style>
