<template>
  <div class="shop-box">
    <div class="my-container shop-container">
      <div class="shop-title">
        <div class="shop-title-icon">
          <i class="el-icon-shopping-bag-1"></i>
          <i class="fa fa-fire"></i>
        </div>
        <div class="shop-title-content">
          <p><a>{{ shopIntro.shopName }}</a></p>
          <p><a>{{ shopIntro.slogen }}</a></p>
        </div>
      </div>
      <div class="shop-another-item">
        <div class="shop-another-item-detail" v-for="(item, index) in shopIntro.showGoods" :key="index">
          <div class="shop-another-item-img">
            <img :src="item.img" alt="">
          </div>
          <div class="shop-anoter-item-intro">
            <p>{{ item.intro[0] }}</p>
            <p>{{ item.intro[1] }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ShopHeader',
  data () {
    return {
      shopIntro: {
        shopName: 'PILI-SHOP',
        slogen: 'The Best Thing For You',
        showGoods: [
          {
            img: '/img/header/素还真.png',
            intro: ['清香白莲', '素还真']
          },
          {
            img: '/img/header/一页书.png',
            intro: ['百世经纶', '一页书']
          },
          {
            img: '/img/header/叶小钗.png',
            intro: ['刀狂剑痴', '叶小钗']
          }
        ]
      }
    }
  }
}
</script>

<style scoped lang="scss">
  @import "../../assets/css/base";
  /* 店铺介绍 */
  .shop-box {
    width: 100%;
    height: 120px;
    background-color: #1b1b1b;
  }

  .shop-container {
    height: 100%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    color: #fff;
  }

  .shop-title {
    display: flex;
    flex-direction: row;
  }

  .shop-title-icon {
    font-size: 46px;
  }

  .shop-title-content {
    margin-left: 15px;
  }

  .shop-title-content p {
    line-height: 28px;
    font-size: 20px;
  }

  .shop-title-content a {
    color: #fff;
  }

  .shop-another-item {
    display: flex;
    flex-direction: row;
  }

  .shop-another-item-detail {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin-left: 15px;
  }

  .shop-another-item-img {
    background-color: #f0f0f0;
    height: 80px;
    border-radius: 40px;
    overflow: hidden;
  }

  .shop-another-item-img img {
    width: 80px;
  }

  .shop-anoter-item-intro {
    margin-left: 15px;
    line-height: normal;
  }
</style>
