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
        <div v-if="defaultAddressId===0">
          <h2>您的地址栏空空如也
            <el-button @click="dialogVisible=true"
                       type="text">新增地址
            </el-button>
          </h2>
        </div>
        <el-card v-else class="box-card" :class="defaultAddressId===address.id?'default-address':''"
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
            <!--删除按钮-->
            <el-button class="option-delete" type="text" icon="el-icon-delete" :disabled="defaultAddressId===address.id"
                       @click="deleteAddress(index,address)"></el-button>
            <!--编辑按钮-->
            <el-button type="text" @click="updateAddressDialog(index,address)"
                       icon="el-icon-edit-outline"></el-button>
            <!--添加按钮-->
            <el-button class="option-add" @click="addAddressDialog" type="text"
                       icon="el-icon-circle-plus-outline"></el-button>
            <!--选择默认地址-->
            <el-switch
              class="option-default"
              :value="defaultAddressId===address.id"
              :disabled="defaultAddressId===address.id"
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
          <el-select class="form-address" v-model="form.province" placeholder="省份" @change="changeProvince">
            <el-option
              v-for="item in provinceList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
          <el-select class="form-address" v-model="form.city" placeholder="城市" @change="changeCity">
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
        <el-button @click="resetForm('form')">取 消</el-button>
        <el-button type="primary" @click="submitForm('form')">确 定</el-button>
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
import { addAddress, deleteAddress, findAddressList, findDefaultAddress, updateAddress, updateDefaultAddress } from '@/api/user/address'
import { MessageBoxConfirm } from '@/lib/tools'

export default {
  name: 'Address',
  data () {
    return {
      // 判断提交表单时是修改地址还是新增地址(true:新增,false:修改)
      addressFlag: true,
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
      // 保留地址代码的地址列表
      codeAddressList: [],
      // 新增地址dialog
      dialogVisible: false,
      formLabelWidth: '120px',
      form: {
        id: '',
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
      defaultAddressId: 0
    }
  },
  created () {
    this.handleInit()
  },
  // 计算属性
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
          const itemTemp = { ...item }
          this.codeAddressList.push(itemTemp)
          item = this.codeToName(item)
          this.addressList.push(item)
        })
      })
    },
    // 获取用户默认地址
    handleFindDefaultAddress () {
      findDefaultAddress().then(res => {
        this.defaultAddressId = res.id
      })
    },
    // 后端省市区代码转为前端可视化名称
    codeToName (form) {
      form.province = provinceObjList[form.province].name
      form.city = cityObjList[form.city].name
      form.district = countryObjList[form.district].name
      return form
    },
    // 重置表单
    resetForm (formName) {
      if (!this.addressFlag) {
        this.form = this.codeToName(this.form)
      }
      this.dialogVisible = false
      this.$refs[formName].resetFields()
    },
    // 新增/修改用户地址
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.addressFlag) {
            // 新增地址
            addAddress(this.form).then(res => {
              this.defaultAddressId = res.defaultId
              this.form.id = res.id
              const itemTemp = { ...this.form }
              this.codeAddressList.push(itemTemp)
              this.form = this.codeToName(this.form)
              this.addressList.push(this.form)
              this.dialogVisible = false
            })
          } else {
            // 修改地址
            updateAddress(this.form).then(res => {
              this.form = this.codeToName(this.form)
              this.dialogVisible = false
            })
          }
        } else {
          this.$message.error('请填写完整信息')
          return false
        }
      })
    },
    // 修改默认地址
    changeDefaultAddress (address) {
      this.defaultAddressId = address.id
      updateDefaultAddress({ id: address.id })
    },
    // 添加地址弹窗事件
    addAddressDialog () {
      this.addressFlag = true
      this.dialogVisible = true
      this.cleanForm()
    },
    // 用户删除地址
    deleteAddress (index, address) {
      MessageBoxConfirm('是否确认删除该地址?', '警告').then(flag => {
        if (flag) {
          deleteAddress(address.id)
          this.addressList.splice(index, 1)
          this.codeAddressList.splice(index, 1)
        }
      })
    },
    // 修改地址弹窗事件
    updateAddressDialog (index, address) {
      this.addressFlag = false
      this.form = address
      this.form.province = this.codeAddressList[index].province
      this.form.city = this.codeAddressList[index].city
      this.form.district = this.codeAddressList[index].district
      this.dialogVisible = true
    },
    // 省份变化，判断城市,区域
    changeProvince (newValue) {
      if (!(this.form.city in cityList)) {
        this.form.city = ''
        this.form.district = ''
      }
    },
    // 城市变化，判断区域
    changeCity (newValue) {
      if (!(this.form.district in countryList)) {
        this.form.district = ''
      }
    },
    cleanForm () {
      const formClean = {
        id: '',
        receiveName: '',
        phone: '',
        province: '',
        city: '',
        district: '',
        detailedAddress: ''
      }
      this.form = formClean
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
