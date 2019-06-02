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

public class VueBDDSeance extends JFrame implements ActionListener 
{
	private JTabbedPane panelOnglet;
	
	private JPanel PanelListeSeance = new JPanel();
	private JPanel PanelAjoutSeance = new JPanel();
	
	private JButton btAjoutSeance = new JButton("Ajouter une séance");
	private JButton btListeSeance = new JButton("Liste des séances");
	   	
	private PanelAjoutSeances unPanelAjoutSeance = new PanelAjoutSeances();
	private PanelListerSeances unPanelListerSeance = new PanelListerSeances();
	
	public VueBDDSeance()
	{
		
		this.add(this.btListeSeance);
		this.add(this.unPanelListerSeance);
		this.btListeSeance.addActionListener(this);
		
		this.add(this.btAjoutSeance);
		this.add(this.unPanelAjoutSeance);
		this.btAjoutSeance.addActionListener(this);
		
		this.unPanelAjoutSeance.setBounds(30, 70, 450, 400);
		this.unPanelListerSeance.setBounds(30, 70, 450, 400);
	 
	    this.panelOnglet = new JTabbedPane();
	    this.PanelListeSeance.add(this.btListeSeance);
	    this.PanelAjoutSeance.add(this.btAjoutSeance);
	    
	    this.panelOnglet.addTab("Lister les séances", null, this.PanelListeSeance);
	    this.panelOnglet.addTab("Ajouter une séance", null, this.PanelAjoutSeance);
	    
	    this.setTitle("Menu dans la BDD");
	    this.getContentPane().add(panelOnglet);
	    this.setSize(500,500);
	    
	    this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAjoutSeance) {
			this.unPanelAjoutSeance.setVisible(true);
			this.unPanelListerSeance.setVisible(false);

		}
		if (e.getSource() == this.btListeSeance) {
			this.unPanelAjoutSeance.setVisible(false);
			this.unPanelListerSeance.setVisible(true);

		} 
	}
}
