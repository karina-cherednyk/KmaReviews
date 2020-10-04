import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import reviewApi from "api/reviewApi";


export default new Vuex.Store({
    state: {
        reviews, totalPages, currentPage
    },
    getters: {
        sortedReviews: state => (state.reviews || []).sort((a, b) => -(a.id - b.id))
    },
    mutations: {
        addReviewMutation(state, review) {
            state.reviews = [
                ...state.reviews,
                review
            ]
        },
        addReviewPageMutation(state, reviews) {
            const targetReviews = state.reviews
                .concat(reviews)
                .reduce((res, val) => {
                    res[val.id] = val
                    return res
                }, {})

            state.reviews = Object.values(targetReviews)
        },
        updateTotalPagesMutation(state, totalPages) {
            state.totalPages = totalPages
        },
        updateCurrentPageMutation(state, currentPage) {
            state.currentPage = currentPage
        }
    },
    actions: {
        async addReviewAction({commit, state}, review) {
            const result = await reviewApi.add(review)
            const data = await result.json()
            commit('addReviewMutation', data)
        },
        async loadPageAction({commit, state}) {
            const response = await reviewApi.page(state.currentPage + 1)
            const data = await response.json()

            commit('addReviewPageMutation', data.reviews)
            commit('updateTotalPagesMutation', data.totalPages)
            commit('updateCurrentPageMutation', Math.min(data.currentPage, data.totalPages - 1))
        }
    }
})
