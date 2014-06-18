package model;

public class Kategorija {
	protected String naziv;
	protected String opis;
	protected String pod_kategorija_naziv;
	
	public Kategorija(){
		naziv="";
		opis="";
		pod_kategorija_naziv="";
	}
	public Kategorija(String aNaziv,String aOpis,String aPod_kategorija_naziv){
		setNaziv(aNaziv);
		setOpis(aOpis);
		setPod_kategorija_naziv(aPod_kategorija_naziv);
	}
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getPod_kategorija_naziv() {
		return pod_kategorija_naziv;
	}

	public void setPod_kategorija_naziv(String pod_kategorija_naziv) {
		this.pod_kategorija_naziv = pod_kategorija_naziv;
	}
	
}
