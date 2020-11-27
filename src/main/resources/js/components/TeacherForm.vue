<template>
        <b-input-group>
            <b-form-select v-model="selectedTeacher" :options="teachersOptions1" id="teachers"></b-form-select>
            <b-form-select v-model="selectedFaculty" :options="facultyOptions"></b-form-select>
            <b-input-group-append class="pl-2">
                <b-button variant="outline-light bg-success" @click="getByTeacher">Пошук</b-button>
            </b-input-group-append>
        </b-input-group>
</template>

<script>
    import { mapGetters} from 'vuex'
    export default {
        name: "TeacherForm",
        computed: {
            ...mapGetters([ 'facultyOptions']),
            teachersOptions1() {

                let ops = this.$store.getters.teachersOptions
                if(this.selectedFaculty == null) return ops
                else {
                    let res = []
                    let id = this.selectedFaculty.id
                    for(const x of ops ) if(x.value == null || x.value.faculty && x.value.faculty.id == id ) res.push(x)
                    return res
                }
            },

        },

        data(){
            return {
                selectedTeacher: null,
                selectedFaculty: null,
            }
        },
        methods: {

            getByTeacher(){
                if(this.selectedTeacher) this.$router.push('/teacher/'+this.selectedTeacher.id)
                else if(this.selectedFaculty)  this.$router.push('/faculty/'+this.selectedFaculty.id)
                else this.$router.push('/')
            },
            updateTeacher(teacher){
                this.selectedTeacher = teacher
            }


        },
        mounted() {
            this.$root.$on('teacher_set', (teacher) => {
                this.updateTeacher(teacher)
            })
        }

    }
</script>

<style scoped>

</style>
