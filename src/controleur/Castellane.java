package controleur;

import javax.swing.JOptionPane;

import modele.BDD;
import modele.ModeleAnnonce;
import modele.ModeleSeance;
import modele.ModeleUser;
import modele.ModeleVehicle;
import vue.VueConnexion;
import vue.VueAdministrateur;
import vue.VueUtilisateur;
import vue.VueAutre;

public class Castellane {

	private static VueConnexion uneVueConnexion ; 
	private static VueAdministrateur uneVueAdministrateur; 
	private static VueUtilisateur uneVueUtilisateur; 
	private static VueAutre uneVueAutre; 
	
	public static void setVisible (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}

	public static void main(String[] args) {
	uneVueConnexion = new VueConnexion();
	}

	public static void verifConnexion(String email, String mdp) {
		if (email.equals("") || mdp.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Veuillez remplir vos identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
		} else {
			//appel du modeleUser 
			Users unUser = ModeleUser.selectWhereUser(email, mdp);
			if (unUser == null ) {
				JOptionPane.showMessageDialog(null,"Veuillez vérifier vos identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
			} else {
					JOptionPane.showMessageDialog(null,"Vous êtes connectés "+ unUser.getLastname() + "   " +unUser.getFirstname(),
							"Connexion", JOptionPane.INFORMATION_MESSAGE);
					uneVueConnexion.dispose();
					if (unUser.getRight().equals("Administrateur")) {
					uneVueAdministrateur = new VueAdministrateur(unUser);
					} else if (unUser.getRight().equals("Utilisateur")) {
					uneVueUtilisateur = new VueUtilisateur(unUser);
					} else if (unUser.getRight().equals("Moniteur")) {
					uneVueAutre = new VueAutre(unUser);
					}
			} 					
			
		}
		
		
		
	}

	public static void insertSeance(Seances uneSeance) {
		// TODO Auto-generated method stub
		ModeleSeance.insertSeance(uneSeance);
		
	}

	public static Seances selectWhereSeance(Seances uneSeance) {
		// TODO Auto-generated method stub
		return ModeleSeance.selectWhereSeance(uneSeance);
	}
	
	public static void insertAnnonce(Annonces uneAnnonce) {
		// TODO Auto-generated method stub
		ModeleAnnonce.insertAnnonce(uneAnnonce);
		
	}

	public static Annonces selectWhereAnnonce(Annonces uneAnnonce) {
		// TODO Auto-generated method stub
		return ModeleAnnonce.selectWhereAnnonce(uneAnnonce);
	}
	
	public static void insertVehicle(Vehicles unVehicle) {
		// TODO Auto-generated method stub
		ModeleVehicle.insertVehicle(unVehicle);
		
	}

	public static Vehicles selectWhereVehicle(Vehicles unVehicle) {
		// TODO Auto-generated method stub
		return ModeleVehicle.selectWhereVehicle(unVehicle);
	}

}






