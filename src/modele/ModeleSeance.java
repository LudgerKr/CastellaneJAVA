package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Annonces;

//import com.mysql.fabric.xmlrpc.base.Array;

import controleur.Seances;

public class ModeleSeance
{
	static BDD uneBdd = new BDD("localhost", "castellane","richard","richard");
	
	public static ArrayList<Seances> selectAllSeances ()
	{
		ArrayList<Seances> lesSeances = new ArrayList<Seances>();
		String requete = "select * from seance; ";
		ModeleSeance.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleSeance.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				Seances uneSeance = new Seances(
						desResultats.getInt("idseance"), 
						desResultats.getString("date"),
						desResultats.getString("time")
						);
				lesSeances.add(uneSeance);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleSeance.uneBdd.seDeConnecter();
		return lesSeances;
	}
	
	public static void insertSeance (Seances uneSeance)
	{
		String requete = "insert into seance values (null,'"+uneSeance.getDate()+"','"+uneSeance.getTime()+"');";
		ModeleSeance.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleSeance.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleSeance.uneBdd.seDeConnecter();
	}
	public static void deleteSeance (int idseance)
	{
		String requete = "delete from seance "
				+ "	where idseance ="+idseance+";";
		ModeleSeance.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleSeance.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		ModeleSeance.uneBdd.seDeConnecter();
	}
	
	public static void updateSeance (Seances uneSeance)
	{
		String requete = "update seance set nom ='"+uneSeance.getDate()
				+"', prices = "+uneSeance.getTime()+ "'where "
						+ " idseance = "+uneSeance.getIdseance()+" ;";
		ModeleSeance.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleSeance.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleSeance.uneBdd.seDeConnecter();
	}

	public static Seances selectWhereSeance(Seances uneSeance) {
		// TODO Auto-generated method stub
		String requete = "select * from seance where date ='"+uneSeance.getDate()
		+"' and time = '"+uneSeance.getTime()+"';";
		Seances uneSean = null;
		ModeleSeance.uneBdd.seConnecter();
		try
		{
		Statement unStat = ModeleSeance.uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats = unStat.executeQuery(requete);
		while (desResultats.next())
			{
			uneSean = new Seances(
					desResultats.getInt("idseance"), 
					desResultats.getString("date"),
					desResultats.getString("time")
					);
			}
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete : "+requete);
			}

		ModeleSeance.uneBdd.seDeConnecter();
		return uneSean;
		}
}