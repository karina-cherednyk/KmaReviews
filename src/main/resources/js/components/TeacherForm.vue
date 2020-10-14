<template>
        <b-input-group>
            <b-form-select v-model="selected" :options="teachersOptions"></b-form-select>
            <b-input-group-append class="pl-2">
                <b-button variant="outline-light">Button</b-button>
                <b-button variant="outline-light bg-success" >Button</b-button>
            </b-input-group-append>
        </b-input-group>
</template>

<script>
    import { mapGetters , mapState} from 'vuex'
    export default {
        name: "TeacherForm",
        computed: mapGetters(['teachersOptions']),

        data(){
            return {
                selected: null,

            }
        }
    }
</script>

<style scoped>

</style>
