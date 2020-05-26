<template>
  <main>
    <!--导航-->
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>权限管理</el-breadcrumb-item>
        <el-breadcrumb-item>角色列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <!--搜索栏-->
      <div class="handle-box">
        <el-button type="primary" icon="el-icon-search" @click="handleAdd">添加角色</el-button>
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
            <el-button
              type="text"
              icon="el-icon-edit"
              class="el-button--edit"
              @click="handleUpdate(scope.$index, scope.row)">编辑权限
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
    <!-- 添加角色弹出框 -->
    <el-dialog title="添加角色" :visible.sync="dialog" width="30%">
      <el-form ref="form" :model="form" :rules="rules" label-width="70px">
        <el-form-item label="角色名" prop="name">
          <el-input v-model="form.name"></el-input>
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
    <!-- 编辑权限弹出框 -->
    <el-dialog title="编辑权限" :visible.sync="right_dialog" width="30%">
      <el-form ref="right_form" label-width="70px">
        <el-form-item label="权限">
          <el-checkbox-group v-model="selectedRight" @change="handleCheckedRightsChange">
            <el-checkbox v-for="right in rights" :key="right.id" :label="right" :checked="right in selectedRight">
              {{ right.name }}
            </el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
                    <el-button @click="resetForm('right_form')">取 消</el-button>
                    <el-button type="primary" @click="submitRightForm('right_form')">确 定</el-button>
                </span>
    </el-dialog>
  </main>
</template>

<script>
import { deleteRole, findRoleList } from '../api/admin/role'
import { addRole } from '@/api/admin/role'
import { findResourceByRoleId, findResourceList, updateRole } from '@/api/admin/resource'

export default {
  name: 'Roles',
  data () {
    let checkName = (rule, value, callback) => {
      if (!value || value.trim() < 1) {
        return callback(new Error('角色名称不能为空'))
      }
      // TODO 判断角色名称是否已存在
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
      dialog: false,
      right_dialog: false,
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 2,
        total: 0
      },
      tableData: [
        {
          id: -1,
          name: '管理员',
          code: 'ROLE_ADMIN',
          createTime: '',
          updateTime: ''
        }
      ],
      form: {
        name: '',
        code: ''
      },
      // 校检规则
      rules: {
        name: [
          { validator: checkName, trigger: 'blur' }
        ],
        code: [
          { validator: checkCode, trigger: 'blur' }
        ]
      },
      // 所有权限
      rights: [
        {
          id: '1',
          name: '查询管理员',
          url: '/admin/list',
          code: 'admin-001'
        }
      ],
      selectedRight: [
        {
          id: '1',
          name: '查询管理员',
          url: '/admin/list',
          code: 'admin-001'
        }
      ],
      roleRight: {
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
    // 查询角色
    handleFind () {
      findRoleList(this.pageInfo).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
        this.loading_table = false
      })
    },
    // 添加角色
    handleAdd () {
      this.dialog = true
    },
    // 删除角色
    handleDel (index, row) {
      deleteRole(row.id).then(res => {
        this.loading_table = true
        this.handleFind()
      })
    },
    // 编辑权限
    handleUpdate (index, row) {
      this.findAllRight(row)
      this.right_dialog = true
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
      this.right_dialog = false
    },
    // 提交表单
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          addRole(this.form).then(res => {
            this.handleFind()
            this.resetForm(formName)
            this.dialog = false
          })
        } else {
          this.$message.error('请填写完整信息!')
          return false
        }
      })
    },
    // 提交修改权限表单
    submitRightForm (formName) {
      if (this.selectedRight.length > 0) {
        this.roleRight.resourceAOS = this.selectedRight
        console.log('resourceAOS', this.roleRight.resourceAOS)
        updateRole(this.roleRight).then(res => {
          this.resetForm(formName)
          this.right_dialog = false
        })
      } else {
        this.$message.error('请填写完整信息!')
        return false
      }
    },
    // 查询所有权限
    findAllRight (row) {
      let pageInfo = {
        pageNum: 1,
        pageSize: 0
      }
      findResourceList(pageInfo).then(res => {
        this.rights = res.list
        this.findHaveRight(row)
      })
    },
    // 查询当前角色所拥有权限
    findHaveRight (row) {
      findResourceByRoleId(row.id).then(res => {
        this.selectedRight = res.list
        this.roleRight.roleId = row.id
      })
    },
    // 权限变化
    handleCheckedRightsChange (value) {

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
