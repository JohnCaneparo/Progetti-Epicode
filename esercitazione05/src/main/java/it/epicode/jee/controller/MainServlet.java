package it.epicode.jee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.jee.model.Fornitore;
import it.epicode.jee.model.Prodotto;
import it.epicode.jee.service.FornitoreService;
import it.epicode.jee.service.ProdottoService;

@WebServlet("/main-servlet")
public class MainServlet extends HttpServlet {
	FornitoreService f = new FornitoreService();
	ProdottoService p = new ProdottoService();
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//GESTIONE DEI FORNITORI
		//		
		if (request.getParameter("archivioFornitore") != null) {
			request.getRequestDispatcher("/jsp/archivioFornitore.jsp").forward(request, response);
		}

		if (request.getParameter("aggiungiFornitore") != null) {
			request.getRequestDispatcher("/jsp/editFornitore.jsp").forward(request, response);
		}

		if (request.getParameter("enter") != null) {
			Fornitore forn = new Fornitore(Integer.parseInt(request.getParameter("codiceFornitore")),
					request.getParameter("nome"), request.getParameter("indirizzo"), request.getParameter("citta"));
			f.saveFornitore(forn);
			request.getRequestDispatcher("/jsp/archivioFornitore.jsp").forward(request, response);
		}
		
		/**
		 * Per quanto riguarda la parte del compito facoltativa ho passato molto tempo a capire come riuscire a passarmi l'oggetto selezionato dalla radio button, 
		 * ma dopo svariati tentativi non ho trovato una soluzione che funzionasse. ho provato a cercare su internet, ma il codice che più mi era comprensibile era  
		 * anche difficile da implementare quindi ho deciso di confrontarmi con il docente e la classe al riguardo.
		 * Ho comunque svolto la parte facoltativa riguardo la gestione dell'archivio dei prodotti, riscontrando ovviamente lo stesso problema con laradio button.
		 */
		

		if (request.getParameter("edit") != null) {
			request.getRequestDispatcher("/jsp/editFornitore.jsp").forward(request, response);
			Fornitore f1 = (Fornitore) request.getAttribute("fornitore");
			Fornitore forn = new Fornitore(f1.getCodiceFornitore(), request.getParameter("nome"), request.getParameter("indirizzo"), request.getParameter("citta"));
			if (request.getParameter("modifica") != null) {
				f.updateFornitore(Integer.parseInt(request.getParameter("codiceFornitore")), forn);
				request.getRequestDispatcher("/jsp/archivioFornitore.jsp").forward(request, response);
			}
		}
		
		if (request.getParameter("remove") != null) {
			Fornitore f1 = new Fornitore(); 
			request.setAttribute("fornitore", f1);
			f.deleteFornitore(f1.getCodiceFornitore());
			request.getRequestDispatcher("/jsp/archivioFornitore.jsp").forward(request, response);
		}
		
		
		//GESTIONE DEI PRODOTTI
		//
		if (request.getParameter("archivioProdotto") != null) {
			request.getRequestDispatcher("/jsp/archivioProdotto.jsp").forward(request, response);
		}
		
		if (request.getParameter("aggiungiProdotto") != null) {
			request.getRequestDispatcher("/jsp/editProdotto.jsp").forward(request, response);
		}
		
		if (request.getParameter("enterProd") != null) {
			Prodotto prod = new Prodotto(Integer.parseInt(request.getParameter("codiceProdotto")), request.getParameter("nome"), request.getParameter("descrizione"), request.getParameter("marca"), Integer.parseInt(request.getParameter("fornitore")), Double.parseDouble(request.getParameter("prezzo")));
			p.saveProdotto(prod);
			request.getRequestDispatcher("/jsp/archivioProdotto.jsp").forward(request, response);
		}
		
		if (request.getParameter("removeProd") != null) {
			Prodotto p1 = (Prodotto) request.getAttribute("prodotto");
			p.deleteProdotto(p1.getCodiceProdotto());
			request.getRequestDispatcher("/jsp/archivioProdotto.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
