import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const admin1 = '249617294';
const admin2 = '479091279';
const BOT_TOKEN = '1482457578:AAF8cWKwerOkayrIt0vEDaFsKz9aGCZJBpw';

export default {
    add: message => Vue.http.post("/review", message),
    page: page => Vue.http.get("/review/pageable", {params: {page: page}}),
    getByTeacher : (teacher_id, page) =>
        Vue.http.get('/review/pageable', {params: {teacher_id:teacher_id, page:page} })
    ,
    getByFaculty  : (faculty_id, page) =>
        Vue.http.get('/review/pageable', {params: {faculty_id:faculty_id, page:page} })
    ,
    sendMessage : (text) => {

    }
}
