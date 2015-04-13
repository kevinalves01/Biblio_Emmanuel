package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntArchive;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestRetour {

	public static void main(String[] args) {
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("		   TESTRETOUR");
		System.out.println("------------------------------------------------------");
		System.out.println("\n");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		
		System.out.println("\n-----------------------------------------------");
		System.out.println("	AFFICHAGE EXEMPLAIRE 1");
		System.out.println("-----------------------------------------------");
		System.out.println();
		
		System.out.println("Exemplaire 1 :\n"+ex1);
		System.out.println("\n");
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("\n---------------------------------------");
		System.out.println("	AFFICHAGE ADHERENT 1");
		System.out.println("---------------------------------------");
		System.out.println();
		
		System.out.println("Utilisateur 1 :\n"+ad1);
		System.out.println("\n");
		
		EmpruntEnCours emp1 = null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex1, ad1);
		} catch (BiblioException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		System.out.println("\n--------------------------------------------------------");
		System.out.println("	CREATION D UN EMPRUNT POUR L'ADHERENT 1");
		System.out.println("--------------------------------------------------------");
		System.out.println();
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	AFFICHAGE EMPRUNT EN COURS 1");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Emprunt en cours 1:\n"+emp1);
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	AFFICHAGE STATUT EXEMPLAIRE 1");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Statut de exemplaire 1 : "+ex1.getStatus());
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	AFFICHAGE COLLECTION ADHERENT 1");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'utilisateur :\n"+ad1.getEmpruntEnCours());
		System.out.println("\n");
		
		EmpruntArchive ea1= null;
		
		try {
			ea1 = emp1.retourExemplaire(sdf.parse("11/04/2015"));
			emp1 = null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-------------------------------------------");
		System.out.println("	RETOUR DE L'EXEMPLAIRE");
		System.out.println("-------------------------------------------");
		System.out.println();
		
		System.out.println("\n------------------------------------------------");
		System.out.println("	L'EXEMPLAIRE PASSE A dISPONIBLE");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println("Statut de exemplaire 1 : "+ex1.getStatus());
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------------");
		System.out.println("	LA COLLECTION DE L'ADHERENT DIMINUE");
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'utilisateur :\n"+ad1.getEmpruntEnCours());
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	L'EMPRUNT ARCHIVE EST CREE");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Emprunt archivé :\n"+ea1);
		System.out.println("\n");
		
		System.out.println("\n-------------------------------------------------------");
		System.out.println("	L'EMPRUNT EN COURS EST GABAGE COLLECTE");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		System.out.println("Emprunt en cours :\n"+emp1);	
	}
}
