package biblio.dao;

import java.util.Date;

import biblio.metier.personnes.Adherent;
import biblio.metier.personnes.Employe;
import biblio.metier.personnes.EnumCategorieEmploye;
import biblio.metier.personnes.Utilisateur;

public class UtilisateursDao {
	
	private static Utilisateur[] utilisateurDB = {
		new Utilisateur("Dupont","Jean",new Date(),"masculin",555,"Sésame","DJ"),
		new Employe("Martin","Marie", new Date(),"féminin",666,"Abracadabra","2M","Mat123",EnumCategorieEmploye.BIBLIOTHECAIRE),
		new Adherent("Lajoie", "Suzanne", new Date(), "féminin", 123, "azerty", "LS", "1234567890")
	};
	
	public Utilisateur findByKey(int id) {
		for (Utilisateur ut : utilisateurDB) {
			if (ut.getIdUtilisateur()==id) {
				return ut;
			}
		}
		return null;
	}

}
