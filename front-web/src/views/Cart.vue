<template>
  <main class="my-container">
    <div class="search-nav">
      <div class="search-nav-container">
        <ul>
          <li>我的购物车</li>
        </ul>
      </div>
    </div>
    <el-alert
      class="alert-box"
      title="小提示"
      description="请点击商品前的选择框，选择购物车中的商品，点击付款即可。"
      type="info" :closable="false" show-icon>
    </el-alert>
    <el-main class="cart-box">
      <div class="banner-top" v-if="!tableData[0] || !tableData[0].id">
        <h1>您的购物车空空如也，快去选购吧!</h1>
      </div>
      <el-table
        v-else
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column label="图片(查看大图)" align="center">
          <template slot-scope="scope">
            <el-image
              class="table-td-thumb"
              :src="scope.row.url"
              :preview-src-list="[scope.row.url]"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="name" label="商品名称" align="center"></el-table-column>
        <el-table-column label="单价" align="center" width="100">
          <template slot-scope="scope">{{scope.row.price}}</template>
        </el-table-column>
        <el-table-column label="数量" align="center">
          <template slot-scope="scope">
            <el-input-number size="small" :min=min :max=max v-model="scope.row.number"
            @change="(current,oldValue)=>handleChangeNum(current,oldValue,scope.row)"></el-input-number>
          </template>
        </el-table-column>
        <el-table-column label="小计" align="center" width="100">
          <template slot-scope="scope">
            {{ scope.row.number * scope.row.price }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="100" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-edit"
              @click="handleDel(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
    <div class="address-container">
      <h3>收货人信息</h3>
      <div class="address-box">
        <div class="address-check">
          <div class="address-check-name">
            <span>{{'12'}}</span>
          </div>
          <div class="address-detail">
            <p>{{checkAddress.address}}</p>
          </div>
        </div>
        <el-collapse v-model="collapseName" accordion>
          <el-collapse-item title="选择地址" name="1">
            <el-radio-group vertical size="large" v-model="radio">
              <el-radio :label="3" class="radio-item">备选项</el-radio>
              <el-radio :label="6" class="radio-item">备选项</el-radio>
              <el-radio :label="9" class="radio-item">备选项</el-radio>
            </el-radio-group>
          </el-collapse-item>
        </el-collapse>
      </div>
    </div>
    <div class="invoices-container">
      <h3>发票信息</h3>
      <p>该商品不支持开发票</p>
    </div>
    <div class="pay-container">
      <div class="pay-box">
        <p><span>提交订单应付总额：</span> <span class="money">{{totalPrice.toFixed(2)}}</span></p>
        <div class="pay-btn">
          <router-link to="/pay">
            <el-button type="danger" size="large">支付订单</el-button>
          </router-link>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import { MessageBoxConfirm } from '@/lib/tools'
import { addCartItem, deleteCartItem, findCartList } from '@/api/commodity/cart'

export default {
  name: 'Cart',
  props: {
    username: {
      type: [Number, String],
      default: 'user'
    }
  },
  data () {
    return {
      // 购物车列表
      multipleSelection: [],
      tableData: [
        {
          id: 1,
          name: 'product',
          describe: 'describe',
          price: 99.00,
          number: 2,
          url: ''
        }
      ],
      min: 1,
      max: 9999,
      old: 1,
      // 选择地址
      address: [],
      checkAddress: {},
      collapseName: 1,
      radio: 0
    }
  },
  created () {
    this.handleInit()
  },
  methods: {
    // 初始化数据
    handleInit () {
      this.findUserCart()
    },
    // 查询用户购物车数据
    findUserCart () {
      findCartList().then(res => {
        console.log('购物车数据', res)
        this.tableData = res
      })
    },
    // 商品数量变化
    handleChangeNum (current, old, row) {
      const addCartAO = {
        commodityId: row.id,
        number: current - old
      }
      addCartItem(addCartAO)
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
      console.log(this.multipleSelection)
    },
    // 从购物车中删除商品
    handleDel (index, row) {
      console.log(index)
      MessageBoxConfirm('是否确认删除该商品', '警告').then(flag => {
        if (flag) {
          const CartAO = {
            commodityId: row.id
          }
          // 从购物车中移除该商品
          deleteCartItem(CartAO)
          this.tableData.splice(index, 1)
        }
      })
    }
  },
  computed: {
    totalPrice () {
      let sum = 0
      this.tableData.forEach(item => {
        sum += item.price * item.number
      })
      return sum
    }
  }
}
</script>

<style scoped lang="scss">
  @import "../assets/css/base";

  .my-container {
    .search-nav {
      width: 100%;
      height: 80px;
      border-bottom: 2px solid #B1191A;

      .search-nav-container {
        width: 80%;
        min-width: 1000px;
        height: 50px;
        margin: 0 auto;

        ul {
          margin: 0;
          padding-left: 0;
          list-style: none;

          li {
            cursor: pointer;
            margin: 30px 0;
            line-height: 50px;
            padding: 0 40px;
            background-color: #C81623;
            color: #ffffff;
            font-size: 16px;
            font-weight: bold;
            float: left;
          }
        }
      }
    }

    .alert-box {
      line-height: 25px;
      background-color: #d5e8fc;
      color: #6b6d6f;
      margin-bottom: 30px;
    }

    .cart-box {
      padding: 0;

      .table {
        line-height: normal;

        .table-td-thumb {
          width: 75px;
          height: 75px;
        }

        .el-button--text {
          color: #e4393c;
        }
      }
    }

    .address-container {
      margin-top: 15px;

      .address-box {
        margin-top: 5px;
        padding: 15px;
        border: 1px #ccc dotted;

        .address-check {
          margin: 15px 0;
          height: 36px;
          display: flex;
          align-items: center;

          .address-check-name {
            width: 120px;
            justify-content: center;
            align-content: center;
            background-color: #cccccc;

            span {
              display: block;
              font-size: 14px;
              line-height: 36px;
              text-align: center;
              color: #fff;
              background-color: #f90013;
            }
          }

          .address-detail {
            padding-left: 15px;
            font-size: 14px;
            color: #999999;
          }
        }

        .radio-item {
          display: block;
          padding-left: 25px;
          margin: 15px 0;
        }
      }
    }

    .invoices-container {
      line-height: 45px;
      margin-top: 10px;

      p {
        font-size: 12px;
        line-height: 30px;
        color: #999;
      }
    }

    .pay-container {
      line-height: 45px;
      display: flex;
      justify-content: flex-end;

      .pay-box {
        font-size: 18px;
        font-weight: bolder;
        color: #495060;

        .money {
          font-size: 26px;
          color: #f90013;
        }

        .pay-btn {
          display: flex;
          justify-content: flex-end;

          .el-button {
            font-size: 16px;
          }
        }
      }
    }
  }
</style>
<style>
  .el-collapse-item__header {
    background: #dee7f5;
    padding-left: 25px;
  }
</style>
