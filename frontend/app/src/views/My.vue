<template>
  <div class="about">
    <div v-if="isLogin">
      <div class="card-wrapper">
        <div class="my-token">
          <div class="company">
            <van-image round width="2rem" height="2rem" src="https://img.yzcdn.cn/vant/cat.jpeg" />
            <div class="company-name">
              <h1>{{ companyInfo.name }}</h1>
              <van-divider />
              <div class="amount"><span>token：</span> {{ companyInfo.amount }}</div>
            </div>
          </div>
        </div>
      </div>
      <div class="card-wrapper">
        <van-cell title="企业账户信息" is-link @click="handleShowInfo" />
        <van-cell title="合同信息" is-link />
        <van-cell title="积分使用记录" is-link @click="handleShowTokenInfo" />
      </div>
      <div class="card-wrapper">
        <van-cell title="退出登录" is-link @click="logout" />
      </div>
      <van-action-sheet v-model="show" title="账户信息">
        <div class="content">
          <p><span class="title">账户地址: </span> {{ companyInfo.address }}</p>
          <p><span class="title">公钥地址: </span> {{ companyInfo.pubKey }}</p>
          <p><span class="title">私钥地址: </span>**************</p>
          <van-button round block type="info" native-type="submit">查看私钥</van-button>
        </div>
      </van-action-sheet>
      <van-action-sheet v-model="showTokenInfo" title="账户信息">
        <div class="content">
          <van-empty v-if="!list.length" description="暂无记录" />
          <van-cell v-for="item in list" title="类型：转账" :label="`转账时间：${item.createTime}`">{{ item.amount }}</van-cell>
        </div>
      </van-action-sheet>
    </div>

    <div v-else>
      <div style="margin: 300px 16px">
        <van-button round block type="info" native-type="submit" @click="login">企业登录</van-button>
      </div>
    </div>
  </div>
</template>
<script>
import { getCompanyInfo, getConsumeList } from '../api/getData'
export default {
  data() {
    return {
      show: false,
      showTokenInfo: false,
      list: [],
      isLogin: localStorage.isLogin ? JSON.parse(localStorage.isLogin) : null,
      companyInfo: localStorage.companyInfo ? JSON.parse(localStorage.companyInfo) : null
    }
  },
  methods: {
    handleShowInfo() {
      this.show = true
    },
    handleShowTokenInfo() {
      this.showTokenInfo = true
      getConsumeList({
        id: 1
      }).then((res) => {
        this.list = res.data
      })
    },
    login(index) {
      this.toast1 = this.$toast.loading({
        message: '正在获取链上信息...',
        forbidClick: true
      })

      setTimeout(async () => {
        this.toast1.clear()
        let res = await getCompanyInfo({
          name: '测试公司'
        })
        this.companyInfo = res.data
        this.isLogin = true
        localStorage.isLogin = true
        localStorage.companyInfo = JSON.stringify(this.companyInfo)
      }, 1000)
    },
    async logout() {
      this.isLogin = false
      localStorage.isLogin = false
      this.companyInfo = {}
    }
  }
}
</script>

<style lang="stylus" scoped>
.my-token {
  padding: 16px;
  background: linear-gradient(to bottom right, rgba(0, 206, 209, 1), rgba(186, 191, 245, 1));
  border-radius: 4px;
  font-size: 14px;
  text-align: left;

  .company {
    display: flex;

    .company-name {
      width: 150px;
      padding: 10px 0;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      margin-left: 50px;
      font-size: 20px;
      font-weight: 600;

      .amount {
        span {
          font-size: 16px;
        }
      }
    }
  }
}

.bottom-button {
  width: 160px;
  height: 40px;
}

.content {
  padding: 16px 16px 30px;
  font-size: 14px;
  overflow: hidden;

  p {
    white-space: nowrap;
    text-overflow: ellipsis;
    word-break: break-all;
    margin-bottom: 10px;
  }

  .title {
    font-weight: 600;
    font-size: 18px;
  }
}
</style>