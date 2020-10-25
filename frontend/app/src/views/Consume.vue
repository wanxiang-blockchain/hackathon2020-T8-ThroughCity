<template>
  <div class="card-wrapper">
    <van-form @submit="onSubmit">
      <van-field readonly clickable name="picker" :value="reciver" label="接收方" placeholder="点击选择接收方" @click="showPicker = true" />
      <van-popup v-model="showPicker" position="bottom">
        <van-picker show-toolbar :columns="companyNameList" @confirm="onConfirm" @cancel="showPicker = false" />
      </van-popup>
      <van-field v-model="token" name="token" label="积分" placeholder="请输入token数量" />
      <div style="margin: 16px">
        <van-button round block type="info" native-type="submit"> 确认转账 </van-button>
      </div>
    </van-form>
  </div>
</template>
<script>
import { getCompanyList, consume } from '../api/getData'
export default {
  name: '',
  data() {
    return {
      token: 0,
      showPicker: false,
      reciver: null,
      reciverId: null,
      companyList: [],
      columns: []
    }
  },
  computed: {
    companyNameList() {
      return this.companyList.map((item) => item.name)
    }
  },
  async mounted() {
    let res = await getCompanyList()
    this.companyList = res.data
  },
  methods: {
    async onSubmit() {
      let res = await consume({
        fromCompanyId: JSON.parse(localStorage.companyInfo).id,
        toCompanyId: this.reciverId,
        amount: this.token
      })
      this.$toast.success('积分转账成功')
    },
    onConfirm(val) {
      this.reciver = val
      this.companyList.forEach((item) => {
        if (item.name === val) this.reciverId = item.id
      })
      this.showPicker = false
    }
  }
}
</script>
<style lang="stylus" scoped></style>