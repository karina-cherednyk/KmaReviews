<template>
    <v-app>
    <review-form  />
    <review-list />
    </v-app>
</template>

<script>
    import ReviewForm from "components/ReviewForm.vue";
    import ReviewList from "components/ReviewList.vue";

    export default {
        name: "App",
        components: {ReviewList, ReviewForm},
    }
</script>

<style scoped>

</style>
