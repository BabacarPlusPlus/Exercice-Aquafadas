import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;


public class main {

	public static void main(String[] args) throws ParserConfigurationException, RuntimeException {
		
		// creation de classes de tests
		
		Campus c1 = new Campus("montpellier","languedoc",10000);
		Campus c2 = new Campus("nimes","languedoc",3000);
		Campus c3 = new Campus("Paris","Ile de France",50000);
		Campus c4 = new Campus("Bordeaux","Gironde",1);
		
		Student s1 = new Student(3,"Boris", "Martin");
		Student s2 = new Student(6,"Ludovic", "Williams");
		Student s3 = new Student(5,"David", "Ginola");
		Student s4 = new Student(9,"Zinedine", "Zidane");
		Student s5 = new Student(15,"François", "Bocquet");
		Student s6 = new Student(25,"Maxime", "Puec");
		Student s7 = new Student(7,"Eddie", "Bric");
		Student s8 = new Student(8,"Paul", "Le Bon");
		Student s9 = new Student("Luc", "Skywalker");
		Student s10 = new Student(8,"lou", "Fabre");
		Student s11 = new Student("Julien", "Martinez");
		Student s12 = new Student(7,"Bob", "Bernardo");
		Student s13 = new Student("lise", "Mouto");
		Student s14 = new Student(2,"Ines", "Ammon");
		
		InternalTeacher t1 = new InternalTeacher(1,"Bernard", "Minet");
		InternalTeacher t2 = new InternalTeacher(2,"lily", "Lapas");
		ExternalTeacher t3= new ExternalTeacher(3,"Elodie", "Gasperge",2200);
		ExternalTeacher t4 = new ExternalTeacher(4,"Amandine", "Dubois",2000);
		ExternalTeacher t5 = new ExternalTeacher(5,"Cédric", "DuPont",3000);
		
		// on les met dans un campus
		c1.addStudent(s1);c1.addStudent(s2);
		c1.addStudent(s12);c1.addStudent(s13);
		c1.addStudent(s14);
		c2.addStudent(s3);c2.addStudent(s4);
		c3.addStudent(s5);c2.addStudent(s6);
		c3.addStudent(s7);c2.addStudent(s8);
		c4.addStudent(s10);
		
		c1.addTeacher(t1);
		c2.addTeacher(t2);
		c3.addTeacher(t3);
		c3.addTeacher(t4);
		c4.addTeacher(t5);
		
		//test des comparaisons
		
		System.out.println("--------------Comparaison----------");
		
		if( c2.Equals(c1) ) System.out.println("egaux");
		else  System.out.println("non egaux");

		if( c2.Equals(c2) ) System.out.println("egaux");
		else  System.out.println("non egaux");
		
		if( s1.Equals(s2) ) System.out.println("egaux");
		else  System.out.println("non egaux");

		if( s9.Equals(s9) ) System.out.println("egaux");
		else  System.out.println("non egaux");		

		if( s6.Equals(s8) ) System.out.println("egaux");
		else  System.out.println("non egaux");
		
		
		ArrayList  <Campus> ListeCampus =  new ArrayList  <Campus>();
		ListeCampus.add(c1);
		ListeCampus.add(c2);
		ListeCampus.add(c3);
		ListeCampus.add(c4);

		System.out.println("------------------------------");
		System.out.println("-----Verification que les ID des étudiants du camus 'c1' sont triés--------");
		ArrayList  <Student> L = c1.getStudents();
		for(Student s: L)
		{
			System.out.print(s.getID()+" - ");
		}
		System.out.print("\n");
		
		System.out.println("------------------------------");
		
		//Pour rajouter en ligne de commande d'autres données, ici les ID ne sont pas vérifiées
		
		boolean End = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Creer d'autres campus en plus de ceux du main ? '0' pour refuser, sinon '1'.");
		int reponse = Integer.parseInt(sc.nextLine());
		if(reponse == 0) End= true;
		
		
		while(!End)
		{
			
			System.out.println("Vous creez un campus,  veuillez saisir sa ville :");
			String ville = sc.nextLine();
			System.out.println("sa région :");
			String region = sc.nextLine();
			System.out.println("sa capacité :");
			int capacite = Integer.parseInt(sc.nextLine());
			
			System.out.println("Combien d'éleves voulez vous ajouter ?");
			int nb = Integer.parseInt(sc.nextLine());
			
			Campus c =new Campus(ville,region,capacite);
			for(int i =0;i<nb;i++)
			{
				System.out.println("Vous creez un élève,  veuillez saisir son id :");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("prenom :");
				String prenom = sc.nextLine();
				System.out.println("nom :");
				String nom = sc.nextLine();
				Student s = new Student(id,prenom,nom);				
				c.addStudent(s);		
			}
			
			System.out.println("Combien de professseurs voulez vous ajouter ?");
			nb = Integer.parseInt(sc.nextLine());
	
			for(int i =0;i<nb;i++)
			{
				System.out.println("Vous creez un professeur,  veuillez saisir son id :");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("prenom :");
				String prenom = sc.nextLine();
				System.out.println("nom :");
				String nom = sc.nextLine();
				
				System.out.println("Est-il interne (0) ou externe (1)?");
				int interne  = Integer.parseInt( sc.nextLine());
				
				if( interne == 0)
				{
					InternalTeacher it = new InternalTeacher(id,prenom,nom);
					c.addTeacher(it);
				}
				if( interne == 1){
					System.out.println("son salaire :");
					int s = Integer.parseInt(sc.nextLine());					
					ExternalTeacher et = new ExternalTeacher(id,prenom,nom,s);
					c.addTeacher(et);
				}			
			}
			
			ListeCampus.add(c);
			
			System.out.println("Campus crée, voulez vous en créer un autre ? '0' pour refuser, sinon '1'.");
			int s = Integer.parseInt(sc.nextLine());
			if(s == 0) End= true;
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("Fin du traitement creation du fichier : donnees.xml ");
		
		
		// creation XML
		Donnees d = new Donnees();
		d.creerDocumentXML("donnees.xml", ListeCampus );
		
		//Lever l'exception		
		//c4.addStudent(s11);// enlever les commentaire pour tester cette exception
		
	}


}
