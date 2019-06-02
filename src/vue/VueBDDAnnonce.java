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


public class VueBDDAnnonce extends JFrame implements ActionListener 
{
	private JTabbedPane panelOnglet;
	
	private JPanel PanelListeAnnonce = new JPanel();
	private JPanel PanelAjoutAnnonce = new JPanel();
	
	private JButton btAjoutAnnonce = new JButton("Ajouter une annonce");
	private JButton btListeAnnonce = new JButton("Liste des annonces");
	   	
	private PanelAjoutAnnonces unPanelAjoutAnnonce = new PanelAjoutAnnonces();
	private PanelListerAnnonces unPanelListerAnnonce = new PanelListerAnnonces();
	
	public VueBDDAnnonce()
	{
		
		this.add(this.btListeAnnonce);
		this.add(this.unPanelListerAnnonce);
		this.btListeAnnonce.addActionListener(this);
		
		this.add(this.btAjoutAnnonce);
		this.add(this.unPanelAjoutAnnonce);
		this.btAjoutAnnonce.addActionListener(this);
		
		this.unPanelAjoutAnnonce.setBounds(30, 70, 450, 400);
		this.unPanelListerAnnonce.setBounds(30, 70, 450, 400);
	 
	    this.panelOnglet = new JTabbedPane();
	    this.PanelListeAnnonce.add(this.btListeAnnonce);
	    this.PanelAjoutAnnonce.add(this.btAjoutAnnonce);
	    
	    this.panelOnglet.addTab("Lister les annonces", null, this.PanelListeAnnonce);
	    this.panelOnglet.addTab("Ajouter une annonce", null, this.PanelAjoutAnnonce);
	    
	    this.setTitle("Menu dans la BDD");
	    this.getContentPane().add(panelOnglet);
	    this.setSize(500,500);
	    
	    this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAjoutAnnonce) {
			this.unPanelAjoutAnnonce.setVisible(true);
			this.unPanelListerAnnonce.setVisible(false);

		}
		if (e.getSource() == this.btListeAnnonce) {
			this.unPanelAjoutAnnonce.setVisible(false);
			this.unPanelListerAnnonce.setVisible(true);
		} 
	}
}
