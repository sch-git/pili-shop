<template>
  <main>
    <!--导航-->
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>权限管理</el-breadcrumb-item>
        <el-breadcrumb-item>权限列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <!--搜索栏-->
      <div class="handle-box">
        <el-button type="primary" icon="el-icon-search" @click="handleAdd">添加权限</el-button>
      </div>
      <!--表格-->
      <el-table
        v-loading="loading_table"
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column prop="name" label="名称" align="center"></el-table-column>
        <el-table-column prop="url" label="路径" align="center"></el-table-column>
        <el-table-column prop="code" label="代码" align="center"></el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center"></el-table-column>
        <el-table-column prop="updateTime" label="修改时间" align="center"></el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-delete"
              @click="handleDel(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <!--分页-->
      <div class="pagination">
        <el-pagination
          background
          layout="total, prev, pager, next"
          :current-page="pageInfo.pageNum"
          :page-size="pageInfo.pageSize"
          :total="pageInfo.total"
          @current-change="handlePageChange"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加权限弹出框 -->
    <el-dialog title="添加分类" :visible.sync="dialog" width="30%">
      <el-form ref="form" :model="form" :rules="rules" label-width="70px">
        <el-form-item label="权限名" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="路径" prop="url">
          <el-input v-model="form.url"></el-input>
        </el-form-item>
        <el-form-item label="权限代码" prop="code">
          <el-input v-model="form.code"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
                <el-button @click="resetForm('form')">取 消</el-button>
                <el-button type="primary" @click="submitForm('form')">确 定</el-button>
            </span>
    </el-dialog>
  </main>
</template>

<script>
import { addResource, deleteResource, findResourceList } from '../api/admin/resource'

export default {
  name: 'Rights',
  data () {
    let checkName = (rule, value, callback) => {
      if (!value || value.trim() < 1) {
        return callback(new Error('分权限称不能为空'))
      }
      // TODO 判断分类名称是否已存在
      callback()
    }
    let checkUrl = (rule, value, callback) => {
      if (!value || value.trim() < 1) {
        return callback(new Error('路径不能为空'))
      }
      callback()
    }
    let checkCode = (rule, value, callback) => {
      if (!value || value.trim() < 1) {
        return callback(new Error('代码不能为空'))
      }
      callback()
    }
    return {
      loading_table: true,
      multipleSelection: [],
      // 列表数据
      tableData: [{
        id: 0,
        name: '',
        url: '',
        code: '',
        createTime: '',
        updateTime: ''
      }],
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 1,
        total: 0
      },
      // 添加权限弹窗
      dialog: false,
      form: {
        name: '',
        url: '',
        code: ''
      },
      // 校检规则
      rules: {
        name: [
          { validator: checkName, trigger: 'blur' }
        ],
        url: [
          { validator: checkUrl, trigger: 'blur' }
        ],
        code: [
          { validator: checkCode, trigger: 'blur' }
        ]
      }
    }
  },
  created () {
    this.handleSearch()
  },
  methods: {
    // 触发搜索按钮
    handleSearch () {
      findResourceList(this.pageInfo).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
        this.loading_table = false
      })
    },
    // 分页导航
    handlePageChange (val) {
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    // 删除权限
    handleDel (index, row) {
      deleteResource(row.id)
      this.pageInfo.pageNum = 1
      this.handleSearch()
    },
    // 添加权限
    handleAdd () {
      this.dialog = true
    },
    // 重置表单
    resetForm (formName) {
      this.$refs[formName].resetFields()
      this.dialog = false
    },
    // 提交表单
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.form)
          addResource(this.form).then(res => {
            this.handleSearch()
            this.resetForm(formName)
            this.dialog = false
          })
        } else {
          this.$message.error('请填写完整!')
          return false
        }
      })
    }
  }
}
</script>

<style scoped>
  .handle-box {
    margin-bottom: 20px;
  }

  .table {
    width: 100%;
    font-size: 14px;
  }

  .el-button--text {
    color: red;
  }
</style>
