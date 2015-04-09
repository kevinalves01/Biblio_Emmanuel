/**
 * 
 */
package biblio.metier.personnes;

import java.util.ArrayList;
import java.util.Date;

import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Utilisateur extends Personne 
{

	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private ArrayList<EmpruntEnCours> empruntEnCours;
	
	public Utilisateur(String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, String pwd, String pseudonyme) {
		super(nom,prenom,dateNaissance,sexe);
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
		this.empruntEnCours = new ArrayList<EmpruntEnCours>();
	}
	
/*	public Utilisateur(int idUtilisateur, String pwd, String pseudonyme) 
	{
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
	}
	
	public Utilisateur(int idUtilisateur, String pwd)
	{
		
	}
	
	public Utilisateur(int idUtilisateur)
	{
		
	}
	
	public Utilisateur()
	{
			}
*/	
	/**
	 * @return l'ID de l'
	 * Utilisateur
	 */
	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur l'ID de l'utilisateur à mettre
	 */
	public void setIdUtilisateur(int idUtilisateur) 
	{
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return le pwd
	 */
	public String getPwd() 
	{
		return pwd;
	}

	/**
	 * @param pwd le mot de passe a mettre
	 */
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	/**
	 * @return le pseudonyme
	 */
	public String getPseudonyme() 
	{
		return pseudonyme;
	}

	/**
	 * @param pseudonyme le pseudonyme a mettre
	 */
	public void setPseudonyme(String pseudonyme) 
	{
		this.pseudonyme = pseudonyme;
	}

	
	public ArrayList<EmpruntEnCours> getEmpruntEnCours() {
		return empruntEnCours;
	}

	public void setEmpruntEnCours(ArrayList<EmpruntEnCours> empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}

	@Override
	public String toString() 
	{
		return "Utilisateur [nom :" + this.getNom() + ":prénom:" + this.getPrenom()
				+ ":idUtilisateur:" + this.idUtilisateur + ":pseudonyme:" + this.pseudonyme + "]";
	}
	
	@Override
	public boolean equals(Object o){
		if (o==this)
			return true;
		if (o instanceof Utilisateur) {
			Utilisateur u = (Utilisateur) o;
			if (!this.getNom().equals(u.getNom())) {
				return false;
			}
			if (!this.getPrenom().equals(u.getPrenom())) {
				return false;
			}
			if (this.idUtilisateur!=u.idUtilisateur) {
				return false;
			}
			if (!this.pseudonyme.equals(u.pseudonyme)) {
				return false;
			}
			return true;			
		}
		return false;
	}
	
	public int hashCode() {
		int hash = 3;
		hash = hash * 5 + this.getNom().hashCode();
		hash = hash * 7 + this.getPrenom().hashCode();
		hash = hash * 11 + this.idUtilisateur;
		hash = hash * 13 + this.pseudonyme.hashCode();
		return hash;
	}
	
	public int getNbEmpruntEnCours() {
		if (this.empruntEnCours==null)
			return 0;
		return empruntEnCours.size();
	}

	public boolean isConditionsPretAcceptees() throws BiblioException{
		return false;
	}
	
	public void addEmpruntEnCours(EmpruntEnCours emp) throws BiblioException {
		if (this.isConditionsPretAcceptees()) {
			this.empruntEnCours.add(emp);
		}
	}
	
	public void removeEmpruntEnCours(EmpruntEnCours emp) {
		this.empruntEnCours.remove(emp);
	}

}
