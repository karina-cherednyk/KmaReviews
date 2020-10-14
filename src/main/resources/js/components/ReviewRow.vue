<template>
     <b-card class="bg-light">
         <b-card-body>
             <b-card-title><b-link>{{review.teacher.name}}</b-link></b-card-title>
             <b-card-sub-title>{{ review.sendTime }}</b-card-sub-title>
            <b-card-text>{{ review.text }}</b-card-text>
         </b-card-body>
    </b-card>
</template>

<script>
    export default {
        name: "ReviewRow",
        props: ['review']
    }
</script>

<style scoped>

</style>
