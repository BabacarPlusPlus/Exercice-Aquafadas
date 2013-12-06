import java.util.ArrayList;


public class Campus {
	
	private String ville;
	private String region;
	private int capacite;	
	private ArrayList <Student> listeEtudiant;
	private ArrayList <Teacher> listeProfesseur;
	
	/* Constructors */
	public Campus()
	{	}
	
	public Campus(String v, String r, int c)
	{
		ville=v;
		region=r;
		capacite=c;
		listeEtudiant = new ArrayList <Student>();
		listeProfesseur = new ArrayList <Teacher>();
	}
	
	public Campus(String v, String r, int c, ArrayList <Student> listStudent ,ArrayList <Teacher> listTeacher )
	{
		ville=v;
		region=r;
		capacite=c;
		listeEtudiant = listStudent;
		listeProfesseur = listTeacher;
		
		SortListeEtudiant();
	}
	
	/* List Methods */
	
	
	/*methode de tri de la liste étudiante, est appellée a chaque insertion ou autre 
	 * algorithme 'tri a bule'
	 * */
	

	
	private void SortListeEtudiant()
	{
		boolean echange;
		
		do{
			echange=false;
			
			for( int j=0;j<listeEtudiant.size()-1;j++ )
			{
				if(listeEtudiant.get(j).getID() > listeEtudiant.get(j+1).getID())
				{
					Student s = listeEtudiant.get(j);
					listeEtudiant.set(j,listeEtudiant.get(j+1));
					listeEtudiant.set(j+1,s);
					echange=true;
				}
			}
			
		}while ( echange == true);
	}
	
	
	public void addStudent( Student s)throws  FullCampusException
	{
		if(listeEtudiant.size() < capacite)
		{
			listeEtudiant.add(s);
			SortListeEtudiant();
		}
		else throw new FullCampusException();
	}
	
	
	public void removeStudent( Student s)
	{
		listeEtudiant.remove(s);
	}
	
	public ArrayList <Student> getStudents(){ return listeEtudiant;}
	
	public void addTeacher( Teacher t)
	{
		if(listeProfesseur.size() < capacite)
		listeProfesseur.add(t);
	}
	
	public void removeTeacher( Teacher t)
	{
		listeProfesseur.remove(t);
	}
	
	public ArrayList <Teacher> getTeachers()
	{ 
		return listeProfesseur;
	}
	
	
	
	/*Equals function */
	
	public boolean Equals(Campus c)
	{
		if(( this.ville == c.ville )&& (this.region == c.region)) return true;
		else return false;
	}
	
	
	
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	
	public String toString() {
		return "Campus [ville=" + ville + ", region=" + region + ", capacite="
				+ capacite + ", listeEtudiant=" + listeEtudiant.toString()
				+ ", listeProfesseur=" + listeProfesseur.toString() + "]";
	}


	
}
