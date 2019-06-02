package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controleur.Castellane;
import controleur.Users;
import modele.ModeleAnnonce;
import vue.PanelAjoutSeances;


public class VueSeances extends JFrame implements ActionListener 
{
	private JTabbedPane panelOnglet;
	private JPanel PanelListe = new JPanel(), PanelAjout = new JPanel();
	private JButton btAjout = new JButton("Ajouter une séance"), btListe = new JButton("Liste des séances");
	   	
	private PanelAjoutSeances unPanelAjout = new PanelAjoutSeances();
	
	private PanelListerSeances unPanelLister = new PanelListerSeances();
	
	public VueSeances()
	{
		
		this.add(this.btListe);
		this.add(this.unPanelLister);
		this.btListe.addActionListener(this);
		this.add(this.btAjout);
		this.add(this.unPanelAjout);
		this.btAjout.addActionListener(this);
		
		this.unPanelAjout.setBounds(30, 70, 450, 400);
		this.unPanelLister.setBounds(30, 70, 450, 400);
	 
	    this.panelOnglet = new JTabbedPane();
	    this.PanelListe.add(this.btListe);
	    this.PanelAjout.add(this.btAjout);
	    this.panelOnglet.addTab("Lister", null, this.PanelListe);
	    this.panelOnglet.addTab("Ajouter", null, this.PanelAjout);
	    this.setTitle("Menu des Séances");
	    this.getContentPane().add(panelOnglet);
	    this.setSize(500,500);
	    
	    this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAjout) {
			this.unPanelAjout.setVisible(true);
			this.unPanelLister.setVisible(false);
		}
		if (e.getSource() == this.btListe) {
			this.unPanelAjout.setVisible(false);
			this.unPanelLister.setVisible(true);
		}
		
	}
}
