<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">pili-shop登录</div>
      <el-form :model="param" status-icon :rules="rules" ref="login" label-width="0px" class="ms-content">
        <el-form-item prop="username">
          <el-input v-model="param.username" placeholder="用户名">
            <el-button slot="prepend" icon="el-icon-user-solid"/>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password" placeholder="密码"
            v-model="param.password"
            @keyup.enter.native="submitForm()">
            <el-button slot="prepend" icon="el-icon-key"/>
          </el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm()">登录</el-button>
        </div>
        <p class="login-tips">Tips : 没有注册?<router-link to="/index">前往注册</router-link></p>
      </el-form>
    </div>
  </div>
</template>

<script>

import { login } from '@/api/user'
import { mapMutations } from 'vuex'
export default {
  data: function () {
    return {
      param: {
        username: 'user',
        password: '123'
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
      }
    }
  },
  methods: {
    ...mapMutations([
      'SET_USER'
    ]),
    // 登录
    submitForm () {
      this.$refs.login.validate(valid => {
        if (valid) {
          const loginAO = {
            username: this.param.username,
            password: this.param.password
          }
          login(loginAO).then(res => {
            if (res) {
              this.getUserInfo(res)
              this.$router.push('/index')
            }
          })
        } else {
          this.$message.error('请输入账号和密码')
          console.log('error submit!!')
          return false
        }
      })
    },
    // 登录成功-设置用户信息
    getUserInfo (userInfo) {
      this.SET_USER(userInfo)
    }
  }
}
</script>

<style scoped>
  .el-input-group__prepend > .el-button{
    margin: -10px -25px;
  }
  .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/login-bg.png);
    background-size: 100%;
  }

  .ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
  }

  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
  }

  .ms-content {
    padding: 30px 30px;
  }

  .login-btn {
    text-align: center;
  }

  .login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
  }

  .login-tips,a {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
  }
</style>
