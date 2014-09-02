package repository;

public interface IKomand {
	
	public static final String DODAJ_KATEGORIJU = "DODAJ KATEGORIJU";
	public static final String DODAJ_KOMPONENTU = "DODAJ KOMPONENTU";
	public static final String DODAJ_KORISNIKA = "DODAJ KORISNIKA";
	public static final String DODAJ_RACUN = "DODAJ RACUN";
	public static final String DODAJ_UREDJAJ= "DODAJ UREDJAJ";
	public static final String IZMENI_KATEGORIJU= "IZMENI KATEGORIJU";
	public static final String IZMENI_KOMPONENTU = "IZMENI KOMPONENTU";
	public static final String IZMENI_KORISNIKA ="IZMENI KORISNIKA";
	public static final String IZMENI_UREDJAJ = "IZMENI UREDJAJ";
	public static final String FIND_KOMP_KATEGORIJA = "PRONADJI KOMPONENTU PO KATEGORIJI";
	public static final String FIND_KOMP_NAZIV = "PRONADJI KOMPONENTU PO NAZIVU";
	public static final String FIND_KOMP_OPIS = "PRONADJI KOMPONENTU PO OPISU";
	public static final String FIND_KOMP_OPSEG = "PRONADJI KOMPONENTU PO OPSEGU CENA";
	public static final String FIND_KOMP_KOL = "PRONADJI KOMPONENTU PO KOLICINI";
	public static final String FIND_URE_KOMP = "PRONADJI UREDJAJE PO KOMPONENTAMA";
	public static final String FIND_URE_NAZIV = "PRONADJI UREDJAJE PO NAZIVU";
	public static final String FIND_URE_OPIS = "PRONADJI UREDJAJE PO OPISU";
	public static final String LIST_KAT = "GET ALL KATEGORIJE";
	public static final String LIST_KOMP = "GET ALL KOMPONENTE";
	public static final String LIST_KOR = "GET ALL KORISNICI";
	public static final String LIST_URE = "GET ALL UREDJAJE";
	public static final String LIST_RACUNI = "GET ALL RACUNI";
	public static final String IZVESTAJ_OD_DO = "IZVESTAJI U PERIODU";
	public static final String DEL_KAT = "REMOVE KATEGORIJA";
	public static final String DEL_KOMP = "REMOVE KOMPONENTA";
	public static final String DEL_KOR = "REMOVE KORISNIK";
	public static final String DEL_URE = "REMOVE UREDJAJ";
	public static final String GET_KAT = "GET KATEGORIJA BY PK";
	public static final String GET_KOMP = "GET KOMPONENTA BY PK";
	public static final String GET_URE = "GET UREDJAJ BY PK";
	public static final String GET_KOR = "GET KORISNIK BY PK";
}
