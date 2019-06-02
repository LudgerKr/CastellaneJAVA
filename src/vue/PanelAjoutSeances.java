package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Castellane;
import controleur.Seances;

public class PanelAjoutSeances extends PanelCentral implements ActionListener { 
	
	private JTextField txtDate = new JTextField();
	private JTextField txtTime = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelAjoutSeances() {
		super();
		this.setLayout(new GridLayout(5,2));
		this.add(new JLabel("Date :"));
		this.add(this.txtDate);
		this.add(new JLabel("Temps :"));
		this.add(this.txtTime);

		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAnnuler) {
			this.txtDate.setText("");
			this.txtTime.setText("");
			
		} else if (e.getSource() == this.btEnregistrer) {
			String date = this.txtDate.getText();
			String time = this.txtTime.getText();
			if (txtDate.equals("") || txtTime.equals("")) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			} else {
				//insertion dans la base de données
				Seances uneSeance = new Seances(date, time);
				Castellane.insertSeance(uneSeance);
				JOptionPane.showMessageDialog(this, "Insertion réussie de la séance", "Information", JOptionPane.INFORMATION_MESSAGE);
				this.txtDate.setText("");
				this.txtTime.setText("");

				uneSeance = Castellane.selectWhereSeance(uneSeance);
				Object ligne[] = {uneSeance.getIdseance(), uneSeance.getDate(), uneSeance.getTime()};
				
				PanelListerSeances.getUnTableau().addRow(ligne);
				
				this.setVisible(false);
			}
		}
	}

}