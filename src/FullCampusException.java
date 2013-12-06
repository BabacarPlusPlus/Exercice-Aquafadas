/***
 * L'exception personnalisée
 *
 */
public class FullCampusException extends RuntimeException{

	public FullCampusException(){
	    System.out.println("le Campus a atteint sa taille maximale");
	  }

}
