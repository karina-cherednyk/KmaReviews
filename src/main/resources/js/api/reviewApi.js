import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const reviews = Vue.resource('/review{/id}')

export default {
    add: message => reviews.save({}, message),
    page: page => Vue.http.get('/review/page', {params: { page }}),
    getByTeacher : teacher => Vue.http.get('/teacher/'+teacher+'/reviews'),
}
