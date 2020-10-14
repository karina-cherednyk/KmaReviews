<template>
    <b-container >
        <b-row>
            <h3>Most reviewed teachers: </h3>
        </b-row>
        <b-row class="p-0 ">
            <b-list-group >
                <b-list-group-item href="#some-link">Teacher 1 copy
                    <b-badge variant="primary" pill>14</b-badge>
                </b-list-group-item>
                <b-list-group-item href="#" active>Teacher 2
                    <b-badge variant="primary" pill>14</b-badge>
                </b-list-group-item>
                <b-list-group-item href="#">Teacher 3
                    <b-badge variant="primary" pill>14</b-badge>
                </b-list-group-item>
                <b-list-group-item href="#foobar" >Teacher 4
                    <b-badge variant="primary" pill>14</b-badge>
                </b-list-group-item>
            </b-list-group>
        </b-row>
    </b-container>
</template>

<script>
    export default {
        name: "MostDiscussedList",
        data() {
            return {
                top: [
                    'T1','T2','T3'
                ]

            }
        }
    }
</script>

<style scoped>

</style>
