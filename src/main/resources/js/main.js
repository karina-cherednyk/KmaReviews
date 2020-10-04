import Vue from 'vue'
import Vuetify from 'vuetify'
import App from "pages/App.vue"
import '@babel/polyfill'
//import router from 'router/router'
import store from 'store'

import 'vuetify/dist/vuetify.min.css'

Vue.use(Vuetify)

new Vue({
    el: "#app",
    store,
    //router,
    vuetify: new Vuetify(),
    render: a => a(App)
})


