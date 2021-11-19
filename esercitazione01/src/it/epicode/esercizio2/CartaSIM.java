package it.epicode.esercizio2;

public class CartaSIM {
	private String numeroTelefono;
	private double credito;
	private Chiamata listaChiamate[] = new Chiamata[5];
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	public Chiamata[] getListaChiamate() {
		return listaChiamate;
	}
	public void setListaChiamate(Chiamata[] listaChiamate) {
		this.listaChiamate = listaChiamate;
	}
	
	public CartaSIM(String numeroTelefono, double credito, Chiamata listaChiamate[]) {
		this.numeroTelefono = numeroTelefono;
		credito = 0;
		this.listaChiamate = listaChiamate;
		
	}
	
	public void stampaSIM(CartaSIM sim1) {
		System.out.println("Il numero di telefono è: " + numeroTelefono);
		System.out.println("il credito residuo è: " + credito);
		System.out.println("Le ultime 5 chiamate effettuate sono: " + listaChiamate);
			}
	
}