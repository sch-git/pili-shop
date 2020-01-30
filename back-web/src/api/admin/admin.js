import axios from '@/api/index'

export const login = (loginAO) => {
  return axios.post('/login', loginAO)
}
