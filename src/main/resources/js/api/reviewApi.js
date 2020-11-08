import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)

export default {
    add: message => Vue.http.post("/review", message),
    page: page => Vue.http.get("/review/pageable", {params: {page: page}}),
    getByTeacher : teacher_id =>
        Vue.http.get('/review/all', {params: {teacher_id:teacher_id} })
    ,
}
