<template>
    <b-card :title="review.teacher.name" :sub-title="review.sendTime">
        <b-card-text>
          {{ review.text }}
        </b-card-text>
        <b-link>Send review</b-link>
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
