package biblio.metier.ouvrages;

import java.text.SimpleDateFormat;
import java.util.Date;

import biblio.metier.BiblioException;
import biblio.metier.personnes.Utilisateur;

public class EmpruntEnCours {
	
	private Date dateEmprunt;
	private Exemplaire exemplaire;
	private Utilisateur emprunteur;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	
	public EmpruntEnCours(Date dateEmprunt, Exemplaire exemplaire, Utilisateur emprunteur) throws BiblioException 
	{
		this.dateEmprunt = dateEmprunt;
		this.exemplaire = exemplaire;
		this.emprunteur = emprunteur;
		emprunteur.addEmpruntEnCours(this);
		exemplaire.setEmpruntEnCours(this);
		exemplaire.setStatus(EnumStatusExemplaire.PRETE);
	
	}
	
	
	public Date getDateEmprunt() 
	{
		return dateEmprunt;
	}
	
	public void setDateEmprunt(Date dateEmprunt) 
	{
		this.dateEmprunt = dateEmprunt;
	}
	
	public Exemplaire getExemplaire() 
	{
		return exemplaire;
	}
	
	public void setExemplaire(Exemplaire exemplaire) 
	{
		this.exemplaire = exemplaire;
	}
	
	public Utilisateur getEmprunteur() 
	{
		return emprunteur;
	}
	
	public void setEmprunteur(Utilisateur emprunteur) 
	{
		this.emprunteur = emprunteur;
	}

	@Override
	public String toString() 
	{
		return "EmpruntEnCours \n[dateEmprunt :"		+ sdf.format(dateEmprunt)
							+ "\n, exemplaire :" 		+ getExemplaire() 
							+ "\n, emprunteur :"		+ getEmprunteur() + "]";
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateEmprunt == null) ? 0 : dateEmprunt.hashCode());
		result = prime * result
				+ ((emprunteur == null) ? 0 : emprunteur.hashCode());
		result = prime * result
				+ ((exemplaire == null) ? 0 : exemplaire.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpruntEnCours other = (EmpruntEnCours) obj;
		if (dateEmprunt == null) {
			if (other.dateEmprunt != null)
				return false;
		} else if (!dateEmprunt.equals(other.dateEmprunt))
			return false;
		if (emprunteur == null) {
			if (other.emprunteur != null)
				return false;
		} else if (!emprunteur.equals(other.emprunteur))
			return false;
		if (exemplaire == null) {
			if (other.exemplaire != null)
				return false;
		} else if (!exemplaire.equals(other.exemplaire))
			return false;
		return true;
	}

	public EmpruntArchive retourExemplaire(Date dateRetour)
	{
		emprunteur.removeEmpruntEnCours(this);
		exemplaire.setEmpruntEnCours(null);
		exemplaire.setStatus(EnumStatusExemplaire.DISPONIBLE);
		return new EmpruntArchive(dateRetour,this.dateEmprunt,this.exemplaire,this.emprunteur);
	}

}
