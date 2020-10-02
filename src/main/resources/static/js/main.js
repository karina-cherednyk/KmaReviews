import Vue from 'vue'
import Vuetify from 'vuetify'
import App from "pages/App.vue"
import 'vuetify/dist/vuetify.min.css'

Vue.use(Vuetify)

new Vue({
    el: "#app",
    vuetify: new Vuetify(),
    render: a => a(App)
})


