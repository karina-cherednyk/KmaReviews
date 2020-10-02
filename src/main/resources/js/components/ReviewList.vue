<template>
    <v-container>
        <v-layout align-space-around justify-start column>

        <review-row v-for="review in reviews" :key="review.id" :review="review" />
        </v-layout>
    </v-container>
</template>

<script>
    import ReviewRow from "components/ReviewRow.vue";

    export default {
        name: "ReviewList",
        props: ["reviews"],
        components: {ReviewRow}
    }
</script>

<style scoped>

</style>
