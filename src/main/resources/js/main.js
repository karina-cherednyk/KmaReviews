import Vue from 'vue'
import Vuex from 'vuex'
import App from "pages/App.vue"
import '@babel/polyfill'
import  store from 'store'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueRouter from "vue-router";


import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import ReviewList from "components/ReviewList.vue";


Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(Vuex)
Vue.use(VueRouter)

const router = new VueRouter( {
    routes: [
    { path: '/', component: ReviewList },
    { path: '/teacher/:teacher_id', component: ReviewList },
    { path: '/faculty/:faculty_id', component: ReviewList },

    ]
})


new Vue({
    store: store,
    render: a => a(App),
    router: router ,
}).$mount('#app')


