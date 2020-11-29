<template>
    <b-card bg-variant="light">
        <b-form @submit="onSubmit" @reset="onReset" >
            <b-form-group
                    label="Залишити відгук на викладача:"
                    label-size="lg"
                    label-class="font-weight-bold pt-0"
                    class="mb-0"
            ></b-form-group>

            <b-form-group  label="Викладач:" >
                <b-form-select
                        v-model="selectedTeacher"
                        :options="teachersOptions"
                        required
                ></b-form-select>
            </b-form-group>

            <b-form-group  label="Відгук:" >
                <b-form-textarea
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

                this.$bvToast.toast('Відгук було відправлено', {
                    title: `Успіх`,
                    variant: 'success',
                    solid: true
                })
            },
            countDownChanged(dismissCountDown) {
                this.dismissCountDown = dismissCountDown
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
