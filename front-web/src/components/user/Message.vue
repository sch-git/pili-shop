<template>
  <main class="my-message">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 我的设置
        </el-breadcrumb-item>
        <el-breadcrumb-item>我的反馈</el-breadcrumb-item>
        <a @click="dialog=true">发送反馈</a>
      </el-breadcrumb>
      <div class="message-container">
        <el-collapse @change="handleChange" v-for="(message,index) in messageList" :key="index">
          <el-collapse-item :title="message.title" :name="message.id" >
            <p class="message-item">{{ message.content }}</p>
          </el-collapse-item>
        </el-collapse>
      </div>
    </div>
    <!--发送反馈表格-->
    <el-dialog title="发送反馈" :visible.sync="dialog" width="45%">
      <el-form :model="form" :rules="rules" ref='form'>
        <el-form-item label="标题" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="内容" :label-width="formLabelWidth" prop="content">
          <el-input type="textarea" :rows="2" v-model="form.content"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm('form')">取 消</el-button>
        <el-button type="primary" @click="send('form')">发 送</el-button>
      </div>
    </el-dialog>
  </main>
</template>

<script>
import { findMessageList, sendMessage } from '../../api/user'
import { checkContent, checkTitle } from '../../lib/rule/Message'

export default {
  name: 'Message',
  data () {
    return {
      dialog: false,
      formLabelWidth: '120px',
      form: {
        title: '',
        content: ''
      },
      messageList: [{
        id: '1',
        rid: '0',
        sid: '1',
        name: 'sch',
        url: 'url',
        title: 'title',
        content: 'content',
        createTime: '2020'
      }],
      rules: {
        title: [
          {
            validator: checkTitle,
            trigger: 'blur'
          }
        ],
        content: [
          {
            validator: checkContent,
            trigger: 'blur'
          }
        ]
      }
    }
  },
  created () {
    this.handleInit()
  },
  methods: {
    send () {
      const ao = {
        ...this.form,
        name: this.$store.state.userInfo.username,
        url: this.$store.state.userInfo.avatar
      }
      sendMessage(ao).then(res => {
        this.$message.success('反馈成功')
        this.dialog = false
        this.handleInit()
      })
    },
    handleInit () {
      findMessageList().then(res => {
        this.messageList = res
      })
    },
    // 重置表单
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    handleChange (val) {
      console.log(`message change ${val}`)
    }
  }
}
</script>

<style scoped lang="scss">
.my-message{
  background-color: #f0f0f0;
  .message-container{
    margin-top: 30px;
  }
  .crumbs{
    a{
      color: #66a6f9;
    }
  }
}
</style>
<style lang="scss">
  .my-message{
    div{
      .el-collapse-item__header{
        font-weight: bolder;
        padding-left: 15px;
        height: 40px;
      }
      .el-collapse-item__content{
        padding: 0 15px 10px;
      }
    }
  }

</style>
