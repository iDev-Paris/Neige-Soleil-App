package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.User;
import controleur.Employe;
import controleur.Habitat;
import controleur.Reservation;
public class Modele {

	private static BDD uneBdd = new BDD("localhost", "neigesoleil", "root", ""); //pour PC

	public static void executerRequete(String requete) {
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
	}

	/************************************************ Modele User *************************************/

	public static void insertUser(User unUser)
	//username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password
	{
		String requete = "insert into user values (null, '" + unUser.getUsername() + "', '" + unUser.getPrenom() + "', '" + unUser.getDateNaissance() + "', '" + unUser.getVille() + "', '" + unUser.getCp() + "','" + unUser.getAdresse() + "','" + unUser.getTel()
				+ "','" + unUser.getNom() + "','" + unUser.getMail() + "','" + unUser.getPassword() + "' ," + unUser.getType() + ");";
		executerRequete(requete);
	}

	public static void deleteUser(int iduser) {
		String requete = "delete from user where iduser =  " + iduser + ";";
		executerRequete(requete);
	}

	public static void updateUser(User unUser) {
		String requete = "update user set nom = '" + unUser.getUsername() + "', '" + unUser.getPrenom() + "', '" + unUser.getDateNaissance() + "', '" + unUser.getVille() + "', '" + unUser.getCp() + "','" + unUser.getAdresse() + "','" + unUser.getTel()
				+ "','" + unUser.getNom() + "','" + unUser.getMail() + "'," + unUser.getPassword() + " ," + unUser.getType() + ");";
		executerRequete(requete);
	}

	public static User selectWhereUser(int iduser) {
		User unUser = null;
		String requete = "select * from user where iduser =  " + iduser + ";";
		//System.out.println(requete);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unUser = new User(
						unRes.getInt("iduser"),
						unRes.getString("username"),
						unRes.getString("prenom"),
						unRes.getString("dateNaissance"),
						unRes.getString("ville"),
						unRes.getString("cp"),
						unRes.getString("adresse"),
						unRes.getString("tel"),
						unRes.getString("nom"),
						unRes.getString("mail"),
						unRes.getString("password"),
						unRes.getString("type")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unUser;
	}

