package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestDeBase {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		Exemplaire ex2 = exdb.findByKey(2);
		
		System.out.println("TEST DE BASE");
		System.out.println("------------");
		System.out.println();
		System.out.println("Demande d'Exemplaire 1 (id=1) aux Dao :\n"+ex1);
		System.out.println();
		System.out.println("Demande d'Exemplaire 2 (id=2) aux Dao :\n"+ex2);
		System.out.println();
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("Demande d'un adhérent (id=123) aux Dao :\n"+ad1);
		System.out.println();
		
		Utilisateur em1 = utdb.findByKey(666);
		System.out.println("Demande d'un employé (id=666) aux Dao :\n"+em1);
		System.out.println();

		EmpruntEnCours emp1=null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("07/04/2015"), ex1, ad1);
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Création d'un emprunt en cours pour un adhérent :\n"+emp1);
		System.out.println();
		
		
		EmpruntEnCours emp2 = null;
		
		try {
			emp2 = new EmpruntEnCours(sdf.parse("08/04/2015"), ex2, em1);
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Création d'un emprunt en cours pour un employé :\n"+emp2);
	}

}
