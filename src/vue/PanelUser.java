package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Tableau;
import controleur.Users;

import modele.ModeleUser;

public class PanelUser  extends PanelCentral implements ActionListener {
	
	private JTable uneTable;
	private static Tableau unTableau;

	public PanelUser() {
		super();
		
		String entetes[] = {"email", "mdp", "nom", "prenom", "droits"};
		unTableau = new Tableau(this.getLesDonnees(), entetes);
		uneTable = new JTable(unTableau);
		
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20, 20, 400, 200);
		this.add(uneScroll);
	}

	private Object[][] getLesDonnees() {
		// TODO Auto-generated method stub
		ArrayList<Users> lesUsers = ModeleUser.selectAllUsers();
		Object[][] matrice = new Object[lesUsers.size()][9];
		int i = 0;
		for (Users unUser : lesUsers) {
			matrice[i][0] = unUser.getEmail();
			matrice[i][1] = unUser.getLastname();
			matrice[i][2] = unUser.getPassword();
			matrice[i][3] = unUser.getFirstname();
			matrice[i][4] = unUser.getRight();
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
		PanelUser.unTableau = unTableau;
	}


}