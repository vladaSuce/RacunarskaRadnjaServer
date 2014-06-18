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
import java.util.ArrayList;
import java.util.Map;


import model.Kategorija;
import model.Komponenta;
import model.Uredjaj;

public class ProdavnicaRacunara {
	protected ArrayList<Komponenta>komponente;
	protected ArrayList<Uredjaj> uredjaji;
	protected ArrayList<Kategorija>kategorije;
	protected String kategrijaDat ="kategorije.dat";
	protected String komponenteDat="komponente.dat";
	protected String uredjajiDat = "uredaji.dat";
	public ProdavnicaRacunara(){
		komponente = new ArrayList<Komponenta>();
		kategorije = new ArrayList<Kategorija>();
		uredjaji = new ArrayList<Uredjaj>();
		loadKategorije(kategrijaDat);
		loadKomponente(komponenteDat);
		loadUredjaji(uredjajiDat);
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
}
