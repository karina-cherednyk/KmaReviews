<template>
    <b-container>
    <b-row class="pl-3">
        <h3>FAQ:</h3>
    </b-row>
    <b-list-group>

        <b-list-group-item v-for="qa in model" class="flex-column align-items-start">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">{{qa.question}}</h5>
            </div>
            <p class="mb-1" t>{{qa.answer}}</p>
        </b-list-group-item>

    </b-list-group>
    </b-container>
</template>

<script>
    export default {
        name: "FAQ",
        data(){
            return {
                model: [
                    {"question": "чи будь-хто може надіслати відгук?", "answer": "так!"},
                    {"question": "чи знають викладачі кому належить відгук?", "answer": "ні, бо ми жодним чином не зберігаємо інформацію про авторів(ок)."},
                    {"question": "що робити, якщо викладача немає в списку?", "answer": "написати нам через форму \"повідомити про проблему\", ми все переглянемо та обов'язково виправимо!"},
                    {"question": "що робити, якщо я бачу беззмістовні відгуки?", "answer": "ви можете поскаржитися на них, ми перевіримо та за потреби видалимо "},
                    {"question": "чи можу я лаятися у своєму відгуку?", "answer": "так, ми не адміністрація, щоб перед нами було соромно :)"},

                ]
            }
        }
    }
</script>

<style scoped>

</style>
