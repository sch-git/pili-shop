import Vue from 'vue'
import VueLazyLoad from 'vue-lazyload'
Vue.use(VueLazyLoad, {
  loading: '../img/loading_img.svg'
})
export default VueLazyLoad
