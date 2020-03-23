<template>
  <main class="my-detail">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 我的设置
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础设置</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <el-upload
        class="avatar-box"
        action="http://localhost:10090/user/avatar"
        :headers="tokenHeader"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload">
        <img alt v-if="userInfo.avatar" :src="userInfo.avatar" class="avatar-img">
        <i v-else class="el-icon-plus avatar-uploader-icon"/>
      </el-upload>
      <div class="form-box">
        <el-form ref="form" :model="userInfo" :rules="rules" label-width="80px">
          <el-form-item v-show="false" label="用户头像" prop="url">
            <el-input v-model="userInfo.avatar"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="username">
            <el-input readonly v-model="userInfo.username"></el-input>
          </el-form-item>
          <el-form-item label="昵称" prop="nickName">
            <el-input v-model="userInfo.nickName"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="userInfo.sex">
              <el-radio :label="false">男</el-radio>
              <el-radio :label="true">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="创建时间" prop="createTime">
            <el-input disabled readonly v-model="userInfo.createTime"></el-input>
          </el-form-item>
          <el-form-item label="最后修改时间" prop="updateTime">
            <el-input disabled readonly v-model="userInfo.updateTime"></el-input>
          </el-form-item>
          <el-form-item class="form-item-box">
            <el-button type="primary" @click="submitForm('form')">保存</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </main>
</template>

<script>
import { beforeUpload, uploadSuccess } from '@/lib/tools'
import { checkAvatar, checkNickName, checkUserName } from '@/lib/rule/UserDetail'
import { updateUser } from '@/api/user'
import { mapMutations } from 'vuex'

export default {
  name: 'UserDetail',
  data () {
    return {
      rules: {
        username: [
          {
            validator: checkUserName,
            trigger: 'blur'
          }
        ],
        nickName: [
          {
            validator: checkNickName,
            trigger: 'blur'
          }
        ],
        avatar: [
          {
            validator: checkAvatar,
            trigger: 'blur'
          }
        ]
      }
    }
  },
  created () {
  },
  methods: {
    ...mapMutations([
      'SET_USER'
    ]),
    // 提交表单
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log('修改用户消息{}', this.userInfo)
          updateUser(this.userInfo).then(res => {
            this.SET_USER(this.userInfo)
            this.$message.success('保存成功')
          })
        } else {
          this.$message.error('请填写完整信息')
          return false
        }
      })
    },
    // 上传头像成功
    handleAvatarSuccess (res, file) {
      this.userInfo.avatar = uploadSuccess(res)
    },
    // 上传前的处理
    beforeAvatarUpload (file) {
      return beforeUpload(file)
    }
  },
  computed: {
    userInfo () {
      return this.$store.state.userInfo
    },
    tokenHeader () {
      if (this.$store.state.userInfo.token) {
        return { Authorization: this.$store.state.userInfo.token }
      } else {
        return null
      }
    }
  }
}
</script>

<style scoped lang="scss">
  .my-detail {
    background-color: #f0f0f0;

    .container {
      background: #f0f0f0;
      border: 0;

      .avatar-box {
        width: 100%;

        .avatar-img {
          padding: 10px;
          width: 90px;
          height: 90px;
          border-radius: 50%;
        }
      }
    }
  }

</style>
<style lang="scss">
  .my-detail {
    .form-box {
      .el-input__inner {
        background-color: #dcdcdc;
        color: #5e6167;
        border: 0;
      }

      .el-form-item__label {
        text-align: left;
      }
    }

    .avatar-box {
      .el-upload--text {
        width: 105px;
        height: 105px;
        border-radius: 50%;
        border: 1px dashed #d9d9d9;
      }

      .el-upload--text:hover {
        border: 1px dashed #66a6f9;
      }

      .avatar-uploader-icon {
        font-size: 20px;
        color: #8c939d;
        width: 100px;
        height: 100px;
        line-height: 100px;
        text-align: center;
      }
    }

    .el-form-item__label{
      width: 100px !important;
    }

    .el-form-item__content{
      margin-left: 100px !important;
    }
  }
</style>
