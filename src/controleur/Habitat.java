package controleur;

public class Habitat

{
	private int idhab;
	private String nom, description, nbpersonne, vacant;


	public Habitat(int idhab, String nom, String description, String nbpersonne, String vacant) {
		this.idhab = idhab;
		this.nom = nom;
		this.description = description;
		this.nbpersonne = nbpersonne;
		this.vacant = vacant;
	}
	public Habitat(String nom, String description, String nbpersonne, String vacant) {
		this.idhab = 0;
		this.nom = nom;
		this.description = description;
		this.nbpersonne = nbpersonne;
		this.vacant = vacant;
	}
	public Habitat( )
	{
		this.idhab = 0;
		this.nom = "";
		this.description = "";
		this.nbpersonne = "";
		this.vacant = "";
	}

	//CREATE TABLE habitat( idhab, nom, description, nbpersonne, vacant,

	public int getIdhab() { return idhab; }
	public void setIdhab(int idhab) { this.idhab = idhab; }

	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public String getNbpersonne() { return nbpersonne; }
	public void setNbpersonne(String nbpersonne) { this.nbpersonne = nbpersonne; }

	public String getVacant() { return vacant; }
	public void setVacant(String vacant) { this.vacant = vacant; }
}


 