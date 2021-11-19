package it.epicode.gestioneincendi;

public class ControlloSonda implements Observer {

	private Long id;

	public ControlloSonda() {

	}

	public ControlloSonda(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void update(Subject obj) {
		InfoSonda infS = new InfoSonda((Sonda)obj);
		System.out.println("ALLARME - LIVELLO FUMO DELLA SONDA " + ((Sonda)obj).getId() + " TROPPO ALTO");
		CentroControlloProxy cproxy = new CentroControlloProxy();
		cproxy.rilevaIncendio(infS);
	}

}

