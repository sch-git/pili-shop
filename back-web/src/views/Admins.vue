<template>
  <main>
    <!--导航-->
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>权限管理</el-breadcrumb-item>
        <el-breadcrumb-item>管理员列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <!--搜索栏-->
      <div class="handle-box">
        <el-button type="primary" icon="el-icon-search" @click="handleAdd">添加管理员</el-button>
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
        <el-table-column prop="username" label="名称" align="center"></el-table-column>
        <el-table-column prop="nickname" label="身份" align="center"></el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center"></el-table-column>
        <el-table-column prop="updateTime" label="修改时间" align="center"></el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-delete"
              @click="handleDel(scope.$index, scope.row)">删除
            </el-button>
            <el-button
              type="text"
              icon="el-icon-edit"
              class="el-button--edit"
              @click="handleUpdate(scope.$index, scope.row)">编辑角色
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
    <!-- 添加管理员弹出框 -->
    <el-dialog title="添加管理员" :visible.sync="dialog" width="30%">
      <el-form ref="form" label-width="70px">
        <el-form-item label="角色">
          <el-checkbox-group v-model="selectedRole">
            <el-checkbox v-for="role in roles" :key="role.id" :label="role" :checked="role in selectedRole">
              {{ role.name }}
            </el-checkbox>
          </el-checkbox-group>
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
import { findAdminRole, findRoleList } from '@/api/admin/role'
import { findAdminList } from '@/api/admin/admin'

export default {
  name: 'Admin',
  data () {
    return {
      loading_table: true,
      dialog: false,
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 2,
        total: 0
      },
      tableData: [
        {
          id: -1,
          username: 'root',
          nickname: '管理员',
          createTime: '',
          updateTime: ''
        }
      ],
      // 所有角色
      roles: [
        // {
        //   id: '1',
        //   name: '查询管理员'
        // }
      ],
      selectedRole: [
        {
          id: '1',
          name: '查询管理员'
        }
      ],
      adminRole: {
        roleId: '1',
        resourceAOS: [
          {
            id: '1',
            name: '查询管理员',
            url: '/admin/list',
            code: 'admin-001'
          }
        ]
      }
    }
  },
  created () {
    this.handleFind()
  },
  methods: {
    handleSelectionChange () {

    },
    // 初始化
    handleInit () {

    },
    // 查询管理员
    handleFind () {
      findAdminList(this.pageInfo).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
        this.loading_table = false
      })
    },
    // 添加角色
    handleAdd () {
      this.$message.error('您没有权限添加管理员')
    },
    // 删除角色
    handleDel (index, row) {
      this.$message.error('您没有权限删除管理员')
    },
    // 编辑角色
    handleUpdate (index, row) {
      this.findAllRole(row)
      this.dialog = true
    },
    // 分页导航
    handlePageChange (val) {
      this.pageInfo.pageNum = val
      this.handleFind()
    },
    // 重置表单
    resetForm (formName) {
      this.$refs[formName].resetFields()
      this.dialog = false
    },
    // 提交表单
    submitForm (formName) {
      if (this.selectedRole.length > 0) {

      } else {
        this.$message.error('请填写完整信息!')
        return false
      }
    },
    // 查询所有角色
    findAllRole (row) {
      let params = {
        pageNum: '1',
        pageSize: '0'
      }
      findRoleList(params).then(res => {
        this.roles = res.list
        this.findSelectedRole(row)
      })
    },
    // 查询所拥有角色
    findSelectedRole (row) {
      findAdminRole(row.id).then(res => {
        this.selectedRole = res
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

  .el-button--edit {
    color: #20a0ff;
  }
</style>
