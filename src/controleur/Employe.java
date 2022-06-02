package controleur;

public class Employe {
    private int idemploye;
    private String username, prenom, nom, mail, password;
   

    public Employe(int idemploye, String username, String prenom, String nom, String mail, String password) {
        this.idemploye = idemploye;
        this.username = username;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
       
    }

    public Employe(String username, String prenom, String nom, String mail, String password) {
        this.idemploye = 0;
        this.username = username;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
     
    }

    public Employe() {
        this.idemploye = 0;
        this.username = "";
        this.prenom = "";
        this.nom = "";
        this.mail = "";
        this.password = "";
       
    }

    public int getIdemploye() {
        return this.idemploye;
    }

    public void setIdemploye(int idemploye) {
        this.idemploye = idemploye;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return this.mail = mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
