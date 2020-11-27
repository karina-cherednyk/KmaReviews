<template>
     <b-card class="bg-light">
         <b-card-body>
             <b-card-title><b-link @click="findReviews">{{review.teacher.name}}</b-link></b-card-title>
             <b-card-sub-title>{{ review.sendTime }}</b-card-sub-title>
            <b-card-text>{{ review.text }}</b-card-text>
         </b-card-body>
    </b-card>
</template>

<script>
    export default {
        name: "ReviewRow",
        props: ['review'],
        methods: {
            findReviews() {
                this.$router.push('/teacher/'+this.review.teacher.id)
                this.$root.$emit('teacher_set', this.review.teacher)
            }
        }


    }
</script>

<style scoped>

</style>
