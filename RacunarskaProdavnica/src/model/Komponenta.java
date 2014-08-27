package model;

import java.awt.Image;
import java.io.Serializable;

public class Komponenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 164605316319946827L;
	protected String naziv;
	protected Kategorija kategorija;
	protected int raspoloziva_kolicina;
	protected double cena;
	protected String opis;
	protected String link;
	protected Image Slika;
	public Komponenta(String naziv, Kategorija kategorija,
			int raspoloziva_kolicina, double cena, String opis, String link,
			Image slika) {
		super();
		this.naziv = naziv;
		this.kategorija = kategorija;
		this.raspoloziva_kolicina = raspoloziva_kolicina;
		this.cena = cena;
		this.opis = opis;
		this.link = link;
		Slika = slika;
	}
	public Komponenta(){}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	public int getRaspoloziva_kolicina() {
		return raspoloziva_kolicina;
	}
	public void setRaspoloziva_kolicina(int raspoloziva_kolicina) {
		this.raspoloziva_kolicina = raspoloziva_kolicina;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Image getSlika() {
		return Slika;
	}
	public void setSlika(Image slika) {
		Slika = slika;
	}
	@Override
	public String toString() {
		return "Komponenta [naziv=" + naziv + ", kategorija=" + kategorija
				+ ", raspoloziva_kolicina=" + raspoloziva_kolicina + ", cena="
				+ cena + ", Opis=" + opis + ", link=" + link + ", Slika="
				+ Slika + "]";
	}
	
}
