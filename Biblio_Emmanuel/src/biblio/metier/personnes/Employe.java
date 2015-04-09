/**
 * 
 */
package biblio.metier.personnes;

import java.util.Date;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Employe extends Utilisateur
{

	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;
	
	public Employe(String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, 
			String pwd, String pseudonyme, String codeMatricule, EnumCategorieEmploye categorieEmploye) {
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.codeMatricule = codeMatricule;
		this.categorieEmploye = categorieEmploye;
	}
	
	public String getCodeMatricule() {
		return codeMatricule;
	}
	
	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}
	
	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}
	
	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
	}
	
	@Override
	public String toString() {
		return "Employé[Nom:" + this.getNom() + ":Prénom:" + this.getPrenom()
				+ ":idUtilisateur:" + this.getIdUtilisateur() + ":CodeMatricule:" + this.codeMatricule
				+ ":Catégorie:" + this.categorieEmploye + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) {
			return true;
		}
		if (o instanceof Employe) {
			Employe e = (Employe) o;
			if (this.getIdUtilisateur()!=e.getIdUtilisateur()) {
				return false;
			}
			if (!this.codeMatricule.equals(e.codeMatricule)) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = hash * 7 + this.getIdUtilisateur();
		hash = hash * 11 + this.codeMatricule.hashCode();
		return hash;
	}
	
	@Override
	public boolean isConditionsPretAcceptees(){
		return true;
	}
	

	
}
