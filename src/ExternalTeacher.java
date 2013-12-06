
public class ExternalTeacher extends Teacher {
	
	private int salaire;
	
	
	public ExternalTeacher(int iD, String prenom, String nom, int salaire) {
		super(iD, prenom, nom);
		this.salaire=salaire;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public String toString() {
		return "ExternalTeacher [prenom=" + prenom +", nom ="+nom+" ,salaire=" + salaire + "]";
	}
	
}
