<template>
    <b-container id="app" >
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-navbar-nav  class="col-md-6 ml-auto" >
               <teacher-form />
            </b-navbar-nav>
        </b-navbar>
        <review-list/>
    </b-container>
</template>

<script>

    import 'bootstrap/dist/css/bootstrap.css'
    import 'bootstrap-vue/dist/bootstrap-vue.css'
    import TeacherForm from "components/TeacherForm.vue";
    import ReviewList from "components/ReviewList.vue";

    export default {
        components: { TeacherForm, ReviewList}
    }
</script>

<style scoped>

</style>
