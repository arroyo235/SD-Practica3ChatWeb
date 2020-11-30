<%
  if ((request.getParameter("username") != null)) {
%>

<jsp:forward page="chatroom.jsp" />

<% } else { %>

<%@ include file="index.html" %>

<% } %>

