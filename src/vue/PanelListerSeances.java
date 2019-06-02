package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Seances;
import controleur.Tableau;

import modele.ModeleSeance;

public class PanelListerSeances  extends PanelCentral implements ActionListener {
	
	private JTable uneTable;
	private static Tableau unTableau;

	public PanelListerSeances() {
		super();
		
		String entetes[] = {"Numéro", "Date", "Time"};
		unTableau = new Tableau(this.getLesDonnees(), entetes);
		uneTable = new JTable(unTableau);
		
		uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) { // nombre de clique = 2
					int ligneSelectionnee = uneTable.getSelectedRow();
					int retour =  JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer la séance ?", "Suppression Séance", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						int idSeance = (int) uneTable.getValueAt(ligneSelectionnee, 0);
						unTableau.deleteRow(ligneSelectionnee);
						ModeleSeance.deleteSeance(idSeance);
						JOptionPane.showMessageDialog(null, "Suppression effectuée", "Suppression Séance", JOptionPane.YES_NO_OPTION);
					}
				}
			}
		});
		
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20, 20, 400, 200);
		this.add(uneScroll);
	}

	private Object[][] getLesDonnees() {
		// TODO Auto-generated method stub
		ArrayList<Seances> lesSeances = ModeleSeance.selectAllSeances();
		Object[][] matrice = new Object[lesSeances.size()][3];
		int i = 0;
		for (Seances uneSeance : lesSeances) {
			matrice[i][0] = uneSeance.getIdseance();
			matrice[i][1] = uneSeance.getDate();
			matrice[i][2] = uneSeance.getTime();
			i += 1;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public JTable getUneTable() {
		return uneTable;
	}

	public void setUneTable(JTable uneTable) {
		this.uneTable = uneTable;
	}

	public static Tableau getUnTableau() {
		return unTableau;
	}

	public static void setUnTableau(Tableau unTableau) {
		PanelListerSeances.unTableau = unTableau;
	}


}