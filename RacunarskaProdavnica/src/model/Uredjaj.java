package model;

import java.util.ArrayList;

public class Uredjaj {
	protected String naziv;
	protected ArrayList<Komponenta> komponente;
	protected String opis;
	public Uredjaj(String naziv, ArrayList<Komponenta> komponente, String opis) {
		super();
		this.naziv = naziv;
		this.komponente = komponente;
		this.opis = opis;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<Komponenta> getKomponente() {
		return komponente;
	}
	public void setKomponente(ArrayList<Komponenta> komponente) {
		this.komponente = komponente;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	@Override
	public String toString() {
		return "Uredjaj [naziv=" + naziv + ", komponente=" + komponente
				+ ", opis=" + opis + "]";
	}
	
}
