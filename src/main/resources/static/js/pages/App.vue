<template>
    <v-app>
    <review-form :reviews="reviews"  />
    <review-list :reviews="reviews" />
    </v-app>
</template>

<script>
    import ReviewForm from "components/ReviewForm.vue";
    import ReviewList from "components/ReviewList.vue";
    import  Vue from 'vue'
    import VueResource from 'vue-resource'
    Vue.use(VueResource)
    var reviewApi = Vue.resource('/review{/id}');

    export default {
        name: "App",
        components: {ReviewList, ReviewForm},
        data(){
            return{
                reviews: []
            }
        },

        created: function() {
            reviewApi.get().then(result =>
                result.json().then(data =>
                    data.forEach(review => this.reviews.push(review))
                ))
        }

    }
</script>

<style scoped>

</style>
