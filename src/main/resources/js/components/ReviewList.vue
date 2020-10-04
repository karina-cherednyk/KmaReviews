<template>
    <v-container>
        <v-layout align-space-around justify-start column>

        <review-row v-for="review in sortedReviews" :key="review.id" :review="review" />
        </v-layout>
    </v-container>
</template>

<script>
    import ReviewRow from "components/ReviewRow.vue";
    import { mapGetters } from 'vuex'

    export default {
        name: "ReviewList",
        components: {ReviewRow},
        computed: mapGetters(['sortedReviews'])
    }
</script>

<style scoped>

</style>
