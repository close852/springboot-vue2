import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

const HelloWorld2 = { template: '<div>bar</div>' }
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'HelloWorld2',
      component: HelloWorld2
    }
  ]
})
