<template>
  <main class="my-container">
    <!--搜索-->
    <div class="search-box">
      <el-input v-model="commodityAO.name" size="large" class="sreach" placeholder="输入你想查找的商品">
        <el-button slot="append" icon="el-icon-search" @click="handleSearch"></el-button>
      </el-input>
    </div>
    <!--分类-->
    <div class="search-nav">
      <div class="search-nav-container">
        <ul>
          <li @click="handleSearch">全部商品分类</li>
          <li>
            <router-link to="/index">首页</router-link>
          </li>
          <li @click="handleSearch(item.id)" v-for="item in categoryList" :key="item.id">
            <a href="javascript:;">{{ item.name }}</a>
          </li>
        </ul>
      </div>
    </div>
    <!--商品-->
    <div class="product-box">
      <div class="banner-top" v-if="!commodityList[0] || !commodityList[0].id">
        <h1>很遗憾，没有找到你想要的！</h1>
      </div>
      <div class="list-box" v-else>
        <el-row>
          <el-col :span="6" class="item" v-for="item in commodityList" :key="item.id">
            <div @click="handleDetail(item.id)" style="cursor: pointer">
              <div class="item-img">
                <img v-lazy="item.url" alt=""/>
              </div>
              <div class="item-info">
                <h5>{{ item.name }}</h5>
                <p>{{ item.price }}<i class="el-icon-shopping-cart-1"/></p>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>
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
  </main>
</template>

<script>
import { findCategoryList } from '@/api/commodity/category'
import { findCommodityList } from '@/api/commodity'
// eslint-disable-next-line
  import VueLazyload from '@/lib/tools'

export default {
  name: 'GoodList',
  data () {
    return {
      // 分页数据
      pageInfo: {
        pageNum: 1,
        pageSize: 8,
        total: 0
      },
      // 商品列表
      commodityList: [
        {
          id: '',
          categoryId: '',
          categoryName: '',
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
      commodityAO: {
        name: '',
        categoryId: null,
        status: true,
        pageNum: 1,
        pageSize: 8
      },
      // 分类列表
      categoryAO: {
        status: true,
        name: '',
        pageNum: 1,
        pageSize: 0
      },
      categoryList: [
        {
          id: 0,
          name: '手办',
          status: true
        }
      ]
    }
  },
  created () {
    this.handleInit()
  },
  methods: {
    // 初始化数据
    handleInit () {
      this.findCategoryList()
      this.findCommodityList()
    },
    // 获取分类
    findCategoryList () {
      findCategoryList(this.categoryAO).then(res => {
        this.categoryList = res.list
      })
    },
    // 获取商品
    findCommodityList () {
      findCommodityList(this.commodityAO).then(res => {
        this.commodityList = res.list
        this.pageInfo.total = res.total
      })
    },
    // 分页导航
    handlePageChange (val) {
      this.commodityAO.pageNum = val
      this.pageInfo.pageNum = val
      this.findCommodityList()
    },
    // 触发搜索按钮
    handleSearch (categoryId) {
      console.log(categoryId)
      if (typeof (categoryId) === 'number') {
        this.commodityAO.categoryId = categoryId
      } else {
        this.commodityAO.categoryId = null
      }
      this.findCommodityList()
    },
    // 点击查看商品详情
    handleDetail (commodityId) {
      console.log(commodityId)
      this.$router.push(`/goodDetail/${commodityId}`)
    }
  }
}
</script>

<style scoped lang="scss">
  @import "../../assets/css/base";

  .search-nav {
    width: 100%;
    height: 50px;
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
          margin-left: 30px;
          line-height: 50px;
          color: #C81623;
          font-size: 16px;
          font-weight: bold;
          float: left;

          a {
            color: #C81623;
            text-decoration: none;
          }
        }

        li:first-child {
          padding: 0 38px;
          background: #B1191A;
          margin: 0;
          color: #fff;
        }
      }
    }
  }

  .product-box {
    margin-top: 20px;

    .banner-top {
      h1 {
        margin: 50px 0;
        text-align: center;
      }
    }

    .list-box {
      .item {
        height: 300px;
        margin-bottom: 15px;
        text-align: center;
        padding: 10px;

        .item-img {
          width: 100%;
          height: 230px;

          img {
            width: 100%;
            height: 100%;
          }
        }

        .item-info {
          h5 {
            font-size: 14px;
            height: 16px;
            line-height: 16px;
            color: #333333;
            margin: 20px 0 21px;
          }

          p {
            font-size: 15px;
            height: 18px;
            line-height: 18px;
            color: #99999f;

            i {
              float: right;
              margin-right: 10px;
              color: red;
            }
          }

        }
      }
    }
  }

  .pagination > .el-pagination {
    height: 30px;
    padding-top: 30px;
  }
</style>
