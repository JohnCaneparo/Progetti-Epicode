<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Fornitore</title>
</head>
<body>
	<form action="/esercitazione05/main-servlet" method="get">
	
		<input type="text" name="codiceFornitore" placeholder="inserisici codice fornitore"><br>
		<input type="text" name="nome" placeholder="inserisici nome del fornitore"><br>
		<input type="text" name="indirizzo" placeholder="inserisici indirizzo del fornitore"><br>
		<input type="text" name="citta" placeholder="inserisici città del fornitore"><br>
		<input type="submit" name="enter" value="Salva Fornitore">
		<input type="submit" name="modifica" value="Modifica Fornitore">
	
	</form>
</body>
</html>