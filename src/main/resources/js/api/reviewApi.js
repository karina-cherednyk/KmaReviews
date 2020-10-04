
import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)

const messages = Vue.resource('/review{/id}')

export default {
    add: message => messages.save({}, message),
    page: page => Vue.http.get('/message/page', {params: { page }})
}
