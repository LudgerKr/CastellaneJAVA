package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Users;

public class ModeleUser {
	private static BDD uneBdd = new BDD("localhost", "castellane","richard","richard");
	
	public static void insertUser (Users unUser)
	{
		String requete = "insert into user (email, "
				+ "mdp, nom, prenom, droits) values('"+unUser.getEmail()
				+"','"+unUser.getPassword()+"','"+unUser.getLastname()+"','"+unUser.getFirstname()+
				",'"+unUser.getRight()+"');";
		
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
	}
	public static void updateUSer (Users unUser) {
		String requete = "update user set email ='"+unUser.getEmail()
		+"', mdp = '"+unUser.getPassword()+"',nom = '"+unUser.getLastname()+"',prenom = '"+unUser.getFirstname()+
		"', droits ='"+unUser.getRight()+"' where "
				+ " iduser = "+unUser.getIduser()+" ;";
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
	}
	
	public static void deleteUser(int idUser) {
		String requete = "delete from user "
				+ "	where idarticle ="+idUser+";";
		ModeleUser.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
	}
	public static Users selectWhereUser(String email, String mdp) {
		String requete = "select * from users where email = '"+email+"' and password = '"+mdp+"';";

		Users unUser = null; 
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next())
			{
				 unUser = new Users(
						 unResultat.getInt("iduser"),
						 unResultat.getString("lastname"),
						 unResultat.getString("firstname"),
						 unResultat.getInt("age"),
						 unResultat.getInt("phone"),
						 unResultat.getString("email"),
						 unResultat.getString("password"),
						 unResultat.getString("right")
					);
			}
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
		return unUser; 
	}
	
	public static ArrayList<Users> selectAllUsers(){
		ArrayList<Users> lesUsers = new ArrayList<Users>();
		String requete = "select * from user ; ";
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				Users unUser = new Users(
						desResultats.getInt("iduser"),
						desResultats.getString("lastname"),
						desResultats.getString("firstname"),
						desResultats.getInt("age"),
						desResultats.getInt("phone"),
						desResultats.getString("email"),
						desResultats.getString("password"),
						desResultats.getString("right"),
						desResultats.getInt("ban"),
						desResultats.getString("reply"),
						desResultats.getInt("termsUse"),
						desResultats.getInt("idquestion")
						);
				lesUsers.add(unUser);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
		return lesUsers;
	}
	//creer dans le controleur une classe User avce trois 
	//constructeurs et des getters et des setters 
}
