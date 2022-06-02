package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.VueConnexion;
import vue.VueUsers;
import vue.VueHabitat;
import vue.VueEmploye;
import vue.VueReservation;

public class Main {
	private static VueConnexion uneVueConnexion;
	private static VueUsers uneVueUsers;
	private static VueHabitat uneVueHabitat;
	private static VueEmploye uneVueEmploye;
	private static VueReservation uneVueReservation;

	public static void main(String args[]) {
		uneVueConnexion = new VueConnexion();
	}

	public static void rendreVisible(boolean action) {
		Main.uneVueConnexion.setVisible(action);
	}

	public static void instancierVueClients() {
		Main.uneVueUsers = new VueUsers();
	}

	public static void instancierVueEmploye() {
		Main.uneVueEmploye = new VueEmploye();
	}

	public static void instancierVueHabitat() {
		Main.uneVueHabitat = new VueHabitat();
	}

	public static void instancierVueReservation() {
		Main.uneVueReservation = new VueReservation();
	}

	/********************************* Controleur Client *******************************/
	public static void insertUser(User unUser) {
		//on controle les donnees avant insertion 
		Modele.insertUser(unUser);
	}

	public static void deleteUser(int iduser) {
		Modele.deleteUser(iduser);
	}

	public static void updateUser(User unUser) {
		//on controle les donnees avant insertion 
		Modele.updateUser(unUser);
	}

	public static User selectWhereUser(int iduser) {
		return Modele.selectWhereUser(iduser);
	}

	public static User selectWhereUser(String email) {
		return Modele.selectWhereUser(email);
	}

	public static ArrayList<User> selectAllUser(String mot) {
		return Modele.selectAllUser(mot);
	}

	/********************************* Controleur Habitat *******************************/
	public static void insertHabitat(Habitat unHabitat) {
		//on controle les donnees avant insertion
		Modele.insertHabitat(unHabitat);
	}

	public static void deleteHabitat(int idhab) {
		Modele.deleteHabitat(idhab);
	}

	public static void updateHabitat(Habitat unHabitat) {
		//on controle les donnees avant insertion
		Modele.updateHabitat(unHabitat);
	}

	public static Habitat selectWhereHabitat(int idhab) {
		return Modele.selectWhereHabitat(idhab);
	}

	public static Habitat selectWhereHabitat(String nom) {
		return Modele.selectWhereHabitat(nom);
	}

	public static ArrayList<Habitat> selectAllHabitat(String mot) {
		return Modele.selectAllHabitat(mot);
	}

	/********************************* Controleur Employe *******************************/
	public static void insertEmploye(Employe unEmploye) {
		//on controle les donnees avant insertion 
		Modele.insertEmploye(unEmploye);
	}

	public static void deleteEmploye(int idemploye) {
		Modele.deleteEmploye(idemploye);
	}

	public static void updateEmploye(Employe unEmploye) {
		//on controle les donnees avant insertion 
		Modele.updateEmploye(unEmploye);
	}

	public static Employe selectWhereEmploye(int idEmploye) {
		return Modele.selectWhereEmploye(idEmploye);
	}

	public static Employe selectWhereEmploye(String mail) {
		return Modele.selectWhereEmploye(mail);
	}

	public static ArrayList<Employe> selectAllEmploye(String mot) {
		return Modele.selectAllEmploye(mot);
	}

	public static Employe selectWhereEmploye(String mail, String password) {
		return Modele.selectWhereEmploye(mail, password);
	}

	/********************************* Controleur Reservation *******************************/

	public static void insertReservation(Reservation unReservation) {
		Modele.insertReservation(unReservation);
	}

	public static void deleteReservation(int idreser) {
		Modele.deleteReservation(idreser);
	}

	public static void updateReservation(Reservation unReservation) {
		Modele.updateReservation(unReservation);
	}

	public static Reservation selectWhereReservation(int idreser) {
		return Modele.selectWhereReservation(idreser);
	}

	public static Reservation selectWhereReservation(String dateA, String dateD) {
		return Modele.selectWhereReservation(dateA,dateD);
	}

	public static ArrayList<Reservation> selectAllReservation(String mot) {
		return Modele.selectAllReservation(mot);
	}
}