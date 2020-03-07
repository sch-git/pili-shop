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
        <el-table-column label="头像(查看大图)" align="center">
          <template slot-scope="scope">
            <el-image
              class="table-td-thumb"
              src="http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w"
              :preview-src-list="['http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w']"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="name" label="商品名称" align="center"></el-table-column>
        <el-table-column label="单价" align="center">
          <template slot-scope="scope">{{scope.row.price}}</template>
        </el-table-column>
        <el-table-column label="数量" align="center">
          <template slot-scope="scope">
            <el-input-number size="small" :min=min :max=max v-model="scope.row.number"></el-input-number>
          </template>
        </el-table-column>
        <el-table-column label="小计" align="center">
          <template slot-scope="scope">
              {{ scope.row.number * scope.row.price }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="180" align="center">
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
    <div>

    </div>
  </main>
</template>

<script>
export default {
  name: 'Cart',
  data () {
    return {
      multipleSelection: [],
      tableData: [
        {
          id: 1,
          name: 'product',
          price: 99.00,
          number: 2,
          url: ''
        }
      ],
      min: 1,
      max: 9999
    }
  },
  created () {
    this.handleInit()
  },
  methods: {
    // 初始化数据
    handleInit () {

    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
      console.log(this.multipleSelection)
    },
    handleDel (index, row) {

    }
  },
  computed: {}
}
</script>

<style scoped lang="scss">
  @import "../../assets/css/base";
  .my-container{
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
    .alert-box{
      line-height: 25px;
      background-color: #d5e8fc;
      color: #6b6d6f;
      margin-bottom: 30px;
    }
    .cart-box{
      padding: 0;
      .table{
        line-height: normal;
        .table-td-thumb{
          width: 75px;
          height: 75px;
        }
      }
    }
  }
</style>
<style>

</style>
