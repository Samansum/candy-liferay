<%@ include file="/html/init.jsp" %>

<div id="<portlet:namespace />candy">
  <table class="table">
    <thead>
      <tr>
        <th scope="col">BookId</th>
        <th scope="col">Book Title</th>
        <th scope="col">Author</th>
        <th scope="col">Year of publish</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="book in books">
        <td v-cloak>{{book.bookId}}</td>
        <td v-cloak>{{book.bookTitle}}</td>
        <td v-cloak>{{book.author}}</td>
        <td v-cloak>{{getFormatedDate(book.publishDate)}}</td>
      </tr>
    </tbody>
  </table>
</div>

<aui:script require="<%= mainRequire %>">
	main.default('<portlet:namespace />', <%=candyDisplayContext.getBooksAsJson()%>);
</aui:script>