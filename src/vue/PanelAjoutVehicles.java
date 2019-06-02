package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Castellane;
import controleur.Seances;
import controleur.Vehicles;

public class PanelAjoutVehicles extends PanelCentral implements ActionListener { 
	
	private JTextField txtLicenseplate = new JTextField();
	private JTextField txtMileage = new JTextField();
	private JTextField txtBrand = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	String[] status = {"Disponible", "Occupée", "Réparation", "Détruite"}; 
	private JComboBox comboStatus = new JComboBox(status);
	
	public PanelAjoutVehicles() {
		super();
		this.setLayout(new GridLayout(6,2));
		this.add(new JLabel("Plaque d'immatriculation :"));
		this.add(this.txtLicenseplate);
		this.add(new JLabel("Kilométrage :"));
		this.add(this.txtMileage);
		this.add(new JLabel("Marque :"));
		this.add(this.txtBrand);
		this.add(new JLabel("Status"));
		this.add(this.comboStatus);

		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAnnuler) {
			this.txtLicenseplate.setText("");
			this.txtMileage.setText("");
			this.txtBrand.setText("");
			
		} else if (e.getSource() == this.btEnregistrer) {
			String licenseplate = this.txtLicenseplate.getText();
			String mileage = this.txtMileage.getText();
			String brand = this.txtBrand.getText();
			String status = this.comboStatus.getSelectedItem().toString();

			if (txtLicenseplate.equals("") || txtMileage.equals("") || txtBrand.equals("")) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			} else {
				//insertion dans la base de données
				Vehicles unVehicle = new Vehicles(licenseplate, mileage, brand, status);
				Castellane.insertVehicle(unVehicle);
				JOptionPane.showMessageDialog(this, "Insertion réussie du véhicule, veuillez fermer la fênetre pour actualiser la liste", "Information", JOptionPane.INFORMATION_MESSAGE);
				this.txtLicenseplate.setText("");
				this.txtMileage.setText("");
				this.txtBrand.setText("");

				unVehicle = Castellane.selectWhereVehicle(unVehicle);
				Object ligne[] = {unVehicle.getIdvehicles(), unVehicle.getlicenseplate(), unVehicle.getMileage(), unVehicle.getBrand(), unVehicle.getStatus()};
				
				PanelListerSeances.getUnTableau().addRow(ligne);
				
				this.setVisible(false);
			}
		}
	}

}