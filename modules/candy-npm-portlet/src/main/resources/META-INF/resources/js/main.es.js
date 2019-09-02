import Vue from 'vue/dist/vue.common';

export default function(portletNamespace, candyData) {
	new Vue({
		el: `#${portletNamespace}candy`,
		data: {
			message: 'Hello from Vue.js!',
			myData: JSON.parse(candyData),
			checkedImage: ''
		},

		methods: {
			reverseMessage: function() {
				this.message = this.message
					.split(' ')[0];
			},
		},
	});

	Vue.component('todo-item', {
		props: ['todo'],
		template: '<li>{{ todo.text }}</li>',
	});

	new Vue({
		el: `#${portletNamespace}-2`,
		data: {
			groceryList: [
				{ id: 0, text: 'Vegetables' },
				{ id: 1, text: 'Cheese' },
				{ id: 2, text: 'Whatever else humans are supposed to eat' },
			],
		},
	});
}