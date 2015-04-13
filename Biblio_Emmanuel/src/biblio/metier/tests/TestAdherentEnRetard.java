package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;
import biblio.metier.personnes.Adherent;

public class TestAdherentEnRetard 
{

	public static void main(String[] args) throws ParseException 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("-----------------------");
		System.out.println("TEST ADHERENT EN RETARD");
		System.out.println("-----------------------");
		System.out.println("\n");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		Exemplaire ex2 = exdb.findByKey(2);
		
		System.out.println("------------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=1) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println(ex1);
		System.out.println("\n");
		
		System.out.println("------------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=2) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println(ex2);
		System.out.println("\n");
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("------------------------------------------------");
		System.out.println("Demande d'un adhérent (id=123) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println(ad1);
		System.out.println("\n");

		System.out.println("----------------------------------------------------------");
		System.out.println("Création d'un emprunt en cours avec une date en retard.");
		System.out.println("----------------------------------------------------------");
		System.out.println();
		
		EmpruntEnCours emp1=null;
		EmpruntEnCours emp2=null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("07-04-2014"), ex1, ad1);
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		System.out.println("Emprunt en cours 1 :");
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println(emp1);
		System.out.println();

		System.out.println("----------------------------------------------------------");
		System.out.println("Tentative de création d'un deuxième emprunt en cours.");
		System.out.println("----------------------------------------------------------");
		System.out.println();
		
		try {
			emp2 = new EmpruntEnCours(sdf.parse("27-04-2015"), ex2, ad1);
		} catch (BiblioException e) {
			System.out.println(e);;
		}
		
		// l'adhérent est en vérité un utilisateur, il faut caster pour retrouver 
		//les methodes adhérent dans adhérent tenu par ref d'utilisateur 
		
		System.out.println("----------------------");
		System.out.println("Emprunt en retard :"); 
		System.out.println("----------------------");
		System.out.println();
		
		System.out.println(((Adherent)ad1).getRetards());
		System.out.println();
	
		System.out.println("---------------------------------------");
		System.out.println("Etat du deuxième emprunt en cours :");
		System.out.println("---------------------------------------");
		System.out.println();
		
		System.out.println(emp2);
		System.out.println();
		
		System.out.println("--------------------------------------------");
		System.out.println("Nombre d'emprunt en cours de l'adhérent :");
		System.out.println("--------------------------------------------");
		System.out.println();	
		
		System.out.println(ad1.getNbEmpruntEnCours());
		System.out.println();
	
	
	}
}
