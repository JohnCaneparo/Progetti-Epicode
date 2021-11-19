package it.epicode.esercizio3;

public class Carrello {
	private String clienteAssociato;
	private String[] elencoArticoli;
	private double totaleCostoArticoli;
	
	public String getClienteAssociato() {
		return clienteAssociato;
	}
	public void setClienteAssociato(String clienteAssociato) {
		this.clienteAssociato = clienteAssociato;
	}
	public String[] getElencoArticoli() {
		return elencoArticoli;
	}
	public void setElencoArticoli(String[] elencoArticoli) {
		this.elencoArticoli = elencoArticoli;
	}
	public double getTotaleCostoArticoli() {
		return totaleCostoArticoli;
	}
	public void setTotaleCostoArticoli(double totaleCostoArticoli) {
		this.totaleCostoArticoli = totaleCostoArticoli;
	}
	
	public Carrello(String clienteAssociato, String[] elencoArticoli, double totaleCostoArticoli) {
		this.clienteAssociato = clienteAssociato;
		this.elencoArticoli = elencoArticoli;
		this.totaleCostoArticoli = totaleCostoArticoli;
	}
}
