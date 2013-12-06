
public class Student   {

		private int ID;
		private String prenom;
		private String nom;
		
		/*COSTRUTORS */
		public Student() {}
		
		public Student(int iD, String prenom, String nom) {
			this.ID = iD;
			this.prenom = prenom;
			this.nom = nom;
		}
		
		public Student( String prenom, String nom) {
			this.ID = 0;
			this.prenom = prenom;
			this.nom = nom;
		}
		
		/* METHODS */
		public boolean Equals(Student c)
		{
			if( this.ID == c.ID)
			{ 
				return true;
			}
			else if(( this.prenom == c.prenom) && (this.nom == c.prenom) && (this.ID==0)&& (c.ID==0) )
			{
				return true;
			}
			else if( ((this.ID==0)&& (c.ID!=0)) || ((this.ID!=0)&& (c.ID==0)) )
			{
				return false;
			}			
			else return false;
		}

		/*ACCESSOR */
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

		public String toString() {
			return "Student [ID=" + ID + ", prenom=" + prenom + ", nom=" + nom
					+ "]";
		}
		
		
		
}
