package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.EnumStatusExemplaire;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Adherent;
import biblio.metier.personnes.Employe;
import biblio.metier.personnes.EnumCategorieEmploye;
import biblio.metier.personnes.Utilisateur;

public class TestEmmanuel {
	
	public static void main(String[] args) throws ParseException, BiblioException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		Utilisateur ut1 = new Utilisateur("Toto","Léon", new Date(), "masculin", 1254, "Sésame", "TL");
		Utilisateur ut2 = new Adherent("Dupont","Jean", new Date(), "masculin", 1253, "Abracadabra", "Dup","0123456789");
		Utilisateur ut3 = new Employe("Martin","Marie", new Date(), "féminin", 666, "123456","2M","555",EnumCategorieEmploye.BIBLIOTHECAIRE);
		Exemplaire ex1 = new Exemplaire(1213, new Date(), EnumStatusExemplaire.DISPONIBLE, "132");
		Exemplaire ex2 = new Exemplaire(214, new Date(), EnumStatusExemplaire.DISPONIBLE, "456");
		Exemplaire ex3 = new Exemplaire(789, new Date(), EnumStatusExemplaire.DISPONIBLE, "987");
		EmpruntEnCours emp11 = new EmpruntEnCours(new Date(), ex1, ut1);
		EmpruntEnCours emp12 = new EmpruntEnCours(new Date(), ex2, ut1);
		EmpruntEnCours emp13 = new EmpruntEnCours(new Date(), ex3, ut1);
		try {
			System.out.println(ut1.isConditionsPretAcceptees());
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		
		EmpruntEnCours emp21 = new EmpruntEnCours(sdf.parse("07/04/2015"), ex1, ut2);
		EmpruntEnCours emp22 = new EmpruntEnCours(sdf.parse("24/03/2015"), ex2, ut2);
		EmpruntEnCours emp23 = new EmpruntEnCours(new Date(), ex3, ut2);
		try {
			ut2.addEmpruntEnCours(emp21);
			ut2.addEmpruntEnCours(emp22);
			//ut2.addEmpruntEnCours(emp23);
		} catch (BiblioException e1) {
			System.out.println(e1);
		}
		System.out.println(ut2.getNbEmpruntEnCours());
		try {
			System.out.println(ut2.isConditionsPretAcceptees());
		} catch (BiblioException e) {
			System.out.println(e);
		}

		EmpruntEnCours emp31 = new EmpruntEnCours(new Date(), ex1, ut3);
		EmpruntEnCours emp32 = new EmpruntEnCours(new Date(), ex2, ut3);
		EmpruntEnCours emp33 = new EmpruntEnCours(new Date(), ex3, ut3);
		try {
			System.out.println(ut3.isConditionsPretAcceptees());
		} catch (BiblioException e) {
			System.out.println(e);
		}
		
		
		
	}

}
