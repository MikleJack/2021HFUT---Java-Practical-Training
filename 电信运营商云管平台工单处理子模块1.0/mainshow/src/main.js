// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from "axios";
import VueCookies from 'vue-cookies'
import store from './store/store.js'
import qs from 'qs'


Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueCookies)
Vue.$cookies.config('1d')

Vue.prototype.$qs = qs

Vue.prototype.$axios = axios;
axios.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

axios.defaults.transformRequest = [function (data) {
  let ret = ''
  for (let it in data) {
    ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
  }
  return ret
}]

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  qs,
  components: { App },
  template: '<App/>'
})
