import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '首页',
    component: Home
  },
  {
    path: '/my',
    name: '我的',
    component: () => import(/* webpackChunkName: "about" */ '../views/My.vue')
  },
  {
    path: '/recharge',
    name: '充值',
    component: () => import(/* webpackChunkName: "about" */ '../views/Recharge.vue')
  },
  {
    path: '/payment',
    name: '水电费',
    component: () => import(/* webpackChunkName: "about" */ '../views/Payment.vue')
  },
  {
    path: '/consume',
    name: '转账',
    component: () => import(/* webpackChunkName: "about" */ '../views/Consume.vue')
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
