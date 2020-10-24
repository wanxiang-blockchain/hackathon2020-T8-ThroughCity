<template>
  <div id="app">
    <Navbar />
    <router-view />
    <Tabbar />
  </div>
</template>
<script>
import Navbar from './components/Navbar'
import Tabbar from './components/Tabbar'
export default {
  components: {
    Navbar,
    Tabbar
  }
}
</script>

<style lang="stylus">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  background: #cccccc2e;
  padding-top: 46px;
  padding-bottom: 50px;
  height: 100vh;
  overflow-y: scroll;
}
</style>
