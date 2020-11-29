<template>
    <b-container>
        <review-form  class="mb-4"/>
        <problems-form/>
    </b-container>
</template>

<script>
    import ReviewForm from "components/ReviewForm.vue";
    import ProblemsForm from "components/ProblemsForm.vue";

    export default {
        name: "InputForm",
        components: {ProblemsForm, ReviewForm}
    }
</script>

<style scoped>

</style>
