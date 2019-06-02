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

import vue.PanelAjoutVehicles;

public class VueBDDVehicle extends JFrame implements ActionListener 
{
	private JTabbedPane panelOnglet;
	
	private JPanel PanelListeVehicle = new JPanel();
	private JPanel PanelAjoutVehicle = new JPanel();
	
	private JButton btAjoutVehicle = new JButton("Ajouter un véhicule");
	private JButton btListeVehicle = new JButton("Liste des véhicules");
	   	
	private PanelAjoutVehicles unPanelAjoutVehicle = new PanelAjoutVehicles();
	private PanelListerVehicles unPanelListerVehicle = new PanelListerVehicles();
	
	public VueBDDVehicle()
	{
		
		this.add(this.btListeVehicle);
		this.add(this.unPanelListerVehicle);
		this.btListeVehicle.addActionListener(this);
		
		this.add(this.btAjoutVehicle);
		this.add(this.unPanelAjoutVehicle);
		this.btAjoutVehicle.addActionListener(this);
		
		this.unPanelAjoutVehicle.setBounds(30, 70, 450, 400);
		this.unPanelListerVehicle.setBounds(30, 70, 450, 400);
	 
	    this.panelOnglet = new JTabbedPane();
	    this.PanelListeVehicle.add(this.btListeVehicle);
	    this.PanelAjoutVehicle.add(this.btAjoutVehicle);
	    
	    this.panelOnglet.addTab("Lister les véhicules", null, this.PanelListeVehicle);
	    this.panelOnglet.addTab("Ajouter un véhicule", null, this.PanelAjoutVehicle);
	    
	    this.setTitle("Menu dans la BDD");
	    this.getContentPane().add(panelOnglet);
	    this.setSize(500,500);
	    
	    this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAjoutVehicle) {
			this.unPanelAjoutVehicle.setVisible(true);
			this.unPanelListerVehicle.setVisible(false);

		}
		if (e.getSource() == this.btListeVehicle) {
			this.unPanelAjoutVehicle.setVisible(false);
			this.unPanelListerVehicle.setVisible(true);

		} 
	}
}