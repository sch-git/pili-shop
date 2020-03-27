<template>
    <main>
      <div class="freeback-container">
        <div class="freeback-img-box">
          <img src="../assets/img/freeback.png" alt="">
        </div>
        <div class="freeback-box-border">
          <div class="freeback-box">
            <div class="freeback-title">
              <h1>意见反馈</h1>
              <h2>感谢你的反馈，我们会积极改善，做出更好的服务的</h2>
            </div>
            <div class="freeback-content">
              <div class="freeback-form">
                <el-form :model="formItem" :label-width="80">
                  <el-form-item label="标题">
                    <el-input v-model="formItem.title" placeholder="请输入标题"></el-input>
                  </el-form-item>
                  <el-form-item label="反馈信息">
                    <el-input v-model="formItem.content" type="textarea" :autosize="{minRows: 8,maxRows: 10}" placeholder="请输入反馈信息"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary">提交</el-button>
                    <el-button type="info">清空信息</el-button>
                  </el-form-item>
                </el-form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
</template>

<script>
export default {
  name: 'FeedBack',
  data () {
    return {
      formItem: {
        title: '',
        content: ''
      }
    }
  }
}
</script>

<style scoped lang="scss">
  .freeback-container {
    margin: 15px auto;
    width: 80%;
    height: 600px;
    display: flex;
    align-items: center;
    /* background-color: #ccc; */
    .freeback-img-box {
      width: 60%;
      height: 600px;
      display: flex;
      align-items: center;
      justify-content: center;
      img{
        width: 100%;
      }
    }
    .freeback-box-border {
      display: flex;
      align-items: center;
      justify-content: center;
      .freeback-box {
        width: 480px;
      }
      .freeback-content {
        margin: 15px auto;
        border: 1px #ccc dotted;
        .freeback-form {
          margin: 30px auto;
          width: 90%;
        }
      }
    }
  }
</style>
