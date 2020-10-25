<template>
  <div class="nav-bar">
    <van-nav-bar title="虹口科技产业园" :left-arrow="leftArrow" @click-left="onClickLeft" @click-right="onClickRight" />
  </div>
</template>
<script>
export default {
  name: 'tabbar',
  data() {
    return {}
  },
  computed: {
    title() {
      return this.$route.name
    },
    leftArrow() {
      if (this.$route.path === '/' || this.$route.path === '/vicinity' || this.$route.path === '/coupon' || this.$route.path === '/my') return false
      return true
    }
  },
  methods: {
    onClickLeft() {
      this.$router.go(-1)
    },
    onClickRight() {}
  }
}
</script>
<style lang="stylus" scoped>
.nav-bar {
  width 100%
  position: fixed;
  top: 0;
  z-index 9999
}
</style>