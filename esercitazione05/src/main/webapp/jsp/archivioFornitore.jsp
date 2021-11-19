<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.epicode.jee.service.FornitoreService"%>
<%@ page import="java.util.List"%>
<%@ page import="it.epicode.jee.model.Fornitore"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	FornitoreService f = new FornitoreService();
	for (Fornitore forn : f.getFornitoreAll()) {
		out.println(forn + "<br>");
	}
	for (Fornitore forn : f.getFornitoreAll()) {
	out.println("<input type=\"radio\" name=\"fornitore\" value=" + forn + ">" + forn.getNome() + "<br>");
	}
	%>
	<form action="/esercitazione05/main-servlet" method="get">
		<input type="submit" name="aggiungiFornitore" value="Nuovo Fornitore">
		<input type="submit" name="edit" value="Modifica Fornitore">
		<input type="submit" name="remove" value="Rimuovi Fornitore">
	</form>
	<hr><a href="/esercitazione05/jsp/index.jsp">Torna all'indice</a>
</body>
</html>