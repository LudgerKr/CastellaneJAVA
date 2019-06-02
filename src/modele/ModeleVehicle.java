package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Annonces;

//import com.mysql.fabric.xmlrpc.base.Array;

import controleur.Seances;
import controleur.Vehicles;

public class ModeleVehicle
{
	static BDD uneBdd = new BDD("localhost", "castellane","richard","richard");
	
	public static ArrayList<Vehicles> selectAllVehicles ()
	{
		ArrayList<Vehicles> lesVehicles = new ArrayList<Vehicles>();
		String requete = "select * from vehicles; ";
		ModeleVehicle.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleVehicle.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				Vehicles unVehicle = new Vehicles(
						desResultats.getInt("idvehicles"), 
						desResultats.getString("licenseplate"),
						desResultats.getString("mileage"),
						desResultats.getString("brand"),
						desResultats.getString("status")
						);
				lesVehicles.add(unVehicle);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleVehicle.uneBdd.seDeConnecter();
		return lesVehicles;
	}
	
	public static void insertVehicle (Vehicles unVehicle)
	{
		String requete = "insert into vehicles values (null,'"+unVehicle.getlicenseplate()+"','"+unVehicle.getMileage()+"','"+unVehicle.getBrand()+"','"+unVehicle.getStatus()+"');";
		ModeleVehicle.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleVehicle.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleVehicle.uneBdd.seDeConnecter();
	}
	public static void deleteVehicle (int idvehicles)
	{
		String requete = "delete from vehicles "
				+ "	where idvehicles ="+idvehicles+";";
		ModeleVehicle.uneBdd.seConnecter();
		try {
			Statement unStat = ModeleVehicle.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		ModeleVehicle.uneBdd.seDeConnecter();
	}
	
	/**
	public static void updateVehicle (Vehicles unVehicle)
	{
		String requete = "update vehicles set licenseplate ='"+unVehicle.getlicenseplate()
				+"', mileage = "+unVehicle.getMileage()+ "'where "
						+ " idseance = "+uneSeance.getIdseance()+" ;";
		ModeleVehicle.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleVehicle.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de' la requete : "+requete);
		}
		ModeleVehicle.uneBdd.seDeConnecter();
	}
	**/

	public static Vehicles selectWhereVehicle(Vehicles unVehicle) {
		// TODO Auto-generated method stub
		String requete = "select * from vehicles where licenseplate ='"+unVehicle.getlicenseplate()
		+"' and mileage = '"+unVehicle.getMileage()+"'  and brand = '"+unVehicle.getBrand()+"'"
		+ " and `status` = '"+unVehicle.getStatus()+"';";
		Vehicles unVehic = null;
		ModeleVehicle.uneBdd.seConnecter();
		try
		{
		Statement unStat = ModeleVehicle.uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats = unStat.executeQuery(requete);
		while (desResultats.next())
			{
			unVehic = new Vehicles(
					desResultats.getInt("idvehicles"), 
					desResultats.getString("licenseplate"),
					desResultats.getString("mileage"),
					desResultats.getString("brand"),
					desResultats.getString("Stauts")
					);
			}
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete : "+requete);
			}

		ModeleVehicle.uneBdd.seDeConnecter();
		return unVehic;
		}
}