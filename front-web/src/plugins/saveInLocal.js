// 持久化插件
export default store => {
  // 刷新浏览器时调用
  if (sessionStorage.state) {
    store.replaceState(JSON.parse(sessionStorage.state))
  }
  // 提交mutation时调用
  store.subscribe((mutation, state) => {
    sessionStorage.state = JSON.stringify(state)
  })
}
