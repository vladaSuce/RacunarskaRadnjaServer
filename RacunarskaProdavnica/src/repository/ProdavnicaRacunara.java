package repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;






import model.Kategorija;
import model.Komponenta;
import model.Korisnik;
import model.Racun;
import model.Uredjaj;

public class ProdavnicaRacunara implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -807300620120368370L;
	protected ArrayList<Komponenta>komponente;
	protected ArrayList<Uredjaj> uredjaji;
	protected ArrayList<Kategorija>kategorije;
	protected ArrayList<Racun>racuni;
	protected ArrayList<Korisnik>korisnici;
	protected String kategrijaDat ="kategorije.dat";
	protected String komponenteDat="komponente.dat";
	protected String uredjajiDat = "uredaji.dat";
	protected String racuniDat = "racuni.dat";
	protected String korisniciDat ="korisnici.dat";
	public ProdavnicaRacunara(){
		komponente = new ArrayList<Komponenta>();
		kategorije = new ArrayList<Kategorija>();
		uredjaji = new ArrayList<Uredjaj>();
		racuni = new ArrayList<Racun>();
		korisnici= new ArrayList<Korisnik>();
		loadKorisnici(korisniciDat);
		loadKategorije(kategrijaDat);
		loadKomponente(komponenteDat);
		loadUredjaji(uredjajiDat);
		loadRacuni(racuniDat);
	}
	public ArrayList<Komponenta> getKomponente() {
		return komponente;
	}
	public ArrayList<Uredjaj> getUredjaji() {
		return uredjaji;
	}
	public ArrayList<Kategorija> getKategorije() {
		return kategorije;
	}
	public ArrayList<Racun> getRacuni() {
		return racuni;
	}
	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}
	protected void saveRacuni(String dat) {
		File file = new File(dat);
		ObjectOutputStream out = null;
		try {
			if (!file.exists())
				file.createNewFile();
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			out.writeObject(racuni);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void loadKorisnici(String dat) {
		File file = new File(dat);
		ObjectInputStream in = null;
		try {
			if (!file.exists())
				return;
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			korisnici = (ArrayList<Korisnik>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void saveKorisnik(String dat) {
		File file = new File(dat);
		ObjectOutputStream out = null;
		try {
			if (!file.exists())
				file.createNewFile();
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			out.writeObject(korisnici);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void loadRacuni(String dat) {
		File file = new File(dat);
		ObjectInputStream in = null;
		try {
			if (!file.exists())
				return;
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			racuni = (ArrayList<Racun>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void saveUredjaji(String dat) {
		File file = new File(dat);
		ObjectOutputStream out = null;
		try {
			if (!file.exists())
				file.createNewFile();
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			out.writeObject(uredjaji);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveKomponente(String dat) {
		File file = new File(dat);
		ObjectOutputStream out = null;
		try {
			if (!file.exists())
				file.createNewFile();
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			out.writeObject(komponente);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveKategorije(String dat) {
		File file = new File(dat);
		ObjectOutputStream out = null;
		try {
			if (!file.exists())
				file.createNewFile();
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			out.writeObject(kategorije);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadKategorije(String dat) {
		File file = new File(dat);
		ObjectInputStream in = null;
		try {
			if (!file.exists())
				return;
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			kategorije = (ArrayList<Kategorija>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void loadUredjaji(String dat) {
		File file = new File(dat);
		ObjectInputStream in = null;
		try {
			if (!file.exists())
				return;
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			uredjaji = (ArrayList<Uredjaj>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void loadKomponente(String dat) {
		File file = new File(dat);
		ObjectInputStream in = null;
		try {
			if (!file.exists())
				return;
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			komponente = (ArrayList<Komponenta>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void addKategorija(Kategorija k){
		kategorije.add(k);
		saveKategorije(kategrijaDat);
	}
	public void addKomponenta(Komponenta k){
		komponente.add(k);
		saveKomponente(komponenteDat);
	}
	public void addRacun(Racun r){
		racuni.add(r);
		saveRacuni(racuniDat);
	}
	public void addKorisnik (Korisnik k){
		korisnici.add(k);
		saveKorisnik(korisniciDat);
	}
	public void addUredjaj(Uredjaj u){
		uredjaji.add(u);
		saveUredjaji(uredjajiDat);
	}
	public void removeKategorija(String nazivK){
		Kategorija temp = findKategorija(nazivK);
		if(temp != null){
			kategorije.remove(temp);
			saveKategorije(kategrijaDat);
		}
	}
	public void removeKorisnik(String nazivK){
		boolean sadrzi =false;
		Korisnik temp = new Korisnik();
		for (Korisnik k : korisnici ){
			if (k.getUserName().toLowerCase() == nazivK.toLowerCase()){
				sadrzi=true;
				temp = k;
				break;
			}
		}
		if(sadrzi){
			korisnici.remove(temp);
			saveKorisnik(korisniciDat);
		}
	}
	public void removeKomponenta(String nazivK){
		Komponenta temp = findKomponenta(nazivK);
		if(temp != null){
			komponente.remove(temp);
			saveKomponente(komponenteDat);
		}
	}
	public void removeUredjaj(String nazivK){
		Uredjaj temp = findUredjaj(nazivK);
		if(temp != null){
			uredjaji.remove(temp);
			saveUredjaji(uredjajiDat);
		}
	}
	public Kategorija findKategorija(String nazivK){
		Kategorija retVal =  null;
		boolean sadrzi =false;
		Kategorija temp = new Kategorija();
		for (Kategorija k : kategorije ){
			if (k.getNaziv().toLowerCase() == nazivK.toLowerCase()){
				sadrzi=true;
				temp = k;
				break;
			}
		}
		if(sadrzi){
			retVal=temp;			
		}
		return retVal;
	}
	public Komponenta findKomponenta(String nazivK){
		Komponenta retVal =  null;
		boolean sadrzi =false;
		Komponenta temp = new Komponenta();
		for (Komponenta k : komponente ){
			if (k.getNaziv().toLowerCase() == nazivK.toLowerCase()){
				sadrzi=true;
				temp = k;
				break;
			}
		}
		if(sadrzi){
			retVal=temp;			
		}
		return retVal;
	}
	public Uredjaj findUredjaj(String nazivK){
		Uredjaj retVal =  null;
		boolean sadrzi =false;
		Uredjaj temp = new Uredjaj();
		for (Uredjaj k : uredjaji ){
			if (k.getNaziv().toLowerCase() == nazivK.toLowerCase()){
				sadrzi=true;
				temp = k;
				break;
			}
		}
		if(sadrzi){
			retVal=temp;			
		}
		return retVal;

	}	
	public Korisnik findKorisnik(String nazivK){
		Korisnik retVal =  null;
		boolean sadrzi =false;
		Korisnik temp = new Korisnik();
		for (Korisnik k : korisnici ){
			if (k.getUserName().toLowerCase() == nazivK.toLowerCase()){
				sadrzi=true;
				temp = k;
				break;
			}
		}
		if(sadrzi){
			retVal=temp;			
		}
		return retVal;
	}
	public void editKategorija(Kategorija k){
		Kategorija temp = findKategorija(k.getNaziv());
		kategorije.remove(temp);
		kategorije.add(k);
		saveKategorije(kategrijaDat);
	}
	public void editKomponente(Komponenta k){
		Komponenta temp = findKomponenta(k.getNaziv());
		komponente.remove(temp);
		komponente.add(k);
		saveKomponente(komponenteDat);
	}
	public void editUredjaj(Uredjaj u){
		Uredjaj temp = findUredjaj(u.getNaziv());
		uredjaji.remove(temp);
		uredjaji.add(u);
		saveUredjaji(uredjajiDat);
	}
	public void editKorisnik(Korisnik k){
		Korisnik temp = findKorisnik(k.getUserName());
		korisnici.remove(temp);
		korisnici.add(k);
		saveKorisnik(korisniciDat);
	}
}
