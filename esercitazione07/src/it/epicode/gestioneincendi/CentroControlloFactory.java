package it.epicode.gestioneincendi;

public class CentroControlloFactory {

	public CentroControlloInterface creaCentroControllo (String tipoCentroControllo) {
		if (tipoCentroControllo == null) {
			return null;
		}
		if (tipoCentroControllo.equalsIgnoreCase("CentroControlloHttp")){
			return new CentroControlloHttp();
		}
		return null;
	}
	
}
