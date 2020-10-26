<template>
        <b-input-group>
            <b-form-select v-model="selectedTeacher" :options="teachersOptions"></b-form-select>
            <b-input-group-append class="pl-2">
                <b-button variant="outline-light bg-success" @click="getByTeacher">Пошук</b-button>
            </b-input-group-append>
        </b-input-group>
</template>

<script>
    import { mapGetters, mapActions} from 'vuex'
    export default {
        name: "TeacherForm",
        computed: mapGetters(['teachersOptions']),

        data(){
            return {
                selectedTeacher: null,
            }
        },
        methods: {
            getByTeacher(){
                if(this.selectedTeacher) this.$router.push('/'+this.selectedTeacher.id+'/reviews')
                else this.$router.push('/')
                console.log(this.$route.path)
            },

        },

    }
</script>

<style scoped>

</style>
