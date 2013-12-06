

public class InternalTeacher extends Teacher {

	

	private int salaire=1500;
	
	public InternalTeacher(int iD, String prenom, String nom) {
		super(iD, prenom, nom);		
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
