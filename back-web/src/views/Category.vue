<template>
  <main>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 分类管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="searchAO.name" placeholder="分类名" class="handle-input mr10"></el-input>
        <el-select v-model="searchAO.status" clearable placeholder="是否启用" class="handle-input mr10">
          <el-option
            v-for="item in statusOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
        <el-button type="primary" icon="el-icon-search" @click="handleAdd">添加分类</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
        @selection-change="handleSelectionChange"
        @row-dblclick="dbclick"
      >
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column prop="name" label="分类名" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.enabled===true">{{scope.row.name}}</span>
            <el-input id="edit-input" v-else v-model="scope.row.name"></el-input>
          </template>
        </el-table-column>
        <el-table-column label="是否启用" align="center">
          <template slot-scope="scope">
            <el-button @click="scope.row.status=!scope.row.status,handleChange(scope.row)" size="small"
                       :type="scope.row.status===true?'primary':'danger'"
            >{{scope.row.status===true?'正常':'禁用'}}
            </el-button>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center"></el-table-column>
        <el-table-column prop="updateTime" label="修改时间" align="center"></el-table-column>
      </el-table>
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
    <!-- 添加分类弹出框 -->
    <el-dialog title="添加分类" :visible.sync="dialog" width="30%">
      <el-form ref="form" :model="form" :rules="rules" label-width="70px">
        <el-form-item label="分类名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="是否启用">
          <el-select v-model="form.status" clearable placeholder="请选择状态" class="handle-input mr10">
            <el-option
              v-for="item in statusOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
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

import { addCategory, findCategoryList, updateCategory } from '@/api/commodity/category'

export default {
  name: 'Category',
  data () {
    let checkName = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('分类名称不能为空'))
      }
      // TODO 判断分类名称是否已存在
      callback()
    }
    return {
      multipleSelection: [],
      // 查询条件
      searchAO: {
        status: '',
        name: '',
        pageNum: 1,
        pageSize: 3
      },
      // 列表数据
      tableData: [
        {
          id: '',
          name: '',
          status: '',
          createTime: '',
          updateTime: '',
          enabled: true
        }
      ],
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 3,
        total: 0
      },
      // 选择器
      statusOptions: [
        {
          value: true,
          label: '是'
        },
        {
          value: false,
          label: '否'
        }
      ],
      // 对话框
      dialog: false,
      form: {
        name: '',
        status: '',
        createName: this.$store.state.user.userInfo.username
      },
      // 校检规则
      rules: {
        name: [
          { validator: checkName, trigger: 'blur' }
        ]
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    // 初始化数据
    getData () {
      this.handleSearch()
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    // 触发搜索按钮
    handleSearch () {
      findCategoryList(this.searchAO).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
      })
    },
    // 触发添加按钮
    handleAdd () {
      this.dialog = true
    },
    // 分页导航
    handlePageChange (val) {
      this.searchAO.pageNum = val
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 状态改变
    handleChange (row) {
      let updateCategoryAO = {
        id: row.id,
        name: row.name,
        status: row.status
      }
      console.log(updateCategoryAO)
      updateCategory(updateCategoryAO).then(res => {
        this.getData()
      })
    },
    // 双击修改分类名
    dbclick (row, event, column) {
      row.enabled = !row.enabled
      if (row.enabled) {
        this.handleChange(row)
      }
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
          addCategory(this.form).then(res => {
            this.getData()
          })
        } else {
          this.$message.error('表单错误!')
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

  .handle-select {
    width: 120px;
  }

  .handle-input {
    width: 150px;
    display: inline-block;
  }

  .table {
    width: 100%;
    font-size: 14px;
  }

  .red {
    color: #ff0000;
  }

  .mr10 {
    margin-right: 10px;
  }
</style>
<style>
  #edit-input {
    height: 32px;
    line-height: 32px;
  }
</style>
