/**
 * 
 */
package biblio.metier.personnes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Adherent extends Utilisateur
{
	
	private String telephone;
	private static int nbMaxPrets = 3;
	private static int dureeMaxPrets = 15;

	public Adherent (String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, 
			String pwd, String pseudonyme, String telephone) {
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static int getNbMaxPrets() {
		return nbMaxPrets;
	}

	public static void setNbMaxPrets(int nbMaxPrets) {
		Adherent.nbMaxPrets = nbMaxPrets;
	}

	public static int getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	public static void setDureeMaxPrets(int dureeMaxPrets) {
		Adherent.dureeMaxPrets = dureeMaxPrets;
	}

	@Override
	public String toString() {
		return "Adhérent[Nom:" + this.getNom() + ":Prénom:" + this.getPrenom() + ":idUtilisateur:"
				+ this.getIdUtilisateur() + ":pseudonyme:" + this.getPseudonyme() + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) {
			return true;
		}
		if (o instanceof Adherent) {
			Adherent a = (Adherent) o;
			if (!this.getNom().equals(a.getNom())) {
				return false;
			}
			if (!this.getPrenom().equals(a.getPrenom())) {
				return false;
			}
			if (this.getIdUtilisateur()!=a.getIdUtilisateur()) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 11 + this.getNom().hashCode();
		hash = hash * 13 + this.getPrenom().hashCode();
		hash = hash * 17 + this.getIdUtilisateur();
		return hash;
	}
	
	@Override
	public boolean isConditionsPretAcceptees() throws BiblioException{
		if (this.getNbEmpruntEnCours()>=nbMaxPrets) {
			throw new BiblioException("Impossible, cet adhérent a déjà atteint le nombre maximum d'emprunt.");
		}
		if (this.getNbRetards()!=0) {
			throw new BiblioException("Impossible, cet adhérent a au moins un prêt en retard.");
		}
		return true;
	}
	
	public int getNbRetards() {
		int nb = 0;
		Iterator<EmpruntEnCours> it = this.getEmpruntEnCours().iterator();
		while (it.hasNext()) {
			EmpruntEnCours emp = it.next();
			GregorianCalendar calendrier = new GregorianCalendar();
			calendrier.add(GregorianCalendar.DAY_OF_YEAR, -(dureeMaxPrets+1));
			Date prêt = calendrier.getTime();
			if (prêt.after(emp.getDateEmprunt())) {
				nb++;
			}
		}
		return nb;
	}

}
