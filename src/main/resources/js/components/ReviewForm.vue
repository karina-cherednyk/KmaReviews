<template>
    <div> +
        <input type="text" placeholder="Write something" v-model="teacher" />
        <input type="text" placeholder="Write something" v-model="course" />
        <input type="button" value="Save" @click="save" />
    </div>
</template>

<script>
    import  Vue from 'vue'
    import VueResource from 'vue-resource'
    Vue.use(VueResource)
    var reviewApi = Vue.resource('/review{/id}');

    export default {
        name: "ReviewForm",
        props: ['reviews'],
        data(){
            return{
                teacher: '',
                course: ''
            }
        },
        methods: {
            save() {
                const review = {teacher: this.teacher, course: this.course};
                reviewApi.save({}, review).then(result =>
                    result.json().then(data => {
                        this.reviews.push(data);
                        this.teacher = this.course = ''
                    }))
            }

        }
    }
</script>

<style scoped>

</style>
