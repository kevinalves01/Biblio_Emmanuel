/**
 * 
 */
package biblio.metier.ouvrages;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Exemplaire 
{
	
	private int idExemplaire;
	private Date dateAchat;
	private EnumStatusExemplaire status;
	private String isbn;
	private EmpruntEnCours empruntEnCours;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Constructeur d'exemplaire avec tous les paramètres.
	 * @param idExemplaire l'identifiant (ID) de l'exemplaire.
	 * @param dateAchat la date d'achat.
	 * @param status le status de l'exemplaire.
	 * @param isbn l'isbn de l'exemplaire.
	 */
	public Exemplaire(int idExemplaire, Date dateAchat, EnumStatusExemplaire status, String isbn) {
		this.idExemplaire = idExemplaire;
		this.dateAchat = dateAchat;
		this.status = status;
		this.isbn = isbn;
		this.empruntEnCours = null;
	}
	
	
	/**
	 * Methode sur le status de l'exemplaire renvoyant un boolean 
	 * @return true si exemplaire est DISPONIBLE / false sinon.
	 */
	public boolean isDisponible() 
	{
		if (status == EnumStatusExemplaire.DISPONIBLE)
			return true;
		else
			return false;
	}
	
	/**
	 * Accesseur sur l'ID de l'exemplaire.
	 * @return idExemplaire l'Id de l'exemplaire.
	 */
	public int getIdExemplaire() 
	{
		return idExemplaire;
	}
	
	/**
	 * Accesseur sur la date d'achat de l'exemplaire.
	 * @return dateAchat la date d'achat de l'exemplaire.
	 */
	public Date getDateAchat() 
	{
		return dateAchat;
	}
	
	/**
	 * Accesseur sur l'ISBN de l'exemplaire.
	 * @return isbn l'ISBN de l'exemplaire.
	 */
	public String getIsbn() 
	{
		return isbn;
	}
	
	/**
	 * Accesseur sur le status de l'exemplaire.
	 * @return status le status de l'exemplaire.
	 */
	public EnumStatusExemplaire getStatus() 
	{
		return status;
	}
	
	/**
	 * Accesseur sur l'emprunt en cours de l'exemplaire.
	 * @return empruntEnCours l'emprunt de l'exemplaire.
	 */
	public EmpruntEnCours getEmpruntEnCours() 
	{
		return empruntEnCours;
	}
	
	/**
	 * Mutateur sur l'ID de l'exemplaire.
	 * @param idExemplaire
	 */
	public void setIdExemplaire(int idExemplaire) 
	{
		this.idExemplaire = idExemplaire;
	}

	/**
	 * Mutateur sur la date d'achat de l'exemplaire.
	 * @param dateAchat la date d'achat de l'exemplaire.
	 */
	public void setDateAchat(Date dateAchat) 
	{
		this.dateAchat = dateAchat;
	}
	
	/**
	 * Mutateur sur le status de l'exemplaire.
	 * @param status le status de l'exemplaire.
	 */
	// si le livre est emprunter alors il passe a PRETE
	public void setStatus(EnumStatusExemplaire stat) 
	{
		this.status = stat;
	}
	
	/**
	 * Mutateur sur l'ISBN de l'exemplaire.
	 * @param isbn l'ISBN de l'exemplaire.
	 */
	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}
	
	/**
	 * Mutateur sur l'emprunt en cour de l'exemplaire.
	 * @param empruntEnCours emprunt de l'exemplaire.
	 */
	public void setEmpruntEnCours(EmpruntEnCours empruntEnCours) 
	{
		this.empruntEnCours = empruntEnCours;
	}

	@Override
	public String toString() 
	{
		return "Exemplaire [idExemplaire :" 		+ idExemplaire 
							+ ", status :" 			+ status 
							+ ", isbn :" 			+ isbn + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idExemplaire;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exemplaire other = (Exemplaire) obj;
		if (idExemplaire != other.idExemplaire)
			return false;
		return true;
	}
	
	
}
