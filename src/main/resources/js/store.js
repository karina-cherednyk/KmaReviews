import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import reviewApi from "api/reviewApi";


export default new Vuex.Store({
    state: {
        teachers, reviews:[], totalPages, currentPage, faculties, facId: null, tId:null
    },
    getters: {
        sortedReviews: state => (state.reviews || []).sort((a, b) => -(a.id - b.id)),
        sortedTeachers: state => (state.teachers || []).sort((a, b) => (a.name - b.name)),
        teachersOptions: state => state.teachers.reduce((acc, x) => [...acc,{text: x.name, value: x}] , [{text: 'Оберіть викладача', value:null}]),
        facultyOptions: state => state.faculties.reduce((acc, x) => [...acc,{text: x.name, value: x}] , [{text: 'Оберіть факультет', value:null}]),

    },
    mutations: {
        addReviewMutation(state, review) {
            state.reviews = [
                review,
                ...state.reviews

            ]
        },
        resetPage(state){
            state.reviews = []
            state.totalPages = 0
            state.currentPage = -1
        },
        addReviewPageMutation(state, reviews) {
            const  targetReviews = state.reviews.concat(reviews)
            state.reviews = []
            let d = {}
            for(let r of targetReviews) {
                if (!(r.id in d)) {
                    state.reviews.push(r);
                    d[r.id] = 1
                }
            }

        },
    },
    actions: {
        async addReviewAction({commit, state}, review) {
            let result = await reviewApi.add(review)
            const data = await result.json()
            console.log(data)
            let notAdd =  state.tId && data.teacher.id != state.tId || state.facId && state.facId != data.teacher.faculty.id
            if(!notAdd ) commit('addReviewMutation', data)
        }
        ,
        async loadPageAction({commit, state}, {teacher_id, faculty_id} ) {
            let response;
            if(teacher_id ) response = await reviewApi.getByTeacher(teacher_id, state.currentPage + 1)
            else if(faculty_id) response = await reviewApi.getByFaculty(faculty_id, state.currentPage + 1)
            else response = await reviewApi.page(state.currentPage + 1)
            const data = await response.json()
            state.facId = faculty_id
            state.tId = teacher_id

            state.totalPages =  data.totalPages
            state.currentPage =  Math.min(data.currentPage, data.totalPages - 1)
            commit('addReviewPageMutation', data.reviews)

        },

    }
})
