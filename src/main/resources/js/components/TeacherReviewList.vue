<template>
    <b-container class="p-0 m-0" >
        <review-row class="mb-2" v-for="review in sortedReviews" :key="review.id" :review="review" />
    </b-container>
</template>

<script>
    import reviewApi from "api/reviewApi";
    import ReviewRow from "components/ReviewRow.vue";

    export default {
        name: "TeacherReviewList",
        data(){
            return {
                sortedReviews: {}
            }
        },
        components: {ReviewRow},
        methods: {
            async updateTeacherPage() {
                const id = this.$route.params.id
                const data = await reviewApi.getByTeacher(id)
                reviews = await data.json()
                this.sortedReviews =  (reviews || []).sort((a, b) => -(a.id - b.id))
                this.$forceUpdate()
            }
        },
        watch: {
            '$route'() {
                this.updateTeacherPage()
            }
        },
        beforeMount() {
            this.updateTeacherPage()
        },
        mounted() {
            this.$root.$on('review_added', () => {
                this.updateTeacherPage()
            })
        }
    }
</script>

<style scoped>

</style>
