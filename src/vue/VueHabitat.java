package vue;

import controleur.Main;
import controleur.Tableau;
import controleur.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class VueHabitat extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ;
	/************************** Panel Ajout Client *********/
	private JPanel panelInsert = new JPanel();
	private JTextField txtNom = new JTextField();
	private JTextField txtDescription = new JTextField();
	private JTextField txtNbpersonne = new JTextField();
	private JTextField txtVacant = new JTextField();
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

	public VueHabitat() {
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
		//idhab, nom, description, nbpersonne, vacant
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(new Color (40, 92, 247));
		this.panelInsert.setLayout(new GridLayout(6,2));
		this.panelInsert.add(new JLabel("Nom : "));
		this.panelInsert.add(this.txtNom);
		this.panelInsert.add(new JLabel("Description : "));
		this.panelInsert.add(this.txtDescription);
		this.panelInsert.add(new JLabel("Nbpersonne : "));
		this.panelInsert.add(this.txtNbpersonne);
		this.panelInsert.add(new JLabel("vacant : "));
		this.panelInsert.add(this.txtVacant);
		this.panelInsert.add(this.btAnnuler);
		this.panelInsert.add(this.btEnregistrer);
		this.add(this.panelInsert);

		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(new Color (40, 92, 247));
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Client","Nom Client", "Prénom", "Adresse", "Email"};
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
				{//idhab, nom, description, nbpersonne, vacant
					int indiceLigne = uneTable.getSelectedRow();
					txtNom.setText(unTableau.getValueAt(indiceLigne,1).toString());
					txtDescription.setText(unTableau.getValueAt(indiceLigne,2).toString());
					txtNbpersonne.setText(unTableau.getValueAt(indiceLigne,3).toString());
					txtVacant.setText(unTableau.getValueAt(indiceLigne,4).toString());
					btEnregistrer.setText("Modifier");
				}

			}
		});

		this.setVisible(true);
	}

	public Object [][] remplirDonnees (String mot)
	{	// idhab, nom, description, nbpersonne, vacant
		//cette fonction transforme l'ArrayList des lesVehicules en une matrice d'objets
		ArrayList<Habitat> lesHabitats = Main.selectAllHabitat(mot);
		Object [][] matrice = new Object [lesHabitats.size()][6];
		int i = 0;
		for (Habitat unHabitat : lesHabitats)
		{
			matrice [i][0] = unHabitat.getIdhab();
			matrice [i][1] = unHabitat.getNom();
			matrice [i][2] = unHabitat.getDescription();
			matrice [i][3] = unHabitat.getNbpersonne();
			matrice [i][4] = unHabitat.getVacant();
			i++;
		}
		return matrice;
	}

	public void viderChamps () {
		// idhab, nom, description, nbpersonne, vacant
		this.txtNom.setText("");
		this.txtDescription.setText("");
		this.txtNbpersonne.setText("");
		this.txtVacant.setText("");
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
			// idhab, nom, description, nbpersonne, vacant
			String nom = this.txtNom.getText();
			String description = this.txtDescription.getText();
			String nbpersonne = this.txtNbpersonne.getText();
			String vacant = this.txtVacant.getText();
			Habitat unHabitat = new Habitat(0,nom, description, nbpersonne, vacant);
			Main.insertHabitat(unHabitat);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau client !");
			this.viderChamps();

			//extraction de l'ID du dernier client inséré
			unHabitat = Main.selectWhereHabitat(nom);
			//actualisation de l'affichage
			Object ligne[] = {unHabitat.getIdhab(), nom, description, nbpersonne, vacant};
			this.unTableau.ajouterLigne(ligne);
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText();
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{// idhab, nom, description, nbpersonne, vacant
			int indiceLigne = uneTable.getSelectedRow();
			int idhab = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un client, on l'ajoute au bdd
			String nom = this.txtNom.getText();
			String description = this.txtDescription.getText();
			String nbpersonne = this.txtNbpersonne.getText();
			String vacant = this.txtVacant.getText();
			Habitat unHabitat = new Habitat (idhab, nom, description, nbpersonne, vacant);
			Main.updateHabitat(unHabitat);
			//actualisation de l'affichage
			Object ligne[] = {idhab, nom, description, nbpersonne, vacant};
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du client !");
			this.viderChamps();
		}
	}
}
