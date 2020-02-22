<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 商品列表
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="searchCommodityAO.name" clearable placeholder="商品名称" class="handle-input mr10"></el-input>
        <el-select v-model="searchCommodityAO.categoryId" clearable placeholder="请选择商品分类" class="handle-input mr10">
          <el-option
            v-for="item in categoryOptions"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
        <el-select v-model="searchCommodityAO.status" clearable placeholder="上架状态" class="handle-input mr10">
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
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column label="商品图片" align="center">
          <template slot-scope="scope">
            <el-image
              class="table-td-thumb"
              src="http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w"
              :preview-src-list="['http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w']"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="name" label="商品名称" align="center"></el-table-column>
        <el-table-column prop="price" label="价格" align="center"></el-table-column>
        <el-table-column prop="describe" label="描述" align="center">
          <!--
                    <template slot-scope="scope">{{scope.row.describe}}</template>
          -->
        </el-table-column>
        <el-table-column label="是否上架" align="center">
          <template slot-scope="scope">
            <el-switch
              @click="handleStatusChange(scope.row)"
              style="display: block"
              v-model="scope.row.status"
              active-color="#13ce66"
              inactive-color="#ff4949"
              active-text="上架"
              inactive-text="下架">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-edit"
              @click="handleEdit(scope.$index, scope.row)"
            >编辑
            </el-button>
            <el-button
              type="text"
              icon="el-icon-edit"
              @click="handleEditImage(scope.$index, scope.row)"
            >修改图片
            </el-button>
          </template>
        </el-table-column>

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

import { findCommodityList, updateCommodityStatus } from '@/api/commodity'

export default {
  name: 'commodity',
  data () {
    return {
      multipleSelection: [],
      // 查询条件
      searchCommodityAO: {
        name: '',
        categoryId: '',
        status: '',
        pageNum: 1,
        pageSize: 3
      },
      // 列表数据
      tableData: [
        {
          id: '',
          categoryId: '',
          name: '',
          price: 0.00,
          describe: '',
          status: true,
          url: '',
          createName: '',
          createTime: '',
          updateName: '',
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
      statusOptions: [
        {
          value: false,
          label: '下架'
        },
        {
          value: true,
          label: '上架'
        }
      ],
      categoryOptions: [
        {
          id: 1,
          name: '手办'
        },
        {
          id: 2,
          name: '布偶'
        }
      ],
      // 对话框
      dialog: false,
      form: {
        name: '',
        status: ''
      }
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
      findCommodityList(this.searchCommodityAO).then(res => {
        this.tableData = res.list
        this.pageInfo.total = res.total
      })
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    // 分页导航
    handlePageChange (val) {
      this.searchCommodityAO.pageNum = val
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 状态改变
    handleStatusChange (row) {
      let updateCommodityStatusAO = {
        id: row.id,
        status: !row.status
      }
      updateCommodityStatus(updateCommodityStatusAO).then(res => {
        this.handleSearch()
      })
    },
    // 触发编辑按钮
    handleEdit (index, row) {
      this.dialog = true
    },
    // 触发修改图片按钮
    handleEditImage (index, row) {
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
