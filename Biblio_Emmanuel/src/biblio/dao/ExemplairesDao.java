package biblio.dao;

import java.util.Date;

import biblio.metier.ouvrages.EnumStatusExemplaire;
import biblio.metier.ouvrages.Exemplaire;

public class ExemplairesDao {
	
	private static Exemplaire[] exemplaireDB = {
		new Exemplaire(1,new Date(),EnumStatusExemplaire.DISPONIBLE,"123"),
		new Exemplaire(2,new Date(),EnumStatusExemplaire.DISPONIBLE,"456"),
		new Exemplaire(3,new Date(),EnumStatusExemplaire.DISPONIBLE,"789"),
		new Exemplaire(4,new Date(),EnumStatusExemplaire.DISPONIBLE,"753"),
		new Exemplaire(5,new Date(),EnumStatusExemplaire.DISPONIBLE,"951"),
	};
	
	public Exemplaire findByKey(int id) {
		for (Exemplaire ex : exemplaireDB) {
			if (ex.getIdExemplaire()==id)
				return ex;
		}
		return null;
	}

}
