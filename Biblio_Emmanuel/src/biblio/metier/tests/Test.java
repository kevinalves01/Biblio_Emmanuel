package biblio.metier.tests;

import biblio.metier.personnes.Utilisateur;

public class Test 
{

	public static void main(String[] args) 
	{
		
		Utilisateur ut1 = new Utilisateur(123456789,"caca","lolo");
		
		System.out.println("Utilisateur 1 :" + ut1);
	}

}
