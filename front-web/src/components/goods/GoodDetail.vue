<template>
  <main>
    <ShopHeader></ShopHeader>
    <div class="good-detail">
      <div class="shop-item-path">
        <el-breadcrumb class="my-container" separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>{{ commodityList[0].categoryName }}</el-breadcrumb-item>
          <el-breadcrumb-item>{{ commodityList[0].name }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </div>
    <div class="my-container">
      <div class="item-detail-show">
        <div class="swiper-box">
          <swiper :options="swiperOptions">
            <swiper-slide :key="index" v-for="(item,index) in commodityList">
              <img :src="item.url" alt=""/>
            </swiper-slide>
            <div class="swiper-pagination" slot="pagination"></div>
            <div class="swiper-button-prev" slot="button-prev"></div>
            <div class="swiper-button-next" slot="button-next"></div>
          </swiper>
        </div>
        <div class="item-detail-right">
          <div class="item-detail-title">
            <p>
              <span class="item-detail-express"></span> {{commodityList[0].name}}</p>
          </div>
          <div class="item-detail-price-row">
            <div class="item-price-row">
              <p>
                <span class="item-price-title">价格</span>
                <span class="item-price">￥{{ commodityList[0].price }}</span>
              </p>
            </div>
          </div>
          <div class="item-select">
            <div class="item-select-title">
              <p>规格</p>
            </div>
            <div class="item-select-box">
              <div class="item-select-column">
                <div class="item-select-img">
                  <img :src="commodityList[0].url" alt="">
                </div>
              </div>
              <div class="item-select-intro">
                <p>{{ commodityList[0].name }}</p>
              </div>
            </div>
          </div>
          <div class="item-select">
            <div class="item-select-title">
              <p>数量</p>
            </div>
              <div class="item-select-column">
                <el-input-number size="small" :min=min :max=max v-model="num"></el-input-number>
              </div>
          </div>
          <div class="add-buy-car-box">
            <div class="add-buy-car">
              <el-button type="danger" plain>立即购买</el-button>
              <el-button type="warning" icon="el-icon-shopping-cart-1" @click="addGoodToCart">加入购物车</el-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import 'swiper/dist/css/swiper.css'
import { swiper, swiperSlide } from 'vue-awesome-swiper'
import ShopHeader from '~c/common/ShopHeader'
import { addCartItem, findCommodityById } from '@/api/commodity'

export default {
  name: 'GoodDetail',
  props: {
    commodityId: {
      type: [Number, String],
      default: 1
    }
  },
  components: {
    ShopHeader,
    swiper,
    swiperSlide
  },
  data () {
    return {
      // 轮播图
      swiperOptions: {
        autoplay: true,
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev'
        },
        pagination: {
          el: '.swiper-pagination',
          clickable: true
        }
      },
      // 商品详情
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
      num: 1,
      min: 1,
      max: 9999
    }
  },
  created () {
    this.findGoodDetail()
  },
  methods: {
    // 查询商品详情
    findGoodDetail () {
      findCommodityById(this.commodityId).then(res => {
        this.commodityList = res
      })
    },
    // 添加商品到购物车
    addGoodToCart () {
      const addCartAO = {
        commodityId: this.commodityList[0].id,
        number: this.num
      }
      addCartItem(addCartAO).then(res => {
        this.num = 1
      })
    }
  }
}
</script>

<style scoped lang="scss">
  @import "../../assets/css/base";

  .shop-item-path {
    height: 60px;
    line-height: 60px;
    background-color: #f6faff;
    color: #2c2c2c;

    .el-breadcrumb {
      height: 60px;
      line-height: 60px;
    }

    .shop-nav-container {
      margin: 0 auto;
      width: 80%;
    }
  }

  .my-container {
    .item-detail-show {
      margin: 75px auto;
      display: flex;
      flex-direction: row;

      .swiper-box {
        .swiper-container {
          height: 350px;
          width: 350px;

          .swiper-button-next {
            width: 100px;
            height: 100px;
            background: none;
          }

          .swiper-button-prev {
            width: 100px;
            height: 100px;
            background: none;
          }

          img {
            width: 100%;
            height: 100%;
          }
        }
      }
    }

    .item-detail-right {
      width: 600px;
      margin-left: 50px;

      .item-detail-title {
        p {
          color: #666;
          font-size: 20px;
          font-weight: bold;
          text-align: center;
        }
      }

      .item-detail-price-row {
        padding-left: 25px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        background-color: #FFF2E8;

        .item-price-row {
          margin: 5px 0;

          .item-price-title {
            color: #999999;
            font-size: 14px;
            margin-right: 15px;
          }

          .item-price {
            color: #e4393c;
            font-size: 22px;
            font-weight: bold;
            cursor: pointer;
          }
        }
      }

      .item-select {
        display: flex;
        flex-direction: row;
        margin-top: 15px;
        padding-left: 20px;

        .item-select-title {
          color: #999999;
          font-size: 14px;
          margin-right: 15px;
        }
        .item-select-box {
          height: 40px;
          margin-top: 10px;
          display: flex;
          flex-direction: row;
          align-items: center;
          border: #e4393c 2px solid;
          .item-select-column {
            width: 40px;
            height: 40px;
            padding: 5px 0;
            img {
              width: 40px;
              height: 40px;
            }
          }
          .item-select-intro{
            height: 40px;
            line-height: 40px;
            font-size: 12px;
            font-weight: bold;
            text-align: center;
            padding: 0 6px;
          }
        }

      }

      .add-buy-car-box {
        width: 100%;
        margin-top: 15px;
        border-top: 1px dotted #ccc;
        .add-buy-car {
          margin-top: 15px;
          height: 60px;
        }
      }

    }
  }

</style>
