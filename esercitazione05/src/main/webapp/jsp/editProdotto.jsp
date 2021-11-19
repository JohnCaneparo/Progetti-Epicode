<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Prodotto</title>
</head>
<body>
	<form action="/esercitazione05/main-servlet" method="get">
	
		<input type="text" name="codiceProdotto" placeholder="inserisici codice prodotto"><br>
		<input type="text" name="nome" placeholder="inserisici nome del prodotto"><br>
		<input type="text" name="descrizione" placeholder="inserisici descrizione del prodotto"><br>
		<input type="text" name="marca" placeholder="inserisici marca del prodotto"><br>
		<input type="text" name="fornitore" placeholder="inserisici fornitore del prodotto"><br>
		<input type="text" name="prezzo" placeholder="inserisici prezzo del prodotto"><br>
		<input type="submit" name="enterProd" value="Salva Prodotto">
		<input type="submit" name="modificaProd" value="Modifica Prodotto">
	
	</form>
</body>
</html>