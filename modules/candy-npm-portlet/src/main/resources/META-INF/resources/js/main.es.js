import Vue from 'vue/dist/vue.common';

export default function(portletNamespace, candyData) {
	new Vue({
		el: `#${portletNamespace}candy`,
		data: {
			message: 'Hello from Vue.js!',
			myData: JSON.parse(candyData),
			checkedImage: '',
			selectedProtocol: 'https://'
		},

		methods: {
			reverseMessage: function() {
				this.message = this.message
					.split(' ')[0];
			},
		},
	});

}