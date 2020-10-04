<template>
   <v-card>
       <v-card-text primary-title>
    <i>({{ review.id }})</i> {{ review.text }}, {{ review.teacher }} , {{ review.course }}

    <span style="position: absolute; right: 0">
        </span>
       </v-card-text>
   </v-card>
</template>

<script>
    export default {
        name: "ReviewRow",
        props: ['review']
    }
</script>

<style scoped>

</style>
