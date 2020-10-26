<template>
    <b-card bg-variant="light">
        <b-form @submit="onSubmit" @reset="onReset" >
            <b-form-group
                    label="Залишити відгук на викладача:"
                    label-size="lg"
                    label-class="font-weight-bold pt-0"
                    class="mb-0"
            ></b-form-group>

            <b-form-group id="input-group-3" label="Викладач:" label-for="input-teacher">
                <b-form-select
                        id="input-teacher"
                        v-model="selectedTeacher"
                        :options="teachersOptions"
                        required
                ></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-2" label="Відгук:" label-for="input-review">
                <b-form-textarea
                        id="input-review"
                        v-model="review"
                        required
                        rows="6"
                ></b-form-textarea>
            </b-form-group>

            <b-button type="submit" variant="primary">Відправити</b-button>
            <b-button type="reset" variant="danger">Очистити форму</b-button>

        </b-form>
    </b-card>
</template>

<script>
    import { mapActions , mapGetters} from 'vuex'


    export default {
        name: "ReviewForm",
        computed: mapGetters(['teachersOptions']),
        data() {
            return {
                selectedTeacher: null,
                review: null,
            }
        },
        methods: {
            ...mapActions(['addReviewAction']),
            onSubmit(evt){
                evt.preventDefault()
                const review = {
                    text : this.review,
                    teacher: this.selectedTeacher,
                }
                this.addReviewAction(review)


                this.$root.$emit('review_added')

                this.selectedTeacher = null
                this.review = null
            },
            onReset(evt){
                evt.preventDefault()
                this.selectedTeacher = null
                this.review = null
            }
        }
    }
</script>

<style scoped>

</style>
