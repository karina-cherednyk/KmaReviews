<template>
    <b-container class="p-2 m-2" style="max-width: 100%">
    <b-row>
        <!--<b-col col lg="3" class="d-md-none d-lg-block"> <most-discussed-list/> </b-col>-->
        <b-col col lg="3" class="d-md-none d-lg-block" ><FAQ  /></b-col>
         <b-col lg="5">
             <b-nav >
                 <teacher-form class="form-inline mt-2 mb-2"/>
             </b-nav>
             <router-view></router-view>
         </b-col>
        <b-col lg="4">
            <review-form  class="mb-4"/>
            <problems-form/>
        </b-col>
    </b-row>
<!--    <b-row align-h="center" class="p-3">-->
<!--        <b-pagination-nav  :pages="getPagesLinks" use-router ></b-pagination-nav>-->
<!--    </b-row>-->
    </b-container>
</template>

<script>
    import TeacherForm from "components/TeacherForm.vue";
    import ReviewList from "components/ReviewList.vue";
    import MostDiscussedList from "components/MostDiscussedList.vue";
    import FAQ  from "components/FAQ.vue";
    import {mapGetters} from "vuex";
    import ReviewForm from "components/ReviewForm.vue";
    import ProblemsForm from "components/ProblemsForm.vue";

    export default {
        name: "ReviewDisplay",
        components: {ProblemsForm, ReviewForm, TeacherForm, ReviewList, MostDiscussedList, FAQ},
        computed: mapGetters(["getPagesLinks"]),
    }
</script>

<style scoped>

</style>
