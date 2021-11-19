package it.epicode.gestioneincendi;

public class CentroControlloProxy implements CentroControlloInterface{

	CentroControlloFactory cc = new CentroControlloFactory();
	CentroControlloInterface cInt = cc.creaCentroControllo("CentroControlloHttp");
	
	
	@Override
	public void rilevaIncendio(InfoSonda i) {
		cInt.rilevaIncendio(i);
	}
	
	
	

	
}
