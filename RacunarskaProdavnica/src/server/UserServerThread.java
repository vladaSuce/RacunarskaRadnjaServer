package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;




import model.Poruka;
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
		return addAutor(request.getPodatak());
	} else if (request.getKomanda().equals("IZMENI AUTORA")) {
		return editAutor(request.getPodatak());
	} else if (request.getKomanda().equals("OBRISI AUTORA")) {
		return removeAutor(request.getPodatak());
	} else if (request.getKomanda().equals("PRONADJI AUTORA")) {
		return getAutor(request.getPodatak());
	} else if (request.getKomanda().equals("DOBAVI AUTORE")) {
		return listAutor();

	} else if (request.getKomanda().equals("DODAJ DELO")) {
		return addDelo(request.getPodatak());
	} else if (request.getKomanda().equals("IZMENI DELO")) {
		return editDelo(request.getPodatak());
	} else if (request.getKomanda().equals("OBRISI DELO")) {
		return removeDelo(request.getPodatak());
	} else if (request.getKomanda().equals("PRONADJI DELO")) {
		return getDelo(request.getPodatak());
	} else if (request.getKomanda().equals("DOBAVI DELA")) {
		return listDelo();

	} else if (request.getKomanda().equals("LOGIN")) {
		return login(request.getPodatak());
	} else if (request.getKomanda().equals("O NAMA")) {
		return getInfo();
	} else if (request.getKomanda().equals("DOBAVI STILOVE")) {
		return getStilovi();
	} else if (request.getKomanda().equals("DOBAVI TEHNIKE")) {
		return getTehnike();
	} else if (request.getKomanda().equals("LIST TEHNIKA DELA")) {
		return listTehnikeDela(request.getPodatak());
	} else if (request.getKomanda().equals("LIST STIL DELA")) {
		return listStiloviDela(request.getPodatak());
	} else if (request.getKomanda().equals("LIST AUTOR DELA")) {
		return listAutorDela(request.getPodatak());
	} else if (request.getKomanda().equals("LIST TEHNIKA AUTORI")) {
		return listTehnikeAutori(request.getPodatak());
	} else if (request.getKomanda().equals("LIST STIL AUTORI")) {
		return listStiloviAutori(request.getPodatak());
	} else if (request.getKomanda().equals("PRETRAZI AUTORE")) {
		return searchAutori(request.getPodatak());
	} else if (request.getKomanda().equals("PRETRAZI DELA")) {
		return searchDela(request.getPodatak());
	}

	System.err.println("Unknown request: " + request);
	return null;
}

private Object addAutor(Object autor) {
	try {
		galerija.dodajAutora((Autor) autor);
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

private Object editAutor(Object autor) {
	try {
		Autor aut = (Autor) autor;
		galerija.izmeniAutora(aut.getIme(), aut.getPrezime(),
				aut.getDatumRodjenja(), aut.getDatumSmrti(),
				aut.getMestoRodjenja(), aut.getMestoSmrti(),
				aut.getBiografija(), aut.isZiv(), aut.getId());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;

}

private Object removeAutor(Object id) {
	try {
		galerija.obrisiAutora((Integer) id);
		return null;
	} catch (Exception e) {

	}
	return "Autor je već vezan za delo";
}

private Object getAutor(Object id) {
	try {
		return galerija.pronadjiAutora((Integer)id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

private Object listAutor() {
	return galerija.getAutori();
}

private Object addDelo(Object delo) {
	try {
		galerija.dodajUmetnickoDelo((UmetnickoDelo) delo);

	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

private Object editDelo(Object delo) {
	try {
		galerija.izmeniUmetnickoDelo((UmetnickoDelo) delo);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

private Object removeDelo(Object delo) {
	try {
		galerija.obrisiUmetnickoDelo((Integer) delo);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

private Object getDelo(Object delo) {
	try {
		return galerija.pronadjiUmetnickoDelo((Integer) delo);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

private Object listDelo() {
	return galerija.getDela();
}

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

private Object getInfo() {
	return galerija.toString();
}

private Object getStilovi() {
	return galerija.getStilovi();
}

private Object getTehnike() {
	return galerija.getTehnike();
}

private Object listStiloviDela(Object data) {
	try {
		String dat = (String) data;
		Collection<UmetnickoDelo> dela = new ArrayList<UmetnickoDelo>();
		for (UmetnickoDelo ud : galerija.getDela()) {
			if (ud.getStil().equals(dat))
				dela.add(ud);
		}
		return dela;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

private Object listAutorDela(Object data) {
	try {
		int dat = (Integer)data;
		Collection<UmetnickoDelo> dela = new ArrayList<UmetnickoDelo>();
		for (UmetnickoDelo ud : galerija.getDela()) {
			if (dat == ud.getIdAutora())
				dela.add(ud);
		}
		return dela;

	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

private Object listTehnikeDela(Object data) {
	try {
		String dat = (String) data;
		Collection<UmetnickoDelo> dela = new ArrayList<UmetnickoDelo>();
		for (UmetnickoDelo ud : galerija.getDela()) {
			if (ud.getTehnika().equals(dat))
				dela.add(ud);
		}
		return dela;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

@SuppressWarnings("unchecked")
private Object listStiloviAutori(Object data) {
	try {
		String dat = (String) data;
		Collection<Autor> autori = new ArrayList<Autor>();
		Collection<UmetnickoDelo> dela = (Collection<UmetnickoDelo>) listStiloviDela(dat);
		for (Autor aut : galerija.getAutori()) {
			for (UmetnickoDelo ud : dela) {
				if (aut.getId() == ud.getIdAutora()) {
					autori.add(aut);
					break;
				}
			}
		}
		return autori;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

@SuppressWarnings("unchecked")
private Object listTehnikeAutori(Object data) {
	try {
		String dat = (String) data;
		Collection<Autor> autori = new ArrayList<Autor>();
		Collection<UmetnickoDelo> dela = (Collection<UmetnickoDelo>) listTehnikeDela(dat);
		for (Autor aut : galerija.getAutori()) {
			for (UmetnickoDelo ud : dela) {
				if (aut.getId() == ud.getIdAutora()) {
					autori.add(aut);
					break;
				}
			}
		}
		return autori;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

private Object searchAutori(Object data) {
	try {
		String dat = ((String)data).toLowerCase();
		Collection<Autor> ret = new ArrayList<Autor>();
		Collection<Autor> autori = galerija.getAutori();

		for (Autor aut : autori) {
			StringTokenizer st = new StringTokenizer(dat, " ");
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (token.equals(String.valueOf(aut.getId()))
						|| aut.getIme().toLowerCase().contains(token)
						|| aut.getPrezime().toLowerCase().contains(token)) {
					ret.add(aut);
					break;
				}
			}
		}
		return ret;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}

}

private Object searchDela(Object data) {
	try {
		String dat = ((String)data).toLowerCase();
		Collection<UmetnickoDelo> ret = new ArrayList<UmetnickoDelo>();
		Collection<UmetnickoDelo> dela = galerija.getDela();

		for (UmetnickoDelo ud : dela) {
			StringTokenizer st = new StringTokenizer(dat, " ");
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				Autor aut = galerija.pronadjiAutora(ud.getIdAutora());
				if (token.equals(String.valueOf(ud.getId()))
						|| ud.getNaslov().toLowerCase().contains(token)
						|| aut.getPrezime().toLowerCase().contains(token)
						|| aut.getIme().toLowerCase().contains(token)) {
					ret.add(ud);
					break;
				}
			}
		}
		return ret;

	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
}

