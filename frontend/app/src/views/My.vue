<template>
  <div class="about">
    <div class="card-wrapper">
      <div class="my-token" v-if="isLogin">
        <div class="company">
          <van-image round width="2rem" height="2rem" src="https://img.yzcdn.cn/vant/cat.jpeg" />
          <span class="company-name">{{companyInfo.name}}</span>
        </div>
        <van-divider />
        <div>
          <h1>token余额</h1>
          <h2>{{ companyInfo.amount }}</h2>
        </div>
        <p>账户地址: {{ companyInfo.address }}</p>
        <p>pubKey: {{ companyInfo.pubKey }}</p>
      </div>
      <div v-else>
        <div style="margin: 16px">
          <van-button round block type="info" native-type="submit" @click="login">企业登录</van-button>
        </div>
      </div>
    </div>

    <div class="card-wrapper">
      <van-cell title="企业信息" is-link />
      <van-cell title="积分使用记录" is-link />
    </div>
    <div class="card-wrapper">
      <van-cell title="退出登录" is-link @click="logout" />
    </div>
  </div>
</template>
<script>
import { getCompanyInfo } from '../api/getData'
export default {
  data() {
    return {
      isLogin: localStorage.isLogin ? JSON.parse(localStorage.isLogin) : null,
      companyInfo: localStorage.companyInfo ? JSON.parse(localStorage.companyInfo) : null
    }
  },
  methods: {
    async login(index) {
      let res = await getCompanyInfo({
        name: '测试公司'
      })
      this.companyInfo = res.data
      this.isLogin = true
      localStorage.isLogin = true
      localStorage.companyInfo = JSON.stringify(this.companyInfo)
    },
    async logout() {
      this.isLogin = false
      localStorage.isLogin = false
    }
  }
}
</script>

<style>
.my-token {
  padding: 16px;
  background: linear-gradient(to bottom right, rgba(0, 206, 209, 1), rgba(186, 191, 245, 1));
  border-radius: 4px;
  font-size: 14px;
  text-align: left;
}
.bottom-button {
  width: 160px;
  height: 40px;
}
</style>