package question2;

/**
 * Classe-test Pile4Test.
 * 
 * @author jalal hassane
 * @version 26/3/2019
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile4Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    private Pile4 pile4;
    /**
     * Constructeur de la classe-test Pile4Test
     */
    public Pile4Test() {
        
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        pile4 = new Pile4(PileI.CAPACITE_PAR_DEFAUT);
    }
        /**
	 * Supprime les engagements
	 * 
	 * Méthode appelée après chaque appel de méthode de test.
	   */
    protected void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}
    public void test_methode() throws Exception{
        pile4.empiler("1");
        pile4.empiler("2");
        pile4.empiler("3");
        pile4.empiler("4");
        pile4.empiler("5");
        pile4.empiler("6");
        assertTrue("la pile est pleine? :" , pile4.estPleine());
        pile4.depiler();
        assertTrue("la pile contient maintenant 5?",pile4.taille()==5);
        assertTrue("Capacite initiale est:", pile4.capacite()==6);
        assertTrue("Sommet est:",pile4.sommet().toString().equals("5"));
        
    }
    
    public void test_to_string() throws Exception{
        test_methode();
        String sommet = (String) pile4.depiler();
        assertTrue("le sommet etait: ",pile4.sommet().toString().equals("4"));
        assertTrue("Representation de la pile est :",
        pile4.toString().equals("[4,3,2,1]"));
    }

}
