package it.epicode.jee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.epicode.jee.connection.ConnectionHandler;
import it.epicode.jee.model.Fornitore;

public class FornitoreDAO {

	ConnectionHandler c = new ConnectionHandler("postgres", "negozio", "postgres", "Pinguino98");

	public void saveFornitore(Fornitore forn) {
		try {
			c.getConnection();
			String querySave = "insert into negozio.fornitore (\"codiceFornitore\", nome, indirizzo, citta)\r\n"
					+ "	values (?,?,?,?)";
			PreparedStatement s = c.getPreparedStatement(querySave);
			s.setInt(1, forn.getCodiceFornitore());
			s.setString(2, forn.getNome());
			s.setString(3, forn.getIndirizzo());
			s.setString(4, forn.getCitta());
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

	public void updateFornitore(int codiceForn, Fornitore forn) {
		try {
			c.getConnection();
			String queryUpdate = "update negozio.fornitore set nome = ?, indirizzo = ?, citta = ?\r\n"
					+ "where \"codiceFornitore\" = ?";
			PreparedStatement s = c.getPreparedStatement(queryUpdate);
			s.setInt(4, codiceForn);
			s.setString(1, forn.getNome());
			s.setString(2, forn.getIndirizzo());
			s.setString(3, forn.getCitta());
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

	public void deleteFornitore(int codiceForn) {
		try {
			c.getConnection();
			String queryDelete = "delete from negozio.fornitore\r\n" + "where \"codiceFornitore\" = ?";
			PreparedStatement s = c.getPreparedStatement(queryDelete);
			s.setInt(1, codiceForn);
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

	public Fornitore getFornitore(int codiceForn) {
		try {
			c.getConnection();
			String queryGetForn = "select \"codiceFornitore\", nome, indirizzo, citta\r\n"
					+ "from negozio.fornitore\r\n" + "where \"codiceFornitore\" = ?";
			PreparedStatement s = c.getPreparedStatement(queryGetForn);
			s.setInt(1, codiceForn);
			ResultSet result = s.executeQuery();
			if (result.next()) {
				int codiceFornitore = result.getInt("codiceFornitore");
				String nome = result.getString("nome");
				String indirizzo = result.getString("indirizzo");
				String citta = result.getString("citta");
				Fornitore forn = new Fornitore(codiceFornitore, nome, indirizzo, citta);
				return forn;
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

	public List<Fornitore> getFornitoreAll() {
		try {
			c.getConnection();
			String queryGetAllForn = "select \"codiceFornitore\", nome, indirizzo, citta from negozio.fornitore";
			PreparedStatement s = c.getPreparedStatement(queryGetAllForn);
			List<Fornitore> listaForn = new ArrayList<>();
			ResultSet result = s.executeQuery();
			while (result.next()) {
				int codiceFornitore = result.getInt("codiceFornitore");
				String nome = result.getString("nome");
				String indirizzo = result.getString("indirizzo");
				String citta = result.getString("citta");
				Fornitore forn = new Fornitore(codiceFornitore, nome, indirizzo, citta);
				listaForn.add(forn);
			}
			return listaForn;
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

	public List<Fornitore> getFornitorePerCitta(String cittaPar) {
		try {
			c.getConnection();
			String queryGetFornitorePerCitta = "select \"codiceFornitore\", nome, indirizzo, citta\r\n"
					+ "from negozio.fornitore\r\n" + "where citta = ?";
			PreparedStatement s = c.getPreparedStatement(queryGetFornitorePerCitta);
			s.setString(1, cittaPar);
			List<Fornitore> listaForn = new ArrayList<>();
			ResultSet result = s.executeQuery();
			while (result.next()) {
				int codiceFornitore = result.getInt("codiceFornitore");
				String nome = result.getString("nome");
				String indirizzo = result.getString("indirizzo");
				String citta = result.getString("citta");
				Fornitore forn = new Fornitore(codiceFornitore, nome, indirizzo, citta);
				listaForn.add(forn);
				return listaForn;
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
