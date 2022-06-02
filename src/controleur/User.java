package controleur;

public class User {
	private int iduser;
	private String username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type;
	
	public User(int iduser, String username, String prenom, String dateNaissance, String ville, String cp, String adresse, String tel, String nom, String mail, String password, String type) {
		//username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password
		this.iduser = iduser;
		this.username = username;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.ville = ville;
		this.cp = cp;
		this.adresse = adresse;
		this.tel = tel;
		this.nom = nom;
		this.mail = mail;
		this.password = password;
		this.type = type;
	} 
	
	public User ( String username, String prenom, String dateNaissance, String ville, String cp, String adresse, String tel, String nom, String mail, String password, String type) {
		this.iduser = 0;
		this.username = username;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.ville = ville;
		this.cp = cp;
		this.adresse = adresse;
		this.tel = tel;
		this.nom = nom;
		this.mail = mail;
		this.password = password;
		this.type = type;
	} 
	public User () {
		this.iduser = 0;
		this.username = "";
		this.prenom = "";
		this.dateNaissance = "";
		this.ville = "";
		this.cp = "";
		this.adresse = "";
		this.tel = "";
		this.nom = "";
		this.mail = "";
		this.password = "";
		this.type = "";
	}

	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() { return type; }
	public void setType(String type) {
		this.type = type;
	}
}

 