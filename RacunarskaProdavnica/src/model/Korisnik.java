package model;

public class Korisnik {

	protected String userName;
	protected String password;
	protected String name;
	protected String surName;
	protected boolean isAdimn;
	protected String telephoneNumber;
	protected String emailAdress;
	
	public Korisnik (){
		userName ="";
		password="";
		name = "";
		surName= "";
		isAdimn=false;
		telephoneNumber="";
		emailAdress="";
	}
	public Korisnik (String aUserName,String aPassword,String aName,String aSurName,
			boolean aIsAdimn,String AtelephoneNumber,String aEmailAdress){
		setUserName(aUserName);
		setPassword(aPassword);
		setName(aName);
		setSurName(aSurName);
		setIsAdimn(aIsAdimn);
		setTelephoneNumber(AtelephoneNumber);
		setEmailAdress(aEmailAdress);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public boolean isAdimn() {
		return isAdimn;
	}

	public void setIsAdimn(boolean isAdimn) {
		this.isAdimn = isAdimn;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	@Override
	public String toString() {
		return "Korisnik [userName=" + userName + ", password=" + password
				+ ", name=" + name + ", surName=" + surName + ", isAdimn="
				+ isAdimn + ", telephoneNumber=" + telephoneNumber
				+ ", emailAdress=" + emailAdress + "]";
	}
	
}
