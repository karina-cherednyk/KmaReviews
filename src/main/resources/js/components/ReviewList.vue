<template>
    <b-container class="p-0 m-0" >
        <review-row class="mb-2" v-for="review in sortedReviews" :key="review.id" :review="review" />
        <lazy-loader></lazy-loader>
    </b-container>
</template>

<script>
    import ReviewRow from "components/ReviewRow.vue";
    import LazyLoader from "components/LazyLoader.vue";
    import { mapGetters } from 'vuex'

    export default {
        name: "ReviewList",
        components: {ReviewRow, LazyLoader},
        computed: mapGetters(['sortedReviews'])
    }
</script>

<style scoped>

</style>
