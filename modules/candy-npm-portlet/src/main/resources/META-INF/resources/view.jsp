<%@ include file="/init.jsp" %>

<div id="<portlet:namespace />candy">
	<p>A friendly reversible message from Vue.js:</p>
	<p>{{message}}</p>
	<button v-on:click="reverseMessage">Reverse message, pretty please</button>

	<div v-for="item in myData">
	    <label :for="item.id">{{item.name}}</label>
	    <input type="radio" v-model="checkedImage" :id="item.id" :value="item.id" />
    </div>
    <h1>{{checkedImage}}</h1>

    <select v-model="selectedProtocol">
        <option>https://</option>
        <option>http://</option>
    </select>

    <h1>{{selectedProtocol}}</h1>
</div>

<aui:script require="<%= mainRequire %>">
	main.default('<portlet:namespace />', '<%=candyDisplayContext.getDataAsJson()%>');
</aui:script>