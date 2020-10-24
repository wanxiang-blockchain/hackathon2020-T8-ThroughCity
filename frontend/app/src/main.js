import 'amfe-flexible'
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vant from 'vant'
import './assets/styles/reset.css'
import 'vant/lib/index.css'
import './assets/styles/base.css'


Vue.use(Vant)

Vue.config.productionTip = false

new Vue({
  router,
  render: (h) => h(App)
}).$mount('#app')
