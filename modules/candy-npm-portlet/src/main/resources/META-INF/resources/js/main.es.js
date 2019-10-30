import Vue from 'vue/dist/vue.common';
import moment from 'moment';

export default function(portletNamespace, books) {
	new Vue({
		el: `#${portletNamespace}candy`,
		data: {
			books: books
		},
		methods: {
      getFormatedDate(date){
        return moment(date).format('MM/DD/YYYY hh:mma');
      }
		},
	});

}