package model;

import java.io.Serializable;

public class Poruka implements Serializable {

	private static final long serialVersionUID = 4725212890105028193L;

	private String komanda;
	private Object podatak;

	public Poruka(String komanda, Object podatak) {
		super();
		this.komanda = komanda;
		this.podatak = podatak;
	}

	@Override
	public String toString() {
		return komanda + " [" + podatak + "]";
	}

	
	public String getKomanda() {
		return komanda;
	}

	public void setKomanda(String komanda) {
		this.komanda = komanda;
	}

	public Object getPodatak() {
		return podatak;
	}

	public void setPodatak(Object podatak) {
		this.podatak = podatak;
	}

}
