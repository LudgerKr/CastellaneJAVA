package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Annonces;

//import com.mysql.fabric.xmlrpc.base.Array;

import controleur.Seances;

public class ModeleAnnonce
{
	static BDD uneBdd = new BDD("localhost", "castellane","richard","richard");
	
	public static ArrayList<Annonces> selectAllAnnonces ()
	{
		ArrayList<Annonces> lesAnnonces = new ArrayList<Annonces>();
		String requete = "select * from news; ";
		ModeleAnnonce.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleAnnonce.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				Annonces uneAnnonce = new Annonces(
						desResultats.getInt("idnew"), 
						desResultats.getString("title"),
						desResultats.getString("content")
						);
				lesAnnonces.add(uneAnnonce);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleAnnonce.uneBdd.seDeConnecter();
		return lesAnnonces;
	}
	
	public static void insertAnnonce (Annonces uneAnnonce)
	{
		String requete = "insert into news values (null,'"+uneAnnonce.getTitle()+"','"+uneAnnonce.getContent()+"',1);";
		ModeleAnnonce.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleAnnonce.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleAnnonce.uneBdd.seDeConnecter();
	}
	public static void deleteAnnonce (int idnew)
	{
		String requete = "delete from news "
				+ "	where idnew ="+idnew+";";
		ModeleAnnonce.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleAnnonce.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		ModeleAnnonce.uneBdd.seDeConnecter();
	}
	
	public static void updateAnnonce (Annonces uneAnnonce)
	{
		String requete = "update news set title ='"+uneAnnonce.getTitle()
				+"', content = "+uneAnnonce.getContent()+ "'where "
						+ " idnew = "+uneAnnonce.getIdnew()+" ;";
		ModeleAnnonce.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleAnnonce.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleAnnonce.uneBdd.seDeConnecter();
	}

	public static Annonces selectWhereAnnonce(Annonces uneAnnonce) {
		// TODO Auto-generated method stub
		String requete = "select * from news where title ='"+uneAnnonce.getTitle()
		+"' and content = '"+uneAnnonce.getContent()+"';";
		Annonces uneAnnon = null;
		ModeleAnnonce.uneBdd.seConnecter();
		try
		{
		Statement unStat = ModeleAnnonce.uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats = unStat.executeQuery(requete);
		while (desResultats.next())
			{
			uneAnnon = new Annonces(
					desResultats.getInt("idnew"), 
					desResultats.getString("title"),
					desResultats.getString("content")
					);
			}
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete : "+requete);
			}

		ModeleAnnonce.uneBdd.seDeConnecter();
		return uneAnnon;
		}
}