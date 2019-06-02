package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Annonces;
import controleur.Castellane;

public class PanelAjoutAnnonces extends PanelCentral implements ActionListener { 
	
	private JTextField txtTitle = new JTextField();
	private JTextArea txtContent = new JTextArea();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelAjoutAnnonces() {
		super();
		this.setLayout(new GridLayout(5,2));
		this.add(new JLabel("Titre :"));
		this.add(this.txtTitle);
		this.add(new JLabel("Contenu :"));
		this.add(this.txtContent);

		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAnnuler) {
			this.txtTitle.setText("");
			this.txtContent.setText("");
			
		} else if (e.getSource() == this.btEnregistrer) {
			String title = this.txtTitle.getText();
			String content = this.txtContent.getText();
			if (txtTitle.equals("") || txtContent.equals("")) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			} else {
				//insertion dans la base de données
				Annonces uneAnnonce = new Annonces(title, content);
				Castellane.insertAnnonce(uneAnnonce);
				JOptionPane.showMessageDialog(this, "Insertion réussie de l'annonce, veuillez fermer la fênetre afin de mettre à jour l'affichage", "Information", JOptionPane.INFORMATION_MESSAGE);
				this.txtTitle.setText("");
				this.txtContent.setText("");

				uneAnnonce = Castellane.selectWhereAnnonce(uneAnnonce);
				Object ligne[] = {uneAnnonce.getIdnew(), uneAnnonce.getTitle(), uneAnnonce.getContent()};
				
				PanelListerSeances.getUnTableau().addRow(ligne);
				
				this.setVisible(false);
			}
		}
	}

}