<template>
    <b-container class="p-0 m-0" >
        <review-row class="mb-2" v-for="review in reviews" :key="review.id" :review="review" />
        <lazy-loader></lazy-loader>
    </b-container>
</template>

<script>
    import ReviewRow from "components/ReviewRow.vue";
    import LazyLoader from "components/LazyLoader.vue";
    import { mapMutations, mapState, mapActions } from 'vuex'

    export default {
        name: "ReviewList",
        components: {ReviewRow, LazyLoader},
        methods: { ...mapMutations(['resetPage']), ...mapActions(['loadPageAction']) },
        watch: {
            '$route'() {
                this.resetPage()
                this.loadPageAction({teacher_id: this.teacher_id, faculty_id: this.faculty_id} )
            }
        },
        computed: {
            ...mapState(['reviews']),
            teacher_id() { return this.$route.params.teacher_id} ,
            faculty_id() { return this.$route.params.faculty_id}

        },
        async mounted() {
            this.resetPage()
            await this.loadPageAction({teacher_id: this.teacher_id, faculty_id: this.faculty_id})
            this.loadPageAction({teacher_id: this.teacher_id, faculty_id: this.faculty_id})
        }
    }
</script>

<style scoped>

</style>
