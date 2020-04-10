<template>
  <main class="my-order">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 我的设置
        </el-breadcrumb-item>
        <el-breadcrumb-item>我的订单</el-breadcrumb-item>
      </el-breadcrumb>
      <div class="container">
        <div class="search-box">
          <el-select v-model="searchAO.status" clearable placeholder="订单状态" class="handle-input">
            <el-option
              v-for="item in statusOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <el-button type="primary" size="medium" icon="el-icon-search" @click="handleSearch">搜索</el-button>
        </div>
        <div class="table-box">
          <el-table
            v-loading="loading_table"
            :data="tableData"
            border
            class="table"
            header-cell-class-name="table-header"
          >
            <el-table-column prop="code" label="订单编号" align="center"></el-table-column>
            <el-table-column prop="receiveName" label="收货人" align="center"></el-table-column>
            <el-table-column label="收货地址" align="center">
              <template slot-scope="scope">
                <el-tooltip class="item" effect="dark" :content="scope.row.detailedAddress" placement="top">
                  <span>{{scope.row.province}}-{{scope.row.city}}-{{scope.row.district}}</span>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column prop="status" label="订单状态" width="85px" align="center">
              <template slot-scope="scope">
                <el-button type="text" size="mini" disabled>
                  {{scope.row.status>=0?statusOptions[scope.row.status].label:'' }}
                </el-button>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="180" align="center">
              <template slot-scope="scope">
                <el-button v-if="scope.row.status===0" type="warning" plain size="mini"
                          @click="handlePayOrder(scope.$index, scope.row,)">前往支付
                </el-button>
                <el-button v-if="scope.row.status===2" type="warning" icon="el-icon-edit" size="mini"
                           plain @click="handleStatus(scope.$index, scope.row,)">收货
                </el-button>
                <el-popover
                  placement="bottom-start"
                  width="750"
                  trigger="click"
                  v-if="tableInfoData">
                  <div class="popoverClass">
                    <el-table :data="tableInfoData" >
                      <el-table-column property="url" label="图片" width="150" align="center">
                        <template slot-scope="scope">
                          <img
                            class="table-td-thumb"
                            :src="scope.row.url"
                            :preview-src-list="[scope.row.url]" alt=""/>
                        </template>
                      </el-table-column>
                      <el-table-column property="commodityName" label="商品名称" align="center"></el-table-column>
                      <el-table-column property="price" label="价格" align="center">
                        <template slot-scope="scope">
                          {{Number(scope.row.price).toFixed(2)}}
                        </template>
                      </el-table-column>
                      <el-table-column width="100" property="number" label="数量" align="center"></el-table-column>
                    </el-table>
                    <p class="orderTime">创建时间：<code>{{ scope.row.createTime }}</code></p>
                    <p v-if="scope.row.payTime!==null" class="orderTime">支付时间：<code>{{ scope.row.payTime }}</code></p>
                    <p v-if="scope.row.successTime!==null" class="orderTime">完成时间：<code>{{ scope.row.successTime }}</code>
                    </p>
                    <p v-if="scope.row.cancelTime!==null" class="orderTime">取消时间：<code>{{ scope.row.cancelTime }}</code>
                    </p>
                  </div>
                  <el-button type="primary" icon="el-icon-edit" slot="reference" size="mini" plain
                             @click="handleInfo(scope.$index, scope.row)">详情
                  </el-button>
                </el-popover>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div class="page-box">
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
    </div>
  </main>
</template>

<script>
import { findOrderDetail, findOrderList, payOrder, updateOrderStatus } from '@/api/order'
import { mapMutations } from 'vuex'

export default {
  name: 'OrderList',
  data () {
    return {
      loading_table: false,
      // 查询条件
      searchAO: {
        status: '',
        pageNum: 1,
        pageSize: 3
      },
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 3,
        total: 0
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
  // 数据初始化
  created () {
    this.handleSearch()
  },
  beforeRouteLeave (to, from, next) {
    this.SET_LOADING(false)
    next()
  },
  // 计算属性
  computed: {},
  methods: {
    ...mapMutations([
      'SET_PAY_FORM',
      'SET_LOADING'
    ]),
    // 分页导航
    handlePageChange (val) {
      this.searchAO.pageNum = val
      this.pageInfo.pageNum = val
      this.handleSearch()
    },
    // 查询订单列表
    handleSearch () {
      this.loading_table = true
      findOrderList(this.searchAO).then(res => {
        this.pageInfo.total = res.total
        this.tableData = res.list
        this.loading_table = false
      })
    },
    // 订单状态样式
    statusType (status) {
      if (status === 0) return 'primary'
      if (status === 1) return 'info'
      if (status === 2) return 'danger'
      if (status === 3) return 'success'
      if (status === 4) return 'danger'
    },
    // 订单收货
    handleStatus (index, row) {
      const updateStatusAO = {
        id: row.id,
        status: row.status + 1
      }
      updateOrderStatus(updateStatusAO)
    },
    // 订单支付
    handlePayOrder (index, row) {
      const payOrderAO = {
        code: row.code,
        total: row.total,
        receiveName: row.receivedAlert
      }
      this.SET_LOADING(true)
      payOrder(payOrderAO).then(data => {
        this.SET_PAY_FORM(data)
        this.$router.push('/order/pay')
      })
    },
    // 查看订单详情
    handleInfo (index, row) {
      this.tableInfoData = []
      findOrderDetail(row.id).then(res => {
        this.tableInfoData = res
      })
    }
  }
}
</script>

<style scoped lang="scss">
  .my-order {
    background-color: #f0f0f0;
    width: 780px;

    .container {
      padding: 0;
      border: 0;
      background: #f0f0f0;

      .search-box {
        .handle-input {
          width: 120px;
          margin-right: 15px;
        }
      }

      .table-box {
        .table{
          font-size: 13px !important;
          .popoverClass {
            height: 300px;
            overflow-y: auto;
          }
        }

      }

      .page-box {

      }
    }
  }

</style>
<style lang="scss">
  .orderTime {
    font-weight: bolder;
    margin: 10px 10px 5px 0;
  }
  img{
    width: 75px;
    height: 75px;
  }
</style>
