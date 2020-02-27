<template>
  <main>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 商品图片
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="commodityName" placeholder="商品名称" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
      </div>
      <div class="form-box">
        <el-upload
          class="avatar-uploader avatar-box"
          action="http://localhost:10080/admin/avatar"
          :headers="tokenHeader"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :on-success="handleAvatarSuccess"
          :file-list="imageList"
          list-type="picture-card">
          <i class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-dialog :visible.sync="dialog" width="30%">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </div>
    </div>
  </main>
</template>

<script>
import { addCommodityImage, deleteCommodityImage, findImageList } from '@/api/commodity/commodityImage'
import { uploadSuccess } from '@/api/common'

export default {
  name: 'CommodityImage',
  props: {
    commodityId: {
      type: [Number, String],
      default: 1
    }
  },
  data () {
    return {
      commodityName: '',
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
      findImageList(this.commodityId).then(data => {
        this.imageList = data
      })
    },
    // 图片上传成功
    handleAvatarSuccess (res, file) {
      this.url = uploadSuccess(res)
      let addCommodityImageAO = {
        commodityId: this.commodityId,
        url: this.url,
        createName: this.$store.state.user.userInfo.username
      }
      addCommodityImage(addCommodityImageAO)
    },
    // 删除图片
    handleRemove (file, imageList) {
      deleteCommodityImage(file.id)
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
