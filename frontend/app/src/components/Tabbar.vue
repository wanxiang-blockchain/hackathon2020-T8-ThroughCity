<template>
  <van-tabbar route>
    <van-tabbar-item replace to="/" icon="home-o">园区</van-tabbar-item>
    <van-tabbar-item replace to="/my" icon="user-o">我的</van-tabbar-item>
  </van-tabbar>
</template>
<script>
export default {
  name: 'tabbar',
  data() {
    return {
      active: 'home'
    }
  }
}
</script>
<style lang="stylus" scoped>

</style>