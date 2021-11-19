package it.epicode.esercitazione04;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

	ConnectionHandler c = new ConnectionHandler("postgres", "negozio", "postgres", "Pinguino98");

	public void saveProdotto(Prodotto prod) {
		try {
			c.getConnection();
			String querySave = "insert into negozio.prodotto (\"codiceProdotto\", nome, descrizione, marca, fornitore, prezzo)\r\n"
					+ "	values (?,?,?,?,?,?)";
			PreparedStatement s = c.getPreparedStatement(querySave);
			s.setInt(1, prod.getCodiceProdotto());
			s.setString(2, prod.getNome());
			s.setString(3, prod.getDescrizione());
			s.setString(4, prod.getMarca());
			s.setInt(5, prod.getFornitore());
			s.setDouble(6, prod.getPrezzo());
			s.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateProdotto(int codiceProd, Prodotto prod) {
		try {
			c.getConnection();
			String queryUpdate = "update negozio.prodotto set nome = ?, descrizione = ?, marca = ?, fornitore = ?, prezzo = ?\r\n"
					+ "where \"codiceProdotto\" = ?";
			PreparedStatement s = c.getPreparedStatement(queryUpdate);
			s.setInt(6, codiceProd);
			s.setString(1, prod.getNome());
			s.setString(2, prod.getDescrizione());
			s.setString(3, prod.getMarca());
			s.setInt(4, prod.getFornitore());
			s.setDouble(5, prod.getPrezzo());
			s.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteProdotto(int codiceProd) {
		try {
			c.getConnection();
			String queryDelete = "delete from negozio.prodotto\r\n" + "where \"codiceProdotto\" = ?";
			PreparedStatement s = c.getPreparedStatement(queryDelete);
			s.setInt(1, codiceProd);
			s.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Prodotto getProdotto(int codiceProd) {
		try {
			c.getConnection();
			String queryGetProd = "select \"codiceProdotto\", nome, descrizione, marca, fornitore, prezzo\r\n"
					+ "from negozio.prodotto\r\n" + "where \"codiceProdotto\" = ?";
			PreparedStatement s = c.getPreparedStatement(queryGetProd);
			s.setInt(1, codiceProd);
			ResultSet result = s.executeQuery();
			if (result.next()) {
				int codiceProdotto = result.getInt("codiceProdotto");
				String nome = result.getString("nome");
				String descrizione = result.getString("descrizione");
				String marca = result.getString("marca");
				int fornitore = result.getInt("fornitore");
				double prezzo = result.getDouble("prezzo");
				Prodotto prod = new Prodotto(codiceProdotto, nome, descrizione, marca, fornitore, prezzo);
				return prod;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Prodotto> getProdottoAll() {
		try {
			c.getConnection();
			String queryGetAllProd = "select \"codiceProdotto\", nome, descrizione, marca, fornitore, prezzo\r\n"
					+ "from negozio.prodotto";
			PreparedStatement s = c.getPreparedStatement(queryGetAllProd);
			List<Prodotto> listaProd = new ArrayList<>();
			ResultSet result = s.executeQuery();
			while (result.next()) {
				int codiceProdotto = result.getInt("codiceProdotto");
				String nome = result.getString("nome");
				String descrizione = result.getString("descrizione");
				String marca = result.getString("marca");
				int fornitore = result.getInt("fornitore");
				double prezzo = result.getDouble("prezzo");
				Prodotto prod = new Prodotto(codiceProdotto, nome, descrizione, marca, fornitore, prezzo);
				listaProd.add(prod);
				return listaProd;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Prodotto> getProdottoPerForn(int forn) {
		try {
			c.getConnection();
			String queryGetProdottoPerForn = "select \"codiceProdotto\", nome, descrizione, marca, fornitore, prezzo\r\n"
					+ "from negozio.prodotto\r\n" + "where fornitore = ?";
			PreparedStatement s = c.getPreparedStatement(queryGetProdottoPerForn);
			s.setInt(1, forn);
			List<Prodotto> listaProd = new ArrayList<>();
			ResultSet result = s.executeQuery();
			while (result.next()) {
				int codiceProdotto = result.getInt("codiceProdotto");
				String nome = result.getString("nome");
				String descrizione = result.getString("descrizione");
				String marca = result.getString("marca");
				int fornitore = result.getInt("fornitore");
				double prezzo = result.getDouble("prezzo");
				Prodotto prod = new Prodotto(codiceProdotto, nome, descrizione, marca, fornitore, prezzo);
				listaProd.add(prod);
				return listaProd;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
