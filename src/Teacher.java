
public abstract class Teacher {
	protected int ID;
	protected String prenom;
	protected String nom;
	
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Teacher(int iD, String prenom, String nom) {
		
		this.ID = iD;
		this.prenom = prenom;
		this.nom = nom;
	}


	public String toString() {
		return "Teacher [ID=" + ID + ", prenom=" + prenom + ", nom=" + nom
				+ "]";
	}
	
	
	
}
