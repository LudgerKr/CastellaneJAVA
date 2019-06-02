package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Castellane;
import controleur.Users;

import vue.PanelAjoutSeances;

public class VueMoniteur extends JFrame implements ActionListener
{
	private static VueBDDSeance uneVueBDDSeance;
	private static VueBDDAnnonce uneVueBDDAnnonce;
	private static VueBDDVehicle uneVueBDDVehicle;

	private JPanel panelProfil = new JPanel(); 
	private JButton btQuitter = new JButton("Quitter");
	
	private PanelListerSeances unPanelSeance = new PanelListerSeances();
	private JButton btSeance = new JButton("Séance");
	
	private PanelListerAnnonces unPanelAnnonce = new PanelListerAnnonces();
	private JButton btAnnonce = new JButton("Annonce");
	
	private PanelListerVehicles unPanelVehicle = new PanelListerVehicles();
	private JButton btVehicle = new JButton("Vehicule");
	
	public VueMoniteur(Users unUser)
	{
		this.setTitle("Administration de la base de données Castellane ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 20, 1200, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GREEN);
		this.setResizable(false);
		
		this.btQuitter.setBounds(1000, 400, 100, 30);
		this.add(this.btQuitter); 
		
		//construction du panel Profil 
		this.panelProfil.setBounds(20, 40, 200, 250);
		this.panelProfil.setBackground(Color.CYAN);
		
		// insertion du panel Séance
		this.btSeance.setBounds(350, 10, 100, 20);
		this.add(this.btSeance);
		this.add(this.unPanelSeance);
		this.btSeance.addActionListener(this);
		
		// insertion du panel Annonce
		this.btAnnonce.setBounds(450, 10, 100, 20);
		this.add(this.btAnnonce);
		this.add(this.unPanelAnnonce);
		this.btAnnonce.addActionListener(this);
		
		// insertion du panel Vehicle
		this.btVehicle.setBounds(550, 10, 100, 20);
		this.add(this.btVehicle);
		this.add(this.unPanelVehicle);
		this.btVehicle.addActionListener(this);
		
		// placement de la photo
		ImageIcon uneImage = new ImageIcon("src/images/other.png"); 
		JLabel monImage = new JLabel(uneImage); 
		monImage.setBounds(750, 40, 260, 200);
		this.add(monImage);
 
		this.panelProfil.setLayout(new GridLayout(5, 1));
		this.panelProfil.add(new JLabel("Bienvenue à l'espace Administration Castellane"));
		this.panelProfil.add(new JLabel("Votre nom est : " + unUser.getLastname() ));
		this.panelProfil.add(new JLabel("Votre prénom est : " + unUser.getFirstname() ));
		this.panelProfil.add(new JLabel("Votre Email est : " + unUser.getEmail() ));
		this.panelProfil.add(new JLabel("Vous avez les droits : " + unUser.getRight() ));
		this.add(this.panelProfil);
		
		
		this.btQuitter.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter) {
			if (JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application")==0) {
				this.dispose();
				Castellane.setVisible(true); 
				} 
		} else if (e.getSource() == this.btSeance) {
			uneVueBDDSeance = new VueBDDSeance();
		} else if (e.getSource() == this.btAnnonce) {
			uneVueBDDAnnonce = new VueBDDAnnonce();
		} else if (e.getSource() == this.btVehicle) {
			uneVueBDDVehicle = new VueBDDVehicle();
		}
	}
}