	public static User selectWhereUser(String mail) {
		User unUser = null;
		String requete = "select * from user where mail =  '" + mail + "' ;";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unUser = new User(
						unRes.getInt("iduser"),
						unRes.getString("username"),
						unRes.getString("prenom"),
						unRes.getString("dateNaissance"),
						unRes.getString("ville"),
						unRes.getString("cp"),
						unRes.getString("adresse"),
						unRes.getString("tel"),
						unRes.getString("nom"),
						unRes.getString("mail"),
						unRes.getString("password"),
						unRes.getString("type")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unUser;
	}

	public static ArrayList<User> selectAllUser(String mot) {
		ArrayList<User> lesUsers = new ArrayList<User>();
		String requete = "";
		if (mot.equals("")) {
			requete = "select * from user ;";
		} else {
			requete = "select * from user where nom like '%" + mot + "%'  or prenom like '%" + mot + "%' "
					+ " or username like '%" + mot + "%' ; ";
		}

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				//instanciation du produit resultat
				User unUser = new User(
						desRes.getInt("iduser"),
						desRes.getString("username"),
						desRes.getString("prenom"),
						desRes.getString("dateNaissance"),
						desRes.getString("ville"),
						desRes.getString("cp"),
						desRes.getString("adresse"),
						desRes.getString("tel"),
						desRes.getString("nom"),
						desRes.getString("mail"),
						desRes.getString("password"),
						desRes.getString("type")
				);
				//Ajout du client dans la liste des clients
				lesUsers.add(unUser);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesUsers;
	}

	/************************************************ Modele Habitat *************************************/

	public static void insertHabitat(Habitat unHabitat) {
		String requete = "insert into habitat values (null, '" + unHabitat.getNom() + "', '" + unHabitat.getDescription() + "', '" + unHabitat.getNbpersonne() + "', '" + unHabitat.getVacant() + "');";
		executerRequete(requete);
	}

	public static void deleteHabitat(int idhab) {
		String requete = "delete from habitat where idhab =  " + idhab + ";";
		executerRequete(requete);
	}

	public static void updateHabitat(Habitat unHabitat) {
		String requete = "update habitat set nom = ''" + unHabitat.getNom() + "', '" + unHabitat.getDescription() + "', '" + unHabitat.getNbpersonne() + "', '" + unHabitat.getVacant() + "' ; ";
		executerRequete(requete);
	}

	public static Habitat selectWhereHabitat(int idhab) {
		Habitat unHabitat = null;
		String requete = "select * from habitat where idhab =  " + idhab + ";";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unHabitat = new Habitat(
						unRes.getInt("idhab"),
						unRes.getString("nom"),
						unRes.getString("description"),
						unRes.getString("nbpersonne"),
						unRes.getString("vacant")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unHabitat;
	}

	public static Habitat selectWhereHabitat(String nom) {
		Habitat unHabitat = null;
		String requete = "select * from habitat where nom =  '" + nom + "' ;";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unHabitat = new Habitat(
						unRes.getInt("idhab"),
						unRes.getString("nom"),
						unRes.getString("description"),
						unRes.getString("nbpersonne"),
						unRes.getString("vacant")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unHabitat;
	}

	public static ArrayList<Habitat> selectAllHabitat(String mot) {
		ArrayList<Habitat> lesHabitats = new ArrayList<Habitat>();
		String requete = "";
		if (mot.equals("")) {
			requete = "select * from habitat ;";
		} else {
			requete = "select * from habitat where nom like '%" + mot + "%'  or description like '%" + mot + "%'; ";
		}

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				//instanciation du produit resultat
				Habitat unHabitat = new Habitat(
						desRes.getInt("idhab"),
						desRes.getString("nom"),
						desRes.getString("description"),
						desRes.getString("nbpersonne"),
						desRes.getString("vacant")
				);
				//Ajout du client dans la liste des clients
				lesHabitats.add(unHabitat);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesHabitats;
	}

	/************************************************ Modele Employe *************************************/
	public static void insertEmploye(Employe unEmploye) {
		String requete = "insert into employe values (null, '" + unEmploye.getUsername() + "', '" + unEmploye.getPrenom() + "', '" + unEmploye.getNom() + "', '" + unEmploye.getMail() + "', '" + unEmploye.getPassword() + "');";
		executerRequete(requete);
	}

	public static void deleteEmploye(int idemploye) {
		String requete = "delete from employe where idemploye =  " + idemploye + ";";
		executerRequete(requete);
	}

	public static void updateEmploye(Employe unEmploye) {
		String requete = "update employe set nom = '" + unEmploye.getUsername() + "', '" + unEmploye.getPrenom() + "', '" + unEmploye.getNom() + "', '" + unEmploye.getMail() + "', '" + unEmploye.getPassword() + "' ; ";
		executerRequete(requete);
	}

	public static Employe selectWhereEmploye(int idemploye) {
		Employe unEmploye = null;
		String requete = "select * from employe where idemploye =  " + idemploye + ";";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unEmploye = new Employe(
						unRes.getInt("idemploye"),
						unRes.getString("username"),
						unRes.getString("prenom"),
						unRes.getString("nom"),
						unRes.getString("mail"),
						unRes.getString("password")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unEmploye;
	}

	public static Employe selectWhereEmploye(String mail) {
		Employe unEmploye = null;
		String requete = "select * from employe where mail =  '" + mail + "' ;";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unEmploye = new Employe(
						unRes.getInt("idemploye"),
						unRes.getString("username"),
						unRes.getString("prenom"),
						unRes.getString("nom"),
						unRes.getString("mail"),
						unRes.getString("password")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unEmploye;
	}

	public static ArrayList<Employe> selectAllEmploye(String mot) {
		ArrayList<Employe> lesEmployes = new ArrayList<Employe>();
		String requete = "";
		if (mot.equals("")) {
			requete = "select * from employe ;";
		} else {
			requete = "select * from employe where nom like '%" + mot + "%'  or prenom like '%" + mot + "%' or qualification like '%" + mot + "%' or email like '%" + mot + "%' ; ";
		}

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				//instanciation du produit resultat
				Employe unEmploye = new Employe(
						desRes.getInt("idemploye"),
						desRes.getString("username"),
						desRes.getString("prenom"),
						desRes.getString("nom"),
						desRes.getString("mail"),
						desRes.getString("password")
				);
				//Ajout du Technicien dans la liste des Techniciens 
				lesEmployes.add(unEmploye);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesEmployes;
	}


	public static Employe selectWhereEmploye(String mail, String password) {
		Employe unEmploye = null;
		String requete = "select * from employe where mail =  '" + mail + "' and password ='" + password + "' ;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				//instanciation du produit resultat
				unEmploye = new Employe(
						unRes.getInt("idemploye"),
						unRes.getString("username"),
						unRes.getString("prenom"),
						unRes.getString("nom"),
						unRes.getString("mail"),
						unRes.getString("password")
				);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unEmploye;
	}

	/************************************************ Modele Reservation *************************************/

	public static void insertReservation(Reservation unReservation) {
		String requete = "insert into reservation values (null, '" + unReservation.getDateA() + "', '" + unReservation.getDateD() + "', " + unReservation.getIdhab() + ", " + unReservation.getIduser() + ");";
		executerRequete(requete);
	}

	public static void deleteReservation(int idreser) {
		String requete = "delete from reservation where idreser =  " + idreser + ";";
		executerRequete(requete);
	}// int idreser, String dateA, String dateD, String habitat, int iduser

	public static void updateReservation(Reservation unReservation) {
		String requete = "update reservation set dateA = '" + unReservation.getDateA() + "', '" + unReservation.getDateA() + "', " + unReservation.getIdhab() + ", " + unReservation.getIduser() + "" + "  where idhab =  " + unReservation.getIdReservation() + " ; ";
		executerRequete(requete);
	}

	public static Reservation selectWhereReservation(int idreser) {
		Reservation unReservation = null;
		String requete = "select * from reservation where idreser=  " + idreser + ";";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {

				// int idreser, String dateA, String dateD, String habitat, int iduser
				unReservation = new Reservation(
						unRes.getInt("idreser"),
						unRes.getString("dateA"),
						unRes.getString("dateD"),
						unRes.getInt("idhab"),
						unRes.getInt("iduser"));
			}

			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException var5) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}

		return unReservation;
	}

	public static Reservation selectWhereReservation(String dateA, String dateD) {
		Reservation unReservation = null;
		String requete = "select * from reservation where dateA =  '" + dateA + "'  and dateD ='"+ dateD +"';";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unReservation = new Reservation(
						unRes.getInt("idreser"),
						unRes.getString("dateA"),
						unRes.getString("dateD"),
						unRes.getInt("idhab"),
						unRes.getInt("iduser"));
			}// int idreser, String dateA, String dateD, String habitat, int iduser

			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException var5) {
			System.out.println("Impossible d'exÃ©cuter la requete : " + requete);
		}

		return unReservation;
	}

	public static ArrayList<Reservation> selectAllReservation(String mot) {
		ArrayList<Reservation> lesReservations = new ArrayList();
		String requete = "";
		if (mot.equals("")) {
			requete = "select * from reservation ;";
		} else {
			requete = "select * from reservation where dateA like '%" + mot + "%'  or dateD like '%" + mot + "%'; ";
		}

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);

			while(desRes.next()) {
				Reservation unReservation = new Reservation(
						desRes.getInt("idreser"),
						desRes.getString("dateA"),
						desRes.getString("dateD"),
						desRes.getInt("idhab"),
						desRes.getInt("iduser"));
				lesReservations.add(unReservation);
			}

			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException var6) {
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}

		return lesReservations;
	}

}