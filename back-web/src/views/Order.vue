<template>
  <main>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 订单管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="searchAO.province" placeholder="省份" class="handle-input mr10"></el-input>
        <el-select v-model="searchAO.status" clearable placeholder="是否启用" class="handle-input mr10">
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
      >
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column prop="code" label="订单编号" align="center"></el-table-column>
        <el-table-column prop="receiveName" label="收货人" align="center"></el-table-column>
        <el-table-column label="收货地址" align="center">
          <template slot-scope="scope">
            <el-tooltip class="item" effect="dark" :content="scope.row.detailedAddress" placement="top">
              <span>{{scope.row.province}}-{{scope.row.city}}-{{scope.row.district}}</span>
            </el-tooltip>
          </template>
        </el-table-column>
        <el-table-column prop="status" label="订单状态" align="center">
          <template slot-scope="scope">
            <el-button plain :type="statusType(scope.row.status)">{{
              scope.row.status>=0?statusOptions[scope.row.status].label:''
              }}
            </el-button>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button v-if="scope.row.status===1" type="warning" icon="el-icon-edit"
                       @click="handleStatus(scope.$index, scope.row)">发货
            </el-button>
            <el-popover
              placement="bottom-start"
              width="750"
              trigger="click">
              <div class="popoverClass">
                <el-table :data="tableInfoData">
                  <el-table-column width="100" property="commodityId" label="商品id" align="center"></el-table-column>
                  <el-table-column property="address" label="图片" align="center">
                    <template slot-scope="scope">
                      <el-image
                        class="table-td-thumb"
                        :src="scope.row.url"
                        :preview-src-list="[scope.row.url]"
                      ></el-image>
                    </template>
                  </el-table-column>
                  <el-table-column property="commodityName" label="商品名称" align="center"></el-table-column>
                  <el-table-column property="price" label="价格" align="center"></el-table-column>
                  <el-table-column width="100" property="number" label="数量" align="center"></el-table-column>
                </el-table>
                <p class="orderTime">创建时间：<code>{{ scope.row.createTime }}</code></p>
                <p v-if="scope.row.payTime!==''" class="orderTime">支付时间：<code>{{ scope.row.payTime }}</code></p>
                <p v-if="scope.row.successTime!==''" class="orderTime">完成时间：<code>{{ scope.row.successTime }}</code></p>
                <p v-if="scope.row.cancelTime!==''" class="orderTime">取消时间：<code>{{ scope.row.cancelTime }}</code></p>
              </div>
              <el-button type="primary" icon="el-icon-edit" slot="reference"
                         @click="handleInfo(scope.$index, scope.row)">详情
              </el-button>
            </el-popover>
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
  </main>
</template>

<script>
import { findOrderDetail, findOrderList, updateOrderStatus } from '@/api/order'

export default {
  name: 'Order',
  data () {
    return {
      // 加载
      loading_table: false,
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 3,
        total: 0
      },
      // 查询条件
      searchAO: {
        status: '',
        province: '',
        pageNum: 1,
        pageSize: 3
      },
      // 选择器
      statusOptions: [
        {
          value: 0,
          label: '待支付'
        },
        {
          value: 1,
          label: '待发货'
        },
        {
          value: 2,
          label: '待收货 '
        },
        {
          value: 3,
          label: '已完成'
        },
        {
          value: 4,
          label: '已取消'
        }
      ],
      // 订单表格
      tableData: [
        {
          // id: 0,
          // code: '',
          // status: -1,
          // total: 0,
          // userName: '',
          // phone: '',
          // province: '',
          // city: '',
          // district: '',
          // detailedAddress: '',
          // createTime: '',
          // payTime: '',
          // successTime: '',
          // cancelTime: ''
        }
      ],
      // 订单详情表格
      tableInfoData: [
        {
          // id: 1,
          // orderId: 1,
          // commodityId: 1,
          // commodityName: '',
          // price: 0.0,
          // number: 1,
          // url: ''
        }
      ]
    }
  },
  created () {
    this.handleSearch()
  },
  methods: {
    // 分页导航
    handlePageChange (val) {
      this.searchAO.pageNum = val
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 查询订单列表
    handleSearch () {
      findOrderList(this.searchAO).then(res => {
        this.pageInfo.total = res.total
        this.tableData = res.list
      })
    },
    // 订单状态样式
    statusType (status) {
      if (status === 0) return 'primary'
      if (status === 0) return 'info'
      if (status === 2) return 'warning'
      if (status === 3) return 'success'
      if (status === 4) return 'danger'
    },
    // 订单发货
    handleStatus (index, row) {
      const updateStatusAO = {
        id: row.id,
        status: 2
      }
      updateOrderStatus(updateStatusAO)
    },
    // 查看订单详情
    handleInfo (index, row) {
      this.tableInfoData = []
      findOrderDetail(row.id).then(res => {
        this.tableInfoData = res
      })
    }
  },
  computed: {}
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

  .mr10 {
    margin-right: 10px;
  }

  .orderTime {
    font-weight: bolder;
    margin: 10px 10px 5px 0;
  }

  .table-td-thumb {
    display: block;
    margin: auto;
    width: 75px;
    height: 75px;
  }

  .popoverClass {
    height: 300px;
    overflow-y: auto;
  }
</style>
<style>
  #edit-input {
    height: 32px;
    line-height: 32px;
  }
</style>
