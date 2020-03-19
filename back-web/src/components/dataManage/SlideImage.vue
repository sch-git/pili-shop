<template>
  <main>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 轮播图管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="form-box">
        <el-upload
          class="avatar-uploader avatar-box"
          action="http://localhost:10080/admin/avatar"
          :headers="tokenHeader"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :before-remove="handleBeforeRemove"
          :on-success="handleAvatarSuccess"
          :file-list="imageList"
          list-type="picture-card">
          <i class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-dialog :visible.sync="dialog" width="75%">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </div>
    </div>
  </main>
</template>

<script>
import { uploadSuccess } from '@/api/common'
import { addSlideImage, deleteSlideImage, findSlideImageList } from '@/api/dataManage/slideImage'

export default {
  name: 'SlideImage',
  data () {
    return {
      dialog: false,
      dialogImageUrl: '',
      imageList: [],
      tokenHeader: { Authorization: this.$store.state.user.userInfo.token }
    }
  },
  created () {
    this.handleSearch()
  },
  methods: {
    // 查询图片
    handleSearch () {
      findSlideImageList().then(res => {
        if (res) {
          res.forEach(item => {
            this.imageList.push({ url: item })
          })
        }
      })
    },
    // 图片上传成功
    handleAvatarSuccess (res, file) {
      this.url = uploadSuccess(res)
      addSlideImage({ url: this.url })
      this.imageList.push({ url: this.url })
    },
    // 删除图片之前的钩子
    handleBeforeRemove (file, imageList) {
      if (imageList.length <= 1) {
        this.$message.error('请保留至少一张图片!')
        return false
      }
    },
    // 删除图片
    handleRemove (file, imageList) {
      console.log(file.url)

      deleteSlideImage(file.url)
    },
    // 放大查看图片
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url
      this.dialog = true
    }
  }
}
</script>

<style scoped>
  .crumbs {
    margin: 10px 0;
  }

  .handle-input {
    width: 150px;
    display: inline-block;
  }

  .mr10 {
    margin-right: 10px;
  }

  .form-box {
    width: 54%;
    padding: 50px 23%;
  }

  .avatar-uploader >>> .el-upload {
    border: 1px dashed #8c939d;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader >>> .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 146px;
    height: 146px;
    line-height: 146px;
    text-align: center;
  }

  .avatar-uploader {
    width: 100%;
  }

  .avatar-box {
    padding: 10px;
  }
</style>
