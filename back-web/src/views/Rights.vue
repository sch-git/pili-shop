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
  </main>
</template>

<script>
import { findResourceList } from '../api/admin/resource'

export default {
  name: 'Rights',
  data () {
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
        pageSize: 3,
        total: 0
      }
    }
  },
  created () {
  },
  methods: {
    // 添加权限
    handleAdd () {

    },
    // 触发搜索按钮
    handleSearch () {
      let searchAO = {
        ...this.pageInfo
      }
      findResourceList(searchAO).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
        this.loading_table = false
      })
    },
    // 分页导航
    handlePageChange (val) {
      console.log('pageNum', this.pageInfo.pageNum)
      console.log('pageSize', this.pageInfo.pageSize)
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    // 删除权限
    handleDel (index, row) {

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
  .el-button--text{
    color: red;
  }
</style>
