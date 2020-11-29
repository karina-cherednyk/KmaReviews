<template>
    <b-container class="p-2 m-2" style="max-width: 100%">
        <b-row class="d-md-none" >
                <b-button class="ml-3" v-b-toggle.input_collapse  variant="outline-light bg-primary" >Show input forms</b-button>
                <b-collapse id="input_collapse">
                    <input-form></input-form>
                </b-collapse>
        </b-row>
        <b-row>
            <b-col col lg="3" class="d-none d-md-block" ><FAQ  /></b-col>
             <b-col lg="5">
                 <b-nav >
                     <teacher-form class="form-inline mt-2 mb-2"/>
                 </b-nav>
                 <router-view></router-view>
             </b-col>
            <b-col lg="4" class="d-none d-md-block">
                <input-form></input-form>
            </b-col>
        </b-row>
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
    import InputForm from "pages/InputForm.vue";


    export default {
        name: "ReviewDisplay",
        components: {InputForm, TeacherForm, ReviewList, MostDiscussedList, FAQ, ProblemsForm, ReviewForm},
        computed: mapGetters(["getPagesLinks"]),
    }
</script>

<style scoped>

</style>
