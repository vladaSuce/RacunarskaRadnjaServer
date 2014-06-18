package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Racun {
	
	protected HashMap<Komponenta,Integer> komponente;
	protected HashMap<Uredjaj,Integer>uredjaji;
	protected double porez;
	protected double ukupna_cena;
	protected String kupac;
	protected String date_time;
	public Racun(HashMap<Komponenta, Integer> komponente,
			HashMap<Uredjaj, Integer> uredjaji, double porez,
			double ukupna_cena, String kupac, String date_time) {
		super();
		this.komponente = komponente;
		this.uredjaji = uredjaji;
		this.porez = porez;
		this.ukupna_cena = ukupna_cena;
		this.kupac = kupac;
		this.date_time = date_time;
	}
	public HashMap<Komponenta, Integer> getKomponente() {
		return komponente;
	}
	public void setKomponente(HashMap<Komponenta, Integer> komponente) {
		this.komponente = komponente;
	}
	public HashMap<Uredjaj, Integer> getUredjaji() {
		return uredjaji;
	}
	public void setUredjaji(HashMap<Uredjaj, Integer> uredjaji) {
		this.uredjaji = uredjaji;
	}
	public double getPorez() {
		return porez;
	}
	public void setPorez(double porez) {
		this.porez = porez;
	}
	public double getUkupna_cena() {
		return ukupna_cena;
	}
	public void setUkupna_cena(double ukupna_cena) {
		this.ukupna_cena = ukupna_cena;
	}
	public String getKupac() {
		return kupac;
	}
	public void setKupac(String kupac) {
		this.kupac = kupac;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
}
