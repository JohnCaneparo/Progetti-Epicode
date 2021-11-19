<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.epicode.jee.service.ProdottoService"%>
<%@ page import="java.util.List"%>
<%@ page import="it.epicode.jee.model.Prodotto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ProdottoService p = new ProdottoService();
		for (Prodotto prod : p.getProdottoAll()) {
			out.println(prod + "<br>");
		}
		for (Prodotto prod : p.getProdottoAll()) {
		out.println("<input type=\"radio\" name=\"prodotto\" value=" + prod + ">" + prod.getNome() + "<br>");
		}
	%>
	<form action="/esercitazione05/main-servlet" method="get">
		<input type="submit" name="aggiungiProdotto" value="Nuovo Prodotto">
		<input type="submit" name="editProd" value="Modifica Prodotto">
		<input type="submit" name="removeProd" value="Rimuovi Prodotto">
	</form>
	<hr><a href="/esercitazione05/jsp/index.jsp">Torna all'indice</a>
</body>
</html>