<template>
    <span></span>
</template>

<script>
    import { mapActions } from 'vuex'

    export default {
        name: 'LazyLoader',
        methods: mapActions(['loadPageAction']),
        computed: {
            teacher_id() { return this.$route.params.teacher_id} ,
            faculty_id() { return this.$route.params.faculty_id}
        },
        mounted() {
            window.onscroll = () => {
                const el = document.documentElement
                const isBottomOfScreen = el.scrollTop + window.innerHeight  >  el.offsetHeight - 10
                if (isBottomOfScreen) {
                    this.loadPageAction({teacher_id: this.teacher_id, faculty_id: this.faculty_id} )
                }
            }
        },
        beforeDestroy() {
            window.onscroll = null
        }
    }
</script>

<style scoped>
</style>
