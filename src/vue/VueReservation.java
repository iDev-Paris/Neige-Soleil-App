package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.User;
import controleur.Main;
import controleur.Tableau;
import controleur.Reservation;
import controleur.Habitat;

public class VueReservation extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Vehicule *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtDateA = new JTextField();
	private JTextField txtDateD = new JTextField();
	private JComboBox<String> cbxUser= new JComboBox<String>();
	private JComboBox<String> cbxHabitat= new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Vehicule *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ;
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les Véhicules :"); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueReservation() {
		this.setTitle("Gestion des réservations");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (191, 247, 40));
		
		/******************** Construction BT Retour **********/
		this.btRetour.setBounds(400, 440, 200, 30);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		
		/**************** Construction Panel Insert ***************/
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(new Color (40, 199, 247));
		this.panelInsert.setLayout(new GridLayout(5,2));
		this.panelInsert.add(new JLabel("DateA : "));
		this.panelInsert.add(this.txtDateA);
		this.panelInsert.add(new JLabel("DateD : "));
		this.panelInsert.add(this.txtDateD);
		this.panelInsert.add(new JLabel("User : "));
		this.panelInsert.add(this.cbxUser);
		this.panelInsert.add(new JLabel("Habitat : "));
		this.panelInsert.add(this.cbxHabitat);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(new Color (40, 188, 247));
		this.panelLister.setLayout(null);
		String entetes[] = {"idreser","dateA","dateD","User", "Habitat"};
		//instanciation de la classe tableau donnees et entetes 
		this.unTableau = new Tableau(this.remplirDonnees(""), entetes);
		//instanciation de la Jtable sur la tableModel unTableau
		this.uneTable = new JTable(unTableau); 
		
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.uneScroll.setBounds(0, 20, 460, 280);
		this.panelLister.add(this.uneScroll); 
		this.add(this.panelLister); 
		
		/*********************** rendre les boutons *****************/
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		/***************** REMPLIR LES CBX *************************/
		this.remplirCBXHabitat ();
		this.remplirCBXUser ();
		
		/**************** Construction Panel Filtrer ***************/
		this.panelFiltrer.setBounds(420, 40, 380, 25);
		this.panelFiltrer.setBackground(new Color (191, 247, 40));
		this.panelFiltrer.setLayout(new GridLayout(1, 3));
		this.panelFiltrer.add(this.lbRecherche); 
		this.panelFiltrer.add(this.txtMot); 
		this.panelFiltrer.add(this.btFiltrer); 
		this.add(this.panelFiltrer);
		this.btFiltrer.addActionListener(this);
		
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
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette réservation ?",
									"Suppression de la réservation", JOptionPane.YES_NO_OPTION);
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, "Réservation supprimée ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int idreser = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteReservation(idreser);
								unTableau.supprimerLigne(indiceLigne);
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtDateA.setText(unTableau.getValueAt(indiceLigne,1).toString());
							txtDateD.setText(unTableau.getValueAt(indiceLigne,2).toString());
							
							btEnregistrer.setText("Modifier");
						}
						
					}
				});
				
				
		this.setVisible(true);
	}

	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des lesVehicules en une matrice d'objets
		ArrayList<Reservation> lesReservations = Main.selectAllReservation(mot);
		Object [][] matrice = new Object [lesReservations.size()][5];
		int i = 0;
		for (Reservation unReservation : lesReservations)
		{
			matrice[i][0] = unReservation.getIdReservation();
			matrice[i][1] = unReservation.getDateA();
			matrice[i][2] = unReservation.getDateD();
			Habitat unHabitat = Main.selectWhereHabitat(unReservation.getIdhab());
			matrice [i][3] = unHabitat.getIdhab()+"-"+unHabitat.getNom();
			User unUser = Main.selectWhereUser(unReservation.getIduser());
			matrice [i][4] = unUser.getIduser()+"-"+unUser.getUsername();
			i++;
		}
		return matrice;
	}

	public void remplirCBXHabitat() {
		this.cbxHabitat.removeAllItems();
		Iterator var2 = Main.selectAllHabitat("").iterator();

		while(var2.hasNext()) {
			Habitat unHabitat = (Habitat)var2.next();
			this.cbxHabitat.addItem(unHabitat.getIdhab() + " - " + unHabitat.getNom());
		}
	}
	public void remplirCBXUser() {
		this.cbxUser.removeAllItems();
		Iterator var2 = Main.selectAllUser("").iterator();

		while(var2.hasNext()) {
			User unClient = (User)var2.next();
			this.cbxUser.addItem(unClient.getIduser() + " - " + unClient.getNom() + " - " + unClient.getPrenom());
		}

	}
	public void viderChamps ()
	{
		this.txtDateA.setText("");
		this.txtDateD.setText("");
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
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) {
			//on récupère les données, on instancie un client, on l'ajoute au bdd 
			String DateA = this.txtDateA.getText();
			String DateD = this.txtDateD.getText();
			String chaine = this.cbxHabitat.getSelectedItem().toString();
			String chaine2 = this.cbxUser.getSelectedItem().toString();
			String tab[] = chaine.split(" - ");
			String tab2[] = chaine2.split(" - ");
			int iduser = Integer.parseInt(tab[0]);
			int idhab = Integer.parseInt(tab2[0]);
			
			Reservation unReservation = new Reservation(DateA,DateD,idhab, iduser);
			Main.insertReservation(unReservation);
			JOptionPane.showMessageDialog(this, "Réservation enregistrée !");
			this.viderChamps();
			
			//extraction de l'ID du dernier vehicule inséré
			unReservation = Main.selectWhereReservation(DateA, DateD);
			//actualisation de l'affichage
			Object ligne[] = {unReservation.getIdReservation(), DateA, DateD, idhab ,iduser};
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
			int idReservation = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			// on récupère les données, on instancie un véhicule, on l'ajoute au bdd
			String DateA = this.txtDateA.getText();
			String DateD = this.txtDateD.getText();

			String chaine = this.cbxUser.getSelectedItem().toString();
			String tab [] = chaine.split(" - "); 
			int iduser = Integer.parseInt(tab[0]);
			String chaine2 = this.cbxHabitat.getSelectedItem().toString();
			String tab2 [] = chaine2.split(" - ");
			int idhab = Integer.parseInt(tab2[0]);
			
			Reservation unReservation = new Reservation(idReservation, DateA, DateD,idhab, iduser);
			Main.updateReservation(unReservation);
			//actualisation de l'affichage
			Object ligne[] = {idReservation, DateA, DateD, idhab, iduser};
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie de la réservation !");
			this.viderChamps();
		}
	}
}