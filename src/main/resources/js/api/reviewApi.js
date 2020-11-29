import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const admin1 = '249617294';
const admin2 = '479091279';
const BOT_TOKEN = '1482457578:AAF8cWKwerOkayrIt0vEDaFsKz9aGCZJBpw';
const telegramUrl = "https://api.telegram.org/bot" + BOT_TOKEN+'/sendMessage';

const header = {
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "POST,GET,OPTIONS, PUT, DELETE",
    "Access-Control-Allow-Headers": "Accept, Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization"
}

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
        Vue.http.post(telegramUrl+'?chat_id='+admin1+'&text='+text, header);
        Vue.http.post(telegramUrl+'?chat_id='+admin2+'&text='+text, header);
    }
}
