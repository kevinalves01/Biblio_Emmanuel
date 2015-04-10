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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		
		System.out.println("Exemplaire 1 :\n"+ex1);
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("Utilisateur 1 :\n"+ad1);
		
		EmpruntEnCours emp1 = null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex1, ad1);
		} catch (BiblioException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		System.out.println("Emprunt en cours 1:\n"+emp1);
		System.out.println("Statut de exemplaire 1 : "+ex1.getStatus());
		System.out.println("Collection d'emprunt de l'utilisateur :\n"+ad1.getEmpruntEnCours());
		
		EmpruntArchive ea1= null;
		
		try {
			ea1 = emp1.retourExemplaire(sdf.parse("11/04/2015"));
			emp1 = null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Statut de exemplaire 1 : "+ex1.getStatus());
		System.out.println("Collection d'emprunt de l'utilisateur :\n"+ad1.getEmpruntEnCours());
		System.out.println("Emprunt archivé :\n"+ea1);
		System.out.println("Emprunt en cours :\n"+emp1);
		
		
	}

}
