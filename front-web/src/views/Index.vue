<template>
  <main class="index">
    <div class="my-container">
      <!--轮播-->
      <div class="swiper-box">
        <div class="nav-menu">
          <el-menu
            class="el-menu-vertical-demo"
            background-color="#242f42"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item v-for="item in categoryList" :key="item.id">
              <i class="el-icon-menu"></i>
              <span slot="title">{{ item.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
        <swiper :options="swiperOptions">
          <swiper-slide class="my-slide-img" :key="item.id" v-for="item in slideList">
            <img :src="item.url" alt=""/>
          </swiper-slide>
          <div class="swiper-pagination" slot="pagination"></div>
        </swiper>
      </div>
      <!--广告位-->
      <div class="ads-box">
        <a href="javascript:;" v-for="item in adsList" :key="item.id">
          <img :src="item.url" alt=""/>
        </a>
      </div>
      <!--商品-->
      <el-menu
        class="el-menu-demo my-container"
        mode="horizontal"
        background-color="#f0f0f0"
        text-color="#242f42"
        router>
        <el-menu-item>更多商品>>></el-menu-item>
      </el-menu>
      <div class="product-box">
        <div class="banner-top"></div>
        <div class="list-box">
          <el-row>
            <el-col :span="6" class="item" v-for="item in commodityList" :key="item.id">
              <div class="item-img">
                <img :src="item.url" alt=""/>
              </div>
              <div class="item-info">
                <h5>{{ item.name }}</h5>
                <p>{{ item.price }}<i class="el-icon-shopping-cart-1"/></p>
              </div>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import 'swiper/dist/css/swiper.css'
import { swiper, swiperSlide } from 'vue-awesome-swiper'
import { findCategoryList } from '@/api/commodity/category'
import { findCommodityList } from '@/api/commodity'

export default {
  name: 'Index',
  components: {
    swiper,
    swiperSlide
  },
  data () {
    return {
      // 分类
      categoryList: [
        {
          id: 0,
          name: '手办',
          status: true
        }
      ],
      categoryAO: {
        status: true,
        name: '',
        pageNum: 1,
        pageSize: 6
      },
      // 商品
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
        categoryId: '',
        status: true,
        pageNum: 1,
        pageSize: 12
      },
      // 轮播图
      swiperOptions: {
        autoplay: true,
        loop: true,
        effect: 'cube',
        cubeEffect: {
          shadow: false,
          shadowOffset: 100,
          shadowScale: 0.6
        },
        pagination: {
          el: '.swiper-pagination',
          clickable: true
        }
      },
      slideList: [
        {
          id: 1,
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        },
        {
          id: 2,
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        },
        {
          id: 3,
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        },
        {
          id: 4,
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        }
      ],
      // 广告位
      adsList: [
        {
          id: 1,
          name: 'name-1',
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        },
        {
          id: 2,
          name: 'name-2',
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        },
        {
          id: 3,
          name: 'name-3',
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        },
        {
          id: 4,
          name: 'name-5',
          url: 'http://pili-shop.schblog.cn/FkcGx2bLMOP4szHZoCLx6D0fM_1w'
        }
      ]
    }
  },
  created () {
    this.handlerInit()
  },
  methods: {
    // 初始化数据
    handlerInit () {
      this.findCategoryList()
      this.findCommodityList()
    },
    // 获取分类
    findCategoryList () {
      findCategoryList(this.categoryAO).then(res => {
        this.categoryList = res.list
        console.log(this.categoryList)
      })
    },
    // 获取商品
    findCommodityList () {
      findCommodityList(this.commodityAO).then(res => {
        this.commodityList = res.list
      })
    },
    // 获取轮播图
    handlerSwiperImage () {

    },
    // 获取分类信息
    handlerGetCategory () {

    }
  }
}
</script>

<style lang="scss">
  @import "../assets/css/base";

  .index {
    /*margin-top: 15px;*/
    .swiper-box {
      .nav-menu {
        position: absolute;
        width: 160px;
        height: 360px;
        z-index: 10;
        background-color: #242f42;

        .el-menu-item {
          height: 60px;
          font-size: 16px;
        }
      }

      .swiper-container {
        margin-left: 160px;
        height: 360px;
        width: 840px;

        img {
          width: 100%;
          height: 100%;
        }
      }
    }

    .ads-box {
      display: flex;
      justify-content: space-between;
      margin-top: 15px;
      margin-bottom: 25px;

      a {
        width: 240px;
        height: 120px;
      }
    }

    .product-box {

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
              margin: 10px 0 10px;
            }

            p {
              font-size: 14px;
              height: 14px;
              line-height: 14px;
              color: #999999;
              i{
                float: right;
              }
            }

          }
        }
      }
    }
  }
</style>
