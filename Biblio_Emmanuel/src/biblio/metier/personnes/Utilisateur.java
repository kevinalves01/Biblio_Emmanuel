/**
 * 
 */
package biblio.metier.personnes;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Utilisateur 
{

	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	
	public Utilisateur(int idUtilisateur, String pwd, String pseudonyme) 
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

	
	@Override
	public String toString() 
	{
		return "Utilisateur [idUtilisateur :" 		+ idUtilisateur 
								  + ", pwd=" 		+ pwd
								  + ", pseudonyme=" + pseudonyme + "]";
	}

	public static void main(String[] args) 
	{

	}

}
