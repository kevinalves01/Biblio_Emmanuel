package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestAdherentEnRetard 
{

	public static void main(String[] args) throws ParseException 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		Exemplaire ex2 = exdb.findByKey(2);
		System.out.println("Exemplaire 1 :\n"+ex1);
		System.out.println("Exemplaire 2 :\n"+ex2);
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		System.out.println("Adhérent :\n"+ad1);
		EmpruntEnCours emp1=null;
		EmpruntEnCours emp2=null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("07-04-2014"), ex1, ad1);
		} catch (BiblioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Emprunt en cours 1\n"+emp1);

		
		try {
			emp2 = new EmpruntEnCours(sdf.parse("27-04-2015"), ex2, ad1);
		} catch (BiblioException e) {
			System.out.println(e);;
		}
		
		System.out.println();
		System.out.println("Emprunt en cours 2\n"+emp2);
		
		System.out.println("Nombre d'emprunt en cours 2\n"+ad1.getNbEmpruntEnCours());
	}

}
