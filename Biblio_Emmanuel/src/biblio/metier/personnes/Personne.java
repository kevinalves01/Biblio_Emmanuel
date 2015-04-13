package biblio.metier.personnes;

import java.util.Date;

public class Personne {
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	
	public Personne(String nom, String prenom, Date dateNaissance, String sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	@Override
	public String toString() {
		return "Personne [nom : "+ this.nom + ", prénom : " + this.prenom
				+ ", date de naissance : " + this.dateNaissance + "]"; 
	}
	
	@Override
	public boolean equals(Object o) {
		if (o==this)
			return true;
		if (o instanceof Personne) {
			Personne p = (Personne) o;
			if (!this.nom.equals(p.nom)) {
				return false;
			}
			if (!this.prenom.equals(p.prenom)) {
				return false;
			}
			if(this.dateNaissance!=p.dateNaissance) {
				if(!this.dateNaissance.equals(p.dateNaissance)) {
					return false;
				}
			}
			if (!this.sexe.equals(p.sexe)) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 3 + this.nom.hashCode();
		hash = hash * 5 + this.prenom.hashCode();
		hash = hash * 7 + this.dateNaissance.hashCode();
		hash = hash * 11 + this.sexe.hashCode();
		return hash;
	}

}
