package vue;

import controleur.Main;
import controleur.Tableau;
import controleur.Employe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class VueEmploye extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ;
	/************************** Panel Ajout Client *********/
	private JPanel panelInsert = new JPanel();
	private JTextField txtUsername = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtNom= new JTextField();
	private JTextField txtMail = new JTextField();
	private JTextField txtPassword = new JTextField();
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

	public VueEmploye() {
		this.setTitle("Gestion des clients Feu-Vert");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		/******************** Construction BT Retour **********/
		this.btRetour.setBounds(400, 440, 200, 30);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		
		/**************** Construction Panel Insert ***************/
		//idemploye, username, prenom, nom, mail, password
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(new Color (40, 92, 247));
		this.panelInsert.setLayout(new GridLayout(8,2));
		this.panelInsert.add(new JLabel("Username : "));
		this.panelInsert.add(this.txtUsername);
		this.panelInsert.add(new JLabel("Prénom : "));
		this.panelInsert.add(this.txtPrenom);
		this.panelInsert.add(new JLabel("Nom : "));
		this.panelInsert.add(this.txtNom);
		this.panelInsert.add(new JLabel("Mail : "));
		this.panelInsert.add(this.txtMail);
		this.panelInsert.add(new JLabel("Password : "));
		this.panelInsert.add(this.txtPassword);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(new Color (40, 92, 247));
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Client","Nom Client", "Prénom", "Adresse", "Email", "Téléphone"};
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
						int idemploye = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
						Main.deleteUser(idemploye);
						unTableau.supprimerLigne(indiceLigne);
					}
				}else if (e.getClickCount() == 1)
				{//idemploye, username, prenom, nom, mail, password Employe unEmploye
					int indiceLigne = uneTable.getSelectedRow(); 
					txtUsername.setText(unTableau.getValueAt(indiceLigne,1).toString());
					txtPrenom.setText(unTableau.getValueAt(indiceLigne,2).toString());
					txtNom.setText(unTableau.getValueAt(indiceLigne,3).toString());
					txtMail.setText(unTableau.getValueAt(indiceLigne,4).toString());
					txtPassword.setText(unTableau.getValueAt(indiceLigne,5).toString());
					btEnregistrer.setText("Modifier");
				}
			}
		});
		
		this.setVisible(true);
	}
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des clients en une matride d'objets 
		ArrayList<Employe> lesEmployes = Main.selectAllEmploye(mot);
		Object [][] matrice = new Object [lesEmployes.size()][8];
		int i = 0; 
		for (Employe unEmploye : lesEmployes)
		{//idemploye, username, prenom, nom, mail, password
			matrice [i][0] = unEmploye.getIdemploye();
			matrice [i][1] = unEmploye.getUsername();
			matrice [i][2] = unEmploye.getPrenom();
			matrice [i][3] = unEmploye.getNom();
			matrice [i][4] = unEmploye.getMail();
			matrice [i][5] = unEmploye.getPassword();
			i++;
		}
		return matrice;
	}
	
	public void viderChamps () {
		this.txtUsername.setText("");
		this.txtPrenom.setText("");
		this.txtNom.setText("");
		this.txtMail.setText("");
		this.txtPassword.setText("");
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
			//idemploye, username, prenom, nom, mail, password
			String username = this.txtUsername.getText();
			String prenom = this.txtPrenom.getText();
			String nom = this.txtNom.getText();
			String mail = this.txtMail.getText();
			String password = this.txtPassword.getText();
			Employe unEmploye = new Employe(username, prenom, nom, mail, password);
			Main.insertEmploye(unEmploye);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau client !");
			this.viderChamps();
			
			//extraction de l'ID du dernier client inséré
			unEmploye = Main.selectWhereEmploye(mail);
			//actualisation de l'affichage 
			Object ligne[] = {unEmploye.getIdemploye(), username, prenom, nom, mail, password};
			this.unTableau.ajouterLigne(ligne);
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText(); 
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{//idemploye, username, prenom, nom, mail, password
			int indiceLigne = uneTable.getSelectedRow(); 
			int idemploye = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un client, on l'ajoute au bdd 
			String username = this.txtUsername.getText();
			String prenom = this.txtPrenom.getText();
			String nom = this.txtNom.getText();
			String mail = this.txtMail.getText();
			String password = this.txtPassword.getText();
			Employe unEmploye = new Employe (idemploye, username, prenom, nom, mail, password);
			Main.updateEmploye(unEmploye);
			//actualisation de l'affichage 
			Object ligne[] = {idemploye, username, prenom, nom, mail, password, };
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du client !");
			this.viderChamps();
		}
	}
}








