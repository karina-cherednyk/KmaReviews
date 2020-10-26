<template>
    <b-container id="app" style="max-width: 100%" >

        <b-navbar toggleable="lg" class="navbar-expand-md navbar-dark bg-primary">
            <b-navbar-nav class="collapse navbar-collapse">
                 <h1 class="p-3 text-light">Чесні відгуки на викладачів НаУКМА</h1>
            </b-navbar-nav>
        </b-navbar>
        <review-display/>
        <go-top ></go-top>
    </b-container>
</template>

<script>

    import 'bootstrap/dist/css/bootstrap.css'
    import 'bootstrap-vue/dist/bootstrap-vue.css'
    import ReviewDisplay from "pages/ReviewDisplay.vue";
    import GoTop from '@inotom/vue-go-top';


    export default {
        components: {ReviewDisplay, GoTop}
    }
</script>

<style scoped>

</style>
