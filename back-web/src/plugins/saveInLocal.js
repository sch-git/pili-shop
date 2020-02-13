// 持久化插件
export default store => {
  // 刷新浏览器时调用
  if (localStorage.state) {
    store.replaceState(JSON.parse(localStorage.state))
  }
  // 提交mutation时调用
  store.subscribe((mutation, state) => {
    localStorage.state = JSON.stringify(state)
  })
}
