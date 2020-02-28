const path = require('path')
const resolve = dir => {
  return path.join(__dirname, dir)
}
const BASE_URL = process.env.NODE_ENV === 'production' ? '/pili-shop/' : '/'
module.exports = {
  devServer: {
    port: 10090,
    proxy: 'http://localhost:8099'
  },
  lintOnSave: false,
  publicPath: BASE_URL,
  chainWebpack: (config) => {
    config.resolve.alias
      .set('@', resolve('src'))
      .set('~c', resolve('src/components'))
  },
  // 打包时不生成.map文件
  productionSourceMap: false
}
