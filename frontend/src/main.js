// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import axios from 'axios'

import { MainPage, AboutPage, PostPage } from './views'
Vue.use(VueRouter)

Vue.config.productionTip = false
Vue.prototype.$http = axios

const routes = [
  {
    path: '/',
    component: MainPage
  },
  {
    path: '/about',
    component: AboutPage
  },
  {
    path: '/post/:id?',
    component: PostPage
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

new Vue({
  render: h => h(App),
  router // router 추가
}).$mount('#app')
