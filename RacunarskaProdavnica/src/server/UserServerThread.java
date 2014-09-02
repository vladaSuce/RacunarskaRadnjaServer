package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;














import model.Kategorija;
import model.Komponenta;
import model.Korisnik;
import model.Poruka;
import model.Racun;
import model.Uredjaj;
import repository.IKomand;
import repository.ProdavnicaRacunara;


public class UserServerThread extends Thread {

	private Socket sock;
	private  ProdavnicaRacunara prodavnica;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	public UserServerThread(Socket sock, ProdavnicaRacunara prodavnica) {
		this.sock = sock;
		this.prodavnica = prodavnica;

		try {
			in = new ObjectInputStream(sock.getInputStream());

			out = new ObjectOutputStream(sock.getOutputStream());

			start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run() {

		try {
			Poruka request = (Poruka)in.readObject();
			System.out.println("Incoming request: " + request);
			Object response = clientResponse(request);
			//System.out.println("Outgoing response: " + response);
			out.writeObject(response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			in.close();
			out.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Object clientResponse(Poruka request) {

		if (request.getKomanda().equals(IKomand.DODAJ_KATEGORIJU)) {
			return addKategorija(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DODAJ_KOMPONENTU)) {
			return addKomponenta(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DODAJ_KORISNIKA)) {
			return addKorisnik(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DODAJ_RACUN)) {
			return addRacun(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DODAJ_UREDJAJ)) {
			return addUredjaj(request.getKomanda());
		} else if (request.getKomanda().equals(IKomand.GET_KAT)) {
			return getKategorija(request.getKomanda());	
		} else if (request.getKomanda().equals(IKomand.GET_KOMP)) {
			return getKomponenta(request.getKomanda());	
		} else if (request.getKomanda().equals(IKomand.GET_KOR)) {
			return getKorisnik(request.getKomanda());
		} else if (request.getKomanda().equals(IKomand.GET_URE)) {
			return getUredjaj(request.getKomanda());
		} else if (request.getKomanda().equals(IKomand.IZMENI_KATEGORIJU)) {
			return editKategorija(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.IZMENI_KOMPONENTU)) {
			return editKomponenta(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.IZMENI_KORISNIKA)) {
			return editKorisnik(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.IZMENI_UREDJAJ)) {
			return editUredjaj(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DEL_KAT)) {
			return removeKategorija(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DEL_KOMP)) {
			return removeKomponenta(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DEL_KOR)) {
			return removeKorisnik(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.DEL_URE)) {
			return removeUredjaj(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_KOMP_KATEGORIJA)) {
			return findKomponentaByKategorija(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_KOMP_KOL)) {
			return findKomponentaByRaspolozivaKolicina(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_KOMP_NAZIV)) {
			return findKomponentaByNziv(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_KOMP_OPIS)) {
			return findKomponentaByOpis(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_KOMP_OPSEG)) {
			return findKomponentaByOpsegCene(request.getPodatak(), request.getDodatniPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_URE_KOMP)) {
			return findUredjajByKomponente(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_URE_NAZIV)) {
			return findUredjajByNaziv(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.FIND_URE_OPIS)) {
			return findUredjajByOpis(request.getPodatak());
		} else if (request.getKomanda().equals(IKomand.LIST_KAT)) {
			return listKategorije();
		}else if (request.getKomanda().equals(IKomand.LIST_KOMP)) {
			return listKomponente();
		}else if (request.getKomanda().equals(IKomand.LIST_KOR)) {
			return listKorisnici();
		}else if (request.getKomanda().equals(IKomand.LIST_RACUNI)) {
			return listRacuni();
		}else if (request.getKomanda().equals(IKomand.LIST_URE)) {
			return listUredjaji();
		}
		System.err.println("Unknown request: " + request);
		return null;
	}

	private Object addKategorija(Object kategorija) {
		try {
			prodavnica.addKategorija((Kategorija) kategorija);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Object addKomponenta(Object komponenta) {
		try {
			prodavnica.addKomponenta((Komponenta) komponenta);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Object addKorisnik(Object korisnik) {
		try {
			prodavnica.addKorisnik((Korisnik) korisnik);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Object addRacun(Object racun) {
		try {
			prodavnica.addRacun((Racun) racun);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Object addUredjaj(Object uredjaj) {
		try {
			prodavnica.addUredjaj((Uredjaj) uredjaj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private Object editKategorija(Object kategorija) {
		try {
			Kategorija kat = (Kategorija) kategorija;
			prodavnica.editKategorija(kat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	private Object editKomponenta(Object komponenta) {
		try {
			Komponenta komp = (Komponenta) komponenta;
			prodavnica.editKomponente(komp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	private Object editKorisnik(Object korisnik) {
		try {
			Korisnik kor = (Korisnik) korisnik;
			prodavnica.editKorisnik(kor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	private Object editUredjaj(Object uredjaj) {
		try {
			Uredjaj ure = (Uredjaj) uredjaj;
			prodavnica.editUredjaj(ure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private Object removeKategorija(Object nazivK) {
		try {
			prodavnica.removeKategorija((String)nazivK);
			return null;
		} catch (Exception e) {

		}
		return "Kategorija vezana za komponentu";
	}
	private Object removeKomponenta(Object nazivK) {
		try {
			prodavnica.removeKomponenta((String)nazivK);
			return null;
		} catch (Exception e) {

		}
		return "Komponenta vezana za uredjaj";
	}
	private Object removeUredjaj(Object nazivK) {
		try {
			prodavnica.removeUredjaj((String)nazivK);
			return null;
		} catch (Exception e) {

		}
		return "Uredjaj nije dostupan";
	}
	private Object removeKorisnik(Object nazivK) {
		try {
			prodavnica.removeKorisnik((String)nazivK);
			return null;
		} catch (Exception e) {

		}
		return "Korisnik nije dostupan";
	}


	private Object listKomponente() {
		return prodavnica.getKomponente();
	}
	private Object listKategorije() {
		return prodavnica.getKategorije();
	}
	private Object listKorisnici() {
		return prodavnica.getKorisnici();
	}
	private Object listUredjaji() {
		return prodavnica.getUredjaji();
	}
	private Object listRacuni() {
		return prodavnica.getUredjaji();
	}

	private Object getKomponenta(Object komponentaNaziv) {
		try {
			return prodavnica.findKomponenta((String) komponentaNaziv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private Object getKategorija(Object kategorijaNaziv) {
		try {
			return prodavnica.findKategorija((String) kategorijaNaziv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private Object getKorisnik(Object korisnikNaziv) {
		try {
			return prodavnica.findKorisnik((String) korisnikNaziv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private Object getUredjaj(Object uredjajNaziv) {
		try {
			return prodavnica.findUredjaj((String) uredjajNaziv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
private Object login(Object data) {
	try {
		String dat = (String) data;
		StringTokenizer st = new StringTokenizer(dat, "|");
		while (st.hasMoreTokens()) {
			String username = st.nextToken();
			String password = st.nextToken();
			return galerija.login(username, password);
		}
		return new Kustos();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
	 */
	private Object getInfo() {
		return prodavnica.toString();
	}
	private Object findKomponentaByNziv(Object naziv){
		ArrayList retList = new ArrayList<>();
		ArrayList<Komponenta> tempList = prodavnica.getKomponente();
		for(Komponenta k : tempList){
			if (k.getNaziv().toLowerCase().contains(((String)naziv).toLowerCase()))
				retList.add(k);
		}
		return retList;
	}
	private Object findKomponentaByOpsegCene(Object cenaOd,Object cenaDo){
		ArrayList retList = new ArrayList<>();
		ArrayList<Komponenta> tempList = prodavnica.getKomponente();
		for(Komponenta k : tempList){
			if(k.getCena()>= (double)cenaOd && k.getCena() <= (double)cenaDo)
				retList.add(k);
		}
		return retList;
	}
	private Object findKomponentaByRaspolozivaKolicina(Object kolicina){
		ArrayList retList = new ArrayList<>();
		ArrayList<Komponenta> tempList = prodavnica.getKomponente();
		for(Komponenta k : tempList){
			if(k.getRaspoloziva_kolicina()>= (Integer)kolicina)
				retList.add(k);
		}
		return retList;
	}
	private Object findKomponentaByOpis(Object opis){
		ArrayList retList = new ArrayList<>();
		ArrayList<Komponenta> tempList = prodavnica.getKomponente();
		for(Komponenta k : tempList){
			if(k.getOpis().toLowerCase().contains(((String)opis).toLowerCase()))
				retList.add(k);
		}
		return retList;
	}

	private Object findKomponentaByKategorija(Object nazivKategorije){
		ArrayList retList = new ArrayList<>();
		Kategorija kat = prodavnica.findKategorija((String)nazivKategorije);
		ArrayList<Komponenta> tempList = prodavnica.getKomponente();
		for(Komponenta k : tempList){
			if(k.getKategorija().equals(kat))
				retList.add(k);
		}
		return retList;
	}
	private Object findUredjajByNaziv(Object naziv){
		ArrayList retList = new ArrayList<>();
		ArrayList<Uredjaj> tempList = prodavnica.getUredjaji();
		for(Uredjaj u : tempList){
			if (u.getNaziv().toLowerCase().contains(((String)naziv).toLowerCase()))
				retList.add(u);
		}
		return retList;
	}
	private Object findUredjajByOpis(Object opis){
		ArrayList retList = new ArrayList<>();
		ArrayList<Uredjaj> tempList = prodavnica.getUredjaji();
		for(Uredjaj u : tempList){
			if(u.getOpis().toLowerCase().contains(((String)opis).toLowerCase()))
				retList.add(u);
		}
		return retList;
	}
	private Object findUredjajByKomponente(Object listaKomponenti){
		ArrayList<Object> tempList = (ArrayList<Object>)listaKomponenti;
		ArrayList<Komponenta>tempKompList = new ArrayList<Komponenta>();
		ArrayList retVal = new ArrayList<>();
		for (Object o : tempList){
			Komponenta k = (Komponenta)o;
			tempKompList.add(k);
		}
		if(tempKompList.size()> 0 && tempKompList != null){
			for(Komponenta k : tempKompList){
				ArrayList<Uredjaj>tempUredjaji =  prodavnica.getUredjaji();
				for(Uredjaj u : tempUredjaji){
					if(u.getKomponente().contains(k)){
						if(!retVal.contains(u)){
							retVal.add(u);
						}
					}
				}
			}
		}
		return retVal;
	}
	private Object getIzvestajOdDo(Object datumOd,Object datumDo){

		Date datum1 = (Date)datumOd;
		Date datum2 = (Date)datumDo;
		int brojDanaIzmedju = datum1.compareTo(datum2);
		ArrayList<Racun> racuni = prodavnica.getRacuni();
		HashMap<Date, Double>izvestaji = new HashMap<>();
		for(int j=0; j<=brojDanaIzmedju;j++){
			izvestaji.put(datum1, 0.0);
			datum1.setDate(datum1.getDate()+1);
		}
		Iterator iter = izvestaji.keySet().iterator();
		while(iter.hasNext()){
			Date tempDatum =(Date) iter.next();
			for(Racun r : racuni){
				if(r.getDate().compareTo(tempDatum)==0){
					double vrednost = izvestaji.get(tempDatum);
					vrednost = vrednost + r.getUkupna_cena();
					izvestaji.remove(tempDatum);
					izvestaji.put(tempDatum, vrednost);
				}
			}
		}
		return izvestaji;
	}


}

