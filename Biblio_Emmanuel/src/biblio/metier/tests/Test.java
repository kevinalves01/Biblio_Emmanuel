package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import biblio.metier.BiblioException;
import biblio.metier.personnes.*;
import biblio.metier.ouvrages.*;

public class Test 
{
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	public static void main(String[] args) throws ParseException, BiblioException 
	{
		System.out.println("Test Création d'Utilisateur");
		System.out.println();
		Utilisateur ut1 = new Utilisateur("Rémi","caca",new Date(1990), "Masculin", 123456789,"pwd", "Ak.vin");
		System.out.println("Utilisateur 1 :" + ut1);
		Utilisateur ut2 = new Utilisateur("Rémi","caca",new Date(1990), "Masculin", 123456789,"pwd", "Ak.vin");
		System.out.println();
		
		System.out.println("Test Création d'un Exemplaire");
		System.out.println();
		Exemplaire ex1 = new Exemplaire(123456789, new Date(1992), EnumStatusExemplaire.DISPONIBLE, "cioco");
		System.out.println("Exemplaire 1 :" + ex1);
		Exemplaire ex2 = new Exemplaire(123456789, new Date(1992), EnumStatusExemplaire.DISPONIBLE, "cioco");
		System.out.println();
		
		System.out.println("Test isDisponible");
		System.out.println();
		System.out.println(ex1.isDisponible());
		System.out.println();
		
		System.out.println("Test création d'un emprunt");
		System.out.println();
		EmpruntEnCours emp1;
		emp1 = new EmpruntEnCours(sdf.parse("20-02-2001"),ex1,ut1);
		try {
			emp1 = new EmpruntEnCours(sdf.parse("20-02-2001"),ex1,ut1);
		} catch (BiblioException e) {
			e.printStackTrace();
		}
		System.out.println("Emprunt 1 :" + emp1);
		System.out.println();
		
		System.out.println("Test Equals sur 2 exemplaire");
		System.out.println();
		System.out.println(ex1.equals(ex2));
		System.out.println();
		
		System.out.println("Test EmpruntArchive");
		System.out.println();
		EmpruntArchive empar1 = emp1.retourExemplaire(sdf.parse("30-02-2001"));
		System.out.println(empar1);
	}

}
