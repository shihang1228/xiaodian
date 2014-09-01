<%@ page import="com.baldurtech.domain.Contact" %>
<%
Contact contact = (Contact) request.getAttribute("data");
String message = (String) request.getAttribute("message");
if(null == message) message = "";
%>
<html>
  <head>
    <title>ShowContact</title>
  </head>
  <body>
    <h1>Show Contact</h1> 
    <table border=1>
        <tr><td><%=contact.getId()%></td></tr>
        <tr><td><%=contact.getName()%></td></tr>
        <tr><td>${contact.id}</td></tr>
        <tr><td>${contact.name}</td></tr>
    </table>
    
    <div><%=  message %></div>
    <a href="list">List all contacts</a>
  </body>
</html>