package supmti.sidik.gael;

public class Employes {
	
	private String nom, dateNaissance, date_Embauche;
	private double salaire, prime;
	public static int matricule=0;
	
	
	public Employes(String nom, String dateNaissance, String date_Embauche, double salaire, double prime) {
		super();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.date_Embauche = date_Embauche;
		this.salaire = salaire;
		this.prime = prime;
		
	}



	public double getPrime() {
		return prime;
	}


	public void setPrime(double prime) {
		this.prime = prime;
	}


	public Employes() {
		// TODO Auto-generated constructor stub
		matricule++;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getDate_Embauche() {
		return date_Embauche;
	}


	public void setDate_Embauche(String date_Embauche) {
		this.date_Embauche = date_Embauche;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}



	public int getMatricule() {
		return matricule;
	}
	
	
}
