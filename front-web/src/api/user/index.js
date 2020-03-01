import axios from '@/api/index'

/**
 * @description 登录接口
 * @param loginAO 登录信息
 */
export const login = (loginAO) => {
  return axios.post('/login', loginAO)
}
