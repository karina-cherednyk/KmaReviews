<template>
    <b-card bg-variant="light">
        <b-form @submit="onSubmit" @reset="onReset" >
            <b-form-group
                    label="Повідомити про проблему:"
                    label-size="lg"
                    label-class="font-weight-bold pt-0"
                    class="mb-0"
            ></b-form-group>

            <b-form-group label="Тема:" label-for="input-topic">
                <b-form-input
                        v-model="topic"
                        required
                ></b-form-input>
            </b-form-group>

            <b-form-group label="Повідомлення:" label-for="input-problem">
                <b-form-textarea
                        v-model="text"
                        required
                        rows="6"
                ></b-form-textarea>
            </b-form-group>

            <b-button type="submit" variant="primary">Повідомити</b-button>
            <b-button type="reset" variant="danger">Очистити форму</b-button>

        </b-form>
    </b-card>
</template>

<script>
    export default {
        name: "ProblemsForm",
        data() {
            return {
                topic: "",
                text: "",
            }
        },
        methods: {
            onSubmit(evt){
                evt.preventDefault()
                this.topic = ""
                this.text = " "
            },
            onReset(evt){
                evt.preventDefault()
                this.topic = ""
                this.text = " "
            }
        }
    }
</script>

<style scoped>

</style>
