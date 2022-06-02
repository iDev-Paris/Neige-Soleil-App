package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controleur.Employe;
import controleur.Main;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	/********************* Instanciation Panel Connexion ************/
	private JPanel panelConnexion = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JTextField txtMail = new JTextField();
	private JPasswordField txtPassword = new JPasswordField();
	
	/********************* Instanciation Panel Menu ************/
	private JPanel panelMenu = new JPanel();
	private JButton btClients = new JButton("Gestion Utlisateurs");
	private JButton btTechniciens = new JButton("Gestion Employes");
	private JButton btVehicules = new JButton("Gestion des Habitations");
	private JButton btEntretiens = new JButton("Gestion des reservations ");
	private JButton btStats = new JButton("Statistiques ");
	private JButton btQuitter = new JButton("Quitter l'application"); 
	
	public  VueConnexion() {
		this.setTitle("Gestion des entretiens Véhicules Feu-Vert");
		this.setBounds(200, 200, 700, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color (40, 92, 247));
		
		
		ImageIcon uneImage = new ImageIcon("src/assets/img/Logo225.png");
		JLabel monLogo = new JLabel(uneImage); 
		monLogo.setBounds(20, 60, 270, 200);
		this.add(monLogo); 
		
		/**************** Construction Panel Connexion ***************/
		this.panelConnexion.setBounds(320, 60, 340, 200);
		this.panelConnexion.setBackground(new Color (40, 92, 247));
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.add(new JLabel("Email : ")); 
		this.panelConnexion.add(this.txtMail);
		this.panelConnexion.add(new JLabel("MDP :")); 
		this.panelConnexion.add(this.txtPassword);
		this.panelConnexion.add(this.btAnnuler); 
		this.panelConnexion.add(this.btSeConnecter); 
		this.add(this.panelConnexion); 
		
		/**************** Construction Panel MENU ***************/
		this.panelMenu.setBounds(320, 60, 340, 200);
		this.panelMenu.setBackground(new Color (40, 92, 247));
		this.panelMenu.setLayout(new GridLayout(3,2));
		this.panelMenu.add(this.btClients); 
		this.panelMenu.add(this.btTechniciens); 
		this.panelMenu.add(this.btVehicules); 
		this.panelMenu.add(this.btEntretiens); 
		this.panelMenu.add(this.btStats); 
		this.panelMenu.add(this.btQuitter); 
		this.add(this.panelMenu); 
		this.panelMenu.setVisible(false);
		
		/****************** Rendre les boutons ecoutables ************/
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btEntretiens.addActionListener(this);
		this.btVehicules.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btTechniciens.addActionListener(this);
		this.txtMail.addKeyListener(this);
		this.txtPassword.addKeyListener(this);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (this.btAnnuler == e.getSource())
		 {
			 this.txtMail.setText("");
			 this.txtPassword.setText("");
		 }
		 else if (e.getSource() == this.btSeConnecter)
		 {
			this.traitement (); 
		 }
		 else if (e.getSource() == this.btQuitter)
		 {
			 int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application", 
					 	"Quitter l'application", JOptionPane.YES_NO_OPTION);
			 if (retour == 0) {
				 				this.panelConnexion.setVisible(true);
				 				this.panelMenu.setVisible(false);
			 	}
		 }
		 
		 else if (e.getSource() == this.btClients)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueClients();
		 }
		 else if (e.getSource() == this.btTechniciens)
		 {
			 Main.rendreVisible(false);
			Main.instancierVueEmploye();
		 }

		 else if (e.getSource() == this.btVehicules)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueHabitat();
		 }

		 else if (e.getSource() == this.btEntretiens)
		 {
			 Main.rendreVisible(false);
			 Main.instancierVueReservation();
		 }
		
	}

	public void traitement ()
	{
		 String mail = this.txtMail.getText();
		 String password = new String (this.txtPassword.getPassword());
		 //on demande au controleur de nous donner le technicien 
		 Employe unEmploye = Main.selectWhereEmploye(mail, password);
		 if (unEmploye == null)
		 {
			 JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants ");
		 }
		 else {
			 JOptionPane.showMessageDialog(this, "Bienvenue  "
					 		+unEmploye.getNom()+" " + unEmploye.getPrenom());
			 
			 //on ouvre le logiciel d'administration et on coupe la connexion 
			 this.panelConnexion.setVisible(false);
			 this.panelMenu.setVisible(true);
		 }
		 this.txtMail.setText("");
		 this.txtPassword.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//sur frappe de touche entrée 
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.traitement(); 
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}









