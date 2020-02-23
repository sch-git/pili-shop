<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 用户管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="searchUserAO.name" placeholder="用户名" class="handle-input mr10"></el-input>
        <el-input v-model="searchUserAO.nickName" placeholder="昵称" class="handle-input mr10"></el-input>
        <el-select v-model="searchUserAO.sex" clearable placeholder="请选择性别" class="handle-input mr10">
          <el-option
            v-for="item in sexOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-select v-model="searchUserAO.status" clearable placeholder="请选择状态" class="handle-input mr10">
          <el-option
            v-for="item in statusOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
      </div>
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
        <el-table-column prop="name" label="用户名" align="center"></el-table-column>
        <el-table-column prop="nickName" label="昵称" align="center"></el-table-column>
        <el-table-column label="积分" align="center">
          <template slot-scope="scope">{{scope.row.points}}</template>
        </el-table-column>
        <el-table-column label="头像(查看大图)" align="center">
          <template slot-scope="scope">
            <el-image
              class="table-td-thumb"
              src="http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w"
              :preview-src-list="['http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w']"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center">
          <template slot-scope="scope">
            <el-button @click="handleStatusChange(scope.row)" size="small"
              :type="scope.row.status===false?'primary':'danger'"
            >{{scope.row.status===false?'正常':'禁用'}}</el-button>
          </template>
        </el-table-column>
        <el-table-column label="性别" align="center">
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.sex===false?'primary':'danger'"
            ><i :class="scope.row.sex===false?'el-icon-male':'el-icon-female'"></i></el-tag>
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
  </div>
</template>

<script>
import { findUserList, updateUserStatus } from '@/api/user'

export default {
  name: 'user',
  data () {
    return {
      multipleSelection: [],
      // 查询条件
      searchUserAO: {
        sex: '',
        status: '',
        name: '',
        nickName: '',
        pageNum: 1,
        pageSize: 3
      },
      // 列表数据
      tableData: [
        {
          id: '',
          name: '',
          nickName: '',
          sex: '',
          avatar: '',
          points: '',
          status: '',
          createTime: '',
          updateTime: ''
        }
      ],
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 3,
        total: 0
      },
      // 选择器
      sexOptions: [
        {
          value: 0,
          label: '男'
        },
        {
          value: 1,
          label: '女'
        }
      ],
      statusOptions: [
        {
          value: 0,
          label: '正常'
        },
        {
          value: 1,
          label: '禁用'
        }
      ],
      // 其他
      loading_table: true
    }
  },
  created () {
    this.handleSearch()
  },
  methods: {
    // 初始化数据
    getData () {
      this.handleSearch()
    },
    // 触发搜索按钮
    handleSearch () {
      findUserList(this.searchUserAO).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
        this.loading_table = false
      })
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    // 分页导航
    handlePageChange (val) {
      this.searchUserAO.pageNum = val
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 状态改变
    handleStatusChange (row) {
      let updateUserStatusAO = {
        id: row.id,
        status: !row.status
      }
      updateUserStatus(updateUserStatusAO).then(res => {
        this.getData()
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
  .table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
  }
</style>
