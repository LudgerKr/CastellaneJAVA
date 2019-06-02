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

public class VueAutre extends JFrame implements ActionListener
{
	private JPanel panelProfil = new JPanel(); 
	private JButton btQuitter = new JButton("Quitter");
	
	private PanelAjoutSeances unPanelAjout = new PanelAjoutSeances();
	private JButton btAjouter = new JButton("Ajouter");
	
	private PanelListerSeances unPanelLister = new PanelListerSeances();
	private JButton btLister = new JButton("Lister");
	
	public VueAutre(Users unUser)
	{
		this.setTitle("Administration de la bdd Fnac ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 20, 1200, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GREEN);
		this.setResizable(false);
		
		this.btQuitter.setBounds(1000, 400, 100, 30);
		this.add(this.btQuitter); 
		
		// insertion du panel Ajout
		this.btAjouter.setBounds(350, 10, 100, 20);
		this.add(this.btAjouter);
		this.add(this.unPanelAjout);
		this.btAjouter.addActionListener(this);
		
		// insertion du panel Lister
		this.btLister.setBounds(470, 10, 100, 20);
		this.add(this.btLister);
		this.add(this.unPanelLister);
		this.btLister.addActionListener(this);
		
		//construction du panel Profil 
		this.panelProfil.setBounds(20, 40, 200, 250);
		this.panelProfil.setBackground(Color.CYAN);
		
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
		} else if (e.getSource() == this.btAjouter) {
			this.unPanelAjout.setVisible(true);
			this.unPanelLister.setVisible(false);
		}  else if (e.getSource() == this.btLister) {
			this.unPanelAjout.setVisible(false);
			this.unPanelLister.setVisible(true);
		}
	}
}
