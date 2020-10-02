

var reviewApi = Vue.resource('/review{/id}');

Vue.component('review-form', {
    props: ['reviews'],
    data: function() {
        return {
            teacher: '',
            course: ''
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="teacher" />' +
        '<input type="text" placeholder="Write something" v-model="course" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            const review = {teacher: this.teacher, course: this.course};
            reviewApi.save({}, review).then(result =>
                result.json().then(data => {
                    this.reviews.push(data);
                    this.teacher = this.course = ''
                }))
            }
        }

});

Vue.component('review-row', {
    props: ['review'],
    template: '<div>' +
        '<i>({{ review.id }})</i> {{ review.teacher }} - {{ review.course }}' +

        '<span style="position: absolute; right: 0">' +
        '</span>' +
        '</div>',
});

Vue.component('reviews-list', {
    data: function(){
      return {
          reviews: []
      }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<review-form :reviews="reviews"  />' +
        '<review-row v-for="review in reviews" :key="review.id" :review="review" />' +
        '</div>',
    created: function() {
        reviewApi.get().then(result =>
        result.json().then(data =>
        data.forEach(review => this.reviews.push(review))
    )
    )
    }
});

var app = new Vue({
    el: '#app',
    template: '<reviews-list  />'
});
