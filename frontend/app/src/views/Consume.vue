<template>
  <div class="card-wrapper">
    <van-form @submit="onSubmit">
      <van-field readonly clickable name="picker" :value="value" label="接收方" placeholder="点击选择接收方" @click="showPicker = true" />
      <van-popup v-model="showPicker" position="bottom">
        <van-picker show-toolbar :columns="columns" @confirm="onConfirm" @cancel="showPicker = false" />
      </van-popup>
      <van-field v-model="token" name="token" label="积分" placeholder="请输入token数量" />
      <div style="margin: 16px">
        <van-button round block type="info" native-type="submit"> 确认转账 </van-button>
      </div>
    </van-form>
  </div>
</template>
<script>
import { getActivity } from '../api/getData'
export default {
  name: '',
  data() {
    return {
      token: 0,
      showPicker: false
    }
  },
  mounted() {},
  methods: {
    onSubmit() {}
  }
}
</script>
<style lang="stylus" scoped></style>