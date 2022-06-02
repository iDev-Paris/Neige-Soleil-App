package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import controleur.User;
import controleur.Main;
import controleur.Tableau;

public class VueUsers extends JFrame implements ActionListener
{	//username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Client *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtUsername = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtDateNaissance = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtNom= new JTextField();
	private JTextField txtMail = new JTextField();
	private JTextField txtPassword = new JTextField();
	private JTextField txtType = new JTextField();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Client *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ;
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les clients par mot clé : "); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueUsers() {
		this.setTitle("Gestion des clients Feu-Vert");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (40, 92, 247));
		
		
		/******************** Construction BT Retour **********/
		this.btRetour.setBounds(400, 440, 200, 30);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		
		/**************** Construction Panel Insert ***************/
		//username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(new Color (40, 92, 247));
		this.panelInsert.setLayout(new GridLayout(12,2));
		this.panelInsert.add(new JLabel("Username : "));
		this.panelInsert.add(this.txtUsername);
		this.panelInsert.add(new JLabel("Prénom : "));
		this.panelInsert.add(this.txtPrenom);
		this.panelInsert.add(new JLabel("Date de naissance : "));
		this.panelInsert.add(this.txtDateNaissance);
		this.panelInsert.add(new JLabel("Ville : "));
		this.panelInsert.add(this.txtVille);
		this.panelInsert.add(new JLabel("Code postal : "));
		this.panelInsert.add(this.txtCp);
		this.panelInsert.add(new JLabel("Adresse : "));
		this.panelInsert.add(this.txtAdresse);
		this.panelInsert.add(new JLabel("Téléphone : "));
		this.panelInsert.add(this.txtTel);
		this.panelInsert.add(new JLabel("Nom : "));
		this.panelInsert.add(this.txtNom);
		this.panelInsert.add(new JLabel("Mail : "));
		this.panelInsert.add(this.txtMail);
		this.panelInsert.add(new JLabel("Password : "));
		this.panelInsert.add(this.txtPassword);
		this.panelInsert.add(new JLabel("Vous êtes ? : "));
		this.panelInsert.add(this.txtType);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(new Color (40, 92, 247));
		this.panelLister.setLayout(null);
		String entetes[] = {"ID", "Username", "Prénom " ,"Date de naissance", "Ville" ,"Code postal" ,"Adresse", "Nom" ,"Mail" ,"Password", "Vous êtes ?"};
		//instanciation de la classe tableau donnees et entetes 
		this.unTableau = new Tableau(this.remplirDonnees(""), entetes);
		//instanciation de la Jtable sur la tableModel unTableau
		this.uneTable = new JTable(unTableau); 
		
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.uneScroll.setBounds(0, 20, 460, 280);
		this.panelLister.add(this.uneScroll); 
		this.add(this.panelLister); 
		
		/**************** Construction Panel Filtrer ***************/
		this.panelFiltrer.setBounds(420, 40, 380, 25);
		this.panelFiltrer.setBackground(new Color (40, 92, 247));
		this.panelFiltrer.setLayout(new GridLayout(1, 3));
		this.panelFiltrer.add(this.lbRecherche); 
		this.panelFiltrer.add(this.txtMot); 
		this.panelFiltrer.add(this.btFiltrer); 
		this.add(this.panelFiltrer);
		this.btFiltrer.addActionListener(this);
		
		/*********************** rendre les boutons *****************/
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		//gestion de la modification et de la suppression d'un client 
		this.uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce client ?", 
							"Suppression Client", JOptionPane.YES_NO_OPTION); 
					if (retour == 0)
					{
						JOptionPane.showMessageDialog(null, "Client supprimé ");
						int indiceLigne = uneTable.getSelectedRow(); 
						int iduser = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
						Main.deleteUser(iduser);
						unTableau.supprimerLigne(indiceLigne);
					}
				}else if (e.getClickCount() == 1)
				{
					int indiceLigne = uneTable.getSelectedRow(); 
					txtUsername.setText(unTableau.getValueAt(indiceLigne,1).toString());
					txtPrenom.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
					txtDateNaissance.setText(unTableau.getValueAt(indiceLigne,3).toString());
					txtVille.setText(unTableau.getValueAt(indiceLigne,4).toString());
					txtCp.setText(unTableau.getValueAt(indiceLigne,5).toString());
					txtAdresse.setText(unTableau.getValueAt(indiceLigne,6).toString());
					txtTel.setText(unTableau.getValueAt(indiceLigne,7).toString());
					txtNom.setText(unTableau.getValueAt(indiceLigne,8).toString());
					txtMail.setText(unTableau.getValueAt(indiceLigne,9).toString());
					txtPassword.setText(unTableau.getValueAt(indiceLigne,10).toString());
					txtPassword.setText(unTableau.getValueAt(indiceLigne,11).toString());
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		this.setVisible(true);
	}
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des clients en une matride d'objets 
		ArrayList<User> lesUsers = Main.selectAllUser(mot);
		Object [][] matrice = new Object [lesUsers.size()][12];
		int i = 0; 
		for (User unUser : lesUsers)
		{
			matrice [i][0] = unUser.getIduser();
			matrice [i][1] = unUser.getUsername();
			matrice [i][2] = unUser.getPrenom();
			matrice [i][3] = unUser.getDateNaissance();
			matrice [i][4] = unUser.getVille();
			matrice [i][5] = unUser.getCp();
			matrice [i][6] = unUser.getAdresse();
			matrice [i][7] = unUser.getTel();
			matrice [i][8] = unUser.getNom();
			matrice [i][9] = unUser.getMail();
			matrice [i][10] = unUser.getPassword();
			matrice [i][11] = unUser.getType();
			i++;
		}
		return matrice;
	}
	
	public void viderChamps () {
		//iduser, username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type
		this.txtUsername.setText("");
		this.txtPrenom.setText("");
		this.txtDateNaissance.setText("");
		this.txtVille.setText("");
		this.txtCp.setText("");
		this.txtAdresse.setText("");
		this.txtTel.setText("");
		this.txtNom.setText("");
		this.txtMail.setText("");
		this.txtPassword.setText("");
		this.txtType.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour)
		{
			this.dispose(); //on tue la vue Clients 
			Main.rendreVisible(true);
			
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer"))
		{
			//on récupère les données, on instancie un client, on l'ajoute au bdd
			//iduser, username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type
			String username = this.txtUsername.getText();
			String prenom = this.txtPrenom.getText();
			String dateNaissance = this.txtDateNaissance.getText();
			String ville = this.txtVille.getText();
			String cp = this.txtCp.getText();
			String adresse = this.txtAdresse.getText();
			String tel = this.txtTel.getText();
			String nom = this.txtNom.getText();
			String mail = this.txtMail.getText();
			String password = this.txtPassword.getText();
			String type = this.txtType.getText();
			User unUser = new User(0,username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type);
			Main.insertUser(unUser);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau client !");
			this.viderChamps();
			
			//extraction de l'ID du dernier client inséré
			unUser = Main.selectWhereUser(mail);
			//actualisation de l'affichage 
			Object ligne[] = {unUser.getIduser(), username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type};
			this.unTableau.ajouterLigne(ligne);
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText(); 
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{
			int indiceLigne = uneTable.getSelectedRow(); 
			int iduser = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un client, on l'ajoute au bdd 
			String username = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String dateNaissance = this.txtDateNaissance.getText();
			String ville = this.txtVille.getText();
			String cp = this.txtCp.getText();
			String adresse = this.txtAdresse.getText();
			String tel = this.txtTel.getText();
			String nom = this.txtNom.getText();
			String mail = this.txtMail.getText();
			String password = this.txtPassword.getText();
			String type = this.txtType.getText();
			User unUser = new User(iduser, username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type);
			Main.updateUser(unUser);
			//actualisation de l'affichage 
			Object ligne[] = {iduser, username, prenom, dateNaissance, ville, cp, adresse, tel, nom, mail, password, type};
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du client !");
			this.viderChamps();
		}
	}
}








