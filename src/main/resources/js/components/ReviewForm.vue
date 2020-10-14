<template>
    <div>
        <input type="text" placeholder="teacher id" v-model="teacher" />
        <input type="text" placeholder="course id" v-model="course" />
        <input type="text" placeholder="text" v-model="text" />
        <input type="button" value="Save" @click="save" />
    </div>
</template>

<script>
    import { mapActions } from 'vuex'

    export default {
        name: "ReviewForm",
        data(){
            return{
                teacher: null,
                course: null,
                text : ''
            }
        },
        methods:   {
            ...mapActions(['addReviewAction']),
            save() {
                const review = {
                    text : this.text,
                    teacher: {id: parseInt(this.teacher)},
                    course: {id: parseInt(this.course)}
                }
                this.addReviewAction(review)
                this.teacher = null
                this.course = null
                this.text = ''
            }

        }
    }
</script>

<style scoped>

</style>
