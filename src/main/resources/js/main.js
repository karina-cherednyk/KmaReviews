import Vue from 'vue'
import Vuex from 'vuex'
import App from "pages/App.vue"
import '@babel/polyfill'
import  store from 'store'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(Vuex)


new Vue({
    store: store,
    render: a => a(App)
}).$mount('#app')


