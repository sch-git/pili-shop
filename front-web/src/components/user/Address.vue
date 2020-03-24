<template>
  <main class="my-address">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 我的设置
        </el-breadcrumb-item>
        <el-breadcrumb-item>我的地址</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <!--地址列表-->
      <div class="address-list">
        <div v-if="!defaultAddress">
          <h2>您的地址栏空空如也
            <el-button @click="dialogVisible=true"
                       type="text">新增地址
            </el-button>
          </h2>
        </div>
        <el-card v-else class="box-card" :class="defaultAddress===address.detailedAddress?'default-address':''"
                 shadow="never"
                 v-for="(address,index) in addressList" :key="index">
          <div slot="header">
            <span class="address-name">{{address.receiveName}}</span>
            <span class="address-phone">{{address.phone}}</span>
          </div>
          <div class="item">
            <span>{{address.province}}</span>
            <span>{{address.city}}</span>
            <span>{{address.district}}</span>
            <span>{{address.detailedAddress}}</span>
          </div>
          <div class="item">
            <el-button class="option-delete" type="text" icon="el-icon-delete"></el-button>
            <el-button type="text" @click="this.form=address,dialogVisible=true"
                       icon="el-icon-edit-outline"></el-button>
            <el-button class="option-add" @click="addAddressDialog" type="text"
                       icon="el-icon-circle-plus-outline"></el-button>
            <el-switch
              class="option-default"
              :value="defaultAddress===address.detailedAddress"
              :disabled="defaultAddress===address.detailedAddress"
              @change="changeDefaultAddress(address)"
              active-color="#13ce66">
            </el-switch>
            <span class="option-default">默认地址</span>
          </div>
        </el-card>
      </div>
    </div>
    <!--新增地址-->
    <el-dialog title="收货地址" :visible.sync="dialogVisible" width="45%">
      <el-form :model="form" :rules="rules" ref='form'>
        <el-form-item label="收货人" :label-width="formLabelWidth" prop="receiveName">
          <el-input v-model="form.receiveName"></el-input>
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="所在地区" :label-width="formLabelWidth">
          <el-select class="form-address" v-model="form.province" placeholder="省份">
            <el-option
              v-for="item in provinceList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
          <el-select class="form-address" v-model="form.city" placeholder="城市">
            <el-option
              v-for="item in cityList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
          <el-select class="form-address" v-model="form.district" placeholder="区域">
            <el-option
              v-for="item in countryList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="详细地址" :label-width="formLabelWidth" prop="detailedAddress">
          <el-input v-model="form.detailedAddress"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false ,resetForm('form')">取 消</el-button>
        <el-button type="primary" @click="submitForm('form'),dialogVisible=false">确 定</el-button>
      </div>
    </el-dialog>
  </main>
</template>

<script>
import provinceList from '@/assets/data/province'
import provinceObjList from '@/assets/data/province_object'
import cityList from '@/assets/data/city'
import cityObjList from '@/assets/data/city_object'
import countryList from '@/assets/data/county'
import countryObjList from '@/assets/data/county_object'
import { checkDetailedAddress, checkPhone, checkReceiveName } from '@/lib/rule/Address'
import { addAddress, findAddressList, findDefaultAddress } from '@/api/user/address'

export default {
  name: 'Address',
  data () {
    return {
      // 导入省市区数据
      provinceList: provinceList,
      // 地址列表
      addressList: [
        // {
        // receiveName: '收货人姓名X',
        // phone: '12374589655',
        // province: 'XX省',
        // city: 'XX市',
        // district: 'XX区',
        // detailedAddress: '详细地址'
        // }
      ],
      // 新增地址dialog
      dialogVisible: false,
      formLabelWidth: '120px',
      form: {
        receiveName: '',
        phone: '',
        province: '',
        city: '',
        district: '',
        detailedAddress: ''
      },
      // 校检规则
      rules: {
        receiveName: [
          {
            validator: checkReceiveName,
            trigger: 'blur'
          }
        ],
        phone: [
          {
            validator: checkPhone,
            trigger: 'blur'
          }
        ],
        detailedAddress: [
          {
            validator: checkDetailedAddress,
            trigger: 'blur'
          }
        ]
      },
      // 默认地址
      defaultAddress: ''
    }
  },
  created () {
    this.handleInit()
  },
  computed: {
    userInfo () {
      return this.$store.state.userInfo
    },
    cityList () {
      return cityList[this.form.province]
    },
    countryList () {
      return countryList[this.form.city]
    }
  },
  methods: {
    // 初始化
    handleInit () {
      this.handleFindAddressList()
      this.handleFindDefaultAddress()
    },
    // 获取用户地址列表
    handleFindAddressList () {
      findAddressList().then(res => {
        res.forEach(item => {
          item.province = provinceObjList[item.province].name
          item.city = cityObjList[item.city].name
          item.district = countryObjList[item.district].name
          this.addressList.push(item)
        })
      })
    },
    // 获取用户默认地址
    handleFindDefaultAddress () {
      findDefaultAddress().then(res => {
        this.defaultAddress = res
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          addAddress(this.form).then(res => {
            this.defaultAddress = res
            this.form.id = this.addressList[this.addressList.length - 1].id + 1
            this.addressList.push(this.form)
          })
        } else {
          this.$message.error('请填写完整信息')
          return false
        }
      })
    },
    // todo 修改默认地址
    changeDefaultAddress (address) {
      console.log(address.id, address.detailedAddress)
      this.defaultAddress = address.detailedAddress
    },
    addAddressDialog () {
      this.dialogVisible = true
      this.$nextTick(() => {
        // 打开新增弹窗前先重置表单 避免表单出现上一次新增的校验数据
        this.$refs.form.resetFields()
      })
    }
  }
}
</script>

<style scoped lang="scss">
  .my-address {
    background-color: #f0f0f0;

    .container {
      padding: 0;
      margin: 0;
      background-color: #f0f0f0;
      border: 0;

      .address-list {
        .box-card {
          width: 100%;
          margin-top: 20px;

          .address-name {
            font-weight: bold;
          }

          .address-phone {
            margin-left: 35px;
            font-weight: bold;
          }

          .item {
            span {
              margin-right: 15px;
            }

            button {
              padding: 0;
              font-size: 18px;
            }

            .option-delete {
              color: #e4393c;
            }

            .option-add {
              color: limegreen;
            }

            .option-default {
              float: right;
            }
          }
        }
      }
    }

    .form-address {
      width: 150px;
      margin-right: 20px;
    }
  }
</style>
<style lang="scss">
  .my-address {
    .address-list {
      .default-address {
        border: 2px solid #13ce66 !important;
      }

      .el-card {
        background-color: #f0f0f0;
        border: 2px solid #cccccc;
        line-height: 30px;

        .el-card__header {
          border-bottom: 0;
          padding: 5px 25px 0 25px;
        }

        .el-card__body {
          padding: 2px 25px 7px 25px;
        }

        .el-switch {
          height: 30px;
        }
      }
    }
  }
</style>
