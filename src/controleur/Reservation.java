package controleur;

public class Reservation {
    private int idreser, idhab, iduser ;
    private String dateA, dateD;

    public Reservation(int idreser, String dateA, String dateD, int idhab, int iduser) {
        this.idreser = idreser;
        this.dateA = dateA;
        this.dateD = dateD;
        this.idhab = idhab;
        this.iduser = iduser;
    }

    public Reservation(String dateA, String dateD) {
        this.idreser = 0;
        this.dateA = dateA;
        this.dateD = dateD;
        this.idhab = idhab;
        this.iduser = iduser;
    }

    public Reservation(String dateA, String dateD, int idhab, int iduser) {
        this.idreser = 0;
        this.dateA = dateA;
        this.dateD = dateD;
        this.idhab = idhab;
        this.iduser = iduser;
    }

    public int getIdReservation() {
        return this.idreser;
    }

    public void setIdReservation(int idreser) {
        this.idreser = idreser;
    }

    public String getDateA() {
        return this.dateA;
    }

    public void setDateA(String dateA) {
        this.dateA = dateA;
    }

    public String getDateD() {
        return this.dateD;
    }

    public void setDateD(String dateD) {
        this.dateD = dateD;
    }

    public int getIdhab() { return this.idhab; }

    public void setIdhab(int habitat) { this.idhab = habitat; }

    public int getIduser() {
        return this.iduser;
    }

    public void setIduser(int idClient) {
        this.iduser = idClient;
    }
}
