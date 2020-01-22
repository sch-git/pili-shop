const path = require('path')
const resolve = dir => {
  return path.join(__dirname, dir)
}
const BASE_URL = process.env.NODE_ENV === 'production' ? '/pili-shop/admin' : '/'
module.exports = {
  devServer: {
    port: 10080
  },
  lintOnSave: false,
  publicPath: BASE_URL,
  chainWebpack: (config) => {
    config.resolve.alias
      .set('@', resolve('src'))
      .set('_c', resolve('src/components'))
  },
  // 打包时不生成.map文件
  productionSourceMap: false
  /* 跨域代理
    devServer: {
      proxy: 'http://localhost:8080'
    } */
}
