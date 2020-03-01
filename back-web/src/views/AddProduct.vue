<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 表单
        </el-breadcrumb-item>
        <el-breadcrumb-item>添加商品</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <el-upload
        class="avatar-uploader avatar-box"
        action="http://localhost:10080/admin/avatar"
        :headers="tokenHeader"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload">
        <img alt v-if="form.url" :src="form.url" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"/>
      </el-upload>
      <div class="form-box">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item v-show="false" label="商品图片" prop="url">
            <el-input v-model="form.url"></el-input>
          </el-form-item>
          <el-form-item label="商品名称" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="商品分类" prop="categoryId">
            <el-select v-model.number="form.categoryId" placeholder="请选择">
              <el-option
                v-for="item in categoryOptions"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                :disabled="!item.status">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="商品售价" prop="price">
            <el-input v-model.number="form.price"></el-input>
          </el-form-item>
          <el-form-item label="商品描述" prop="describe">
            <el-input type="textarea"
                      :autosize="{ minRows: 2, maxRows: 4}"
                      v-model="form.describe"></el-input>
          </el-form-item>
          <el-form-item label="是否上架">
            <el-switch v-model="form.status"></el-switch>
          </el-form-item>
          <el-form-item class="form-item-box">
            <el-button type="primary" @click="submitForm('form')">添加商品</el-button>
            <el-button type="danger" plain @click="resetForm('form')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import { beforeUpload, uploadSuccess } from '@/api/common'
import { addCommodity } from '@/api/commodity'
import { checkName, checkPrice, checkCategory, checkDescribe, checkUrl } from '@/lib/tools'
import { findCategoryList } from '@/api/commodity/category'

export default {
  name: 'addProduct',
  data () {
    return {
      // 添加表单
      form: {
        categoryId: '',
        name: '',
        price: '',
        describe: '',
        status: true,
        url: '',
        createName: ''
      },
      // 商品查询条件
      searchAO: {
        status: true,
        name: '',
        pageNum: 1,
        pageSize: 0
      },
      // 商品分类选择器
      categoryOptions: [
        {
          id: 1,
          name: '手办',
          status: true
        },
        {
          id: 2,
          name: '布偶',
          status: true
        }
      ],
      tokenHeader: { Authorization: this.$store.state.user.userInfo.token },
      rules: {
        name: [
          { validator: checkName, trigger: 'blur' }
        ],
        price: [
          { validator: checkPrice, trigger: 'blur' }
        ],
        categoryId: [
          { validator: checkCategory, trigger: 'blur' }
        ],
        describe: [
          { validator: checkDescribe, trigger: 'blur' }
        ],
        url: [
          { validator: checkUrl, trigger: 'blur' }
        ]
      }
    }
  },
  created () {
    this.searchCategory()
  },
  methods: {
    // 查询分类
    searchCategory () {
      findCategoryList(this.searchAO).then(res => {
        this.categoryOptions = res.list
      })
    },
    // 提交表单
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          addCommodity(this.form).then(res => {
            this.$refs[formName].resetFields()
          })
        } else {
          this.$message.error('表单错误!')
          return false
        }
      })
    },
    // 重置表单
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    // 上传头像成功
    handleAvatarSuccess (res, file) {
      this.form.url = uploadSuccess(res)
    },
    // 上传前的处理
    beforeAvatarUpload (file) {
      return beforeUpload(file)
    }
  }
}
</script>
<style scoped>
  .form-box {
    width: 60%;
    padding: 10px 20%;
  }

  .form-item-box {
    min-width: 400px;
    padding: 10px 25%;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-box {
    padding: 10px 45%;
  }

  .avatar {
    width: 110px;
    height: 110px;
  }
</style>
<style>
  .el-upload--text {
    width: 120px;
    height: 120px;
    padding: 5px;
    border-radius: 10%;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 35px;
    color: #8c939d;
    width: 110px;
    height: 110px;
    line-height: 110px;
    text-align: center;
  }
</style>
