/****
 * 
 * Classe permettant la creation de l'XML 
 * ***/

import java.io.File;

import java.util.ArrayList;
 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class Donnees
{ 
	
	   public static void writeXMLCampus(ArrayList  <Campus> ListeCampus, Document document)
	   {
		   Element lcampus = document.createElement("ListeCampus");
		   
		   for(Campus l : ListeCampus)
		   {
			   		   
			   Element campus = document.createElement("Campus");
			   lcampus.appendChild(campus);
			   
			   
			   Element ville = document.createElement("Ville");
			   ville.setTextContent(l.getVille());
			   campus.appendChild(ville);
			   
			   Element region = document.createElement("region");
			   region.setTextContent(l.getRegion());
			   campus.appendChild(region);
			   
			   Element capacite = document.createElement("capacite");
			   capacite.setTextContent( Integer.toString(l.getCapacite()));
			   campus.appendChild(capacite);
			   
			   ArrayList  <Student> ListeEtudiant = l.getStudents();
			   Element listeS = document.createElement("Liste_Etudiants");
			   	
			   
			   for( Student le : ListeEtudiant)
			   {
				   Element student = document.createElement("Etudiant");				   
				   listeS.appendChild(student);
				   
				   Element id = document.createElement("id");
				   id.setTextContent(Integer.toString(le.getID()));
				   student.appendChild(id);
				   
				   Element prenom = document.createElement("prenom");
				   prenom.setTextContent(le.getPrenom());
				   student.appendChild(prenom);
				   
				   Element nom = document.createElement("nom");
				   nom.setTextContent(le.getNom());
				   student.appendChild(nom);
				   
				   
				  
			   }
			   campus.appendChild(listeS);
			   
			  
			   
			   
			   ArrayList  <Teacher> ListeProfesseur = l.getTeachers();
			   Element listeP = document.createElement("Liste_Professeurs");
			  
			   
			   for( Teacher lp : ListeProfesseur)
			   {
				   Element teacher = document.createElement("Professeur");				   
				   listeP.appendChild(teacher);
				   
				   Element id = document.createElement("id");
				   id.setTextContent(Integer.toString(lp.getID()));
				   teacher.appendChild(id);
				   
				   Element prenom = document.createElement("prenom");
				   prenom.setTextContent(lp.getPrenom());
				   teacher.appendChild(prenom);
				   
				   Element nom = document.createElement("nom");
				   nom.setTextContent(lp.getNom());
				   teacher.appendChild(nom);	   
				  
			   }
			   
			   campus.appendChild(listeP);
			   
		   }
		   
		   
		   document.appendChild(lcampus);
		   
		   
	   }
	   
	   
	   public static void creerDocumentXML(String fichier, ArrayList  <Campus> ListeCampus) throws ParserConfigurationException {
		// Création d'un nouveau DOM
		   DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
		   DocumentBuilder constructeur = fabrique.newDocumentBuilder();
		   Document document = constructeur.newDocument();

		   // Propriétés du DOM
		   document.setXmlVersion("1.0");
		   document.setXmlStandalone(true);

		   writeXMLCampus(ListeCampus,document);
		   //writeXMLCampus(ListeCampus2,document);
		   
		   try {
				// Création de la source DOM
				Source source = new DOMSource(document);
				
				// Création du fichier de sortie
				File file = new File(fichier);
				StreamResult resultat = new StreamResult(fichier);
				
				// Configuration du transformer
				TransformerFactory fabrique1 = TransformerFactory.newInstance();
				Transformer transformer = fabrique1.newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
				
				// Transformation
				transformer.transform(source, resultat);
			}catch(Exception e){
				e.printStackTrace();
			}
	    }
}